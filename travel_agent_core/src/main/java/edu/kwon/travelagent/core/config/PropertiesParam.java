package edu.kwon.travelagent.core.config;

public class PropertiesParam {
	
	// Database
	public static final String DATABASE_URL = "${app.database.url}";
	public static final String DATABASE_INITIAL_SIZE = "${app.database.initial.size:5}";
	public static final String DATABASE_MAX_ACTIVE = "${app.database.max.active:10}";
	public static final String DATABASE_USERNAME = "${app.database.username}";
	public static final String DATABASE_PASSWORD = "${app.database.password}";
	
	// App message base name
	public static final String APP_MESSAGE_FILE_NAME = "${app.message:message}";
	
	// App common config
	public static final String DEFAULT_LOCALE_LANGUAGE = "${default.locale.language:en}";
	public static final String DEFAULT_LOCALE_REGION = "${default.locale.region:US}";
	
	public static final String APP_LOGO = "app.logo";
	
	private PropertiesParam() {}

}
