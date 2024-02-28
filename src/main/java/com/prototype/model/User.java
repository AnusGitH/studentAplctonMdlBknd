package com.prototype.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	@Id
	@Column(name="app_id")
	private String appId;
	protected String username;
	protected String password;
		
	@OneToOne
	private Enlist enlst;
	
	@OneToOne
    protected PersonalDetails personalDetails;
	
	@OneToOne
    protected ContactDetails contactDetails;	

	public User() {}

	public User(String appId, String username, String password, Enlist enlst, PersonalDetails personalDetails,
			ContactDetails contactDetails) {
		super();
		this.appId = appId;
		this.username = username;
		this.password = password;
		this.enlst = enlst;
		this.personalDetails = personalDetails;
		this.contactDetails = contactDetails;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Enlist getEnlst() {
		return enlst;
	}

	public void setEnlst(Enlist enlst) {
		this.enlst = enlst;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appId, contactDetails, enlst, password, personalDetails, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(appId, other.appId) && Objects.equals(contactDetails, other.contactDetails)
				&& Objects.equals(enlst, other.enlst) && Objects.equals(password, other.password)
				&& Objects.equals(personalDetails, other.personalDetails) && Objects.equals(username, other.username);
	}	
}