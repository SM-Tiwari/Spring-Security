/**
 * Mar 20, 2015 5:02:02 PM
 */
package com.gnv.vnm.selfcare.core.security;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author  nandipinto
 * @version 1.0
 *
 */
@Component
public class SimplePasswordEncoder implements PasswordEncoder {
	
	private static final String DEFAULT_SALT = "9C5A86C3083D50A6F4ED440F6DF0989A";
	private static final String DEFAULT_ALGO = "PBKDF2WithHmacSHA1";

	private String salt = DEFAULT_SALT;
	private String algo = DEFAULT_ALGO;
	
	public SimplePasswordEncoder(){ }
	
	public SimplePasswordEncoder(String salt, String algo){
		this.salt = salt;
		this.algo = algo;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.crypto.password.PasswordEncoder#encode(java.lang.CharSequence)
	 */
	@Override
	public String encode(CharSequence rawPasswd) {
		return encrypt(rawPasswd.toString());
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.crypto.password.PasswordEncoder#matches(java.lang.CharSequence, java.lang.String)
	 */
	@Override
	public boolean matches(CharSequence rawPasswd, String encodedPasswd) {
		if (rawPasswd == null || encodedPasswd == null) return false;
		String ep = encrypt(rawPasswd.toString());
		return ep != null && ep.equals(encodedPasswd);
	}
	
	public String encrypt(String password){
		int iterations = 20000;
		KeySpec kSpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, 160);
		try {
			SecretKeyFactory skfEnc = SecretKeyFactory.getInstance(algo);
			return toHex(skfEnc.generateSecret(kSpec).getEncoded());
		} catch (Exception e) {}
		return null;
	}
	
	private String toHex(byte[] array) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}

	
	public static void main(String[] args){
		SimplePasswordEncoder spe = new SimplePasswordEncoder();
		
		//e13a9b6759e1d039bcc105f7b9adf8f8251d82ed --> sysadmin
		//6a3728ba2427a6cd45a61f7f89277a9e2677942b --> supervisor
		System.out.println(spe.encode("666666")); 
	}

}
