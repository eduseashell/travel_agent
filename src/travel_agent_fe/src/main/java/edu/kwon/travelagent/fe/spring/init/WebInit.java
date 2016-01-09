package edu.kwon.travelagent.fe.spring.init;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.util.ObjectUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import ru.xpoft.vaadin.SpringApplicationContext;
import ru.xpoft.vaadin.SpringVaadinServlet;
import edu.kwon.frmk.common.share.spring.context.AppContext;
import edu.kwon.travelagent.core.config.ConfigParam;
import edu.kwon.travelagent.fe.spring.config.profiledefault.AppDataConfig;
import edu.kwon.travelagent.fe.spring.config.profiledefault.ApplicationMainContext;
import edu.kwon.travelagent.fe.spring.config.profiledefault.VaadinAppConfig;

/**
 * Web Application Inititializer
 * @author eduseashell
 *
 * @since Jun 27, 2015
 * @since
 * @version
 */
public class WebInit extends AbstractDispatcherServletInitializer {

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		Class<?>[] configClasses = {
			ApplicationMainContext.class,
			AppDataConfig.class
		};
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(configClasses);
		rootContext.getEnvironment().setDefaultProfiles(ConfigParam.APP_PROFILE_DEFAULT);
//		rootContext.refresh();
		
		// Set the context for using in the application
		AppContext.setAppContext(rootContext);
		return rootContext;
	}
	
	@Override
	protected WebApplicationContext createServletApplicationContext() {
		Class<?>[] configClasses = {
				VaadinAppConfig.class
		};
		
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		servletAppContext.register(configClasses);
		servletAppContext.getEnvironment().setDefaultProfiles(ConfigParam.APP_PROFILE_DEFAULT);
		servletAppContext.refresh();
		return servletAppContext;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}
	
	/**
	 * Override registerDispatcherServlet to register SpringVaadinServlet instead
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#registerDispatcherServlet(javax.servlet.ServletContext)
	 */
	@Override
	protected void registerDispatcherServlet(ServletContext servletContext) {
		SpringApplicationContext.setApplicationContext(createServletApplicationContext());
		SpringVaadinServlet dispatcherServlet = new SpringVaadinServlet();
		
		ServletRegistration.Dynamic registration = servletContext.addServlet(getServletName(), dispatcherServlet);
		registration.setLoadOnStartup(1);
		registration.addMapping(getServletMappings());
		registration.setAsyncSupported(isAsyncSupported());
		
		Filter[] filters = getServletFilters();
		if (!(ObjectUtils.isEmpty(filters))) {
			for (Filter filter : filters) {
				registerServletFilter(servletContext, filter);
			}
		}

		customizeRegistration(registration);
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setInitParameter("beanName", "mainUI");
		registration.setInitParameter("productionMode", "false");
		registration.setInitParameter("spring.profiles.default", ConfigParam.APP_PROFILE_DEFAULT);
//		registration.setInitParameter("contextConfigLocation", ConfigParam.VAADIN_CONTEXT_CONFIG_LOCATION);
//		registration.setInitParameter("spring.profiles.active", "");
	}
	
}
