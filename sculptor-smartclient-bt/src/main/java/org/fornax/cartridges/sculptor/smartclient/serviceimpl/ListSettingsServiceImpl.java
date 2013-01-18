package org.fornax.cartridges.sculptor.smartclient.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteria;
import org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.fornax.cartridges.sculptor.framework.annotation.Name;
import org.fornax.cartridges.sculptor.framework.domain.PagingParameter;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.smartclient.domain.ListSettings;
import org.fornax.cartridges.sculptor.smartclient.domain.ListSettingsProperties;
import org.fornax.cartridges.sculptor.smartclient.exception.ListSettingsNotFoundException;
import org.fornax.cartridges.sculptor.smartclient.exception.NotAuthorizedException;
import org.springframework.stereotype.Service;

/**
 * Implementation of ListSettingsService.
 */
@Service("listSettingsService")
public class ListSettingsServiceImpl extends ListSettingsServiceImplBase {

	public List<ListSettings> findUserSettings(@Name("ctx") ServiceContext ctx) {
		List<ConditionalCriteria> condition = ConditionalCriteriaBuilder.criteriaFor(ListSettings.class)
				.withProperty(ListSettingsProperties.userName()).in(new Object[] {"default", ctx.getUserId()}).build();
		List<ListSettings> curList = getListSettingsRepository().findByCondition(condition, PagingParameter.noLimits()).getValues();

		HashMap<String, ListSettings> userVals=new HashMap<String, ListSettings>();
		for (ListSettings listSettings : curList) {
			if (ctx.getUserId().equals(listSettings.getUserName())
					|| ("default".equals(listSettings.getUserName()) && !userVals.containsKey(listSettings.getListID()))) {
				userVals.put(listSettings.getListID(), listSettings);
			}
		}

		return new ArrayList<ListSettings>(userVals.values());
	}

	@Override
	public ListSettings save(@Name("ctx") ServiceContext ctx, 
			@Name("entity") ListSettings entity) throws NotAuthorizedException {

		if (!isUserInRole("ROLE_ADMIN", ctx.getRoles()) && !ctx.getUserId().equals(entity.getUserName())) {
			throw new NotAuthorizedException("ERR9016 - User can change only his own settings (set User attribute to your name)");
		}

		ListSettings retVal;
		try {
			ListSettings existingVal = getListSettingsRepository().findByKey(entity.getListID(), entity.getUserName());
			existingVal.setSettings(entity.getSettings());
			retVal=super.save(ctx, existingVal);
		} catch (ListSettingsNotFoundException e) {
			retVal=super.save(ctx, entity);
		}
		return retVal;
	}

	private boolean isUserInRole(String role, Set<String> roles) {
		for (String assRole : roles) {
			if (role.equalsIgnoreCase(assRole)) {
				return true;
			}
		}

		return false;
	}
}
