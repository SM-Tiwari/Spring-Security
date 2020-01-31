
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
@Table(name = "tb_subs_update_info", uniqueConstraints = {/*@UniqueConstraint(columnNames = "id")*/ @UniqueConstraint(columnNames = "subscriber_id")})
@SequenceGenerator(name = "micstatus_seq", sequenceName = "micstatus_seq", allocationSize = 1)
public class MicStatusEntity extends BaseEntity{

private static final long serialVersionUID = -189136718357159610L;
                
                @Id
                @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "micstatus_seq")
                @Column(name = "id")
                private Integer id;
                
                @Column(name = "msisdn", length = 16)
                private String msisdn;
                
                @Column(name = "subscriber_id", length = 16)
                private String subscriberId;
                
    @Column(name = "status")
                private Integer status = 0;
                
                public MicStatusEntity(){ }

                public MicStatusEntity(Integer id, String msisdn, String subscriberId, Integer status) {
                                super();
                                this.id = id;
                                this.msisdn = msisdn;
                                this.subscriberId = subscriberId;
                                this.status = status;
                }

                
                
                public Integer getId() {
                                return id;
                }

                public void setId(Integer id) {
                                this.id = id;
                }

                public String getMsisdn() {
                                return msisdn;
                }

                public void setMsisdn(String msisdn) {
                                this.msisdn = msisdn;
                }

                public String getSubscriberId() {
                                return subscriberId;
                }

                public void setSubscriberId(String subscriberId) {
                                this.subscriberId = subscriberId;
                }

                public Integer getStatus() {
                                return status;
                }

                public void setStatus(Integer status) {
                                this.status = status;
                }

                @Override
                public int hashCode() {
                                final int prime = 31;
                                int result = super.hashCode();
                                result = prime * result + ((id == null) ? 0 : id.hashCode());
                                result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
                                result = prime * result + ((status == null) ? 0 : status.hashCode());
                                result = prime * result + ((subscriberId == null) ? 0 : subscriberId.hashCode());
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
                                MicStatusEntity other = (MicStatusEntity) obj;
                                if (id == null) {
                                                if (other.id != null)
                                                                return false;
                                } else if (!id.equals(other.id))
                                                return false;
                                if (msisdn == null) {
                                                if (other.msisdn != null)
                                                                return false;
                                } else if (!msisdn.equals(other.msisdn))
                                                return false;
                                if (status == null) {
                                                if (other.status != null)
                                                                return false;
                                } else if (!status.equals(other.status))
                                                return false;
                                if (subscriberId == null) {
                                                if (other.subscriberId != null)
                                                                return false;
                                } else if (!subscriberId.equals(other.subscriberId))
                                                return false;
                                return true;
                }

                @Override
                public String toString() {
                                return "MicStatusEntity [id=" + id + ", msisdn=" + msisdn + ", subscriberId=" + subscriberId + ", status="
                                                                + status + "]";
                }
                
                
                
}
