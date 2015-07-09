package edu.kwon.travelagent.core.config.util;

import edu.kwon.frmk.common.share.spring.util.AppConfig;
import edu.kwon.travelagent.core.config.PropertiesParam;
/**
 * Provide the Core configuration properties
 * @author Bunlong Taing
 *
 * @since Jul 9, 2015
 * @since 0.0.1
 * @version 0.0.1
 */
public class CoreAppConfig extends AppConfig {
	
	public static String getAppLogo() {
		return getConfigValue(PropertiesParam.APP_LOGO);
	}

}
