package edu.kwon.travelagent.fe.spring.config.profiledefault;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import edu.kwon.travelagent.core.config.ConfigParam;

/**
 * 
 * @author eduseashell
 * @since 0.0.1
 * @version 0.0.1
 */
@Configuration
@Profile(ConfigParam.APP_PROFILE_DEFAULT)
@ComponentScan(basePackages = {
		ConfigParam.VAADIN_PACKAGE_SCAN_FRMK,
		ConfigParam.VAADIN_PACKAGE_SCAN_CORE,
		ConfigParam.VAADIN_PACKAGE_SCAN_FE
		})
public class VaadinAppConfig {

}
