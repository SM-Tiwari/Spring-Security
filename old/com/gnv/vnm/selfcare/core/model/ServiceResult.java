package com.gnv.vnm.selfcare.core.model;

public class ServiceResult {
	/**
	 * Variable to store status code.
	 */
	private int code;
	/**
	 * Object containing service response object.
	 */
	private Object result;
	
	private String msg;

	// ------------------------------------------------------------------------------------------------------------------
	/**
	 * Constructor of the class.
	 * 
	 * @param code
	 * @param resultmsg
	 * @param result
	 */
	public ServiceResult(StatusCode code, Object result,String message) {
		this.code = code.statusCode;
		this.msg=message;
		this.result = result;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * Enumeration for Status Codes.
	 * 
	 * @author kuldeep singh
	 *
	 */
	public enum StatusCode {

		SUCCESS(200),JWT_TOKEN_EXPIRE(499), INTERNAL_SERVER_ERROR(500), WARNING(501), BAD_REQUEST(400), UNAUTHORIZED(401), FORBIDDEN(403), ACCOUNT_NOT_VERIFIED(407);

		private int statusCode;

		private StatusCode(int code) {
			this.statusCode = code;
		}

		public int getStatusCode() {
			return statusCode;
		}
	}
}

