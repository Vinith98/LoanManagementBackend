package com.LoanManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "borrowerinformation")
public class BorrowerInformation {
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Id
	@Column(name = "mobilenumber")
	private Double mobileNumber;
	@Column(name = "addressline1")
	private String addressLine1;
	@Column(name = "addressline2")
	private String addressLine2;
	@Column(name = "city")
	private String city;
	@Column(name = "pincode")
	private Integer pincode;	

}