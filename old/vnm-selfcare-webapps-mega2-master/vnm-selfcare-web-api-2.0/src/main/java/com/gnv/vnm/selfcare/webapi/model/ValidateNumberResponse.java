/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class ValidateNumberResponse extends ApiResponse {

	private static final long serialVersionUID = -1143452263451260818L;

	private List<NumberValidationResult> validationResults = new ArrayList<>();
	
	public ValidateNumberResponse() {}

	/**
	 * @param successful
	 * @param code
	 * @param message
	 */
	public ValidateNumberResponse(boolean successful, String code, String message) {
		super(successful, code, message);
	}

	/**
	 * @return the validationResults
	 */
	public List<NumberValidationResult> getValidationResults() {
		return validationResults;
	}

	/**
	 * @param validationResults the validationResults to set
	 */
	public void setValidationResults(List<NumberValidationResult> validationResults) {
		this.validationResults = validationResults;
	}

	public static final class NumberValidationResult{
		
		private String msisdn;
		private int valid = 0;
		
		public NumberValidationResult() {}
		
		public NumberValidationResult(String msisdn, int valid) {
			this.msisdn = msisdn;
			this.valid = valid;
		}

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
		 * @return the valid
		 */
		public int getValid() {
			return valid;
		}

		/**
		 * @param valid the valid to set
		 */
		public void setValid(int valid) {
			this.valid = valid;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + valid;
			result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NumberValidationResult other = (NumberValidationResult) obj;
			if (valid != other.valid)
				return false;
			if (msisdn == null) {
				if (other.msisdn != null)
					return false;
			} else if (!msisdn.equals(other.msisdn))
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("NumberValidationResult [msisdn=");
			builder.append(msisdn);
			builder.append(", valid=");
			builder.append(valid);
			builder.append("]");
			return builder.toString();
		}
		
	}
}
