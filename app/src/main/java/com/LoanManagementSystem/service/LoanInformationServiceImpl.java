package com.LoanManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoanManagementSystem.Exception.LoanInformationNotFoundException;
import com.LoanManagementSystem.model.LoanDetail;
import com.LoanManagementSystem.model.LoanInformation;
import com.LoanManagementSystem.repository.LoanDetailRepository;
import com.LoanManagementSystem.repository.LoanInformationRepository;

@Service
public class LoanInformationServiceImpl implements LoanInformationService{

	@Autowired
	private LoanInformationRepository loanInformationRepository;
    
	@Autowired
	private LoanDetailRepository loanDetailRepository;
	
	
	public List<LoanInformation> getAllLoanInformations() {
		return this.loanInformationRepository.findAll();
	}
	public LoanInformation addNewLoan(LoanInformation loanInformation) {
     LoanInformation addedLoan = this.loanInformationRepository.save(loanInformation);
     return addedLoan;
	}

	public LoanInformation editLoan(LoanInformation loanInformation) {
		LoanInformation editedLoan =  this.loanInformationRepository.save(loanInformation);
		return editedLoan;
	}

	public List<LoanDetail> getLoanDetails() {
		return this.loanDetailRepository.findAll();
	}
	@Override
	public LoanInformation getLoanByNumber(int loanNumber) throws LoanInformationNotFoundException {
	   LoanInformation loanInformation = loanInformationRepository.findByLoanNumber(loanNumber);
	  if(loanInformation == null){
		  throw new LoanInformationNotFoundException();
	  }
	  else
		  return loanInformation;
	}
	
}
