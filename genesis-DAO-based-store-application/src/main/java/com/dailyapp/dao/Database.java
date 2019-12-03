package com.dailyapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dailyapp.constants.Properties;
import com.dailyapp.logging.AppLogger;

public class Database {
	private static final Log LOGGER = LogFactory.getLog(Database.class);

	private static String driver = Properties.DRIVER;
	private static Connection con = null;
	
	public static Connection getConnection(){
		try {
			if (null==con || con.isClosed()) {
				con = DriverManager.getConnection(driver);
				AppLogger.info("connecion with database successful", LOGGER);
			}
		} catch (Exception e) {
			AppLogger.error("error occured while creating DB connection : ", e, LOGGER);
		}
		return con;
	}
}
