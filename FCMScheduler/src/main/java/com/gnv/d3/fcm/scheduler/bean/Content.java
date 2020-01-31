package com.gnv.d3.fcm.scheduler.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  com.gnv.d3.fcm.scheduler.bean.Content 
 * </pre>
 *
 *  {
        "to" : "ff7dwHxWZeE:APA91bFbzYFqFKUwYW...c_1TfunYKKYXcjiX5a",
        "data": {
             “body”: “OTT:fromId:toId:fromNumber:toNumber atau message biasa”,
              “title” : “title apa aja”,
              “link” : “link utk deeplink”,
              “icon” : “icon”,
              “topBanner” : “topBanner”,
              "content_available": true, <— tambahin ini ya
              "priority" : "high”, <— tambahin ini ya
        },
        "notification": { <— buat iphone
		 “body”: “lelelellee”,
		  “title” : “title apa aja”		  
	},
        "content_available": true, <— tambahin ini ya
        "priority" : "high”, <— tambahin ini ya
         “notification” : {}<— yang ini ilangin
      }
 * 
 * @author edwin < edwinkun at gmail dot com >
 * May 9, 2017 1:26:33 PM
 *
 */
public class Content {

    @JsonProperty("to")
    private String to;

    @JsonProperty("link")
    private String link;

    @JsonProperty("data")
    private Map<String, String> data;

    @JsonProperty("notification")
    private Map<String, String> notification;

    @JsonProperty("content_available")
    private Boolean contentAvailable;

    @JsonProperty("priority")
    private String priority;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    /**
     * 
     * @param title
     * @param message 
     * @param link 
     * @param icon 
     * @param topBanner 
     */
    public void createContent(String title, String subtitle, String message, String link, String icon, String topBanner) {
        if (data == null) {
            data = new HashMap<>();
        }
        if (notification == null) {
            notification = new HashMap<>();
        }

        data.put("title", title);
        data.put("subtitle", subtitle);
        data.put("body", message);
        data.put("link", link);
        data.put("icon", icon);
        data.put("topBanner", topBanner);
        
        notification.put("title", title);
        notification.put("body", message);
        
        contentAvailable = Boolean.TRUE;
        priority = "high";
    }

    @Override
    public String toString() {
        return "Content{" + "to=" + to + ", link=" + link + ", data=" + data + '}';
    }

    public Boolean getContentAvailable() {
        return contentAvailable;
    }

    public void setContentAvailable(Boolean contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}