package com.dev.crossover.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

	@Id
	@Column(name = "C_CODE")
	private String code;
	@Column(name = "C_NAME")
	private String name;
	@Column(name = "C_ADDRESS")
	private String address;
	@Column(name = "C_PHONE1")
	private String phone1;
	@Column(name = "C_PHONE2")
	private String phone2;
	@Column(name = "C_CREDITLIMIT")
	private String creditLimit;
	@Column(name = "C_CURRENTLIMIT")
	private String currentLimit;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCurrentLimit() {
		return currentLimit;
	}

	public void setCurrentLimit(String currentLimit) {
		this.currentLimit = currentLimit;
	}

}
