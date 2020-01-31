/**
 * UploadAvatarResponse.java
 */
package com.gnv.vnm.selfcare.webapi.model;

/**
 * @author nandipinto
 *
 */
public class UploadAvatarResponse extends ApiResponse {

	private static final long serialVersionUID = 1129476939733700520L;

	private String imageURL;
	
	public UploadAvatarResponse(){ }
	
	public UploadAvatarResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	public UploadAvatarResponse(boolean successful, String code, String message, String imageURL) {
		super(successful, code, message);
		this.imageURL = imageURL;
	}

	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

}
