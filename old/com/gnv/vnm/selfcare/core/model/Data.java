package com.gnv.vnm.selfcare.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Data {

                                
    private String NAME_LV1;
    private String NAME_LV2;
    private String PRODUCT_ID;
    private String REGISTER_SC;
    private String SMS_KEYWORD;
    private String PRODUCT_CODE;

    public String getPRODUCT_CODE() {
    		return PRODUCT_CODE;
    	}
    	public void setPRODUCT_CODE(String pRODUCT_CODE) {
    		PRODUCT_CODE = pRODUCT_CODE;
    	}
	public String getNAME_LV1() {
		return NAME_LV1;
	}
	public void setNAME_LV1(String nAME_LV1) {
		NAME_LV1 = nAME_LV1;
	}
	public String getNAME_LV2() {
		return NAME_LV2;
	}
	public void setNAME_LV2(String nAME_LV2) {
		NAME_LV2 = nAME_LV2;
	}
	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getREGISTER_SC() {
		return REGISTER_SC;
	}
	public void setREGISTER_SC(String rEGISTER_SC) {
		REGISTER_SC = rEGISTER_SC;
	}
	public String getSMS_KEYWORD() {
		return SMS_KEYWORD;
	}
	public void setSMS_KEYWORD(String sMS_KEYWORD) {
		SMS_KEYWORD = sMS_KEYWORD;
	}
/*	@Override
	public String toString() {
		return "DATA [NAME_LV1=" + NAME_LV1 + ", NAME_LV2=" + NAME_LV2 + ", PRODUCT_ID=" + PRODUCT_ID + ", REGISTER_SC="
				+ REGISTER_SC + ", SMS_KEYWORD=" + SMS_KEYWORD + "]";
	}
    */
                                         
}                                        
                                         
                                         
                                         