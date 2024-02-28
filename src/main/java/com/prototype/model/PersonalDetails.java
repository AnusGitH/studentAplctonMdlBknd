package com.prototype.model;

import java.util.Objects;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="personal_details")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class PersonalDetails {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
    @Column(name="app_id")
    private String appId;
	private String  frstNm;
	private String midNm;
	private String surNm;
	private String gurdNm;
	private String dob;
	private String gndr;
	private String ctgry;
	private String rlgn;
	private boolean mrtlStus;
	private boolean dfrtAbld;
	
	public PersonalDetails() {}

	public PersonalDetails(long id, String appId, String frstNm, String midNm, String surNm, String gurdNm, String dob,
			String gndr, String ctgry, String rlgn, boolean mrtlStus, boolean dfrtAbld) {
		super();
		this.id = id;
		this.appId = appId;
		this.frstNm = frstNm;
		this.midNm = midNm;
		this.surNm = surNm;
		this.gurdNm = gurdNm;
		this.dob = dob;
		this.gndr = gndr;
		this.ctgry = ctgry;
		this.rlgn = rlgn;
		this.mrtlStus = mrtlStus;
		this.dfrtAbld = dfrtAbld;
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

	public String getFrstNm() {
		return frstNm;
	}

	public void setFrstNm(String frstNm) {
		this.frstNm = frstNm;
	}

	public String getMidNm() {
		return midNm;
	}

	public void setMidNm(String midNm) {
		this.midNm = midNm;
	}

	public String getSurNm() {
		return surNm;
	}

	public void setSurNm(String surNm) {
		this.surNm = surNm;
	}

	public String getGurdNm() {
		return gurdNm;
	}

	public void setGurdNm(String gurdNm) {
		this.gurdNm = gurdNm;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGndr() {
		return gndr;
	}

	public void setGndr(String gndr) {
		this.gndr = gndr;
	}

	public String getCtgry() {
		return ctgry;
	}

	public void setCtgry(String ctgry) {
		this.ctgry = ctgry;
	}

	public String getRlgn() {
		return rlgn;
	}

	public void setRlgn(String rlgn) {
		this.rlgn = rlgn;
	}

	public boolean isMrtlStus() {
		return mrtlStus;
	}

	public void setMrtlStus(boolean mrtlStus) {
		this.mrtlStus = mrtlStus;
	}

	public boolean isDfrtAbld() {
		return dfrtAbld;
	}

	public void setDfrtAbld(boolean dfrtAbld) {
		this.dfrtAbld = dfrtAbld;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appId, ctgry, dfrtAbld, dob, frstNm, gndr, gurdNm, id, midNm, mrtlStus, rlgn, surNm);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalDetails other = (PersonalDetails) obj;
		return Objects.equals(appId, other.appId) && Objects.equals(ctgry, other.ctgry) && dfrtAbld == other.dfrtAbld
				&& Objects.equals(dob, other.dob) && Objects.equals(frstNm, other.frstNm)
				&& Objects.equals(gndr, other.gndr) && Objects.equals(gurdNm, other.gurdNm) && id == other.id
				&& Objects.equals(midNm, other.midNm) && mrtlStus == other.mrtlStus && Objects.equals(rlgn, other.rlgn)
				&& Objects.equals(surNm, other.surNm);
	}
}