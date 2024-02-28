package com.prototype.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class UploadDetails {
	@Id
	@Column(name="app_id")
	private String appId;
	@Column(name="img_name")
	private String img_name;
	@Column(name="img_type")
	private String img_type;
	@Column(name="img_pic_byte",length=50000)
	private byte[] img_pic_byte;
	@Column(name="sig_name")
	private String sig_name;
	@Column(name="sig_type")
	private String sig_type;
	@Column(name="sig_pic_byte",length=10000)
	private byte[] sig_pic_byte;
		
	@OneToMany(cascade=CascadeType.ALL, mappedBy="uploadDetails")
	@JsonIgnore
    protected List<TstiDetails> tstiDetails=new ArrayList<TstiDetails>();
	
	public UploadDetails() {}

	public UploadDetails(String appId, String img_name, String img_type, byte[] img_pic_byte, String sig_name,
			String sig_type, byte[] sig_pic_byte, List<TstiDetails> tstiDetails) {
		super();
		this.appId = appId;
		this.img_name = img_name;
		this.img_type = img_type;
		this.img_pic_byte = img_pic_byte;
		this.sig_name = sig_name;
		this.sig_type = sig_type;
		this.sig_pic_byte = sig_pic_byte;
		this.tstiDetails = tstiDetails;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getImg_type() {
		return img_type;
	}

	public void setImg_type(String img_type) {
		this.img_type = img_type;
	}

	public byte[] getImg_pic_byte() {
		return img_pic_byte;
	}

	public void setImg_pic_byte(byte[] img_pic_byte) {
		this.img_pic_byte = img_pic_byte;
	}

	public String getSig_name() {
		return sig_name;
	}

	public void setSig_name(String sig_name) {
		this.sig_name = sig_name;
	}

	public String getSig_type() {
		return sig_type;
	}

	public void setSig_type(String sig_type) {
		this.sig_type = sig_type;
	}

	public byte[] getSig_pic_byte() {
		return sig_pic_byte;
	}

	public void setSig_pic_byte(byte[] sig_pic_byte) {
		this.sig_pic_byte = sig_pic_byte;
	}

	public List<TstiDetails> getTstiDetails() {
		return tstiDetails;
	}

	public void setTstiDetails(List<TstiDetails> tstiDetails) {
		this.tstiDetails = tstiDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(img_pic_byte);
		result = prime * result + Arrays.hashCode(sig_pic_byte);
		result = prime * result + Objects.hash(appId, img_name, img_type, sig_name, sig_type, tstiDetails);
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
		UploadDetails other = (UploadDetails) obj;
		return Objects.equals(appId, other.appId) && Objects.equals(img_name, other.img_name)
				&& Arrays.equals(img_pic_byte, other.img_pic_byte) && Objects.equals(img_type, other.img_type)
				&& Objects.equals(sig_name, other.sig_name) && Arrays.equals(sig_pic_byte, other.sig_pic_byte)
				&& Objects.equals(sig_type, other.sig_type) && Objects.equals(tstiDetails, other.tstiDetails);
	}
}