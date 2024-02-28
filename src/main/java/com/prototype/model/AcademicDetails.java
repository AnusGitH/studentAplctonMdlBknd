package com.prototype.model;

import java.util.Objects;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="academic_details")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class AcademicDetails {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;
	private String  degree;
	private String inst;
	private Integer passyear;
	private Double percentage; 
	@ManyToOne
	@JsonIgnore
	private Enlist enlst;
		
	public AcademicDetails() {}

	public AcademicDetails(long id, String degree, String inst, Integer passyear, Double percentage, Enlist enlst) {
		super();
		this.id = id;
		this.degree = degree;
		this.inst = inst;
		this.passyear = passyear;
		this.percentage = percentage;
		this.enlst = enlst;
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

	public String getInst() {
		return inst;
	}

	public void setInst(String inst) {
		this.inst = inst;
	}

	public Integer getPassyear() {
		return passyear;
	}

	public void setPassyear(Integer passyear) {
		this.passyear = passyear;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Enlist getEnlst() {
		return enlst;
	}

	public void setEnlst(Enlist enlst) {
		this.enlst = enlst;
	}

	@Override
	public int hashCode() {
		return Objects.hash(degree, enlst, id, inst, passyear, percentage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademicDetails other = (AcademicDetails) obj;
		return Objects.equals(degree, other.degree) && Objects.equals(enlst, other.enlst) && id == other.id
				&& Objects.equals(inst, other.inst) && Objects.equals(passyear, other.passyear)
				&& Objects.equals(percentage, other.percentage);
	}
}