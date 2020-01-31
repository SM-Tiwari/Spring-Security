/**
 * GamifyAdapter.java
 */
package com.gnv.vnm.selfcare.core.adapter.gamify;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class GamifyAdapter extends BackEndAdapter {

	private static final Logger logger = LoggerFactory.getLogger(GamifyAdapter.class);
	
	
	private GamifyConnection connection = null;
	private String getMonstersURL = null, redeemMonsterURL = null;
	
	private CloseableHttpClient httpClient = null;
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#init(com.gnv.vnm.selfcare.core.adapter.BackEndConnection)
	 */
	@Override
	public void init(BackEndConnection connection) throws BackEndAdapterException {
		this.connection = (GamifyConnection)connection;
		this.getMonstersURL = this.connection.getGetMonsterURL();
		this.redeemMonsterURL = this.connection.getRedeemByMonsterURL();
		
		if (!StringUtils.hasText(getMonstersURL) || !StringUtils.hasText(redeemMonsterURL)){
			throw new BackEndAdapterException("Missing required adapter configuration!");
		}

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
		return true;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#sendRequest(com.gnv.vnm.selfcare.core.adapter.BackEndAdapterRequest)
	 */
	@Override
	public BackEndAdapterResponse sendRequest(BackEndAdapterRequest request) {
		
		BackEndAdapterResponse result = new BackEndAdapterResponse();
		
		CloseableHttpResponse httpResp = null;
		HttpPost post = null;
		try {
			HttpClientContext context = HttpClientContext.create();

			ObjectMapper om = new ObjectMapper();

			if (request instanceof GamifyGetMonstersRequest){
				
				GamifyGetMonstersRequest getMonsterReq = (GamifyGetMonstersRequest)request;
				
				
				List<NameValuePair> paramList = new ArrayList<>();
				String phoneNumber = getMonsterReq.getMsisdn();
				if (phoneNumber.startsWith("0") && phoneNumber.length() > 1) phoneNumber = phoneNumber.substring(1);
				
				paramList.add(new BasicNameValuePair("phone_number", phoneNumber));
				if (StringUtils.hasText(getMonsterReq.getLangCode())){
					paramList.add(new BasicNameValuePair("lang_code", getMonsterReq.getLangCode()));
				}
				
				LoggingUtil.debug(logger, "#sendRequest --- " + getMonsterReq.getMsisdn() + ", retrieving monster list...");
				
				post = new HttpPost(getMonstersURL);
				post.setEntity(new UrlEncodedFormEntity(paramList));
				
				httpResp = getHttpClient().execute(post, context);
				
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				
				HttpEntity entity = httpResp.getEntity();
				entity.writeTo(out);
				
				LoggingUtil.debug(logger, "#sendRequest --- " + getMonsterReq.getMsisdn() + ", receiving response= " + new String(out.toByteArray()));
				
				GamifyGetMonsterResponse gamifyResp = om.readValue(out.toByteArray(), GamifyGetMonsterResponse.class);
				
				if (gamifyResp != null){
					if (gamifyResp.getResult().getCode().equals(GamifyResultCodes.SUCCESS.code())){
						result.setStatus(RequestStatus.SUCCESS);
						result.setResult(gamifyResp);

					}else{
						result.setStatus(RequestStatus.FAIL);
						result.setResponseCode(GamifyResultCodes.SYSTEM_ERROR.code());
						result.setResponseDescription(GamifyResultCodes.SYSTEM_ERROR.name());

					}
					result.setResponseCode(gamifyResp.getResult().getCode());
					result.setResponseDescription(gamifyResp.getResult().getMessage());
					
				}else{
					result.setStatus(RequestStatus.FAIL);
					result.setResponseCode(GamifyResultCodes.SYSTEM_ERROR.code());
					result.setResponseDescription(GamifyResultCodes.SYSTEM_ERROR.name());
				}
				
				EntityUtils.consume(entity);
				
			}else if (request instanceof GamifyRedeemByMonsterRequest){
				
				GamifyRedeemByMonsterRequest redeemReq = (GamifyRedeemByMonsterRequest)request;
				
				if (!StringUtils.hasLength(redeemReq.getMsisdn())  || redeemReq.getMonsters() == null){
					
					logger.error("#sendRequest --- could not send redeem request to Gamify, missing required parameters!");
					
					result.setStatus(RequestStatus.FAIL);
					result.setResponseCode(GamifyResultCodes.MISSING_PARAMETER.code());
					result.setResponseDescription(GamifyResultCodes.MISSING_PARAMETER.name());
					
					return result;
				}

				List<NameValuePair> paramList = new ArrayList<>();
				if (StringUtils.hasText(redeemReq.getLangCode())){
					paramList.add(new BasicNameValuePair("lang_code", redeemReq.getLangCode()));
				}
				
				String phoneNumber = redeemReq.getMsisdn();
				if (phoneNumber.startsWith("0") && phoneNumber.length() > 1) phoneNumber = phoneNumber.substring(1);
				paramList.add(new BasicNameValuePair("phone_number", phoneNumber));

				String trxId = redeemReq.getTrxId();
				if (!StringUtils.hasText(trxId)) trxId = "" + System.currentTimeMillis();
				paramList.add(new BasicNameValuePair("transaction_id", trxId));

				String monsters = om.writeValueAsString(redeemReq.getMonsters());
				paramList.add(new BasicNameValuePair("monsters", monsters));
				
				LoggingUtil.debug(logger, "#sendRequest --- " + redeemReq.getMsisdn() + ", sending redeem by monster request " + monsters);
				
				post = new HttpPost(redeemMonsterURL);
				post.setEntity(new UrlEncodedFormEntity(paramList));
				
				httpResp = getHttpClient().execute(post, context);
				
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				HttpEntity entity = httpResp.getEntity();
				entity.writeTo(out);
				
				LoggingUtil.debug(logger, "#sendRequest --- " + redeemReq.getMsisdn() + ", receiving response= " + new String(out.toByteArray()));
				GamifyRedeemByMonsterResponse gamifyResp = om.readValue(out.toByteArray(), GamifyRedeemByMonsterResponse.class);
				
				if (gamifyResp != null){
					if (gamifyResp.getResult().getCode().equals(GamifyResultCodes.SUCCESS.code())){
						result.setStatus(RequestStatus.SUCCESS);
						
					}else{
						result.setStatus(RequestStatus.FAIL);
					}
					result.setResponseCode(gamifyResp.getResult().getCode());
					result.setResponseDescription(gamifyResp.getResult().getMessage());
					
				}else{
					result.setStatus(RequestStatus.FAIL);
					result.setResponseCode(GamifyResultCodes.SYSTEM_ERROR.code());
					result.setResponseDescription(GamifyResultCodes.SYSTEM_ERROR.name());
				}
				
				EntityUtils.consume(entity);
			}
			
		} catch (Exception e) {
			logger.error("#sendRequest --- error when processing request to Gamify", e);
			
			result.setStatus(RequestStatus.FAIL);
			result.setResponseCode(GamifyResultCodes.SYSTEM_ERROR.code());
			result.setResponseDescription(GamifyResultCodes.SYSTEM_ERROR.name());
			
		} finally{
			if (httpResp != null){
				try {
					httpResp.close();
				} catch (IOException e) {}
			}
			
			if (post != null){
				post.releaseConnection();
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#reconnect(com.gnv.vnm.selfcare.core.adapter.BackEndConnection)
	 */
	@Override
	public void reconnect(BackEndConnection connection) throws BackEndAdapterException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.adapter.BackEndAdapter#shutdown()
	 */
	@Override
	public void shutdown() {
		
		if (httpClient != null){
			try {
				httpClient.close();
			} catch (Exception e) {}
		}
	}
	
	private CloseableHttpClient getHttpClient(){
		if (httpClient == null){
			httpClient = HttpClients.custom()
					.setDefaultRequestConfig(RequestConfig.custom()
							.setConnectTimeout(this.connection.getConnectionTimeOut() * 1000)
							.setConnectionRequestTimeout(this.connection.getConnectionTimeOut() * 1000)
							.setCookieSpec(CookieSpecs.DEFAULT).build())
					.setRedirectStrategy(new LaxRedirectStrategy()).build();
		}
		return httpClient;
	}

}
