package edu.kwon.travelagent.fe.test;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import edu.kwon.frmk.common.share.spring.context.AppContext;
import edu.kwon.travelagent.core.config.ConfigParam;
import edu.kwon.travelagent.fe.spring.config.profiledefault.AppDataConfig;
import edu.kwon.travelagent.fe.spring.config.profiledefault.ApplicationMainContext;

public class BaseTest {
	
	public BaseTest() {
		initAppContext();
	}
	
	protected void initAppContext() {
		Class<?>[] configClasses = {
				ApplicationMainContext.class,
				AppDataConfig.class
			};
			
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(configClasses);
		rootContext.getEnvironment().setDefaultProfiles(ConfigParam.APP_PROFILE_DEFAULT);
		rootContext.refresh();
		AppContext.setAppContext(rootContext);
	}

}
