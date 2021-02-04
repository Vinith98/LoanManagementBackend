package com.LoanManagementSystem.service;

import java.util.List;
import java.util.Optional;

import com.LoanManagementSystem.Exception.LoanInformationNotFoundException;
import com.LoanManagementSystem.model.LoanDetail;
import com.LoanManagementSystem.model.LoanInformation;

public interface LoanInformationService {
     List<LoanInformation> getAllLoanInformations();
	 LoanInformation addNewLoan(LoanInformation loanInformation);
	 LoanInformation editLoan(LoanInformation loanInformation);
     List<LoanDetail> getLoanDetails();
	LoanInformation getLoanByNumber(int loanNumber) throws LoanInformationNotFoundException;
	
}
