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
import com.dailyapp.service.SignUpService;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet(urlPatterns="/signup")
public class SignUpServlet extends HttpServlet {
	private static final Log LOGGER = LogFactory.getLog(SignUpServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppLogger.info("redirecting to Sign-up page served at: " + request.getContextPath(), LOGGER);
		request.getRequestDispatcher(Constants.SIGNUP_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppLogger.info("into doPost method : calling sign-up service", LOGGER);
		SignUpService service = new SignUpService();
		User user = service.createUser(request);
		service.updateUserInDB(user);
		request.setAttribute(Constants.USER, user);
		AppLogger.info("new user created : redirecting to welcome page", LOGGER);
		request.getRequestDispatcher(Constants.WELCOME_PAGE).forward(request, response);
	}

}
