/**
 * 
 */
package com.gnv.vnm.selfcare.core.utils;

import org.slf4j.Logger;

/**
 * @author nandipinto
 *
 */
public class LoggingUtil {

	public static void debug(Logger logger, String message, Throwable exception){
		if (logger.isDebugEnabled()) logger.debug(message, exception);
	}
	
	public static void debug(Logger logger, String message){
		if (logger.isDebugEnabled()) logger.debug(message);
	}
	
	public static void info(Logger logger, String message, Throwable exception){
		if (logger.isInfoEnabled()) logger.info(message, exception);
	}

	public static void info(Logger logger, String message){
		if (logger.isInfoEnabled()) logger.info(message);
	}

	public static void warn(Logger logger, String message, Throwable exception){
		if (logger.isWarnEnabled()) logger.warn(message, exception);
	}

	public static void error(Logger logger, String message, Throwable exception){
		logger.error(message, exception);
	}
}
