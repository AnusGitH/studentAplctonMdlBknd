package com.prototype.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Enlist {
	
	    @GeneratedValue(strategy=GenerationType.AUTO)
		@Id
		private long id;
	    @Column(name="app_id")
	    private String appId;
		private String mradio;
		protected String discipline;
		protected String subject;
		
		@OneToOne
		private UploadDetails uploadDetails;
		
		@OneToMany(cascade=CascadeType.ALL,mappedBy="enlst")
		@JsonIgnore
	    protected List<AcademicDetails> academicDetails=new ArrayList<AcademicDetails>();
		
		public Enlist() {}

		public Enlist(long id, String appId, String mradio, String discipline, String subject,
		List<AcademicDetails> academicDetails) {
			super();
			this.id = id;
			this.appId = appId;
			this.mradio = mradio;
			this.discipline = discipline;
			this.subject = subject;
			this.academicDetails = academicDetails;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getMradio() {
			return mradio;
		}

		public void setMradio(String mradio) {
			this.mradio = mradio;
		}

		public String getDiscipline() {
			return discipline;
		}

		public void setDiscipline(String discipline) {
			this.discipline = discipline;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public List<AcademicDetails> getAcademicDetails() {
			return academicDetails;
		}

		public void setAcademicDetails(List<AcademicDetails> academicDetails) {
			this.academicDetails = academicDetails;
		}

		@Override
		public int hashCode() {
			return Objects.hash(academicDetails, appId, discipline, id, mradio, subject);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Enlist other = (Enlist) obj;
			return Objects.equals(academicDetails, other.academicDetails) && Objects.equals(appId, other.appId)
					&& Objects.equals(discipline, other.discipline) && id == other.id
					&& Objects.equals(mradio, other.mradio) && Objects.equals(subject, other.subject);
		}

		@Override
		public String toString() {
			return "Enlist [id=" + id + ", appId=" + appId + ", mradio=" + mradio + ", discipline=" + discipline
					+ ", subject=" + subject + ", academicDetails=" + academicDetails + "]";
		}
}
