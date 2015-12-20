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
@Profile(ConfigParam.APP_PROFILE_DEFAULT)
@Configuration
@ComponentScan(basePackages = {"edu.kwon.travelagent.fe.gui", "edu.kwon.travelagent.core.vaadin.menu"})
public class VaadinAppConfig {

}
