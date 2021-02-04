package com.LoanManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Entity
@Table(name = "loandetail")
public class LoanDetail {
	@Id
	@Column(name = "loanamount")
	private Integer loanAmount;
	@Column(name = "loantype")
	private String loanType;
	@Column(name = "loanterm")
	private Integer loanTerm;
	@Column(name = "loanimage")
	private String loanImage;
}