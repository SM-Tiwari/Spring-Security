package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

/**
 * This class is used for handling the FattyMonster Responce of server side .
 * 
 * @author kuldeep Singh
 *
 */
public class FattyMonsterDetails implements Serializable {
	private static final long serialVersionUID = 2026321871267340412L;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(int remainingDays) {
		this.remainingDays = remainingDays;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean isAvilableForRedeem() {
		return isAvilableForRedeem;
	}

	public void setAvilableForRedeem(boolean isAvilableForRedeem) {
		this.isAvilableForRedeem = isAvilableForRedeem;
	}

	public String getFattyImageUrl() {
		return fattyImageUrl;
	}

	public void setFattyImageUrl(String fattyImageUrl) {
		this.fattyImageUrl = fattyImageUrl;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

}
