package com.gnv.d3.fcm.scheduler.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NotificationPushExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotificationPushExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andPushMessageIsNull() {
            addCriterion("PUSH_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andPushMessageIsNotNull() {
            addCriterion("PUSH_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andPushMessageEqualTo(String value) {
            addCriterion("PUSH_MESSAGE =", value, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageNotEqualTo(String value) {
            addCriterion("PUSH_MESSAGE <>", value, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageGreaterThan(String value) {
            addCriterion("PUSH_MESSAGE >", value, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageGreaterThanOrEqualTo(String value) {
            addCriterion("PUSH_MESSAGE >=", value, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageLessThan(String value) {
            addCriterion("PUSH_MESSAGE <", value, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageLessThanOrEqualTo(String value) {
            addCriterion("PUSH_MESSAGE <=", value, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageLike(String value) {
            addCriterion("PUSH_MESSAGE like", value, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageNotLike(String value) {
            addCriterion("PUSH_MESSAGE not like", value, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageIn(List<String> values) {
            addCriterion("PUSH_MESSAGE in", values, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageNotIn(List<String> values) {
            addCriterion("PUSH_MESSAGE not in", values, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageBetween(String value1, String value2) {
            addCriterion("PUSH_MESSAGE between", value1, value2, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andPushMessageNotBetween(String value1, String value2) {
            addCriterion("PUSH_MESSAGE not between", value1, value2, "pushMessage");
            return (Criteria) this;
        }

        public Criteria andGcmUrlIsNull() {
            addCriterion("GCM_URL is null");
            return (Criteria) this;
        }

        public Criteria andGcmUrlIsNotNull() {
            addCriterion("GCM_URL is not null");
            return (Criteria) this;
        }

        public Criteria andGcmUrlEqualTo(String value) {
            addCriterion("GCM_URL =", value, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlNotEqualTo(String value) {
            addCriterion("GCM_URL <>", value, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlGreaterThan(String value) {
            addCriterion("GCM_URL >", value, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlGreaterThanOrEqualTo(String value) {
            addCriterion("GCM_URL >=", value, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlLessThan(String value) {
            addCriterion("GCM_URL <", value, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlLessThanOrEqualTo(String value) {
            addCriterion("GCM_URL <=", value, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlLike(String value) {
            addCriterion("GCM_URL like", value, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlNotLike(String value) {
            addCriterion("GCM_URL not like", value, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlIn(List<String> values) {
            addCriterion("GCM_URL in", values, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlNotIn(List<String> values) {
            addCriterion("GCM_URL not in", values, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlBetween(String value1, String value2) {
            addCriterion("GCM_URL between", value1, value2, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andGcmUrlNotBetween(String value1, String value2) {
            addCriterion("GCM_URL not between", value1, value2, "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlIsNull() {
            addCriterion("APN_URL is null");
            return (Criteria) this;
        }

        public Criteria andApnUrlIsNotNull() {
            addCriterion("APN_URL is not null");
            return (Criteria) this;
        }

        public Criteria andApnUrlEqualTo(String value) {
            addCriterion("APN_URL =", value, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlNotEqualTo(String value) {
            addCriterion("APN_URL <>", value, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlGreaterThan(String value) {
            addCriterion("APN_URL >", value, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("APN_URL >=", value, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlLessThan(String value) {
            addCriterion("APN_URL <", value, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlLessThanOrEqualTo(String value) {
            addCriterion("APN_URL <=", value, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlLike(String value) {
            addCriterion("APN_URL like", value, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlNotLike(String value) {
            addCriterion("APN_URL not like", value, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlIn(List<String> values) {
            addCriterion("APN_URL in", values, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlNotIn(List<String> values) {
            addCriterion("APN_URL not in", values, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlBetween(String value1, String value2) {
            addCriterion("APN_URL between", value1, value2, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlNotBetween(String value1, String value2) {
            addCriterion("APN_URL not between", value1, value2, "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnPayloadIsNull() {
            addCriterion("APN_PAYLOAD is null");
            return (Criteria) this;
        }

        public Criteria andApnPayloadIsNotNull() {
            addCriterion("APN_PAYLOAD is not null");
            return (Criteria) this;
        }

        public Criteria andApnPayloadEqualTo(String value) {
            addCriterion("APN_PAYLOAD =", value, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadNotEqualTo(String value) {
            addCriterion("APN_PAYLOAD <>", value, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadGreaterThan(String value) {
            addCriterion("APN_PAYLOAD >", value, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadGreaterThanOrEqualTo(String value) {
            addCriterion("APN_PAYLOAD >=", value, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadLessThan(String value) {
            addCriterion("APN_PAYLOAD <", value, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadLessThanOrEqualTo(String value) {
            addCriterion("APN_PAYLOAD <=", value, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadLike(String value) {
            addCriterion("APN_PAYLOAD like", value, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadNotLike(String value) {
            addCriterion("APN_PAYLOAD not like", value, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadIn(List<String> values) {
            addCriterion("APN_PAYLOAD in", values, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadNotIn(List<String> values) {
            addCriterion("APN_PAYLOAD not in", values, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadBetween(String value1, String value2) {
            addCriterion("APN_PAYLOAD between", value1, value2, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andApnPayloadNotBetween(String value1, String value2) {
            addCriterion("APN_PAYLOAD not between", value1, value2, "apnPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadIsNull() {
            addCriterion("GCM_PAYLOAD is null");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadIsNotNull() {
            addCriterion("GCM_PAYLOAD is not null");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadEqualTo(String value) {
            addCriterion("GCM_PAYLOAD =", value, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadNotEqualTo(String value) {
            addCriterion("GCM_PAYLOAD <>", value, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadGreaterThan(String value) {
            addCriterion("GCM_PAYLOAD >", value, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadGreaterThanOrEqualTo(String value) {
            addCriterion("GCM_PAYLOAD >=", value, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadLessThan(String value) {
            addCriterion("GCM_PAYLOAD <", value, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadLessThanOrEqualTo(String value) {
            addCriterion("GCM_PAYLOAD <=", value, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadLike(String value) {
            addCriterion("GCM_PAYLOAD like", value, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadNotLike(String value) {
            addCriterion("GCM_PAYLOAD not like", value, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadIn(List<String> values) {
            addCriterion("GCM_PAYLOAD in", values, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadNotIn(List<String> values) {
            addCriterion("GCM_PAYLOAD not in", values, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadBetween(String value1, String value2) {
            addCriterion("GCM_PAYLOAD between", value1, value2, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadNotBetween(String value1, String value2) {
            addCriterion("GCM_PAYLOAD not between", value1, value2, "gcmPayload");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNull() {
            addCriterion("IS_SEND is null");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNotNull() {
            addCriterion("IS_SEND is not null");
            return (Criteria) this;
        }

        public Criteria andIsSendEqualTo(BigDecimal value) {
            addCriterion("IS_SEND =", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotEqualTo(BigDecimal value) {
            addCriterion("IS_SEND <>", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThan(BigDecimal value) {
            addCriterion("IS_SEND >", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_SEND >=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThan(BigDecimal value) {
            addCriterion("IS_SEND <", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_SEND <=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendIn(List<BigDecimal> values) {
            addCriterion("IS_SEND in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotIn(List<BigDecimal> values) {
            addCriterion("IS_SEND not in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_SEND between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_SEND not between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andUuidLikeInsensitive(String value) {
            addCriterion("upper(UUID) like", value.toUpperCase(), "uuid");
            return (Criteria) this;
        }

        public Criteria andPushMessageLikeInsensitive(String value) {
            addCriterion("upper(PUSH_MESSAGE) like", value.toUpperCase(), "pushMessage");
            return (Criteria) this;
        }

        public Criteria andGcmUrlLikeInsensitive(String value) {
            addCriterion("upper(GCM_URL) like", value.toUpperCase(), "gcmUrl");
            return (Criteria) this;
        }

        public Criteria andApnUrlLikeInsensitive(String value) {
            addCriterion("upper(APN_URL) like", value.toUpperCase(), "apnUrl");
            return (Criteria) this;
        }

        public Criteria andApnPayloadLikeInsensitive(String value) {
            addCriterion("upper(APN_PAYLOAD) like", value.toUpperCase(), "apnPayload");
            return (Criteria) this;
        }

        public Criteria andGcmPayloadLikeInsensitive(String value) {
            addCriterion("upper(GCM_PAYLOAD) like", value.toUpperCase(), "gcmPayload");
            return (Criteria) this;
        }
        
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}