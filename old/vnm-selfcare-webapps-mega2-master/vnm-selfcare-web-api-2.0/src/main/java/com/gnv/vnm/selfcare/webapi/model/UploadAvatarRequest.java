/**
 * UploadAvatarRequest.java
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;

/**
 * @author nandipinto
 *
 */
public class UploadAvatarRequest implements Serializable {

	private static final long serialVersionUID = 1682026778974129299L;
	
	private String msisdn;
	private String encodedImage;
	private String imageFormat;
	
	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}
	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	/**
	 * @return the encodedImage
	 */
	public String getEncodedImage() {
		return encodedImage;
	}
	/**
	 * @param encodedImage the encodedImage to set
	 */
	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}
	/**
	 * @return the imageFormat
	 */
	public String getImageFormat() {
		return imageFormat;
	}
	/**
	 * @param imageFormat the imageFormat to set
	 */
	public void setImageFormat(String imageFormat) {
		this.imageFormat = imageFormat;
	}

}
