package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;
/**
 * This
 */
public class RedeemApiResponce implements Serializable{

	
	private static final long serialVersionUID = 6249882043499626844L;
	
	private String expdate;
	
	private int remainingDays;
	
	private boolean isAvilableForRedeem = true;
	
	private String weight;
	
	private int point;
	
	private String fattyImageUrl;
	
	private String displayNameEn;
	
	private String displayNameVi;
	
	private String keyward;
	
	private String productName;
	
	private int level;
	
	private String successMessageVi;
	
	private String successMessageEn;
	

	public String getSuccessMessageVi() {
		return successMessageVi;
	}

	public void setSuccessMessageVi(String successMessageVi) {
		this.successMessageVi = successMessageVi;
	}

	public String getSuccessMessageEn() {
		return successMessageEn;
	}

	public void setSuccessMessageEn(String successMessageEn) {
		this.successMessageEn = successMessageEn;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public int getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(int remainingDays) {
		this.remainingDays = remainingDays;
	}

	public boolean isAvilableForRedeem() {
		return isAvilableForRedeem;
	}

	public void setAvilableForRedeem(boolean isAvilableForRedeem) {
		this.isAvilableForRedeem = isAvilableForRedeem;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getFattyImageUrl() {
		return fattyImageUrl;
	}

	public void setFattyImageUrl(String fattyImageUrl) {
		this.fattyImageUrl = fattyImageUrl;
	}

	public String getDisplayNameEn() {
		return displayNameEn;
	}

	public void setDisplayNameEn(String displayNameEn) {
		this.displayNameEn = displayNameEn;
	}

	public String getDisplayNameVi() {
		return displayNameVi;
	}

	public void setDisplayNameVi(String displayNameVi) {
		this.displayNameVi = displayNameVi;
	}

	public String getKeyward() {
		return keyward;
	}

	public void setKeyward(String keyward) {
		this.keyward = keyward;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	protected boolean successful = false;
	protected String code;
	protected String message;
	private int readstatus;
	
	public int getReadstatus() {
		return readstatus;
	}

	public void setReadstatus(int readstatus) {
		this.readstatus = readstatus;
	}

	public RedeemApiResponce(){ }
	
	public RedeemApiResponce(boolean successful, String code, String message) {
		this.successful = successful;
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the successful
	 */
	public boolean isSuccessful() {
		return successful;
	}

	/**
	 * @param successful the successful to set
	 */
	public void setSuccessful(boolean successful) {
		this.successful = successful;
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
	
	
}
