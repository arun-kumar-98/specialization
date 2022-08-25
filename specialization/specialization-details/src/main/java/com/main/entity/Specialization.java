package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialization_tab")
public class Specialization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer specId;

	@Column(length = 10, nullable = false, unique = true)
	private String specCode;
	@Column(length = 25, nullable = false, unique = true)
	private String specName;
	@Column(length = 250, nullable = false)
	private String specNote;

	public Specialization() {
		super();
	}

	public Specialization(Integer specId, String specCode, String specName, String specNote) {
		super();
		this.specId = specId;
		this.specCode = specCode;
		this.specName = specName;
		this.specNote = specNote;
	}

	public Integer getSpecId() {
		return specId;
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}

	public String getSpecCode() {
		return specCode;
	}

	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSpecNote() {
		return specNote;
	}

	public void setSpecNote(String specNote) {
		this.specNote = specNote;
	}

}
