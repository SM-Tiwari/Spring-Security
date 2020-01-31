/**
 * 
 */
package com.gnv.vnm.selfcare.core.adapter;

/**
 * @author nandipinto
 *
 */
public class BackEndAdapterException extends Exception {

	private static final long serialVersionUID = 9029445004861044633L;

	private String code;
	private String message;
	
	public BackEndAdapterException() {}

	/**
	 * @param message
	 */
	public BackEndAdapterException(String message) {
		super(message);
	}

	public BackEndAdapterException(String code, String message){
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param cause
	 */
	public BackEndAdapterException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BackEndAdapterException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BackEndAdapterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BackEndAdapterException [code=");
		builder.append(code);
		builder.append(", message=");
		builder.append(message);
		builder.append(", throwable=").append(getCause());
		builder.append("]");
		return builder.toString();
	}

	
}
