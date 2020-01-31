package com.gnv.vnm.selfcare.core.model;

import java.util.ArrayList;

import id.gnvsolution.d3.api.dto.response.ProductDto;

public class Packege092Responce {
	
	private ArrayList<ProductDto> dataList=new ArrayList<>();
	private ArrayList<ProductDto> voiceList=new ArrayList<>();
	private ArrayList<ProductDto> comboList=new ArrayList<>();
	public ArrayList<ProductDto> getDataList() {
		return dataList;
	}
	public void setDataList(ArrayList<ProductDto> dataList) {
		this.dataList = dataList;
	}
	public ArrayList<ProductDto> getVoiceList() {
		return voiceList;
	}
	public void setVoiceList(ArrayList<ProductDto> voiceList) {
		this.voiceList = voiceList;
	}
	public ArrayList<ProductDto> getComboList() {
		return comboList;
	}
	public void setComboList(ArrayList<ProductDto> comboList) {
		this.comboList = comboList;
	}

}
