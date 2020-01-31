/**
* ApiResponse.java
*/
package com.gnv.vnm.selfcare.webapi.model;

import java.io.Serializable;

/**
* @author nandipinto
*
*/
public class TokenResponse implements Serializable {

                private static final long serialVersionUID = 8094335486982389409L;

                protected boolean successful = false;
                protected String code;
                protected String message;
                protected String random_token;
                protected String msisdn="";
                protected String ipAddress;
               


				public TokenResponse(){ }
                

                public TokenResponse(boolean successful, String code, String message, String random_token, String msisdn) {
                                super();
                                this.successful = successful;
                                this.code = code;
                                this.message = message;
                                this.random_token = random_token;
                                this.msisdn = msisdn;
                }


                /**
                * @return the successful
                */
                
                public boolean isSuccessful() {
                                return successful;
                }

                public String getRandom_token() {
                                return random_token;
                }

                public void setRandom_token(String random_token) {
                                this.random_token = random_token;
                }

                public String getMsisdn() {
                                return msisdn;
                }

                public void setMsisdn(String msisdn) {
                                this.msisdn = msisdn;
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
                public String getIpAddress() {
					return ipAddress;
				}


				public void setIpAddress(String ipAddress) {
					this.ipAddress = ipAddress;
				}


                @Override
                public int hashCode() {
                                final int prime = 31;
                                int result = 1;
                                result = prime * result + ((code == null) ? 0 : code.hashCode());
                                result = prime * result + ((message == null) ? 0 : message.hashCode());
                                result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
                                result = prime * result + ((random_token == null) ? 0 : random_token.hashCode());
                                result = prime * result + (successful ? 1231 : 1237);
                                return result;
                }


                @Override
                public boolean equals(Object obj) {
                                if (this == obj)
                                                return true;
                                if (obj == null)
                                                return false;
                                if (getClass() != obj.getClass())
                                                return false;
                                TokenResponse other = (TokenResponse) obj;
                                if (code == null) {
                                                if (other.code != null)
                                                                return false;
                                } else if (!code.equals(other.code))
                                                return false;
                                if (message == null) {
                                                if (other.message != null)
                                                                return false;
                                } else if (!message.equals(other.message))
                                                return false;
                                if (msisdn == null) {
                                                if (other.msisdn != null)
                                                                return false;
                                } else if (!msisdn.equals(other.msisdn))
                                                return false;
                                if (random_token == null) {
                                                if (other.random_token != null)
                                                                return false;
                                } else if (!random_token.equals(other.random_token))
                                                return false;
                                if (successful != other.successful)
                                                return false;
                                return true;
                }


                
}
