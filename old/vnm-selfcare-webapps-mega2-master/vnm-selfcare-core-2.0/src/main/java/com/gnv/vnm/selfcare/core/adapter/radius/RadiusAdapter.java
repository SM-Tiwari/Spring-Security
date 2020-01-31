/**
 * RadiusAdapter.java
 */
package com.gnv.vnm.selfcare.core.adapter.radius;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapter;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterException;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.BackEndConnection;
import com.gnv.vnm.selfcare.core.enums.RequestStatus;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;

/**
 * @author nandipinto
 *
 */
public class RadiusAdapter extends BackEndAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RadiusAdapter.class);

	private RadiusConnection connection;
	private InitialDirContext dirContext;
	private boolean connected = false;

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#init(com.gnv.vnm.selfcare.core.adapter.BackEndConnection)
	 */
	@Override
	public void init(BackEndConnection connection) throws BackEndAdapterException {
		this.connection = (RadiusConnection)connection;

//		LoggingUtil.debug(logger, "#init --- username= " + this.connection.getUserName() + ", " + this.connection.getCredential());
		LoggingUtil.debug(logger, "#init -- connecting to " + connection.getHost() + ":" + connection.getPort());

		try {
			Hashtable<String, Object> env = new Hashtable<>();
			env.put("java.naming.ldap.version", this.connection.getLdapVersion());
//			env.put("com.sun.jndi.ldap.connect.pool", this.connection.isConnectionPoolEnabled() ? "true" : "false");

			String connectTimeout = "" + (this.connection.getConnectionTimeOut() > 0 ? this.connection.getConnectionTimeOut() * 1000 : 10000);
			env.put("com.sun.jndi.ldap.read.timeout", connectTimeout);

			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, "ldap://" + this.connection.getHost() + ":" + this.connection.getPort());

			env.put(Context.SECURITY_AUTHENTICATION, "simple");
			env.put(Context.SECURITY_PRINCIPAL, this.connection.getUserName());
			env.put(Context.SECURITY_CREDENTIALS, this.connection.getCredential());

			dirContext = new InitialDirContext(env);
			this.connected = true;

			LoggingUtil.debug(logger, "#init --- connected to Radius.");
		} catch (Exception e) {
			logger.error("#init -- could not initiate RadiusAdapter!", e);
			throw new BackEndAdapterException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#reconnect(com.gnv.vnm.selfcare.core.adapter.BackEndConnection)
	 */
	@Override
	public void reconnect(BackEndConnection connection) throws BackEndAdapterException {
		init(connection);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#login()
	 */
	@Override
	public void login() {
		//do nothing
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#logout()
	 */
	@Override
	public void logout() {
		//do nothing
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#isConnected()
	 */
	@Override
	public boolean isConnected() {
		return connected;
	}

	public InitialDirContext getDirContext() throws BackEndAdapterException{
		if (dirContext == null || !isConnected()){
			init(this.connection);
		}
		return dirContext;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#sendRequest(com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest)
	 */
	@Override
	public BackEndAdapterResponse sendRequest(BackEndAdapterRequest request) {

		BackEndAdapterResponse response = new BackEndAdapterResponse();
		List<BasicSubscriberInfo> sessions = new ArrayList<>();
		try {
			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

			RadiusQueryRequest req = (RadiusQueryRequest)request;
			String searchString = this.connection.getDnPrefix() + req.getIpAddress() + this.connection.getDnSuffix();
			String searchFilter = this.connection.getSearchFilter();
			NamingEnumeration<?> results = getDirContext().search(searchString, searchFilter, controls);

			//if (results.hasMoreElements()){
			while (results.hasMoreElements()){

				SearchResult searchResult = (SearchResult) results.next();
				Attributes attributes = searchResult.getAttributes();

				//output format would be something like:
				//3gppimsi: 452050269482386,
				//calling-station-id: 84924319590,
				String msisdn = ""; 
				if (attributes.get("calling-station-id") != null) {
					msisdn = attributes.get("calling-station-id").toString().split(":")[1].trim();
				}
				
				String imsi = "";
				if (attributes.get("3gppimsi") != null) {
					imsi = attributes.get("3gppimsi").toString().split(":")[1].trim();
				}

				BasicSubscriberInfo bsi = new BasicSubscriberInfo(msisdn, imsi);
				bsi.setCurrentIpAddress(req.getIpAddress());
				try {
					bsi.setSessionStartTime(Long.parseLong(attributes.get("session-start-time").toString().split(":")[1].trim()));
				} catch (Exception e) { }

				sessions.add(bsi);
			}
		} catch (Exception e) {
			response.setStatus(RequestStatus.FAIL);
			response.setResponseDescription(e.getMessage());

			logger.error("#sendRequest --- error occurred when sending request to Radius!", e);
		}

		int sessionCount = sessions.size();
		if (sessionCount > 0) {
			//--- get the most recent session start time as requested by Minh Tuan (20170823)
			if (sessionCount > 1) Collections.sort(sessions, new BasicSubscriberInfo.SessionStartTimeComparator());

			response.setResult(sessions.get(0));
			response.setStatus(RequestStatus.SUCCESS);

		} else {
			response.setStatus(RequestStatus.FAIL);
		}
		return response;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#shutdown()
	 */
	@Override
	public void shutdown() {
		if (dirContext != null){
			try {
				dirContext.close();
			} catch (Exception e) {}
		}
		this.connected = false;
	}

}
