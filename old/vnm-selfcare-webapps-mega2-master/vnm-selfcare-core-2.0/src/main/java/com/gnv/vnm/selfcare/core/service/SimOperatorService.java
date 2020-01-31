/**
 * SimOperatorService.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.List;

 
import com.gnv.vnm.selfcare.core.model.SimOperator;
import com.gnv.vnm.selfcare.core.model.SimOperatorPrefix;
 
/**
 * @author abhinav
 *
 */
public interface SimOperatorService {

	List<SimOperator> getAllSimOperator();
	
	List<SimOperatorPrefix> getAllOperatorPrefix();
	
	List<SimOperatorPrefix> getOperatorPrefix(int operatorId);
	
	String saveOperator(String operatorName, int operatorStatus);
	
	String saveOperatorPrefix(int operatorId, String msisdnPrefix, String msisdnValue);
	
}
