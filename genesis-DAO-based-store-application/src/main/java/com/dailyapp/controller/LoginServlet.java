package com.dailyapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dailyapp.constants.Constants;
import com.dailyapp.logging.AppLogger;
import com.dailyapp.model.User;
import com.dailyapp.service.ErrorService;
import com.dailyapp.service.LoginService;
import com.dailyapp.service.ValidationService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactory.getLog(LoginServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AppLogger.generateUUID();
		AppLogger.info("forwarding request to login page served at: " + request.getContextPath(), LOGGER);
		request.getRequestDispatcher(Constants.LOGIN_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new LoginService().fetchUser(request);
		if (ValidationService.validateUser(request, user)) {
			AppLogger.info("forwarding request to welcome page served at: " + request.getContextPath() + "for user "
					+ request.getParameter(Constants.EMAIL), LOGGER);
			request.setAttribute(Constants.USER, user);
			request.getRequestDispatcher(Constants.WELCOME_PAGE).forward(request, response);
		} else {
			AppLogger.info(
					"validation failed : " + request.getParameter(Constants.EMAIL) + " : re-directing to error page",
					LOGGER);
			String errorMessage = new ErrorService().createErrorMessage(request, user);
			request.setAttribute(Constants.ERROR_MESSAGE, errorMessage);
			request.getRequestDispatcher(Constants.ERROR_PAGE).forward(request, response);
		}
	}

}
