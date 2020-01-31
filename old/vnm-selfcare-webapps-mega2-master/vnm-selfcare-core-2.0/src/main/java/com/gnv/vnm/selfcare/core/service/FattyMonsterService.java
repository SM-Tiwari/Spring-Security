package com.gnv.vnm.selfcare.core.service;
/**
 * This interface provides the FattyMonster Service.
 * 
 * @author Kuldeep Singh
 *
 */

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.model.FattyMonsterDetails;
import com.gnv.vnm.selfcare.core.model.FattyRedeemPointRequest;

public interface FattyMonsterService {

	/**
	 * This method is used for fetch fatty monster details based msisdn
	 * 
	 * @param msisdn
	 *            {@link String}
	 * @return {@link FattyMonster}
	 */
	public FattyMonsterDetails getFattyMonsterDetailsBasedOnMsisdn(String msisdn,
			FattyMonsterDetails fattyMonsterDetails);
	
	/**
	 * This method is used for redeem Point based on offer.
	 * 
	 * @param msisdn
	 *            {@link String}
	 * @return {@link BackEndAdapterResponse}
	 */
	public BackEndAdapterResponse redeemPoint(FattyRedeemPointRequest fattyRedeemPont);
}
