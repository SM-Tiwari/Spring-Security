package com.gnv.d3.fcm.scheduler.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class NotificationPush implements Serializable {
    private String uuid;

    private String pushMessage;

    private String gcmUrl;

    private String apnUrl;

    private String apnPayload;

    private String gcmPayload;

    private BigDecimal isSend;
    
    private String link;

    private String icon;

    private String topBanner;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(String pushMessage) {
        this.pushMessage = pushMessage;
    }

    public String getGcmUrl() {
        return gcmUrl;
    }

    public void setGcmUrl(String gcmUrl) {
        this.gcmUrl = gcmUrl;
    }

    public String getApnUrl() {
        return apnUrl;
    }

    public void setApnUrl(String apnUrl) {
        this.apnUrl = apnUrl;
    }

    public String getApnPayload() {
        return apnPayload;
    }

    public void setApnPayload(String apnPayload) {
        this.apnPayload = apnPayload;
    }

    public String getGcmPayload() {
        return gcmPayload;
    }

    public void setGcmPayload(String gcmPayload) {
        this.gcmPayload = gcmPayload;
    }

    public BigDecimal getIsSend() {
        return isSend;
    }

    public void setIsSend(BigDecimal isSend) {
        this.isSend = isSend;
    }

    //added by Arya
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTopBanner() {
        return topBanner;
    }

    public void setTopBanner(String topBanner) {
        this.topBanner = topBanner;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        NotificationPush other = (NotificationPush) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getPushMessage() == null ? other.getPushMessage() == null : this.getPushMessage().equals(other.getPushMessage()))
            && (this.getGcmUrl() == null ? other.getGcmUrl() == null : this.getGcmUrl().equals(other.getGcmUrl()))
            && (this.getApnUrl() == null ? other.getApnUrl() == null : this.getApnUrl().equals(other.getApnUrl()))
            && (this.getApnPayload() == null ? other.getApnPayload() == null : this.getApnPayload().equals(other.getApnPayload()))
            && (this.getGcmPayload() == null ? other.getGcmPayload() == null : this.getGcmPayload().equals(other.getGcmPayload()))
            && (this.getIsSend() == null ? other.getIsSend() == null : this.getIsSend().equals(other.getIsSend()))
                //added by Arya
            && (this.getIcon()==null ? other.getIcon()==null : this.getIcon().equals(other.getIcon()))
            && (this.getTopBanner()==null ? other.getTopBanner()==null : this.getTopBanner().equals(other.getTopBanner()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getPushMessage() == null) ? 0 : getPushMessage().hashCode());
        result = prime * result + ((getGcmUrl() == null) ? 0 : getGcmUrl().hashCode());
        result = prime * result + ((getApnUrl() == null) ? 0 : getApnUrl().hashCode());
        result = prime * result + ((getApnPayload() == null) ? 0 : getApnPayload().hashCode());
        result = prime * result + ((getGcmPayload() == null) ? 0 : getGcmPayload().hashCode());
        result = prime * result + ((getIsSend() == null) ? 0 : getIsSend().hashCode());
        //added by Arya
        result = prime * result + ((getIcon()==null)? 0 : getIcon().hashCode());
        result = prime * result +((getTopBanner()==null ?0 : getTopBanner().hashCode()));
        return result;
    }

    @Override
    public String toString() {
        return "NotificationPush{" + "uuid=" + uuid + ", pushMessage=" + pushMessage + ", gcmUrl=" + gcmUrl + ", apnUrl=" + apnUrl + ", apnPayload=" + apnPayload + ", gcmPayload=" + gcmPayload + ", isSend=" + isSend + ", link=" + link + ", Icon="+icon+", top banner="+topBanner+'}';
    }
}