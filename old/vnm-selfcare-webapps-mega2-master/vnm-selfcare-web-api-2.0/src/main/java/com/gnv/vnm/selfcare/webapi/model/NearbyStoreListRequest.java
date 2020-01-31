/**
 * 
 */
package com.gnv.vnm.selfcare.webapi.model;

/**
 * @author nandipinto
 *
 */
public class NearbyStoreListRequest extends StoreListRequest {

	private static final long serialVersionUID = 1603363701040256110L;

	private String latitude;
	private String longitude;
	private String maxDistance;
	
	public NearbyStoreListRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param searchTerm
	 * @param pageNo
	 * @param sortBy
	 */
	public NearbyStoreListRequest(String searchTerm, int pageNo, String sortBy) {
		super(searchTerm, pageNo, sortBy);
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
	 * @return the maxDistance
	 */
	public String getMaxDistance() {
		return maxDistance;
	}

	/**
	 * @param maxDistance the maxDistance to set
	 */
	public void setMaxDistance(String maxDistance) {
		this.maxDistance = maxDistance;
	}

}
