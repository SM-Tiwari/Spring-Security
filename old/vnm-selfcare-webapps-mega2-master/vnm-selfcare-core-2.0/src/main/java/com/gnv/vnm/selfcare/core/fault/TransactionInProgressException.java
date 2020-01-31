/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class TransactionInProgressException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public TransactionInProgressException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public TransactionInProgressException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TransactionInProgressException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public TransactionInProgressException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TransactionInProgressException(Throwable cause) {
		super(cause);
	}

	
}
