package com.dailyapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dailyapp.logging.AppLogger;
import com.dailyapp.model.User;
import com.dailyapp.utils.QueryHelper;

public class UserDaoImpl implements UserDao {
	private static final Log LOGGER = LogFactory.getLog(UserDao.class);

	public void addUser(User user) {
		Connection con = Database.getConnection();
		String addUserQuery = QueryHelper.fetchAddUserQuery(user);
		AppLogger.info("executing query for adding user : " + addUserQuery, LOGGER);
		executeFormatUserQuery(addUserQuery, con);
		try {
			con.close();
		} catch (SQLException e) {
			AppLogger.error("exception while closing DB connection : ", e, LOGGER);
		}
	}

	public void removeUser(User user) {
		Connection con = Database.getConnection();
		String removeUserQuery = QueryHelper.fetchDeleteUserQuery(user);
		AppLogger.info("executing query for removing user : " + removeUserQuery, LOGGER);
		executeFormatUserQuery(removeUserQuery, con);
		try {
			con.close();
		} catch (SQLException e) {
			AppLogger.error("exception while closing DB connection : ", e, LOGGER);
		}
	}

	public User getUser(String email) {
		Connection con = Database.getConnection();
		String getUserQuery = QueryHelper.fetchGetUserQuery(email);
		AppLogger.info("executing query for getting user : " + getUserQuery, LOGGER);
		ResultSet rs = executeFormatUserQuery(getUserQuery, con);
		User user = null;
		try {
			if (null != rs) {
				AppLogger.info("Result Set returned : " + rs.toString(), LOGGER);
				user = new User();

				if (StringUtils.isNotBlank(rs.getString(1))) {
					user.setFirstName(rs.getString(1));
					AppLogger.info("First Name : " + rs.getString(1), LOGGER);
				}
				if (StringUtils.isNotBlank(rs.getString(2))) {
					user.setLastName(rs.getString(2));
					AppLogger.info("Last Name : " + rs.getString(2), LOGGER);
				}
				if (StringUtils.isNotBlank(rs.getString(3))) {
					user.setEmail(rs.getString(3));
					AppLogger.info("Email : " + rs.getString(3), LOGGER);
				}
				if (StringUtils.isNotBlank(rs.getString(4))) {
					user.setPassword(rs.getString(4));
				}
				if (StringUtils.isNotBlank(rs.getString(5))) {
					user.setAge(rs.getInt(5));
					AppLogger.info("Age : " + rs.getString(5), LOGGER);
				}
			}else {
				AppLogger.info("Result Set returned by DB : "+rs, LOGGER);
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			user = null;
			AppLogger.error("Error while fetching user from DB : ", e, LOGGER);
		}
		

		return user;
	}

	public void updateUser(User user) {
		// later
	}

	private ResultSet executeFormatUserQuery(String formatUserQuery, Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(formatUserQuery);
		} catch (SQLException e) {
			AppLogger.error("exception while creating SQL : ", e, LOGGER);
		} 
		return rs;
	}

}
