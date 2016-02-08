package edu.kwon.travelagent.core.config;

public interface ConfigParam {
	
	// Application configuration
	String APP_CONFIG_LOCATION_RAW = "application";
	String APP_CONFIG_LOCATION = "classpath:" + APP_CONFIG_LOCATION_RAW;
	String APP_PROPERTIES_EXT = ".properties";
	String APP_CONFIG_PROPERTIES = APP_CONFIG_LOCATION + APP_PROPERTIES_EXT;
	
	String APP_PROFILE_DEFAULT = "default";
	String APP_PROFILE_DEV = "development";
	String APP_PROFILE_PRO = "production";
	
	String APP_PROFILE_DEFAULT_PROPERTIES = APP_CONFIG_LOCATION + "-" + APP_PROFILE_DEFAULT + APP_PROPERTIES_EXT;
	String APP_PROFILE_DEV_PROPERTIES = APP_CONFIG_LOCATION + "-" + APP_PROFILE_DEV + APP_PROPERTIES_EXT;
	String APP_PROFILE_PRO_PROPERTIES = APP_CONFIG_LOCATION + "-" + APP_PROFILE_PRO + APP_PROPERTIES_EXT;
	
	String JPA_REPO_BASE_PACKAGE = "edu.kwon.frmk.common.data.jpa.repository";
	String ENTITY_PACKAGE_TO_SCAN = JPA_REPO_BASE_PACKAGE;
	
	// Hibernate
	String HIBERNATE_SHOW_SQL = "true";
	String HIBERNATE_HBM2DDL_AUTO = "update";
	
	// VAADIN
	String VAADIN_PACKAGE_SCAN_FRMK = "edu.kwon.frmk.vaadin.gui";
	String VAADIN_PACKAGE_SCAN_CORE = "edu.kwon.travelagent.core.vaadin.menu";
	String VAADIN_PACKAGE_SCAN_FE = "edu.kwon.travelagent.fe.gui";

}
