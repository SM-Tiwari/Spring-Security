package com.gnv.vnm.selfcare.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author kuldeep Singh
 *
 */
@Entity
@Table(name = "fatty_item_mapping",  uniqueConstraints = {/* @UniqueConstraint(columnNames = "id"), */ @UniqueConstraint(columnNames = "keyword") })
@SequenceGenerator(name = "fatty_seq", sequenceName = "fatty_seq", allocationSize = 1)
public class FattyItemMappingsEntity extends BaseEntity

{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6169057658716526259L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fatty_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "keyword", length = 50, nullable = false)
	private String keyword;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "display_name_en")
	private String displayNameEN;
	
	@Column(name = "display_name_vi")
	private String displayNameVI;
	
	@Column(name = "monster_weight")
	private Integer monsterWeight;
	
	@Column(name = "monster_img")
	private String monsterImage;
	
	@Column(name="fatty_level")
	private int level;
	
	@Column(name="min_point")
	private Integer minPoint;
	
	@Column(name="max_point")
	private Integer maxPoint;
	
	@Column(name = "STATUS")
	private Integer fattyStatus;
	
	@Column(name="message_vi")
	private String messageVi;
	
	@Column(name="message_en")
	private String messageEn;
	
	
	public String getMessageVi() {
		return messageVi;
	}

	public void setMessageVi(String messageVi) {
		this.messageVi = messageVi;
	}

	public String getMessageEn() {
		return messageEn;
	}

	public void setMessageEn(String messageEn) {
		this.messageEn = messageEn;
	}

	public Integer getFattyStatus() {
		return fattyStatus;
	}

	public void setFattyStatus(Integer fattyStatus) {
		this.fattyStatus = fattyStatus;
	}

	public Integer getMinPoint() {
		return minPoint;
	}

	public void setMinPoint(Integer minPoint) {
		this.minPoint = minPoint;
	}

	public Integer getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(Integer maxPoint) {
		this.maxPoint = maxPoint;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDisplayNameEN() {
		return displayNameEN;
	}

	public void setDisplayNameEN(String displayNameEN) {
		this.displayNameEN = displayNameEN;
	}

	public String getDisplayNameVI() {
		return displayNameVI;
	}

	public void setDisplayNameVI(String displayNameVI) {
		this.displayNameVI = displayNameVI;
	}

	public Integer getMonsterWeight() {
		return monsterWeight;
	}

	public void setMonsterWeight(Integer monsterWeight) {
		this.monsterWeight = monsterWeight;
	}

	public String getMonsterImage() {
		return monsterImage;
	}

	public void setMonsterImage(String monsterImage) {
		this.monsterImage = monsterImage;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
