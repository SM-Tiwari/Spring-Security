package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gnv.vnm.selfcare.core.enums.SubscriberType;

public class Simname implements Serializable {

		private static final long serialVersionUID = -8435360960939624805L;

		private String msisdn;
		private String cos;
		private String classOfServiceName;
		private SubscriberType type;
		private List<String> disabledAppFeatures = new ArrayList<>();
		public Simname(){
			
		}
		
		public Simname(String msisdn, String cos, String classOfServiceName, SubscriberType type) {
			super();
			this.msisdn = msisdn;
			this.cos = cos;
			this.classOfServiceName = classOfServiceName;
			this.type = type;
		}
		
		public List<String> getDisabledAppFeatures() {
			return disabledAppFeatures;
		}

		public void setDisabledAppFeatures(List<String> disabledAppFeatures) {
			this.disabledAppFeatures = disabledAppFeatures;
		}

		public String getMsisdn() {
			return msisdn;
		}
		public void setMsisdn(String msisdn) {
			this.msisdn = msisdn;
		}
		public String getCos() {
			return cos;
		}
		public void setCos(String cos) {
			this.cos = cos;
		}
		public String getClassOfServiceName() {
			return classOfServiceName;
		}
		public void setClassOfServiceName(String classOfServiceName) {
			this.classOfServiceName = classOfServiceName;
		}
		public SubscriberType getType() {
			return type;
		}
		public void setType(SubscriberType type) {
			this.type = type;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((classOfServiceName == null) ? 0 : classOfServiceName.hashCode());
			result = prime * result + ((cos == null) ? 0 : cos.hashCode());
			result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Simname other = (Simname) obj;
			if (classOfServiceName == null) {
				if (other.classOfServiceName != null)
					return false;
			} else if (!classOfServiceName.equals(other.classOfServiceName))
				return false;
			if (cos == null) {
				if (other.cos != null)
					return false;
			} else if (!cos.equals(other.cos))
				return false;
			if (msisdn == null) {
				if (other.msisdn != null)
					return false;
			} else if (!msisdn.equals(other.msisdn))
				return false;
			if (type != other.type)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Simname [msisdn=" + msisdn + ", cos=" + cos + ", classOfServiceName=" + classOfServiceName
					+ ", type=" + type + "]";
		}
		
}