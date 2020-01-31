/**
 * RadiusConnection.java
 */
package com.gnv.vnm.selfcare.core.adapter.radius;

import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;

/**
 * @author nandipinto
 *
 */
public class RadiusConnection extends BackEndConnection {

	private static final long serialVersionUID = -2136910583947067851L;
	
	//dn = "framed-ip-address=" + str(ipAddress) + ",radiusstatus=sessions_by_ipaddress,o=radius"
	
	private String searchFilter = "framed-ip-address=*";
	private String searchScope = "SCOPE_SUBTREE";
	private String dnPrefix = "framed-ip-address=";
	private String dnSuffix = ",radiusstatus=sessions_by_ipaddress,o=radius";
	private String ldapVersion = "2";
	private boolean connectionPoolEnabled = false;
	private int conPoolMinSize = 1;
	private int conPoolMaxSize = 10;
	
	public RadiusConnection() {}

	/**
	 * @param host
	 * @param port
	 * @param userName
	 * @param credential
	 * @param protocol
	 */
	public RadiusConnection(String host, int port, String userName, String credential, String protocol) {
		super(host, port, userName, credential, protocol);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the searchFilter
	 */
	public String getSearchFilter() {
		return searchFilter;
	}

	/**
	 * @param searchFilter the searchFilter to set
	 */
	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	/**
	 * @return the searchScope
	 */
	public String getSearchScope() {
		return searchScope;
	}

	/**
	 * @param searchScope the searchScope to set
	 */
	public void setSearchScope(String searchScope) {
		this.searchScope = searchScope;
	}

	/**
	 * @return the dnPrefix
	 */
	public String getDnPrefix() {
		return dnPrefix;
	}

	/**
	 * @param dnPrefix the dnPrefix to set
	 */
	public void setDnPrefix(String dnPrefix) {
		this.dnPrefix = dnPrefix;
	}

	/**
	 * @return the dnSuffix
	 */
	public String getDnSuffix() {
		return dnSuffix;
	}

	/**
	 * @param dnSuffix the dnSuffix to set
	 */
	public void setDnSuffix(String dnSuffix) {
		this.dnSuffix = dnSuffix;
	}

	/**
	 * @return the ldapVersion
	 */
	public String getLdapVersion() {
		return ldapVersion;
	}

	/**
	 * @param ldapVersion the ldapVersion to set
	 */
	public void setLdapVersion(String ldapVersion) {
		this.ldapVersion = ldapVersion;
	}

	/**
	 * @return the connectionPoolEnabled
	 */
	public boolean isConnectionPoolEnabled() {
		return connectionPoolEnabled;
	}

	/**
	 * @param connectionPoolEnabled the connectionPoolEnabled to set
	 */
	public void setConnectionPoolEnabled(boolean connectionPoolEnabled) {
		this.connectionPoolEnabled = connectionPoolEnabled;
	}

	/**
	 * @return the conPoolMinSize
	 */
	public int getConPoolMinSize() {
		return conPoolMinSize;
	}

	/**
	 * @param conPoolMinSize the conPoolMinSize to set
	 */
	public void setConPoolMinSize(int conPoolMinSize) {
		this.conPoolMinSize = conPoolMinSize;
	}

	/**
	 * @return the conPoolMaxSize
	 */
	public int getConPoolMaxSize() {
		return conPoolMaxSize;
	}

	/**
	 * @param conPoolMaxSize the conPoolMaxSize to set
	 */
	public void setConPoolMaxSize(int conPoolMaxSize) {
		this.conPoolMaxSize = conPoolMaxSize;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RadiusConnection [searchFilter=");
		builder.append(searchFilter);
		builder.append(", searchScope=");
		builder.append(searchScope);
		builder.append(", dnPrefix=");
		builder.append(dnPrefix);
		builder.append(", dnSuffix=");
		builder.append(dnSuffix);
		builder.append(", connectionPoolEnabled=");
		builder.append(connectionPoolEnabled);
		builder.append(", conPoolMinSize=");
		builder.append(conPoolMinSize);
		builder.append(", conPoolMaxSize=");
		builder.append(conPoolMaxSize);
		builder.append(", host=");
		builder.append(host);
		builder.append(", port=");
		builder.append(port);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", credential=");
		builder.append(credential);
		builder.append(", protocol=");
		builder.append(protocol);
		builder.append(", socketTimeOut=");
		builder.append(socketTimeOut);
		builder.append(", connectionTimeOut=");
		builder.append(connectionTimeOut);
		builder.append(", reconnectInterval=");
		builder.append(reconnectInterval);
		builder.append(", maxConcurrentConnections=");
		builder.append(maxConcurrentConnections);
		builder.append("]");
		return builder.toString();
	}

	
}
