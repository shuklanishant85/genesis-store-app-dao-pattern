package com.dailyapp.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dailyapp.constants.Constants;
import com.dailyapp.logging.AppLogger;

public class AppProperties {
	private static final Log LOGGER = LogFactory.getLog(AppProperties.class);
	private static AppProperties appProperties;
	private static Properties properties;

	// private constructor
	// static block to call get instance
	// public static set properties
	// public static get properties
	// private static create instance
	// load class loader --> load file --> read file --> load into properties
	private AppProperties() {
		// do nothing
	}

	static {
		AppLogger.info("initializing properties into application", LOGGER);
		getInstance();
	}

	private static synchronized AppProperties getInstance() {
		if (appProperties == null) {
			synchronized (AppProperties.class) {
				appProperties = new AppProperties();
				properties = new Properties();
				ClassLoader loader = AppProperties.class.getClassLoader();
				try {
					AppLogger.info("loading properties from file : [" + Constants.PROPERTIES_FILE + "]", LOGGER);
					InputStream stream = loader.getResourceAsStream(Constants.PROPERTIES_FILE);
					properties.load(stream);
				} catch (IOException e) {
					AppLogger.error("exception occured while reading properties file ", e, LOGGER);
				}
			}
		}
		return appProperties;
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
