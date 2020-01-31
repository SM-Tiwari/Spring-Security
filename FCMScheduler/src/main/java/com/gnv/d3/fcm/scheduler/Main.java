package com.gnv.d3.fcm.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.gnv.d3.fcm.scheduler.bean.Content;
import com.gnv.d3.fcm.scheduler.bean.MultiDeviceFcmResponse;
import com.gnv.d3.fcm.scheduler.bean.NotificationPush;
import com.gnv.d3.fcm.scheduler.service.NotificationService;

/**
 * <pre>
 *  com.gnv.d3.fcm.scheduler.Main
 * </pre>
 *
 * @author edwin < edwinkun at gmail dot com >
 * May 9, 2017 1:33:15 PM
 *
 */
public class Main extends TimerTask {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String endPoint="https://fcm.googleapis.com/fcm/send";
    private final NotificationService notificationService = new NotificationService();

    public static void main(String[] args) {
    	System.out.println("heree...........");
        Main main = new Main();
        Timer timer = new Timer();
        timer.schedule(main, 0, 10000);
    }

    private void fire() {
    	System.out.println("firee");
        List<NotificationPush> notificationPushs = notificationService.getNotificationPushs();
        List<String> notificationUUIDs = new ArrayList<>();
        
   //     ExecutorService executor = Executors.newFixedThreadPool(200);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        logger.info("grabbing " + notificationPushs.size()+" notification");
        
        //String fcmKey = PropertiesLoader.getPropertiesLoader().getProperties().getProperty("FCM.Key");
        //String fcmKey="AAAAmMqC33E:APA91bEm6AYLlyp8TU5fzENLPTkUazIWNUF2bK5pmE27aubBlzzaCeQXgWiJa2CnHF0OX1hwMj8XoUkv8-yIqQCCNjQakTZMwNLS-_IoGQOf9V1ejBJopkTUhgj7ymC8ynxedV7kv1me";
        String fcmKey="AAAAfqzvFIQ:APA91bGV6gPAklAk_g9SKuZ3RPt02V7u6kSOOUefY4f-0fI534xR7Zc69kcd0FmdI-1nx84soZCwMB38yF6WaNFVRrqdPSsn7nwN1U0H2Y4Z9n5NLBCZOaXsQ8uqH7D-99mncXFfoXlr";
        for (NotificationPush notificationPush : notificationPushs) {
            logger.info("start processing " + notificationPush);
            try {
                // concurrently
                Thread t = new Thread() { 
                    public void run() {
                    //	System.out.println("threaddd ");
                        Content content = new Content();
                        if(notificationPush.getApnUrl() != null) {
                            content.setTo(notificationPush.getApnUrl());
                            content.setLink(notificationPush.getLink());
                            content.createContent("bima notification", notificationPush.getPushMessage(), notificationPush.getApnPayload(), notificationPush.getLink(), notificationPush.getIcon(), notificationPush.getTopBanner());
                        }
                        if(notificationPush.getGcmUrl() != null) {
                            content.setTo(notificationPush.getGcmUrl());
                            content.setLink(notificationPush.getLink());
                            content.createContent("bima notification", notificationPush.getPushMessage(), notificationPush.getGcmPayload(), notificationPush.getLink(), notificationPush.getIcon(), notificationPush.getTopBanner());
                        }
                        else {
                        	 content.setTo(notificationPush.getGcmUrl());
                             content.setLink(notificationPush.getLink());
                             content.createContent("bima notification", notificationPush.getPushMessage(), notificationPush.getGcmPayload(), notificationPush.getLink(), notificationPush.getIcon(), notificationPush.getTopBanner());
                        }
                        

                        try {
                        	
                        	
                        	/**
                        	 * changes by rajat 
                        	 * 
                        	 * 
                        	 * 
                        	 */
                        	MultiDeviceFcmResponse multiDeviceFcmResponse=	notificationService.sendAndroidNotification(notificationPush.getApnUrl(),content, endPoint,fcmKey,notificationPush );
                        	System.out.println("response "+multiDeviceFcmResponse.getSuccess()+" falile"+ multiDeviceFcmResponse.getFailure()+"  id "+multiDeviceFcmResponse.getMulticast_id());
                        	
                        	/*
                        	
                        	*/
                        	/**
                        	 * 
                        	 */
                        	/*
                        	
                            // 0. set proxy first
                            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.103.30.17", 8080));
                            
                            // 1. URL
                            URL url = new URL("https://fcm.googleapis.com/fcm/send");

                            // 2. Open connection
                            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection(proxy);

                            // 3. Specify POST method
                            httpUrlConnection.setRequestMethod("POST");

                            // 4. Set the headers
                            httpUrlConnection.setRequestProperty("Content-Type", "application/json");
                            httpUrlConnection.setRequestProperty("Authorization", "key=".concat(fcmKey));
                            httpUrlConnection.setDoOutput(true);

                            // 5.1 Use Jackson object mapper to convert Content object into JSON
                            ObjectMapper objectMapper = new ObjectMapper();

                            // 5.2 Get connection output stream
                            DataOutputStream dataOutputStream = new DataOutputStream(httpUrlConnection.getOutputStream());

                            // 5.3 Copy Content "JSON"
                            objectMapper.writeValue(dataOutputStream, content);

                            // 5.4 Send the request
                            dataOutputStream.flush();

                            // 5.5 close
                            dataOutputStream.close();

                            // 6. Get the response
                            BufferedReader bufferedReader = null;
                            if(httpUrlConnection.getResponseCode() == 200)
                                bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
                            else
                                bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getErrorStream()));
                            
                            StringBuffer response = new StringBuffer();

                            String inputLine;
                            while ((inputLine = bufferedReader.readLine()) != null) {
                                response.append(inputLine);
                            }
                            bufferedReader.close();

                            // 7. Print result
                            notificationPush.setPushMessage(response.toString());
                            */
                            // 8. add sent uuid to be deleted
                            notificationUUIDs.add(notificationPush.getUuid());
                            
                            logger.info("firing " + content);
                            logger.info("done processing " + notificationPush);
                        } catch (Exception e) {
                            logger.error("error processing " + notificationPush, e);
                        }
                    }
                }; 
                executor.execute(t);
            } catch (Exception e) {
            	e.printStackTrace();
                logger.error("error processing " + notificationPush, e);
            }
        }
        executor.shutdown();
        while(!executor.isTerminated()) {
        }
        logger.info("done grabbing " + notificationUUIDs.size()+" notification");
        
        //clear all
     
      notificationService.clearSuccessfulNotifications(notificationUUIDs);
      notificationService.clearEmptyNotifications();
    }

    @Override
    public void run() {
        fire();
    }
}
