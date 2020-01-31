/**
 * TokenProvider.java
 */
package com.gnv.vnm.selfcare.core.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.fault.TokenExpiredException;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;

/**
 * @author nandipinto
 *
 */

//@Component
public class TokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
	public static final int EXPIRATION_MIN = 5;
	
	private static final String DELIMITER 	= "!";
	private static final int TOKEN_COUNT	= 5;
	
	private int expiryTimeInMinutes = EXPIRATION_MIN;
	
	public TokenProvider() {}

	/**
	 * @return the expiryTimeInMinutes
	 */
	public int getExpiryTimeInMinutes() {
		return expiryTimeInMinutes;
	}

	/**
	 * @param expiryTimeInMinutes the expiryTimeInMinutes to set
	 */
	public void setExpiryTimeInMinutes(int expiryTimeInMinutes) {
		this.expiryTimeInMinutes = expiryTimeInMinutes;
	}


	public String getToken(String clientAppId, String secretKey, String userName) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//MSISDN!APP_ID!SECRET_KEY!TIME_IN_MILLIS!TOKEN_KEY
		StringBuilder tokenBuilder = new StringBuilder();

		long millis = System.currentTimeMillis();
		byte[] token = tokenBuilder
				.append(userName).append(DELIMITER)
				.append(clientAppId).append(DELIMITER)
				.append(secretKey).append(DELIMITER)
				.append(millis).append(DELIMITER)
				.append(new String(buildTokenKey(userName, clientAppId, secretKey, millis)))
				.toString().getBytes("UTF-8");

		return Base64.getEncoder().encodeToString(token);

	}

	public String buildTokenKey(String userName, String clientAppId, String secretKey, long timeInMillis) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//MSISDN!APP_ID!SECRET_KEY!TIME_IN_MILLIS

		Assert.notNull(secretKey, "Secret Key must not be null!");
		
		StringBuilder keyBuilder = new StringBuilder();
		String key = keyBuilder
				.append(userName).append(DELIMITER)
				.append(clientAppId).append(DELIMITER)
				.append(secretKey).append(DELIMITER)
				.append(timeInMillis).toString();

		byte[] keyBytes = key.getBytes("UTF-8");
		
		return AppUtils.byteArrayToHexString(MessageDigest.getInstance("SHA-256").digest(keyBytes));
	}

	public String getUserFromToken(String encodedToken) throws NoSuchAlgorithmException, UnsupportedEncodingException, TokenExpiredException {
		String[] components = decodeAndDissectToken(encodedToken);
		
		if (components == null || components.length != TOKEN_COUNT) {
			return null;
		}
		//MSISDN!APP_ID!SECRET_KEY!TIME_IN_MILLIS!TOKEN_KEY
		String userName = components[0];
		String extAppId = components[1];
		String extSecretKey = components[2];
		Long timeInMillis = Long.parseLong(components[3]);
		String externalKey = components[4];   				//---> this produces incorrect result when running under Tomcat???
		
		LoggingUtil.debug(logger, "#isTokenValid --- userName= " + userName
				+ ", appId= " + extAppId
				+ ", secretKey= " + extSecretKey
				+ ", time= " + AppUtils.dateToString(new Date(timeInMillis), "yyyyMMdd HH:mm:ss") 
				+ ", token_key= " + externalKey);

		String expectedKey = new String(buildTokenKey(userName, extAppId, extSecretKey, timeInMillis));

		LoggingUtil.debug(logger,"#isTokenValid --- expectedKey= " + expectedKey);

		if (!MessageDigest.isEqual(expectedKey.getBytes("UTF-8"), externalKey.getBytes("UTF-8"))) {
			LoggingUtil.debug(logger,"#isTokenValid --- given token key doesn't match expected key!");
			return null;
		}

		long delta = (new Date().getTime() - new Date(timeInMillis).getTime()) / (1000 * 60);
		
		LoggingUtil.debug(logger,"#isTokenValid --- delta in minutes= " + delta);
		
		if (delta > getExpiryTimeInMinutes()) throw new TokenExpiredException("Token has expired!");

		return userName;
	}

	public String[] decodeAndDissectToken(String encodedToken) throws UnsupportedEncodingException {
		if (!StringUtils.hasText(encodedToken)){ //|| !Base64.isBase64(encodedToken.getBytes())) {
			return null;
		}

		String token = new String(Base64.getDecoder().decode(encodedToken), "UTF-8");
		LoggingUtil.debug(logger,"#isTokenValid --- decoded token= " + token);
		
		if (!token.contains(DELIMITER)) {
			return null;
		}
		String[] values = token.split(DELIMITER);
		if (values.length != TOKEN_COUNT) return null;

		return values;
	}
	
	public static void main(String[] args){
		final String token = "MDE4ODgwNDQwMDMhZ2FtaWZ5IXRlc3Rfc2VjcmV0X2tleSExNDk2NjQ4Mjk0NzExITA5N2M1NDFmNTExZTdmN2YyNzA3OTk0MTllNDg5ZDViOGFjOTA0ODI2YWM0ZWE4ZGMyZmIxN2ZiNTYwMGE4YWY=";
		
		try {
			TokenProvider tp = new TokenProvider();
//			System.out.println(tp.getUserFromToken(token));
			String[] values = tp.decodeAndDissectToken(token);
			for (String v:values) System.out.println(v);
			
			System.out.println(AppUtils.dateToString(new Date(1496648294711L), "dd-MM-yyyy HH:mm:ss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
