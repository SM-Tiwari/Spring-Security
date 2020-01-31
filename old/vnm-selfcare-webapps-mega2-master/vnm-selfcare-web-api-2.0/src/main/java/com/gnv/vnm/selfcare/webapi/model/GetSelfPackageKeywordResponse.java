/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.util.List;

import com.gnv.vnm.selfcare.core.model.SelfPackageBalanceName;

/**
 * @author nandipinto
 *
 */
public class GetSelfPackageKeywordResponse extends ApiResponse {

	private static final long serialVersionUID = 1382002857852191585L;

	private List<SelfPackageBalanceName> keywords;
	
	public GetSelfPackageKeywordResponse() {
	}

	public GetSelfPackageKeywordResponse(boolean successful, String code, String message, List<SelfPackageBalanceName> keywords) {
		super(successful, code, message);
		this.keywords = keywords;
	}

	/**
	 * @return the keywords
	 */
	public List<SelfPackageBalanceName> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<SelfPackageBalanceName> keywords) {
		this.keywords = keywords;
	}
	
	
}
