package com.gnv.vnm.selfcare.webportal.test;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.security.TokenProvider;
import com.gnv.vnm.selfcare.core.utils.AppUtils;

public class TokenLoginTest {

	private static final String NEWLINE = "\r\n";
	private static final String DELIMITER 	= "!";
	private static final int TOKEN_COUNT	= 5;
	private static final int EXPIRATION_MIN = 30;

	public static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.151 Safari/535.19";

	static String clientAppId = "gamify";
	static String secretKey = "test_secret_key";
	static String testToken = "MDE4ODgwNDQwMDMhZ2FtaWZ5IXNlY3JldF9rZXlfdGVzdCExNDk2Mjg0NTcyOTQ0Ie+/ve+/vVjvv73vv70GCSDvv70577+9Ce+/vS5r77+9";
//							  "MDE4ODgwNDQwMDMhZ2FtaWZ5IXRlc3Rfc2VjcmV0X2tleSExNTA1ODk5NjUxMzM4ITE4YTk5ZjZiYzc5MWMxZjIxN2JhNmZlNmQ2NzliZWVkYTRhODk2YmFkNTgzZmRkYzRmOGIxZmMzMGU1NGNmYmE=\n"; 
							 
							  
	static String url = "https://thongtin.vietnamobile.com.vn/tokenLogin";

	private static final CloseableHttpClient httpClient = HttpClients.custom()
            .setUserAgent(USER_AGENT)
            .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).build())
            .setRedirectStrategy(new LaxRedirectStrategy())
            .build();

	public static void main(String[] args) {
		
		TokenLoginTest test = new TokenLoginTest();
		CloseableHttpResponse response = null;
		try {
			TokenProvider tp = new TokenProvider();
			String token = getToken(clientAppId, secretKey, "01888044003");
			System.out.println(token);
//			System.out.println(tp.isTokenValid(token) + ", " + test.isTokenValid(token));
			
			System.exit(0);
//			
//			System.out.println(tp.getUserFromToken("MDE4ODgwNDQwMDMhZ2FtaWZ5IXNlY3JldF9rZXlfdGVzdCExNDk2MjQ2NTQ1Mzk1IVYM77+9QUPvv70f77+9JyXvv71T77+9"));
//			System.exit(0);

//			String token = tp.getToken(clientAppId, secretKey, "01888044003");
//			System.out.println(token);
//			System.out.println(tp.getUserFromToken(token));
//			System.exit(0);

//			String token = "MDE4ODgwNDQwMDMhZ2FtaWZ5IXNlY3JldF9rZXlfdGVzdCExNDk2MjQ3OTc2NjkyIe+/ve+/vWJm77+9IO+/ve+/vWXvv73vv73vv73vv73vv70=";
			HttpClientContext context = HttpClientContext.create();
			HttpGet http = new HttpGet(url);
//            http.addHeader("SELFCARE-AUTH-TOKEN", "MDE4ODgwNDQwMDMhZ2FtaWZ5IXNlY3JldF9rZXlfdGVzdCExNDk2MzMwNDI5MjQzIRLvv73vv73vv73vv70b77+977+977+9f++/vR3vv70Heu+/vQ==");
			http.addHeader("SELFCARE-AUTH-TOKEN", token);

            response = httpClient.execute(http, context);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			response.getEntity().writeTo(out);

			System.out.println("------content-------");
			String s = new String(out.toByteArray());
			System.out.println(s);

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}


	public static String getToken(String clientAppId, String secretKey, String userName) throws NoSuchAlgorithmException {
		//MSISDN!APP_ID!SECRET_KEY!TIME_IN_MILLIS!TOKEN_KEY
		StringBuilder tokenBuilder = new StringBuilder();

		long milis = System.currentTimeMillis();
		byte[] token = tokenBuilder
				.append(userName)
				.append(DELIMITER).append(clientAppId)
				.append(DELIMITER).append(secretKey)
				.append(DELIMITER).append(milis)
				.append(DELIMITER).append(buildTokenKey(userName, clientAppId, secretKey, milis))
				.toString().getBytes();

		// the below function returns a string ending in "\r\n", which tends to
		// cause problems...remove it
		return Base64.encodeBase64String(token).replace(NEWLINE, "");

	}
	
	private static MessageDigest getMessageDigest() throws NoSuchAlgorithmException{
		return MessageDigest.getInstance("SHA-256");
	}

	private static String buildTokenKey(String userName, String clientAppId, String secretKey, long timeInMillis) throws NoSuchAlgorithmException {
		//MSISDN!APP_ID!SECRET_KEY!TIME_IN_MILLIS

		Assert.notNull(secretKey, "Secret Key must not be null!");
		StringBuilder keyBuilder = new StringBuilder();
		String key = keyBuilder
				.append(userName).append(DELIMITER)
				.append(clientAppId).append(DELIMITER)
				.append(secretKey).append(DELIMITER)
				.append(timeInMillis).toString();

		byte[] keyBytes = key.getBytes();
//		return MessageDigest.getInstance("MD5").digest(keyBytes);
		return AppUtils.byteArrayToHexString(getMessageDigest().digest(keyBytes));
	}

	public static boolean isTokenValid(String encodedToken) throws NoSuchAlgorithmException {
		String[] components = decodeAndDissectToken(encodedToken);

		if (components == null || components.length != TOKEN_COUNT) {
			return false;
		}
		//MSISDN!APP_ID!SECRET_KEY!TIME_IN_MILLIS!TOKEN_KEY
		String userName = components[0];
		String extAppId = components[1];
		String extSecretKey = components[2];
		Long timeInMillis = Long.parseLong(components[3]);
		String externalKey = components[4];
		String expectedKey = new String(buildTokenKey(userName, extAppId, extSecretKey, timeInMillis));

		if (!MessageDigest.isEqual(expectedKey.getBytes(), externalKey.getBytes())) {
			return false;
		}

		long tokenExpiryTimeInMinutes = EXPIRATION_MIN;

		long delta = (new Date().getTime() - new Date(timeInMillis).getTime()) / (1000 * 60);
		if (delta > tokenExpiryTimeInMinutes) {
			return false;
		}

		return true;
	}

	public static String getUserFromToken(String token) throws NoSuchAlgorithmException {
		if (!isTokenValid(token)) {
			return null;
		}
		String[] components = decodeAndDissectToken(token);
		return components != null ? components[0] : null;
	}

	private static String[] decodeAndDissectToken(String encodedToken) {
		if (!StringUtils.hasText(encodedToken) || !Base64.isBase64(encodedToken.getBytes())) {
			return null;
		}
		// Apache Commons Base64 tools expect Base64 strings to end in "\r\n",
		// add if necessary
		if (!encodedToken.endsWith(NEWLINE)) {
			encodedToken = encodedToken + NEWLINE;
		}
		String token = new String(Base64.decodeBase64(encodedToken));
		if (!token.contains(DELIMITER)) {
			return null;
		}
		String[] values = token.split(DELIMITER);
		if (values.length != TOKEN_COUNT) return null;

		return values;
	}

}
