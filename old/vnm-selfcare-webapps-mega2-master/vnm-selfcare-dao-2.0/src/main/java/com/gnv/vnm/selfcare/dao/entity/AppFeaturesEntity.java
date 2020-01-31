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
@Table(name = "APP_FEATURES_ENTITY")
@SequenceGenerator(name = "app_features_entity_seq", sequenceName = "app_features_entity_seq", allocationSize = 1)
public class AppFeaturesEntity extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2895927762756334377L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_features_entity_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name="feature_name")
	private String featureName;
	
	@Column(name="status_for_android")
	private Integer statusForAndroid;
	
	@Column(name="status_for_ios")
	private Integer statusForIos;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public Integer getStatusForAndroid() {
		return statusForAndroid;
	}

	public void setStatusForAndroid(Integer statusForAndroid) {
		this.statusForAndroid = statusForAndroid;
	}

	public Integer getStatusForIos() {
		return statusForIos;
	}

	public void setStatusForIos(Integer statusForIos) {
		this.statusForIos = statusForIos;
	}

}
