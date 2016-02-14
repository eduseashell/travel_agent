package edu.kwon.travelagent.core.config;

public interface ConfigParam {
	
	// Application configuration
	String APP_CONFIG_PROPERTIES = "classpath:application.properties";
	String APP_PROFILE_DEFAULT = "default";
	String APP_PROFILE_DEFAULT_PROPERTIES = "classpath:application-default.properties";
	String APP_PROFILE_DEV_PROPERTIES = "classpath:application-development.properties";
	String APP_PROFILE_PRO_PROPERTIES = "classpath:application-production.properties";
	
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
