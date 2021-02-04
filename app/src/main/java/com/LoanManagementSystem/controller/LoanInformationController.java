package com.LoanManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LoanManagementSystem.Exception.LoanInformationNotFoundException;
import com.LoanManagementSystem.model.LoanInformation;
import com.LoanManagementSystem.service.LoanInformationService;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping("/loan")
public class LoanInformationController {

	@Autowired
	private LoanInformationService loanInformationService;

	@GetMapping("/all")
	public List<LoanInformation> getAllLoanInformations() {
		return this.loanInformationService.getAllLoanInformations();
	}
	@GetMapping("/user/{loanNumber}")
	public LoanInformation getLoanInformation(@PathVariable int loanNumber) throws LoanInformationNotFoundException {
		return this.loanInformationService.getLoanByNumber(loanNumber);
	  
	}

	@PostMapping("/add")
	public ResponseEntity<LoanInformation> addNewLoan(@RequestBody LoanInformation loanInformation) {
		LoanInformation addedLoan = this.loanInformationService.addNewLoan(loanInformation);
		return new ResponseEntity<LoanInformation>(addedLoan,HttpStatus.CREATED);
	}

	@PutMapping("/edit")
	public ResponseEntity<LoanInformation> editLoan(@RequestBody LoanInformation loanInformation) {
		LoanInformation editedLoan = this.loanInformationService.editLoan(loanInformation);
		return new ResponseEntity<LoanInformation>(editedLoan,HttpStatus.OK);
	}

	@GetMapping("/loanDetail")
	public ResponseEntity<?> getLoanDetails() {
		return new ResponseEntity<>(this.loanInformationService.getLoanDetails(), HttpStatus.OK);
	}

}
