/**
 * ProductChangeMappingEntity.java
 */
package com.gnv.vnm.selfcare.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author nandipinto
 *
 */

@Entity
@Table(name = "product_change_mapping", indexes = { @Index(columnList = "src_product_code") })
@SequenceGenerator(name = "ppm_seq", sequenceName = "ppm_seq", allocationSize = 1)
public class ProductChangeMappingEntity extends BaseEntity {

	private static final long serialVersionUID = -5380148020083066959L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ppm_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "src_product_code", length = 20, nullable = false)
	private String productCode;
	
	@Column(name = "target_product_code", length = 20, nullable = false)
	private String buyableProductCode;

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
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the buyableProductCode
	 */
	public String getBuyableProductCode() {
		return buyableProductCode;
	}

	/**
	 * @param buyableProductCode the buyableProductCode to set
	 */
	public void setBuyableProductCode(String buyableProductCode) {
		this.buyableProductCode = buyableProductCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((buyableProductCode == null) ? 0 : buyableProductCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
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
		ProductChangeMappingEntity other = (ProductChangeMappingEntity) obj;
		if (buyableProductCode == null) {
			if (other.buyableProductCode != null)
				return false;
		} else if (!buyableProductCode.equals(other.buyableProductCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductChangeMappingEntity [id=");
		builder.append(id);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", buyableProductCode=");
		builder.append(buyableProductCode);
		builder.append("]");
		return builder.toString();
	}

}
