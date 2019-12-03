package com.dailyapp.utils;

import com.dailyapp.constants.Constants;
import com.dailyapp.model.User;

public class QueryHelper {
	

	private QueryHelper() {
		// do nothing
	}

	public static String fetchAddUserQuery(User user) {
		return "INSERT INTO " + Constants.TABLE_NAME +
				" values (\"" + user.getFirstName() + Constants.COLUMN_SEPARATOR
				+ user.getLastName() + Constants.COLUMN_SEPARATOR 
				+ user.getEmail() + Constants.COLUMN_SEPARATOR 
				+ user.getPassword() + Constants.COLUMN_SEPARATOR
				+ user.getAge() + "\");";
	}

	public static String fetchDeleteUserQuery(User user) {
		return "DELETE FROM" + Constants.TABLE_NAME 
				+ " WHERE " + Constants.EMAIL 
				+ " = \"" + user.getEmail()+"\";";
	}
	
	public static String fetchGetUserQuery(String email){
		return "SELECT * FROM " + Constants.TABLE_NAME 
				+ " WHERE " + Constants.EMAIL 
				+ " = \"" + email+"\";";
	}
}
