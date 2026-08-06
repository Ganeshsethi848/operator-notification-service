package com.telecom.operator.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigurationUtil {

	private static final Properties properties = new Properties();

	static {

		try (InputStream in = ConfigurationUtil.class.getClassLoader().getResourceAsStream("application.properties")) {

			if (in == null) {
				throw new RuntimeException("application.properties not found");
			}

			properties.load(in);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	private ConfigurationUtil() {
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

}