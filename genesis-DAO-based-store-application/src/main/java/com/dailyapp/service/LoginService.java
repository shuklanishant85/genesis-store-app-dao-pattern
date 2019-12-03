package com.dailyapp.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dailyapp.constants.Constants;
import com.dailyapp.dao.UserDao;
import com.dailyapp.dao.UserDaoImpl;
import com.dailyapp.logging.AppLogger;
import com.dailyapp.model.User;

public class LoginService {
private static final Log LOGGER = LogFactory.getLog(LoginService.class);
	
	public User fetchUser(HttpServletRequest request){
		AppLogger.info("Into Login Service : fetching user with email : "+request.getParameter(Constants.EMAIL), LOGGER);
		User user = null;
		UserDao dao = new UserDaoImpl();
		if (StringUtils.isNotBlank(request.getParameter(Constants.EMAIL))) {
			user = dao.getUser(request.getParameter(Constants.EMAIL));
		}
		return user;
	}
	
}
