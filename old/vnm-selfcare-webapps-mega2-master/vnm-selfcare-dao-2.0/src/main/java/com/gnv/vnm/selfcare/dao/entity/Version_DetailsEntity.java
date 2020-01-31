package com.gnv.vnm.selfcare.dao.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

    @Entity
	@Table(name = "version_details", uniqueConstraints = { @UniqueConstraint(columnNames = "ID")})
	@SequenceGenerator(name = "version_details_seq", sequenceName = "version_details_seq", allocationSize = 1)
	public class Version_DetailsEntity extends BaseEntity{
		
	 private static final long serialVersionUID = -754500817576213551L;

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "version_details_seq")
		@Column(name = "ID")
		private Integer Id;
		
		@Column(name = "msisdn")
		private String loginId;
		
		@Column(name = "app_version")
		private String app_version;
		@Column(name = "app_os")
		private String app_os;
		@Column(name = "app_os_version")
		private String app_os_version;
		@Column(name = "devic_name")
		private String devic_name;
		@Column(name = "devic_modeil")
		private String devic_modeil;
		@Column(name = "devic_id")
		private String devic_id;
		
		
		public Version_DetailsEntity() {
			 
		}

		public Version_DetailsEntity(Integer Id, String loginId, String app_version, String app_os, String app_os_version, String devic_name, String devic_modeil, String devic_id) {
			super();
		
			this.Id = Id;
			this.loginId = loginId;
			this.app_version = app_version;
			this.app_os = app_os;
			this.app_os_version = app_os_version;
			this.devic_name = devic_name;
			this.devic_modeil = devic_modeil;
			this.devic_id = devic_id;
		}

		public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}

		public String getApp_version() {
			return app_version;
		}

		public void setApp_version(String app_version) {
			this.app_version = app_version;
		}

		public String getApp_os() {
			return app_os;
		}

		public void setApp_os(String app_os) {
			this.app_os = app_os;
		}

		public String getApp_os_version() {
			return app_os_version;
		}

		public void setApp_os_version(String app_os_version) {
			this.app_os_version = app_os_version;
		}

		public String getDevic_name() {
			return devic_name;
		}

		public void setDevic_name(String devic_name) {
			this.devic_name = devic_name;
		}

		public String getDevic_modeil() {
			return devic_modeil;
		}

		public void setDevic_modeil(String devic_modeil) {
			this.devic_modeil = devic_modeil;
		}

		public String getDevic_id() {
			return devic_id;
		}

		public void setDevic_id(String devic_id) {
			this.devic_id = devic_id;
		}

		@Override
		public String toString() {
			return "Version_Details [Id=" + Id + ", loginId=" + loginId + ", app_version=" + app_version + ", app_os="
					+ app_os + ", app_os_version=" + app_os_version + ", devic_name=" + devic_name + ", devic_modeil="
					+ devic_modeil + ", devic_id=" + devic_id + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((Id == null) ? 0 : Id.hashCode());
			result = prime * result + ((app_os == null) ? 0 : app_os.hashCode());
			result = prime * result + ((app_os_version == null) ? 0 : app_os_version.hashCode());
			result = prime * result + ((app_version == null) ? 0 : app_version.hashCode());
			result = prime * result + ((devic_id == null) ? 0 : devic_id.hashCode());
			result = prime * result + ((devic_modeil == null) ? 0 : devic_modeil.hashCode());
			result = prime * result + ((devic_name == null) ? 0 : devic_name.hashCode());
			result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Version_DetailsEntity other = (Version_DetailsEntity) obj;
			if (Id == null) {
				if (other.Id != null)
					return false;
			} else if (!Id.equals(other.Id))
				return false;
			if (app_os == null) {
				if (other.app_os != null)
					return false;
			} else if (!app_os.equals(other.app_os))
				return false;
			if (app_os_version == null) {
				if (other.app_os_version != null)
					return false;
			} else if (!app_os_version.equals(other.app_os_version))
				return false;
			if (app_version == null) {
				if (other.app_version != null)
					return false;
			} else if (!app_version.equals(other.app_version))
				return false;
			if (devic_id == null) {
				if (other.devic_id != null)
					return false;
			} else if (!devic_id.equals(other.devic_id))
				return false;
			if (devic_modeil == null) {
				if (other.devic_modeil != null)
					return false;
			} else if (!devic_modeil.equals(other.devic_modeil))
				return false;
			if (devic_name == null) {
				if (other.devic_name != null)
					return false;
			} else if (!devic_name.equals(other.devic_name))
				return false;
			if (loginId == null) {
				if (other.loginId != null)
					return false;
			} else if (!loginId.equals(other.loginId))
				return false;
			return true;
		}
		
		
	}
