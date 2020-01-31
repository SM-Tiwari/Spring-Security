/**
 * WebPortalUtils.java
 */
package com.gnv.vnm.selfcare.webportal.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * @author nandipinto
 *
 */
public class WebPortalUtils {

	public static String resolveMessage(MessageSource messageSource, String key, Object[] args, String defaultMessage){
		return messageSource.getMessage(key, args, defaultMessage, Locale.getDefault());
	}

}
