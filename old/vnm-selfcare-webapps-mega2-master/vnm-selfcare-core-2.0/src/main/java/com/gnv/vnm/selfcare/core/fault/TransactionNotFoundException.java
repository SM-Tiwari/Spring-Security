/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class TransactionNotFoundException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public TransactionNotFoundException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public TransactionNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TransactionNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public TransactionNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TransactionNotFoundException(Throwable cause) {
		super(cause);
	}

	
}