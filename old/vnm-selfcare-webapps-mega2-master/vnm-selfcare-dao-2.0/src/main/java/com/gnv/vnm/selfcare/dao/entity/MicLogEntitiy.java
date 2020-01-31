
package com.gnv.vnm.selfcare.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "mic_log", uniqueConstraints = {/*@UniqueConstraint(columnNames = "id")*/ @UniqueConstraint(columnNames = "logId")})
@SequenceGenerator(name = "miclog_seq", sequenceName = "miclog_seq", allocationSize = 1)
public class MicLogEntitiy extends BaseEntity{

private static final long serialVersionUID = -189136718357159610L;
                
                @Id
                @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miclog_seq")
                @Column(name = "logId")
                private Integer logId;
                
                @Column(name = "msisdn", length = 16)
                private String msisdn;
                
                
                @Column(name = "log_message",length = 4000)
                private String logMessage;
                
                @Column(name = "client_type")
                private String clientType;
                
                public MicLogEntitiy(){ }

                
                public MicLogEntitiy(Integer logId, String msisdn, String logMessage, String clientType) {
					super();
					this.logId = logId;
					this.msisdn = msisdn;
					this.logMessage = logMessage;
					this.clientType = clientType;
				}
 

                public Integer getLogId() {
					return logId;
				}


				public void setLogId(Integer logId) {
					this.logId = logId;
				}


				public String getMsisdn() {
					return msisdn;
				}


				public void setMsisdn(String msisdn) {
					this.msisdn = msisdn;
				}


				public String getLogMessage() {
					return logMessage;
				}


				public void setLogMessage(String logMessage) {
					this.logMessage = logMessage;
				}


				public String getClientType() {
					return clientType;
				}


				public void setClientType(String clientType) {
					this.clientType = clientType;
				}


			 

                @Override
				public int hashCode() {
					final int prime = 31;
					int result = super.hashCode();
					result = prime * result + ((clientType == null) ? 0 : clientType.hashCode());
					result = prime * result + ((logId == null) ? 0 : logId.hashCode());
					result = prime * result + ((logMessage == null) ? 0 : logMessage.hashCode());
					result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
					return result;
				}


				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (!super.equals(obj))
						return false;
					if (getClass() != obj.getClass())
						return false;
					MicLogEntitiy other = (MicLogEntitiy) obj;
					if (clientType == null) {
						if (other.clientType != null)
							return false;
					} else if (!clientType.equals(other.clientType))
						return false;
					if (logId == null) {
						if (other.logId != null)
							return false;
					} else if (!logId.equals(other.logId))
						return false;
					if (logMessage == null) {
						if (other.logMessage != null)
							return false;
					} else if (!logMessage.equals(other.logMessage))
						return false;
					if (msisdn == null) {
						if (other.msisdn != null)
							return false;
					} else if (!msisdn.equals(other.msisdn))
						return false;
					return true;
				}


				@Override
				public String toString() {
					return "MicLogEntitiy [logId=" + logId + ", msisdn=" + msisdn + ", logMessage=" + logMessage
							+ ", clientType=" + clientType + "]";
				}


				 
                
}
