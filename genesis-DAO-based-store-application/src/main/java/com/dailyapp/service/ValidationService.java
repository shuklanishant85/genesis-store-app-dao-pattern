package com.dailyapp.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dailyapp.constants.Constants;
import com.dailyapp.logging.AppLogger;
import com.dailyapp.model.User;

public class ValidationService {
	
	private ValidationService(){
		//do nothing
	}
	
	private static final Log LOGGER = LogFactory.getLog(ValidationService.class);

	public static boolean validateUser(HttpServletRequest request, User user) {
		AppLogger.info("Into ValidationService : validating user for login", LOGGER);
		return ((null!=user) && (StringUtils.isNotBlank(user.getPassword()))
				&& (StringUtils.isNotBlank(request.getParameter(Constants.PASSWORD)))
				&& (StringUtils.equals(user.getPassword(), request.getParameter(Constants.PASSWORD))));
	}
}
