package com.LoanManagementSystem.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "loaninformation")
@Entity
public class LoanInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loannumber")
	private Integer loanNumber;
	@Column(name = "loanamount")
	private Integer loanAmount;
	@Column(name = "loanterm")
	private Integer loanTerm;
	@Column(name = "loanmanagementfees")
	private Integer loanManagementFees;
	@Column(name = "originationaccount")
	private Integer originationAccount;
	@Column(name = "originationdate")
	private Date originationDate;
	@Column(name = "loantype")
	private String loanType;
	@Column(name = "loanstatus")
	private String loanStatus;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mobilenumber", referencedColumnName = "mobilenumber")
	private BorrowerInformation borrowerInformation;
	
}