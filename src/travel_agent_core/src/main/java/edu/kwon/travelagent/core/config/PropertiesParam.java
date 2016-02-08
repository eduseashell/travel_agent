package edu.kwon.travelagent.core.config;

public interface PropertiesParam {
	
	// Database
	String DATABASE_URL = "${app.database.url}";
	String DATABASE_INITIAL_SIZE = "${app.database.initial.size:5}";
	String DATABASE_MAX_ACTIVE = "${app.database.max.active:10}";
	String DATABASE_USERNAME = "${app.database.username}";
	String DATABASE_PASSWORD = "${app.database.password}";
	
	// App message base name
	String APP_MESSAGE_FILE_NAME = "${app.message:message}";
	
	// App common config
	String DEFAULT_LOCALE_LANGUAGE = "${default.locale.language:en}";
	String DEFAULT_LOCALE_REGION = "${default.locale.region:US}";
	
	String APP_LOGO = "app.logo";

}
