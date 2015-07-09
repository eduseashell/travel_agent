package edu.kwon.travelagent.fe.spring.config.profiledefault;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;

import edu.kwon.frmk.common.share.spring.util.I18N;
import edu.kwon.travelagent.core.config.ConfigParam;
import edu.kwon.travelagent.core.config.PropertiesParam;

/**
 * Travel agent Front end Main Context "ApplicationMainContext"
 * @author Bunlong Taing
 *
 * @since Jun 28, 2015
 * @since 0.0.1
 * @version 0.0.1
 */
@Profile(ConfigParam.APP_PROFILE_DEFAULT)
@Configuration
@PropertySource(ConfigParam.APP_CONFIG_LOCATION)
public class ApplicationMainContext {
	
	@Value(PropertiesParam.APP_MESSAGE_FILE_NAME)
	private String message;
	
	@Value(PropertiesParam.DEFAULT_LOCALE_LANGUAGE)
	private String defaultLanguage;
	
	@Value(PropertiesParam.DEFAULT_LOCALE_REGION)
	private String defaultRegion;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(false);
		propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(false);
		return propertySourcesPlaceholderConfigurer;
	}
	
	@Bean
	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(message);
//		messageSource.setCacheSeconds(1);
		return messageSource;
	}
	
	@Bean
	public I18N i18n() {
		I18N i18n = new I18N();
		i18n.setMessageSource(messageSource());
		Locale defaultLocale = new Locale(defaultLanguage, defaultRegion);
		i18n.setLocale(defaultLocale);
		return i18n;
	}
	
//	@Bean
//	public Properties pros() throws IOException {
//		Resource resource = new ClassPathResource(ConfigParam.APP_CONFIG_LOCATION_RAW);
//		Properties pros = PropertiesLoaderUtils.loadProperties(resource);
//		return pros;
//	}

}
