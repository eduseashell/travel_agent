package edu.kwon.travelagent.core.config;

public class ConfigParam {
	
	// Application configuration
	public static final String APP_CONFIG_LOCATION_RAW = "application.properties";
	public static final String APP_CONFIG_LOCATION = "classpath:" + APP_CONFIG_LOCATION_RAW;
	public static final String JPA_REPO_BASE_PACKAGE = "edu.kwon.frmk.common.data.jpa.repository";
	public static final String ENTITY_PACKAGE_TO_SCAN = JPA_REPO_BASE_PACKAGE;
	
	// VAADIN
	public static final String VAADIN_CONTEXT_CONFIG_LOCATION = "/WEB-INF/classes/vaadin-context.xml";
	
	private ConfigParam() {}

}
