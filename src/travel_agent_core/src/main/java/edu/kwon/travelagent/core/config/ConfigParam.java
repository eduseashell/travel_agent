package edu.kwon.travelagent.core.config;

public class ConfigParam {
	
	// Application configuration
	public static final String APP_CONFIG_LOCATION_RAW = "application";
	public static final String APP_CONFIG_LOCATION = "classpath:" + APP_CONFIG_LOCATION_RAW;
	public static final String APP_PROPERTIES_EXT = ".properties";
	public static final String APP_CONFIG_PROPERTIES = APP_CONFIG_LOCATION + APP_PROPERTIES_EXT;
	
	public static final String APP_PROFILE_DEFAULT = "default";
	public static final String APP_PROFILE_DEV = "development";
	public static final String APP_PROFILE_PRO = "production";
	
	public static final String APP_PROFILE_DEFAULT_PROPERTIES = APP_CONFIG_LOCATION + "-" + APP_PROFILE_DEFAULT + APP_PROPERTIES_EXT;
	public static final String APP_PROFILE_DEV_PROPERTIES = APP_CONFIG_LOCATION + "-" + APP_PROFILE_DEV + APP_PROPERTIES_EXT;
	public static final String APP_PROFILE_PRO_PROPERTIES = APP_CONFIG_LOCATION + "-" + APP_PROFILE_PRO + APP_PROPERTIES_EXT;
	
	public static final String JPA_REPO_BASE_PACKAGE = "edu.kwon.frmk.common.data.jpa.repository";
	public static final String ENTITY_PACKAGE_TO_SCAN = JPA_REPO_BASE_PACKAGE;
	
	// VAADIN
	public static final String VAADIN_CONTEXT_CONFIG_LOCATION = "/WEB-INF/classes/vaadin-context.xml";
	
	private ConfigParam() {}

}
