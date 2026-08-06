package com.telecom.operator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnectionUtil {

	private static final String URL = ConfigurationUtil.get("db.url");

	private static final String USERNAME = ConfigurationUtil.get("db.username");

	private static final String PASSWORD = ConfigurationUtil.get("db.password");

	private DBConnectionUtil() {
	}

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}