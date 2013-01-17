package org.fornax.cartridges.sculptor.smartclient.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fornax.cartridges.sculptor.framework.annotation.GuiHints;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.DetailBehavior;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.VisibleOn;
import org.fornax.cartridges.sculptor.framework.annotation.Name;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.smartclient.domain.Property;
import org.fornax.cartridges.sculptor.smartclient.domain.SmartclientErrorCode;
import org.fornax.cartridges.sculptor.smartclient.exception.PropertyAccessDenied;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementation of PropertyService.
 */
@Service("propertyService")
public class PropertyServiceImpl extends PropertyServiceImplBase {
	private static final String PROP_DELIMITER = ".";
	private static final Logger log=LoggerFactory.getLogger(PropertyServiceImpl.class.getName());
	private static final String PROPERTY_ADMIN_ROLE="ROLE_PROPADMIN";
	private static final String USER_LEVEL_PROPERTY_SUFFIX="userLevelProperty";
	private static final String EMPTY_VALUE="(EMPTY)";
	private static final String FILE_PREFIX="file://";

	public static final String XDEFAULT_VAL="#DEFAULT#";
	public static final String XSYSTEM_VAL="#SYSTEM#";

	private String filePrefix="/";
	private String startupProperties="default.properties";

	boolean preloaded=false;
	Properties defaultProp=new Properties();

	@Override
	public Property save(ServiceContext ctx, Property entity) throws PropertyAccessDenied {
		boolean allowUserProp = isUserLevelProperty(ctx, entity.getPropName());

		if (!ctx.isUserInRole(PROPERTY_ADMIN_ROLE) && !allowUserProp ) {
			throw new PropertyAccessDenied(SmartclientErrorCode.PropertyAccessDenied, "User {0} can''t change System level property {1}", ctx.getUserId(), entity.getPropName());
		}

		// if NOT admin is saving user level property than set correct kind
		if (allowUserProp) {
			entity.setPropName(ctx.getUserId() + PROP_DELIMITER + entity.getPropName());
		}

		defaultProp.setProperty(entity.getPropName(), entity.getPropValue());

		return super.save(ctx, entity);
	}

	Pattern placeholder = Pattern.compile("\\$([LP])\\{([A-Za-z0-9\\.]+)\\}");

	@GuiHints(visibleOn=VisibleOn.HIDDEN)
	public String getPropertyValue(ServiceContext ctx, String path, String propKey, String defaultValue) {
		if (!preloaded) {
			synchronized (PropertyServiceImpl.class) {
				if (!preloaded) {
					loadDefaultProperties(ctx);
				}
			}
		}

		path = path == null ? "" : path;
		if (isUserLevelProperty(ctx, propKey)) {
			path = ctx.getUserId() + PROP_DELIMITER + path;
		}
		String retProp=null;
		do {
			retProp=defaultProp.getProperty( (path.length() > 0 ? path + PROP_DELIMITER : "") + propKey);
			if (retProp == null) {
				// cut path
				int dotLastIndex = path.lastIndexOf(".");
				if (path.length() == 0) {
					path = null;
				} else if (dotLastIndex == -1) {
					path = "";
				} else {
					path = path.substring(0, dotLastIndex);
				}
			}
		} while (path != null && retProp == null);

		if (retProp != null && placeholder.matcher(retProp).find()) {
			Matcher propMatcher = placeholder.matcher(retProp);
			StringBuffer sb = new StringBuffer();
			while (propMatcher.find()) {
				String subPropVal;
				String subPropName=propMatcher.group(2);
				if ("L".equals(propMatcher.group(1))) {
					subPropVal=translate(ctx, subPropName);
				} else {
					subPropVal=getPropertyValue(ctx, null, subPropName, null);
				}
				propMatcher.appendReplacement(sb, subPropVal == null ? "#"+propMatcher.group(1) : subPropVal.replaceAll("\\$", "\\\\\\$"));
			}
			propMatcher.appendTail(sb);
			retProp=sb.toString();
		}

		return retProp == null ? defaultValue : retProp.equals(EMPTY_VALUE) ? null : retProp;
	}

	@GuiHints(visibleOn = VisibleOn.ON_DETAIL, detailBehavior = DetailBehavior.ON_ALL, ifRole = "ROLE_ADMIN")
	public void loadDefaultProperties(@Name("ctx") ServiceContext ctx) {
		defaultProp.clear();

		// Load default properties
		loadProperties(defaultProp, filePrefix + startupProperties);

		// Import other properties from "import" property
		String importFrom=defaultProp.getProperty("import");
		if (importFrom != null) {
			String [] importSplit = importFrom.split("[, ]");
			for (String importFromFile : importSplit) {
				importFromFile = filePrefix + importFromFile;
				loadProperties(defaultProp, importFromFile);
			}
		}

		// Update properties from DB when they have different default value
		if (getPropertyRepository() != null) {
			List<Property> defDbProps = getPropertyRepository().findByQuery("PropertyService.findAllNotDefaultProperty", null);
			for (Property defDbProp : defDbProps) {
				defaultProp.setProperty(defDbProp.getPropName(), defDbProp.getPropValue());
			}
		}

		// Loat external file://... properties
		for (Entry<Object, Object> prop : defaultProp.entrySet()) {
			try {
				if (prop.getValue().toString().startsWith(FILE_PREFIX)) {
					String fileName=filePrefix + prop.getValue().toString().substring(FILE_PREFIX.length());
					BufferedReader bufReader = new BufferedReader(new InputStreamReader(PropertyServiceImpl.class.getResourceAsStream(fileName), "UTF-8"));
					StringBuilder resultFile = new StringBuilder();
					char[] buffer=new char[1024];
					while (bufReader.ready()) {
						int readChars=bufReader.read(buffer);
						resultFile.append(buffer, 0, readChars);
					}
					prop.setValue(resultFile.toString());
				}
			} catch (Exception e) {
				log.warn("Property '{}' can't be read from {}", prop.getKey(), prop.getValue());
			}
		}

		preloaded=true;
	}

	private void loadProperties(Properties prop, String propFileName) {
		try {
			BufferedReader bufReader=new BufferedReader(new InputStreamReader(PropertyServiceImpl.class.getResourceAsStream(propFileName), "UTF-8"));
			prop.load(bufReader);
		} catch (Throwable e) {
			log.warn("Can't load properties from file '{}' - continue", propFileName);
		}
	}

	public boolean isUserLevelProperty(ServiceContext ctx, String propName) {
		String allowUserPropStr=defaultProp.getProperty(propName + PROP_DELIMITER + USER_LEVEL_PROPERTY_SUFFIX);
		boolean allowUserProp = false;
		if ("true".equals(allowUserPropStr)) {
			allowUserProp=true;
		}
		return allowUserProp;
	}

	public String translate(ServiceContext ctx, String path, String name) {
		path=makeLangProperty(ctx, path);
		String tran;
		try {
			tran = getPropertyValue(ctx, path, name, null);
	
			if (tran == null && name != null) {
				tran = generateTrans(path, name);
				defaultProp.setProperty(path + "." + name, tran);
			}
		} catch (Exception e) {
			tran = name;
			log.warn("Can not transalate message "+name, e);
		}

		return tran;
	}

	public String translate(ServiceContext ctx, String name) {
		String key=makeLangProperty(ctx, name);
		String tran;
		try {
			tran = getPropertyValue(ctx, null, key, null);
	
			if (tran == null && name != null) {
				tran = generateTrans(null, name);
				defaultProp.setProperty(key, tran);
			}
		} catch (Exception e) {
			tran = key;
			log.warn("Can not transalate message "+name, e);
		}

		return tran;
	}

	private String generateTrans(String path, String propName) {
		if (Config.isDevelopmentMode()) {
			path = path == null ? "" : path + ".";
			return "@"+path+propName;
		} else {
			String tran=propName.replaceAll("(\\p{Upper}+)", " $1").trim();
			return tran.substring(0, 1).toUpperCase()+tran.substring(1);
		}
	}

	public String makeLangProperty(ServiceContext ctx, String propName) {
		String lang = (String) ctx.getProperty("lang");
		if (lang==null) {
			lang="en";
		}
		
		return propName == null ? lang : lang+PROP_DELIMITER+propName;
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	public String getStartupProperties() {
		return startupProperties;
	}

	public void setStartupProperties(String startupProperties) {
		this.startupProperties = startupProperties;
	}

}