/**
 * ProductEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "product", uniqueConstraints = { @UniqueConstraint(columnNames = "code") }) 
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
public class ProductEntity extends BaseEntity {

	private static final long serialVersionUID = 7666332070358704264L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "code", length = 20, nullable = false)
	private String code;

	@Column(name = "ext_code", length = 20, nullable = false)
	private String extCode;

	@Column(name = "ext_product_name", length = 50)
	private String extProductName;
	
	@Column(name = "price", precision = 10, scale = 2)
	private BigDecimal price;
	
	@Column(name = "valid_from_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validFromDate;
	
	@Column(name = "valid_to_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validToDate;

	@Column(name = "status")
	private Integer status = 1;

	@Column(name = "name_en", length = 500)
	private String nameEN;
	
	@Column(name = "name_vi", length = 500)
	private String nameVI;
	
	@Lob
	@Column(name = "details_en")
	private String detailsEN;

	@Lob
	@Column(name = "details_vi")
	private String detailsVI;
	
	@Lob
	@Column(name = "description_en")
	private String descriptionEN;

	@Lob
	@Column(name = "description_vi")
	private String descriptionVI;
	
	@Column(name = "short_desc_en", length = 1000)
	private String shortDescriptionEN;
	
	@Column(name = "short_desc_vi", length = 1000)
	private String shortDescriptionVI;
	
	@Column(name = "howto_reg_en", length = 500)
	private String howToRegEN;
	
	@Column(name = "howto_reg_vi", length = 500)
	private String howToRegVI;

	@Column(name = "howto_unreg_en", length = 500)
	private String howToUnregEN;
	
	@Column(name = "howto_unreg_vi", length = 500)
	private String howToUnregVI;
	
	@Column(name = "default_image", length = 1000)
	private String defaultImage;

	@Column(name = "default_banner", length = 1000)
	private String defaultBanner;

	@Column(name = "is_visible")
	private Integer visibility = 1;
	
	@Column(name = "display_order")
	private Integer displayOrder = 0;
	
	@Column(name = "short_name") //TODO change this to short_name_en
	private String shortNameEN;

	@Column(name = "short_name_vi")
	private String shortNameVI;
	
	@Column(name = "quota")
	private String quotaInfo;
	
	@Column(name = "bal_disp_opt")
	private Integer balanceDisplayOption = 0;
	
	@Column(name = "dashboard_visible")
	private Integer dashboardVisibility = 1;
	
	@ManyToOne
	@JoinColumn(name = "prod_group_id", referencedColumnName = "id")
	private ProductGroupEntity productGroup;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	private Set<ProductMetaDataEntity> metadata = new HashSet<>();
	
	@Column(name = "subs_type")
	private Integer subscriberType = 0;

	public Integer getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(Integer subscriberType) {
		this.subscriberType = subscriberType;
	}

	public ProductEntity(){ }

	public ProductEntity(String code, BigDecimal price) {
		this.code = code;
		this.price = price;
	}

	public ProductEntity(Integer id, String code, BigDecimal price) {
		this.id = id;
		this.code = code;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the extCode
	 */
	public String getExtCode() {
		return extCode;
	}

	/**
	 * @param extCode the extCode to set
	 */
	public void setExtCode(String extCode) {
		this.extCode = extCode;
	}

	/**
	 * @return the extProductName
	 */
	public String getExtProductName() {
		return extProductName;
	}

	/**
	 * @param extProductName the extProductName to set
	 */
	public void setExtProductName(String alias) {
		this.extProductName = alias;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the validFromDate
	 */
	public Date getValidFromDate() {
		return validFromDate;
	}

	/**
	 * @param validFromDate the validFromDate to set
	 */
	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	/**
	 * @return the validToDate
	 */
	public Date getValidToDate() {
		return validToDate;
	}

	/**
	 * @param validToDate the validToDate to set
	 */
	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the nameEN
	 */
	public String getNameEN() {
		return nameEN;
	}

	/**
	 * @param nameEN the nameEN to set
	 */
	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	/**
	 * @return the nameVI
	 */
	public String getNameVI() {
		return nameVI;
	}

	/**
	 * @param nameVI the nameVI to set
	 */
	public void setNameVI(String nameVI) {
		this.nameVI = nameVI;
	}

	/**
	 * @return the detailsEN
	 */
	public String getDetailsEN() {
		return detailsEN;
	}

	/**
	 * @param detailsEN the detailsEN to set
	 */
	public void setDetailsEN(String detailsEN) {
		this.detailsEN = detailsEN;
	}

	/**
	 * @return the detailsVI
	 */
	public String getDetailsVI() {
		return detailsVI;
	}

	/**
	 * @param detailsVI the detailsVI to set
	 */
	public void setDetailsVI(String detailsVI) {
		this.detailsVI = detailsVI;
	}

	/**
	 * @return the descriptionEN
	 */
	public String getDescriptionEN() {
		return descriptionEN;
	}

	/**
	 * @param descriptionEN the descriptionEN to set
	 */
	public void setDescriptionEN(String descriptionEN) {
		this.descriptionEN = descriptionEN;
	}

	/**
	 * @return the descriptionVI
	 */
	public String getDescriptionVI() {
		return descriptionVI;
	}

	/**
	 * @param descriptionVI the descriptionVI to set
	 */
	public void setDescriptionVI(String descriptionVI) {
		this.descriptionVI = descriptionVI;
	}

	/**
	 * @return the shortDescriptionEN
	 */
	public String getShortDescriptionEN() {
		return shortDescriptionEN;
	}

	/**
	 * @param shortDescriptionEN the shortDescriptionEN to set
	 */
	public void setShortDescriptionEN(String shortDescriptionEN) {
		this.shortDescriptionEN = shortDescriptionEN;
	}

	/**
	 * @return the shortDescriptionVI
	 */
	public String getShortDescriptionVI() {
		return shortDescriptionVI;
	}

	/**
	 * @param shortDescriptionVI the shortDescriptionVI to set
	 */
	public void setShortDescriptionVI(String shortDescriptionVI) {
		this.shortDescriptionVI = shortDescriptionVI;
	}

	/**
	 * @return the productGroup
	 */
	public ProductGroupEntity getProductGroup() {
		return productGroup;
	}

	/**
	 * @return the howToRegEN
	 */
	public String getHowToRegEN() {
		return howToRegEN;
	}

	/**
	 * @param howToRegEN the howToRegEN to set
	 */
	public void setHowToRegEN(String howToRegEN) {
		this.howToRegEN = howToRegEN;
	}

	/**
	 * @return the howToRegVI
	 */
	public String getHowToRegVI() {
		return howToRegVI;
	}

	/**
	 * @param howToRegVI the howToRegVI to set
	 */
	public void setHowToRegVI(String howToRegVI) {
		this.howToRegVI = howToRegVI;
	}

	/**
	 * @return the howToUnregEN
	 */
	public String getHowToUnregEN() {
		return howToUnregEN;
	}

	/**
	 * @param howToUnregEN the howToUnregEN to set
	 */
	public void setHowToUnregEN(String howToUnregEN) {
		this.howToUnregEN = howToUnregEN;
	}

	/**
	 * @return the howToUnregVI
	 */
	public String getHowToUnregVI() {
		return howToUnregVI;
	}

	/**
	 * @param howToUnregVI the howToUnregVI to set
	 */
	public void setHowToUnregVI(String howToUnregVI) {
		this.howToUnregVI = howToUnregVI;
	}

	/**
	 * @return the visibility
	 */
	public Integer getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Integer visibleFlag) {
		this.visibility = visibleFlag;
	}

	/**
	 * @return the displayOrder
	 */
	public Integer getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @return the shortNameEN
	 */
	public String getShortNameEN() {
		return shortNameEN;
	}

	/**
	 * @param shortNameEN the shortNameEN to set
	 */
	public void setShortNameEN(String shortName) {
		this.shortNameEN = shortName;
	}

	/**
	 * @return the shortNameVI
	 */
	public String getShortNameVI() {
		return shortNameVI;
	}

	/**
	 * @param shortNameVI the shortNameVI to set
	 */
	public void setShortNameVI(String shortNameVI) {
		this.shortNameVI = shortNameVI;
	}

	/**
	 * @param displayOrder the displayOrder to set
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return the defaultImage
	 */
	public String getDefaultImage() {
		return defaultImage;
	}

	/**
	 * @param defaultImage the defaultImage to set
	 */
	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}

	/**
	 * @return the defaultBanner
	 */
	public String getDefaultBanner() {
		return defaultBanner;
	}

	/**
	 * @param defaultBanner the defaultBanner to set
	 */
	public void setDefaultBanner(String defaultBanner) {
		this.defaultBanner = defaultBanner;
	}

	/**
	 * @param productGroup the productGroup to set
	 */
	public void setProductGroup(ProductGroupEntity productGroup) {
		this.productGroup = productGroup;
	}

	/**
	 * @return the metadata
	 */
	public Set<ProductMetaDataEntity> getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Set<ProductMetaDataEntity> metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return the quotaInfo
	 */
	public String getQuotaInfo() {
		return quotaInfo;
	}

	/**
	 * @param quotaInfo the quotaInfo to set
	 */
	public void setQuotaInfo(String quotaInfo) {
		this.quotaInfo = quotaInfo;
	}

	/**
	 * @return the balanceDisplayOption
	 */
	public Integer getBalanceDisplayOption() {
		return balanceDisplayOption;
	}

	/**
	 * @param balanceDisplayOption the balanceDisplayOption to set
	 */
	public void setBalanceDisplayOption(Integer balanceDisplayOption) {
		this.balanceDisplayOption = balanceDisplayOption;
	}

	/**
	 * @return the dashboardVisibility
	 */
	public Integer getDashboardVisibility() {
		return dashboardVisibility;
	}

	/**
	 * @param dashboardVisibility the dashboardVisibility to set
	 */
	public void setDashboardVisibility(Integer dashboardVisibility) {
		this.dashboardVisibility = dashboardVisibility;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductEntity other = (ProductEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", code=" + code + ", extCode=" + extCode + ", extProductName="
				+ extProductName + ", price=" + price + ", validFromDate=" + validFromDate + ", validToDate="
				+ validToDate + ", status=" + status + ", nameEN=" + nameEN + ", nameVI=" + nameVI + ", detailsEN="
				+ detailsEN + ", detailsVI=" + detailsVI + ", descriptionEN=" + descriptionEN + ", descriptionVI="
				+ descriptionVI + ", shortDescriptionEN=" + shortDescriptionEN + ", shortDescriptionVI="
				+ shortDescriptionVI + ", howToRegEN=" + howToRegEN + ", howToRegVI=" + howToRegVI + ", howToUnregEN="
				+ howToUnregEN + ", howToUnregVI=" + howToUnregVI + ", defaultImage=" + defaultImage
				+ ", defaultBanner=" + defaultBanner + ", visibility=" + visibility + ", displayOrder=" + displayOrder
				+ ", shortNameEN=" + shortNameEN + ", shortNameVI=" + shortNameVI + ", quotaInfo=" + quotaInfo
				+ ", balanceDisplayOption=" + balanceDisplayOption + ", dashboardVisibility=" + dashboardVisibility
				+ ", productGroup=" + productGroup + ", metadata=" + metadata + ", subscriberType=" + subscriberType
				+ "]";
	}

	

	
}
