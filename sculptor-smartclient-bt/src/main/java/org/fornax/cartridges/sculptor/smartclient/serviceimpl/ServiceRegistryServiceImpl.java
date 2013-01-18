package org.fornax.cartridges.sculptor.smartclient.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.framework.annotation.Name;
import org.fornax.cartridges.sculptor.smartclient.framework.GuiDecorator;
import org.fornax.cartridges.sculptor.smartclient.framework.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Implementation of ServiceRegistryService.
 */
@Service("serviceRegistryService")
public class ServiceRegistryServiceImpl 
		extends ServiceRegistryServiceImplBase
		implements ApplicationContextAware {

	private static final Logger log=LoggerFactory.getLogger(ServiceRegistryServiceImpl.class);

	public ServiceRegistryServiceImpl() {
	}

	public List<ServiceDescription> getServices(@Name("ctx") ServiceContext ctx) {
		return getServiceDescription();
	}

	List<ServiceDescription> serviceDescription=null;
	private List<ServiceDescription> getServiceDescription() {
		if (serviceDescription == null) {
			synchronized(ServiceRegistryServiceImpl.class) {
				if (serviceDescription == null) {
					serviceDescription=initServiceDescription();
				}
			}
		}
		return serviceDescription;
	}

	private synchronized List<ServiceDescription> initServiceDescription() {
		List<ServiceDescription> srvDesc=new ArrayList<ServiceDescription>();
		ArrayList<GuiDecorator> decorators=new ArrayList<GuiDecorator>();
		ApplicationContext appContext = getApplicationContext();
		log.trace("Spring appContext = {}", appContext);

		while (appContext != null) {
			for (String beanName : appContext.getBeanDefinitionNames()) {
				Object bean = applicationContext.getBean(beanName);

				if (beanName.endsWith("Service")) {
					try {
						ServiceDescription service=new ServiceDescription(beanName, bean, propertyFacade);
						srvDesc.add(service);
						log.info("Found new service {}", beanName);
					} catch (Exception e) {
						log.warn("Bean ''{}'' isn''t service because: ''{}''", beanName, e.getMessage());
					}
				}

				if (bean instanceof GuiDecorator) {
					decorators.add((GuiDecorator) bean);
				}
			}
			appContext=appContext.getParent();
		}

		for (GuiDecorator decorator : decorators) {
			try {
				decorator.decorateServiceDescriptor(srvDesc);
			} catch (Throwable th) {
				log.warn("Decorator '{}' fired exception: {}", decorator.getClass().getName(), th.getMessage());
			}
		}

		return srvDesc;
	}

	@Autowired
	PropertySupportFacade propertyFacade;

	/* ###########################################################################
	 * # Methods for IoC
	 * ########################################################################### */
	ApplicationContext applicationContext=null;
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext=applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void refresh(@Name("ctx")ServiceContext ctx) {		
		synchronized(ServiceRegistryServiceImpl.class) {
			serviceDescription = null;
		}
	}
}
