package com.dailyapp.logging;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.log4j.MDC;

import com.dailyapp.constants.Constants;

public class AppLogger {

	// create private constructor
	// create log level-wise log methods --> check islogenabled then log.
	// generate uuid for user

	private AppLogger() {
		// do nothing
	}

	public static void debug(final String log, final Log logger) {
		if (logger.isDebugEnabled()) {
			logger.debug(log);
		}

	}

	public static void info(final String log, final Log logger) {
		if (logger.isInfoEnabled()) {
			logger.info(log);
		}

	}

	public static void error(final String log, final Exception e, final Log logger) {
		if (logger.isErrorEnabled()) {
			logger.error(log, e);
		}

	}

	public static void generateUUID() {
		/*
		 * Mapped Diagnostic Context</em>, or MDC in short, is an instrument for
		 * distinguishing interleaved log output from different sources
		 */
		MDC.put(Constants.CLIENT, UUID.randomUUID().toString());
	}

	public static void removeUUID() {
		MDC.remove(Constants.CLIENT);
	}

}
