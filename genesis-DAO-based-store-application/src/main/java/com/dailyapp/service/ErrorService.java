package com.dailyapp.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.dailyapp.constants.Constants;
import com.dailyapp.model.User;

public class ErrorService {
	private static final String INVALID_PASSWORD_MESSAGE = "Please enter a valid username and a valid password";
	private static final String USER_NOT_REGISTERED_MESSAGE = "You are not a registered user. Please sign-up first";
	private static final String INCORRECT_PASSWORD_MESSAGE = "The password you enered is Incorrect. Please try again";

	public String createErrorMessage(HttpServletRequest request, User user) {
		if (!StringUtils.isNotBlank(request.getParameter(Constants.PASSWORD))) {
			return INVALID_PASSWORD_MESSAGE;
		} else if (null == user) {
			return USER_NOT_REGISTERED_MESSAGE;
		}
		return INCORRECT_PASSWORD_MESSAGE;
	}
}
