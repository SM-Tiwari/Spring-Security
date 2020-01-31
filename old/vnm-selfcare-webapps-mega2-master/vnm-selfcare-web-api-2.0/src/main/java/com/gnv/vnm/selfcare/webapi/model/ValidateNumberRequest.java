/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class ValidateNumberRequest implements Serializable {

	private static final long serialVersionUID = -1906522668314154918L;

	private List<String> numbers = new ArrayList<>();
	
	public ValidateNumberRequest() {
	}

	/**
	 * @return the numbers
	 */
	public List<String> getNumbers() {
		return numbers;
	}

	/**
	 * @param numbers the numbers to set
	 */
	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}

}
