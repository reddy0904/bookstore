package com.example.BookStore.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_details")
public class Customer_details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String fullname;

	private String email;

	private String phoneno;

	private String password;

	private String gender;

	private boolean enabled;

	private String verificationCode;
	
	private String role="ROLE_USER";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Customer_details(String fullname, String email, String phoneno,
			String password, String gender, boolean enabled, String verificationCode,String role) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.gender = gender;
		this.setEnabled(enabled);
		this.verificationCode = verificationCode;
		this.role=role;
		
	}

	public Customer_details() {
		super();
		// TODO Auto-generated constructor stub
	}

}