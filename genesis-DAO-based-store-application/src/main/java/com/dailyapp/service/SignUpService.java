package com.dailyapp.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dailyapp.constants.Constants;
import com.dailyapp.dao.UserDao;
import com.dailyapp.dao.UserDaoImpl;
import com.dailyapp.logging.AppLogger;
import com.dailyapp.model.User;

public class SignUpService {
	private static final Log LOGGER = LogFactory.getLog(SignUpService.class);
	
	public User createUser(HttpServletRequest request){
		AppLogger.info("Into SignUp Service : creating new user", LOGGER);
		User user = new User();
		user.setFirstName(request.getParameter(Constants.FIRST_NAME));
		user.setLastName(request.getParameter(Constants.LAST_NAME));
		user.setEmail(request.getParameter(Constants.EMAIL));
		user.setPassword(request.getParameter(Constants.PASSWORD));
		user.setAge(Integer.parseInt(request.getParameter(Constants.AGE)));
		return user;
	}
	
	public void updateUserInDB(User user){
		AppLogger.info("Into SignUp Service : adding user into DataBase", LOGGER);
		UserDao dao = new UserDaoImpl();
		dao.addUser(user);
	}
	
}
