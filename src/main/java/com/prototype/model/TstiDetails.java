package com.prototype.model;

import java.util.Arrays;
import java.util.Objects;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class TstiDetails {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	@Column(name="degree")
	private String degree;
	@Transient
	private String mrkstStd;
	@Column(name="mrkst_pic_byte",length=50000)
	private byte[] mrkst_pic_byte;
	@Column(name="passyear")
	private Integer passyear;
	@Transient
	private String crtftStd;
	@Column(name="crtft_pic_byte",length=10000)
	private byte[] crtft_pic_byte;
	
	@ManyToOne
	@JsonIgnore
	private UploadDetails uploadDetails;

	public TstiDetails() {}

	public TstiDetails(long id, String degree, String mrkstStd, byte[] mrkst_pic_byte, Integer passyear,
			String crtftStd, byte[] crtft_pic_byte, UploadDetails uploadDetails) {
		super();
		this.id = id;
		this.degree = degree;
		this.mrkstStd = mrkstStd;
		this.mrkst_pic_byte = mrkst_pic_byte;
		this.passyear = passyear;
		this.crtftStd = crtftStd;
		this.crtft_pic_byte = crtft_pic_byte;
		this.uploadDetails = uploadDetails;
	}
	
	public TstiDetails(String degree, byte[] mrkst_pic_byte, Integer passyear, byte[] crtft_pic_byte) {
		super();
		this.degree = degree;
		this.mrkst_pic_byte = mrkst_pic_byte;
		this.passyear = passyear;
		this.crtft_pic_byte = crtft_pic_byte;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMrkstStd() {
		return mrkstStd;
	}

	public void setMrkstStd(String mrkstStd) {
		this.mrkstStd = mrkstStd;
	}

	public byte[] getMrkst_pic_byte() {
		return mrkst_pic_byte;
	}

	public void setMrkst_pic_byte(byte[] mrkst_pic_byte) {
		this.mrkst_pic_byte = mrkst_pic_byte;
	}
	
	public Integer getPassyear() {
		return passyear;
	}

	public void setPassyear(Integer passyear) {
		this.passyear = passyear;
	}

	public String getCrtftStd() {
		return crtftStd;
	}

	public void setCrtftStd(String crtftStd) {
		this.crtftStd = crtftStd;
	}

	public byte[] getCrtft_pic_byte() {
		return crtft_pic_byte;
	}

	public void setCrtft_pic_byte(byte[] crtft_pic_byte) {
		this.crtft_pic_byte = crtft_pic_byte;
	}

	public UploadDetails getUploadDetails() {
		return uploadDetails;
	}

	public void setUploadDetails(UploadDetails uploadDetails) {
		this.uploadDetails = uploadDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(crtft_pic_byte);
		result = prime * result + Arrays.hashCode(mrkst_pic_byte);
		result = prime * result + Objects.hash(crtftStd, degree, id, mrkstStd, passyear, uploadDetails);
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
		TstiDetails other = (TstiDetails) obj;
		return Objects.equals(crtftStd, other.crtftStd) && Arrays.equals(crtft_pic_byte, other.crtft_pic_byte)
				&& Objects.equals(degree, other.degree) && id == other.id && Objects.equals(mrkstStd, other.mrkstStd)
				&& Arrays.equals(mrkst_pic_byte, other.mrkst_pic_byte) && Objects.equals(passyear, other.passyear)
				&& Objects.equals(uploadDetails, other.uploadDetails);
	}
}