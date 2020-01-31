/**
 * 
 */
package com.gnv.vnm.selfcare.core.utils;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * @author nandipinto
 *
 */
public class SpringUtils {

	public static String resolveMessage(MessageSource messageSource, String key, Object[] args, String defaultMessage, Locale locale){
		return messageSource.getMessage(key, args, defaultMessage, locale);
	}

}
