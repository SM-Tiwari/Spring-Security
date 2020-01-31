/**
 * Store.java
 */
package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nandipinto
 *
 */
public class Store implements Serializable {

	private static final long serialVersionUID = 6501809885198442070L;

	private Integer id;
	private String code;
	private String name;
	private String address;
	private String latitude;
	private String longitude;
	private String district;
	private String province;
	private String phoneNumber;
	@JsonIgnore
	private double distance;
	
	public Store(){ }
	
	public Store(Integer id, String code, String name, String address, String latitude, String longitude,
			String district, String province) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.district = district;
		this.province = province;
	}

	public Store(String code, String name, String address, String latitude, String longitude,
			String district, String province) {
		this(null, code, name, address, latitude, longitude, district, province);
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
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
		Store other = (Store) obj;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Store [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", district=");
		builder.append(district);
		builder.append(", province=");
		builder.append(province);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append("]");
		return builder.toString();
	}
	

	public static Comparator<Store> StoreNameAscComparator = new Comparator<Store>() {

		@Override
		public int compare(Store o1, Store o2) {
			if (o1 == null || o2 == null) return 0;
			if (o1.name == null || o2.name == null) return 0;
			return o1.name.compareTo(o2.name);
		}
	};
	
	public static Comparator<Store> StoreNameDescComparator = new Comparator<Store>() {

		@Override
		public int compare(Store o1, Store o2) {
			if (o1 == null || o2 == null) return 0;
			if (o1.name == null || o2.name == null) return 0;
			return o2.name.compareTo(o1.name);
		}
	};

	public static Comparator<Store> DistanceAscComparator = new Comparator<Store>() {

		@Override
		public int compare(Store o1, Store o2) {
			if (o1 == null || o2 == null) return 0;
			return new Double(o1.distance).compareTo(new Double(o2.distance));
		}
	};

	public static Comparator<Store> DistanceDescComparator = new Comparator<Store>() {

		@Override
		public int compare(Store o1, Store o2) {
			if (o1 == null || o2 == null) return 0;
			return new Double(o2.distance).compareTo(new Double(o1.distance));
		}
	};

}
