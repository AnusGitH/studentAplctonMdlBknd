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
@Table(name="contact_details")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class ContactDetails {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
    @Column(name="app_id")
    private String appId;
	private String  husNo;
	private String strtNo;
	private String lclty;
	private String wrdNo;
	private String dstrct;
	private String cty;
	private String pin;
	private String stat;
	private long mblNo;
	private long tlNo;
	
	public ContactDetails() {}

	public ContactDetails(long id, String appId, String husNo, String strtNo, String lclty, String wrdNo, String dstrct,
			String cty, String pin, String stat, long mblNo, long tlNo) {
		super();
		this.id = id;
		this.appId = appId;
		this.husNo = husNo;
		this.strtNo = strtNo;
		this.lclty = lclty;
		this.wrdNo = wrdNo;
		this.dstrct = dstrct;
		this.cty = cty;
		this.pin = pin;
		this.stat = stat;
		this.mblNo = mblNo;
		this.tlNo = tlNo;
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

	public String getHusNo() {
		return husNo;
	}

	public void setHusNo(String husNo) {
		this.husNo = husNo;
	}

	public String getStrtNo() {
		return strtNo;
	}

	public void setStrtNo(String strtNo) {
		this.strtNo = strtNo;
	}

	public String getLclty() {
		return lclty;
	}

	public void setLclty(String lclty) {
		this.lclty = lclty;
	}

	public String getWrdNo() {
		return wrdNo;
	}

	public void setWrdNo(String wrdNo) {
		this.wrdNo = wrdNo;
	}

	public String getDstrct() {
		return dstrct;
	}

	public void setDstrct(String dstrct) {
		this.dstrct = dstrct;
	}

	public String getCty() {
		return cty;
	}

	public void setCty(String cty) {
		this.cty = cty;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public long getMblNo() {
		return mblNo;
	}

	public void setMblNo(long mblNo) {
		this.mblNo = mblNo;
	}

	public long getTlNo() {
		return tlNo;
	}

	public void setTlNo(long tlNo) {
		this.tlNo = tlNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appId, cty, dstrct, husNo, id, lclty, mblNo, pin, stat, strtNo, tlNo, wrdNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactDetails other = (ContactDetails) obj;
		return Objects.equals(appId, other.appId) && Objects.equals(cty, other.cty)
				&& Objects.equals(dstrct, other.dstrct) && Objects.equals(husNo, other.husNo) && id == other.id
				&& Objects.equals(lclty, other.lclty) && mblNo == other.mblNo && Objects.equals(pin, other.pin)
				&& Objects.equals(stat, other.stat) && Objects.equals(strtNo, other.strtNo) && tlNo == other.tlNo
				&& Objects.equals(wrdNo, other.wrdNo);
	}
}