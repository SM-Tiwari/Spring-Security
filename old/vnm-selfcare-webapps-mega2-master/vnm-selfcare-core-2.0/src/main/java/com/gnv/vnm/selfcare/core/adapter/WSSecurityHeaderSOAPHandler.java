/**
 * WSSecurityHeaderSOAPHandler.java
 */
package com.gnv.vnm.selfcare.core.adapter;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author nandipinto
 *
 */
public class WSSecurityHeaderSOAPHandler implements SOAPHandler<SOAPMessageContext> {

	private static final String SOAP_ELEMENT_PASSWORD 			= "Password";
	private static final String SOAP_ELEMENT_USERNAME 			= "Username";
	private static final String SOAP_ELEMENT_CREATED			= "Created";
	private static final String SOAP_ELEMENT_NONCE				= "Nonce";
	private static final String SOAP_ELEMENT_USERNAME_TOKEN 	= "UsernameToken";
	private static final String SOAP_ELEMENT_SECURITY			= "Security";
	private static final String NAMESPACE_SECURITY 				= "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
	private static final String PREFIX_SECURITY 				= "wsse";
	private static final String TIMESTAMP_FORMAT				= "yyyy-MM-dd'T'HH:mm:ss'Z'";

	private SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT);
	
	private String userName = "";
	private String password = "";
	private boolean usePasswordDigest = false;

	public WSSecurityHeaderSOAPHandler(String userName, String password, boolean usePasswordDigest) {
		this.userName = userName;
		this.password = password;
		this.usePasswordDigest = usePasswordDigest;
	}

	public boolean handleMessage(SOAPMessageContext soapMessageContext) {

		Boolean outboundProperty = (Boolean) soapMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {

			try {
				SOAPEnvelope soapEnvelope = soapMessageContext.getMessage().getSOAPPart().getEnvelope();

				SOAPHeader header = soapEnvelope.getHeader();
				if (header == null) {
					header = soapEnvelope.addHeader();
				}
				
				SOAPElement securityHeader = header.addChildElement(SOAP_ELEMENT_SECURITY, PREFIX_SECURITY, NAMESPACE_SECURITY);
				SOAPElement usernameToken = securityHeader.addChildElement(SOAP_ELEMENT_USERNAME_TOKEN, PREFIX_SECURITY);
				
				SOAPElement usernameElement = usernameToken.addChildElement(SOAP_ELEMENT_USERNAME, PREFIX_SECURITY);
				usernameElement.addTextNode(this.userName);

				SOAPElement passwordElement = usernameToken.addChildElement(SOAP_ELEMENT_PASSWORD, PREFIX_SECURITY);
				
				if (usePasswordDigest){
					String nonce = buildNonce();
//					sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
					String timeStamp = sdf.format(new Date());

					passwordElement.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest");
					passwordElement.addTextNode(buildPasswordDigest(userName, password, nonce, timeStamp));

					SOAPElement nonceElement = usernameToken.addChildElement(SOAP_ELEMENT_NONCE, PREFIX_SECURITY);
					nonceElement.setAttribute("EncodingType", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
					nonceElement.addTextNode(nonce);
					
					SOAPElement created = usernameToken.addChildElement(SOAP_ELEMENT_CREATED, "wsu", NAMESPACE_SECURITY);
					created.addTextNode(timeStamp);

				}else{
					passwordElement.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
					passwordElement.addTextNode(password);
				}
			} catch (Exception e) {
				throw new RuntimeException("Error on wsSecurityHandler: " + e.getMessage());
			}
		}

		return true;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		// return new TreeSet();
		return null;
	}
	
	//Base64 ( SHA1 ( nonce + created + password ) )
	public static String buildPasswordDigest(String userName, String password, String nonce, String dateTime) throws Exception{
		ByteBuffer buf = ByteBuffer.allocate(1000);
		buf.put(Base64.decodeBase64(nonce));
		buf.put(dateTime.getBytes("UTF-8"));
		buf.put(password.getBytes("UTF-8"));
		byte[] toHash = new byte[buf.position()];
		buf.rewind();
		buf.get(toHash);
		byte[] hash = DigestUtils.sha1(toHash);
		
		return Base64.encodeBase64String(hash);
	}
	
	private String buildNonce() throws Exception{
		java.security.SecureRandom random = java.security.SecureRandom.getInstance("SHA1PRNG");
		random.setSeed(System.currentTimeMillis()); 
		byte[] nonceBytes = new byte[16]; 
		random.nextBytes(nonceBytes); 
		return new String(Base64.encodeBase64(nonceBytes), "UTF-8");
	}
}
