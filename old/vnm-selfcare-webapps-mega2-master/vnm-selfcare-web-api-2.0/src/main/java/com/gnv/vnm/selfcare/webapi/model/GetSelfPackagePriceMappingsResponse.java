/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.util.ArrayList;
import java.util.List;

import com.gnv.vnm.selfcare.core.model.SelfPackagePriceMapping;

/**
 * @author nandipinto
 *
 */
public class GetSelfPackagePriceMappingsResponse extends ApiResponse {

	private static final long serialVersionUID = -58903515356115511L;

	private List<SelfPackagePriceMapping> priceMappings = new ArrayList<>();
	
	public GetSelfPackagePriceMappingsResponse() {
	}

	public GetSelfPackagePriceMappingsResponse(boolean successful, String code, String message, List<SelfPackagePriceMapping> priceMappings) {
		super(successful, code, message);
		this.priceMappings = priceMappings;
	}

	/**
	 * @return the priceMappings
	 */
	public List<SelfPackagePriceMapping> getPriceMappings() {
		return priceMappings;
	}

	/**
	 * @param priceMappings the priceMappings to set
	 */
	public void setPriceMappings(List<SelfPackagePriceMapping> priceMappings) {
		this.priceMappings = priceMappings;
	}

}
