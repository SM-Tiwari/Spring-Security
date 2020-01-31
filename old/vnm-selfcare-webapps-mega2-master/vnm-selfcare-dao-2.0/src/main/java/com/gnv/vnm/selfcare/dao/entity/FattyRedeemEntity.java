package com.gnv.vnm.selfcare.dao.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
* @author  kuldeep Singh
* @version 1.0
* @since   2018-12-04
*/
@Entity
@Table(name = "FATTY_REDEEM_STATUS")
@SequenceGenerator(name = "fatty_redeem_point_seq", sequenceName = "fatty_redeem_point_seq", allocationSize = 1)
public class FattyRedeemEntity extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8268454499556181140L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fatty_redeem_point_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "msisdn", length = 15, nullable = false)
	private String msisdn;	
	
	@Column(name = "weight", length = 20)
	private String weight;
	
	@Column(name="point")
	private Integer point;
	
	@Column(name="fatty_responce_message")
	private String fattyResponceMessage;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="fatty_level")
	private int level;
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getFattyResponceMessage() {
		return fattyResponceMessage;
	}

	public void setFattyResponceMessage(String fattyResponceMessage) {
		this.fattyResponceMessage = fattyResponceMessage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

