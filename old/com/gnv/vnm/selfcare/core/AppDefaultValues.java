/**
 * AppDefaultValues.java
 */
package com.gnv.vnm.selfcare.core;

/**
 * @author nandipinto
 *
 */
public interface AppDefaultValues {

	public static final int TOKEN_EXP_IN_MINUTES = 5;
	public static final int OBJECT_POOL_MAX_IDLE = 20;
	public static final int OBJECT_POOL_MAX_TOTAL = 100;
	public static final int MIN_PASSWORD_LENGTH = 8;
	public static final int PAGED_LIST_SIZE = 9;
	public static final int MIN_DEPOSIT_AMOUNT = 3000000;

	
	
	
	
	public static final String COUNTRY_CODE = "84";
	public static final String LANGUAGE_VIETNAMESE = "vi";
	public static final String LANGUAGE_ENGLISH = "en";
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
	public static final String GREGORIAN_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public static final String AVATAR_IMG_FILE_EXT = "jpg";

	public static final String INTERNAL_APP_ERROR_CODE = "9999";
	public static final String INTERNAL_APP_ERROR_MSG = "Internal application error";

	public static final String SMS_SENDER_ID = "SELFCARE";
	public static final String CURRENCY_VND = "VND";
	public static final String PHONE_NO_REGEX = "((84)|0)((18)|(92))[0-9]{7,8}$"; // "0((18)|(92))[0-9]{7,8}";
	public static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-zA-Z]).{8,})";

}
