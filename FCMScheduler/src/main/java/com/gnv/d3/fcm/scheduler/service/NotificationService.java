package com.gnv.d3.fcm.scheduler.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnv.d3.fcm.scheduler.bean.Content;
import com.gnv.d3.fcm.scheduler.bean.MultiDeviceFcmResponse;
import com.gnv.d3.fcm.scheduler.bean.NotificationPush;
import com.gnv.d3.fcm.scheduler.bean.NotificationPushExample;
import com.gnv.d3.fcm.scheduler.bean.Secretkey;
import com.gnv.d3.fcm.scheduler.bean.SecretkeyExample;
import com.gnv.d3.fcm.scheduler.config.MyBatisSqlSessionFactory;
import com.gnv.d3.fcm.scheduler.mapper.NotificationPushMapper;
import com.gnv.d3.fcm.scheduler.mapper.SecretkeyMapper;
import com.google.gson.Gson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * <pre>
 *  com.gnv.d3.fcm.scheduler.service.NotificationService 
 * </pre>
 *
 * @author edwin < edwinkun at gmail dot com >
 * May 9, 2017 2:07:42 PM
 *
 */
public class NotificationService {

    private Logger logger = Logger.getLogger(this.getClass());
    
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private CloseableHttpClient httpClient = null; 
	private PoolingHttpClientConnectionManager connectionManager = null;
	private RequestConfig requestConfig = null;
    
    public List<NotificationPush> getNotificationPushs() {
        List<NotificationPush> notificationPushs = new ArrayList<>();
        
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession(true);

            NotificationPushMapper mapper = sqlSession.getMapper(NotificationPushMapper.class);
            NotificationPushExample example = new NotificationPushExample();
            example.createCriteria().andIsSendEqualTo(BigDecimal.ZERO).andGcmUrlIsNotNull().andApnUrlIsNotNull();
            
            notificationPushs.addAll(mapper.selectByExampleWithRowbounds(example));
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        
        return notificationPushs;
    }
    
    public void setAsSend(NotificationPush notificationPush) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession(true);

            NotificationPushMapper mapper = sqlSession.getMapper(NotificationPushMapper.class);
            NotificationPushExample example = new NotificationPushExample();
            NotificationPushExample.Criteria criteria = example.createCriteria();
            criteria.andUuidEqualTo(notificationPush.getUuid());
            
            notificationPush.setIsSend(BigDecimal.ONE);
            
            mapper.updateByExampleSelective(notificationPush, example);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    
    
    
	public boolean pushMessage( Content  message, String endPoint,String serverKey) {
		
	
		try {
			HttpPost httpPost = new HttpPost(endPoint);
			httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(message), "UTF-8"));
			
			CloseableHttpResponse response = getHttpClient(serverKey).execute(httpPost);
			if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				Content result = objectMapper.readValue(response.getEntity().getContent(), Content.class);
			
				
				response.close();
				
				return result != null;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
	//		logger.error("#pushMessage --- error when pushing message to FCM for MSISDN " + message.getMsisdn(), e);
		}
		return false;
	}
	
	public CloseableHttpClient getHttpClient(String serverKey){
		if (httpClient == null){
			//String serverKey = getAppConfigValue("fcm.serverkey", "").toString();
		//	String serverKey = "serverkey";
			List<Header> headers = new ArrayList<>();
			headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));
			headers.add(new BasicHeader(HttpHeaders.AUTHORIZATION, "key=" + serverKey));
			
			httpClient = HttpClients.custom()
					.setRedirectStrategy(new LaxRedirectStrategy())
					.setConnectionManager(getConnectionManager())
					.setDefaultHeaders(headers)
					.setDefaultRequestConfig(getRequestConfig()).build();
		}
		return httpClient;
	}
    
	public PoolingHttpClientConnectionManager getConnectionManager() {
		if (connectionManager == null) {
			connectionManager = new PoolingHttpClientConnectionManager();
			connectionManager.setMaxTotal(100);
			
		}
		return connectionManager;
	}
	
	public RequestConfig getRequestConfig() {
		
		if (requestConfig == null) {
			
			int connectTimeout = 30 * 1000;

			requestConfig = RequestConfig.custom()
					.setCookieSpec("default")
					.setSocketTimeout(connectTimeout)
					.setConnectTimeout(connectTimeout)
					.setConnectionRequestTimeout(connectTimeout).build();
		}
		return requestConfig;
	}
    
	
	
	
	/**
	 * This method is used for sending notification to all device id.
	 * 
	 * @param deviceIds
	 * @param jsonObject
	 * @param screenOpen
	 * @return
	 * @throws Exception
	 */
	public MultiDeviceFcmResponse sendAndroidNotification(String token, Content content, String endPoint,String serverKey,NotificationPush np) {
		logger.debug("Inside FCMNotification in sendAndroidNotification method:::::::::::: " );
		MultiDeviceFcmResponse multiDeviceFcmResponse=new MultiDeviceFcmResponse();
		ResponseEntity<String> response=null;
		try {
			
			/*JSONObject jsonObject=new JSONObject();
	    		jsonObject.put("title", "bima notification");
	    		jsonObject.put("body",np.getApnPayload());
	    		jsonObject.put("icon", np.getIcon());
	    		jsonObject.put("topBanner", "default");*/
			
	    		//commented by siddhesh on 27-06-19

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("title", "Bima Notification");
			jsonObject.put("subtitle", np.getPushMessage());
			jsonObject.put("body", np.getApnPayload());
			jsonObject.put("icon", np.getIcon());
			jsonObject.put("topBanner", np.getTopBanner());
			jsonObject.put("link", np.getLink());
			jsonObject.put("data", np.getLink());
			jsonObject.put("mediaUrl", np.getIcon());
			jsonObject.put("priority", 10);
			jsonObject.put("message", np.getPushMessage());
			//jsonObject.put("my-attachment", np.getIcon());
			//jsonObject.put("sound", "default");
			//jsonObject.put("id", "abcd123");
			//jsonObject.put("mutable_content", true);

			/*
			 * JSONObject notifObject = new JSONObject(); JSONObject dataObject = new
			 * JSONObject(); dataObject.put("id", "abcd123");
			 */
			JSONObject jsonData = new JSONObject();
			jsonData.put("mediaUrl", np.getIcon());
			jsonData.put("message", np.getPushMessage());
			
			
			JSONObject jsonIos = new JSONObject();
			
			
			
			jsonIos.put("body", np.getApnPayload());
			jsonIos.put("title", "Bima Notification");
			jsonIos.put("url_redirect", np.getLink());
			jsonIos.put("mediaUrl", np.getIcon());
			jsonIos.put("subtitle", np.getPushMessage());
			jsonIos.put("sound", "default");
			jsonIos.put("icon", np.getIcon());
			jsonIos.put("topBanner", np.getTopBanner());
			jsonIos.put("link", np.getLink());
			jsonIos.put("my-attachment", np.getIcon());
			jsonIos.put("data", np.getLink());
			jsonIos.put("content-available", true);
			jsonIos.put("mutable_content", true);
			jsonIos.put("category", "pushWithImage");
			jsonIos.put("pushWithImage", np.getIcon());
			
			
			JSONObject json = new JSONObject();
			

			json.put("to", token);
			
			//json.put("priority", 10);
			
			//json.put("data", jsonObject);
			//json.put("data", jsonData);
			json.put("notification", jsonIos);
			//json.put("mutable_content", true);
			//json.put("content-available", true);
			
			
			
			System.out.println("jsonoooooobject::::"+json);
			logger.info("jsonoooooobject::::"+json);
			response=this.pushFCMNotification(json,endPoint,serverKey);
			System.out.println("response is----------"+response);
			logger.info("response is----------"+response);
			Gson g = new Gson();
			multiDeviceFcmResponse = g.fromJson(response.getBody(), MultiDeviceFcmResponse.class);
					
					System.out.println("sucess"+multiDeviceFcmResponse.getSuccess()+" fail"+ multiDeviceFcmResponse.getFailure());

					
		} catch (Exception e) {
			logger.error("Exception Inside FCMNotification in sendAndroidNotification method " + e.getMessage());
		}
		return multiDeviceFcmResponse;
	}
	
	
	/**
	 * This method is used for push notification on firebase cloud.
	 * 
	 * @param json
	 *            {@link JSONObject}
	 * @throws Exception
	 */
	public ResponseEntity<String> pushFCMNotification(JSONObject json, String endPoint,String FCMSERVER_KEY) throws Exception {
		System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1");
		RestTemplate restTemplate = new RestTemplate();
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		/*headers.setContentType(MediaType.APPLICATION_JSON);*/
		headers.setContentType( new MediaType("application", "json", StandardCharsets.UTF_8));
		headers.add("Authorization", "key=" + FCMSERVER_KEY);
		restTemplate.getMessageConverters()
        .add(0, new StringHttpMessageConverter());
		/*restTemplate.getMessageConverters()
        .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));*/
		HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);
		logger.debug("::::::::::::::::::PUSH NOTIFICATION REQUEST :::::::::::: " + json.toString());
		System.out.println("URL::"+endPoint+" FCM Server Key"+FCMSERVER_KEY);
		ResponseEntity<String> response = restTemplate.exchange(endPoint, HttpMethod.POST, entity, String.class);
		logger.debug("::::::::::::::::::PUSH NOTIFICATION RESPONSE :::::::::::: " + response.getBody());
		return response;
	}
	
/*  */
	
	
    public void clearSuccessfulNotifications(List<String> uuids) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession(true);

            NotificationPushMapper mapper = sqlSession.getMapper(NotificationPushMapper.class);
            NotificationPushExample example = new NotificationPushExample();
            NotificationPushExample.Criteria criteria = example.createCriteria();
            criteria.andUuidIn(uuids);
            
            mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    
    public void clearEmptyNotifications() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession(true);

            NotificationPushMapper mapper = sqlSession.getMapper(NotificationPushMapper.class);
            NotificationPushExample example = new NotificationPushExample();
            NotificationPushExample.Criteria criteria = example.createCriteria();
            criteria.andGcmUrlIsNull().andApnUrlIsNull();
            
            mapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
