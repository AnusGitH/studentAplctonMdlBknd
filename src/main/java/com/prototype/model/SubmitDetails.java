package com.prototype.model;

import java.util.Objects;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class SubmitDetails {
	
	@Id
	@Column(name="app_id")
	private String appId;
	private String ackChk;
	private String chkAck;
	
	public SubmitDetails() {}

	public SubmitDetails(String appId, String ackChk, String chkAck) {
		super();
		this.appId = appId;
		this.ackChk = ackChk;
		this.chkAck = chkAck;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAckChk() {
		return ackChk;
	}

	public void setAckChk(String ackChk) {
		this.ackChk = ackChk;
	}

	public String getChkAck() {
		return chkAck;
	}

	public void setChkAck(String chkAck) {
		this.chkAck = chkAck;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ackChk, appId, chkAck);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubmitDetails other = (SubmitDetails) obj;
		return Objects.equals(ackChk, other.ackChk) && Objects.equals(appId, other.appId)
				&& Objects.equals(chkAck, other.chkAck);
	}
	
//	@Id
//	@Column(name="app_id")
//	private String appId;
//	protected String emailId;
//	protected long phno;
//	private String mradio;
//	protected String discipline;
//	protected String subject;
//	private String  frstNm;
//	private String midNm;
//	private String surNm;
//	private String gurdNm;
//	private String dob;
//	private String gndr;
//	private String ctgry;
//	private String rlgn;
//	private boolean mrtlStus;
//	private boolean dfrtAbld;
//	private String  husNo;
//	private String strtNo;
//	private String lclty;
//	private String wrdNo;
//	private String dstrct;
//	private String cty;
//	private String pin;
//	private String stat;
//	private long mblNo;
//	private long tlNo;
//	@Column(name="img_pic_byte",length=50000)
//	private byte[] img_pic_byte;
//	@Column(name="sig_pic_byte",length=10000)
//	private byte[] sig_pic_byte;
//	
//	public SubmitDetails() {
//		super();
//	}
//
//	public SubmitDetails(String appId, String emailId, long phno, String mradio, String discipline, String subject,
//			String frstNm, String midNm, String surNm, String gurdNm, String dob, String gndr, String ctgry,
//			String rlgn, boolean mrtlStus, boolean dfrtAbld, String husNo, String strtNo, String lclty, String wrdNo,
//			String dstrct, String cty, String pin, String stat, long mblNo, long tlNo, byte[] img_pic_byte,
//			byte[] sig_pic_byte) {
//		super();
//		this.appId = appId;
//		this.emailId = emailId;
//		this.phno = phno;
//		this.mradio = mradio;
//		this.discipline = discipline;
//		this.subject = subject;
//		this.frstNm = frstNm;
//		this.midNm = midNm;
//		this.surNm = surNm;
//		this.gurdNm = gurdNm;
//		this.dob = dob;
//		this.gndr = gndr;
//		this.ctgry = ctgry;
//		this.rlgn = rlgn;
//		this.mrtlStus = mrtlStus;
//		this.dfrtAbld = dfrtAbld;
//		this.husNo = husNo;
//		this.strtNo = strtNo;
//		this.lclty = lclty;
//		this.wrdNo = wrdNo;
//		this.dstrct = dstrct;
//		this.cty = cty;
//		this.pin = pin;
//		this.stat = stat;
//		this.mblNo = mblNo;
//		this.tlNo = tlNo;
//		this.img_pic_byte = img_pic_byte;
//		this.sig_pic_byte = sig_pic_byte;
//	}
//
//	public String getAppId() {
//		return appId;
//	}
//
//	public void setAppId(String appId) {
//		this.appId = appId;
//	}
//
//	public String getEmailId() {
//		return emailId;
//	}
//
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}
//
//	public long getPhno() {
//		return phno;
//	}
//
//	public void setPhno(long phno) {
//		this.phno = phno;
//	}
//
//	public String getMradio() {
//		return mradio;
//	}
//
//	public void setMradio(String mradio) {
//		this.mradio = mradio;
//	}
//
//	public String getDiscipline() {
//		return discipline;
//	}
//
//	public void setDiscipline(String discipline) {
//		this.discipline = discipline;
//	}
//
//	public String getSubject() {
//		return subject;
//	}
//
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//
//	public String getFrstNm() {
//		return frstNm;
//	}
//
//	public void setFrstNm(String frstNm) {
//		this.frstNm = frstNm;
//	}
//
//	public String getMidNm() {
//		return midNm;
//	}
//
//	public void setMidNm(String midNm) {
//		this.midNm = midNm;
//	}
//
//	public String getSurNm() {
//		return surNm;
//	}
//
//	public void setSurNm(String surNm) {
//		this.surNm = surNm;
//	}
//
//	public String getGurdNm() {
//		return gurdNm;
//	}
//
//	public void setGurdNm(String gurdNm) {
//		this.gurdNm = gurdNm;
//	}
//
//	public String getDob() {
//		return dob;
//	}
//
//	public void setDob(String dob) {
//		this.dob = dob;
//	}
//
//	public String getGndr() {
//		return gndr;
//	}
//
//	public void setGndr(String gndr) {
//		this.gndr = gndr;
//	}
//
//	public String getCtgry() {
//		return ctgry;
//	}
//
//	public void setCtgry(String ctgry) {
//		this.ctgry = ctgry;
//	}
//
//	public String getRlgn() {
//		return rlgn;
//	}
//
//	public void setRlgn(String rlgn) {
//		this.rlgn = rlgn;
//	}
//
//	public boolean isMrtlStus() {
//		return mrtlStus;
//	}
//
//	public void setMrtlStus(boolean mrtlStus) {
//		this.mrtlStus = mrtlStus;
//	}
//
//	public boolean isDfrtAbld() {
//		return dfrtAbld;
//	}
//
//	public void setDfrtAbld(boolean dfrtAbld) {
//		this.dfrtAbld = dfrtAbld;
//	}
//
//	public String getHusNo() {
//		return husNo;
//	}
//
//	public void setHusNo(String husNo) {
//		this.husNo = husNo;
//	}
//
//	public String getStrtNo() {
//		return strtNo;
//	}
//
//	public void setStrtNo(String strtNo) {
//		this.strtNo = strtNo;
//	}
//
//	public String getLclty() {
//		return lclty;
//	}
//
//	public void setLclty(String lclty) {
//		this.lclty = lclty;
//	}
//
//	public String getWrdNo() {
//		return wrdNo;
//	}
//
//	public void setWrdNo(String wrdNo) {
//		this.wrdNo = wrdNo;
//	}
//
//	public String getDstrct() {
//		return dstrct;
//	}
//
//	public void setDstrct(String dstrct) {
//		this.dstrct = dstrct;
//	}
//
//	public String getCty() {
//		return cty;
//	}
//
//	public void setCty(String cty) {
//		this.cty = cty;
//	}
//
//	public String getPin() {
//		return pin;
//	}
//
//	public void setPin(String pin) {
//		this.pin = pin;
//	}
//
//	public String getStat() {
//		return stat;
//	}
//
//	public void setStat(String stat) {
//		this.stat = stat;
//	}
//
//	public long getMblNo() {
//		return mblNo;
//	}
//
//	public void setMblNo(long mblNo) {
//		this.mblNo = mblNo;
//	}
//
//	public long getTlNo() {
//		return tlNo;
//	}
//
//	public void setTlNo(long tlNo) {
//		this.tlNo = tlNo;
//	}
//
//	public byte[] getImg_pic_byte() {
//		return img_pic_byte;
//	}
//
//	public void setImg_pic_byte(byte[] img_pic_byte) {
//		this.img_pic_byte = img_pic_byte;
//	}
//
//	public byte[] getSig_pic_byte() {
//		return sig_pic_byte;
//	}
//
//	public void setSig_pic_byte(byte[] sig_pic_byte) {
//		this.sig_pic_byte = sig_pic_byte;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + Arrays.hashCode(img_pic_byte);
//		result = prime * result + Arrays.hashCode(sig_pic_byte);
//		result = prime * result + Objects.hash(appId, ctgry, cty, dfrtAbld, discipline, dob, dstrct, emailId, frstNm,
//				gndr, gurdNm, husNo, lclty, mblNo, midNm, mradio, mrtlStus, phno, pin, rlgn, stat, strtNo, subject,
//				surNm, tlNo, wrdNo);
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		SubmitDetails other = (SubmitDetails) obj;
//		return Objects.equals(appId, other.appId) && Objects.equals(ctgry, other.ctgry)
//				&& Objects.equals(cty, other.cty) && dfrtAbld == other.dfrtAbld
//				&& Objects.equals(discipline, other.discipline) && Objects.equals(dob, other.dob)
//				&& Objects.equals(dstrct, other.dstrct) && Objects.equals(emailId, other.emailId)
//				&& Objects.equals(frstNm, other.frstNm) && Objects.equals(gndr, other.gndr)
//				&& Objects.equals(gurdNm, other.gurdNm) && Objects.equals(husNo, other.husNo)
//				&& Arrays.equals(img_pic_byte, other.img_pic_byte) && Objects.equals(lclty, other.lclty)
//				&& mblNo == other.mblNo && Objects.equals(midNm, other.midNm) && Objects.equals(mradio, other.mradio)
//				&& mrtlStus == other.mrtlStus && phno == other.phno && Objects.equals(pin, other.pin)
//				&& Objects.equals(rlgn, other.rlgn) && Arrays.equals(sig_pic_byte, other.sig_pic_byte)
//				&& Objects.equals(stat, other.stat) && Objects.equals(strtNo, other.strtNo)
//				&& Objects.equals(subject, other.subject) && Objects.equals(surNm, other.surNm) && tlNo == other.tlNo
//				&& Objects.equals(wrdNo, other.wrdNo);
//	}
//
//	@Override
//	public String toString() {
//		return "SubmitDetails [appId=" + appId + ", emailId=" + emailId + ", phno=" + phno + ", mradio=" + mradio
//				+ ", discipline=" + discipline + ", subject=" + subject + ", frstNm=" + frstNm + ", midNm=" + midNm
//				+ ", surNm=" + surNm + ", gurdNm=" + gurdNm + ", dob=" + dob + ", gndr=" + gndr + ", ctgry=" + ctgry
//				+ ", rlgn=" + rlgn + ", mrtlStus=" + mrtlStus + ", dfrtAbld=" + dfrtAbld + ", husNo=" + husNo
//				+ ", strtNo=" + strtNo + ", lclty=" + lclty + ", wrdNo=" + wrdNo + ", dstrct=" + dstrct + ", cty=" + cty
//				+ ", pin=" + pin + ", stat=" + stat + ", mblNo=" + mblNo + ", tlNo=" + tlNo + ", img_pic_byte="
//				+ Arrays.toString(img_pic_byte) + ", sig_pic_byte=" + Arrays.toString(sig_pic_byte) + "]";
//	}
}