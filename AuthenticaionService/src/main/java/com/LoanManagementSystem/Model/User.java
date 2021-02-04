package com.LoanManagementSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="id")
	private Integer mobileNumber;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer mobileNumber, String password, String role) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [mobileNumber=" + mobileNumber + ", password=" + password + ", role=" + role + "]";
	}	
}
