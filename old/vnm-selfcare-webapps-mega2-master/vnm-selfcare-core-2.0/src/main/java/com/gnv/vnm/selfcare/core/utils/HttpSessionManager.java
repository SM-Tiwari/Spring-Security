/**
 * HttpSessionManager.java
 * Aug 12, 2016 11:34:58 AM
 */
package com.gnv.vnm.selfcare.core.utils;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nandipinto
 *
 */
public class HttpSessionManager {

	private static final Logger logger = LoggerFactory.getLogger(HttpSessionManager.class);
	
	public static final int CONNECT_TIMEOUT_SECS = 60000;
	public static final int SOCKET_TIMOUT_SECS = 60000;
	public static final int MAX_CONCURRENT_CONN = 0;

	private volatile static HttpSessionManager instance;
	
	private HttpConnectionManager connectionManager;
	private HttpClient httpClient;
	
	public static HttpSessionManager getInstance(int soTimeout, int connectionTimeout, int maxTotalConnections, boolean multiThreaded){
		if (instance == null) {
			synchronized (HttpSessionManager.class) {
				if (instance == null) {
					instance = new HttpSessionManager(soTimeout, connectionTimeout, maxTotalConnections, multiThreaded);
				}
			}
		}
		return instance;
	}
	
	private HttpSessionManager(int soTimeout, int connectionTimeout, int maxTotalConnections, boolean multiThreaded) {
		HttpConnectionManagerParams params = new HttpConnectionManagerParams();
		if (soTimeout > 0) params.setSoTimeout(soTimeout);
		if (connectionTimeout > 0) params.setConnectionTimeout(connectionTimeout);
		if (maxTotalConnections > 0) params.setMaxTotalConnections(maxTotalConnections);
		params.setStaleCheckingEnabled(true);
		
		if (multiThreaded) {
			connectionManager = new MultiThreadedHttpConnectionManager();
		} else {
			connectionManager = new SimpleHttpConnectionManager();
		}
		connectionManager.setParams(params);
		httpClient = new HttpClient(connectionManager);
	}

	public HttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public HttpResponseWrapper post(String uri, String requestBody, String contentType, Header[] reqHeaders){
		PostMethod _post = new PostMethod(uri);
		HttpResponseWrapper httpResp = new HttpResponseWrapper();
		try {
			if (reqHeaders != null){
				for (int i=0; i<reqHeaders.length; i++){
					_post.setRequestHeader(reqHeaders[i]);
				}
			}
			StringRequestEntity entity = new StringRequestEntity(requestBody, contentType,  "UTF-8");
			if (requestBody != null && !requestBody.equals("")) _post.setRequestEntity(entity);
			HttpMethodParams p = new HttpMethodParams();
			_post.setParams(p);
			
			int respCode = getHttpClient().executeMethod(_post);
			String response = _post.getResponseBodyAsString();
			Header[] headers = _post.getResponseHeaders();
			
			httpResp.setCode(respCode);
			httpResp.setContent(response);
			httpResp.setHeaders(headers);
			
		} catch (Exception e) {
			httpResp.setCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			httpResp.setContent(e.getMessage());
			
			logger.error("#post >> error sending request to " + uri, e);
		} finally{
			_post.releaseConnection();
		}
		return httpResp;
	}
	
	public HttpResponseWrapper post(String uri, NameValuePair[] params, Header[] reqHeaders){
		PostMethod _post = new PostMethod(uri);
		HttpResponseWrapper httpResp = new HttpResponseWrapper();
		try {
			if (reqHeaders != null){
				for (int i=0; i<reqHeaders.length; i++){
					_post.setRequestHeader(reqHeaders[i]);
				}
			}
			_post.setRequestBody(params);
			HttpMethodParams p = new HttpMethodParams();
			_post.setParams(p);
			int respCode = getHttpClient().executeMethod(_post);
			String response = _post.getResponseBodyAsString();
			Header[] headers = _post.getResponseHeaders();

			httpResp.setCode(respCode);
			httpResp.setContent(response);
			httpResp.setHeaders(headers);

		} catch (Exception e) {
			httpResp.setCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			httpResp.setContent(e.getMessage());
			
			logger.error("#post >> error sending request to " + uri, e);
		} finally{
			_post.releaseConnection();
		}
		return httpResp;
	}
	
	public HttpResponseWrapper get(String uri, NameValuePair[] params, Header[] reqHeaders){
		GetMethod _get = new GetMethod(uri);
		HttpResponseWrapper httpResp = new HttpResponseWrapper();
		try {
			if (reqHeaders != null){
				for (int i=0; i<reqHeaders.length; i++){
					_get.setRequestHeader(reqHeaders[i]);
				}
			}
			if (params != null){
				_get.setQueryString(params);
			}
			int respCode = getHttpClient().executeMethod(_get);
			String response = _get.getResponseBodyAsString();
			Header[] headers = _get.getResponseHeaders();

			httpResp.setCode(respCode);
			httpResp.setContent(response);
			httpResp.setHeaders(headers);
			
		} catch (Exception e) {
			httpResp.setCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			httpResp.setContent(e.getMessage());
			
			logger.error("#get >> error sending request to " + uri, e);
		} finally{
			_get.releaseConnection();
		}
		return httpResp;
	}
	
	public void shutdown(){
		if (connectionManager instanceof MultiThreadedHttpConnectionManager) {
			try {
				((MultiThreadedHttpConnectionManager)connectionManager).shutdown();
			} catch (Exception e) {}
		}
	}

}
