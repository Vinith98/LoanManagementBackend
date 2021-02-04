package com.example.demo.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.jandex.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.LoanManagementSystem.AppApplication;
import com.LoanManagementSystem.Exception.LoanInformationNotFoundException;
import com.LoanManagementSystem.controller.LoanInformationController;
import com.LoanManagementSystem.model.BorrowerInformation;
import com.LoanManagementSystem.model.LoanDetail;
import com.LoanManagementSystem.model.LoanInformation;
import com.LoanManagementSystem.repository.LoanInformationRepository;
import com.LoanManagementSystem.service.LoanInformationServiceImpl;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class LoanInformationControllerTest {
	
	@Mock
	private LoanInformationServiceImpl loanInformationServiceImpl;
	
	@InjectMocks
	private LoanInformationController loanInformationController;

	BorrowerInformation borrowerInformation = new BorrowerInformation("arun", "kumar", 5454d, "3/7,raja angar",
			"madipakkam", "chennai", 60091);
	LoanInformation loanInformation1 = new LoanInformation(123, 200000, 3, 8, 23456, new Date("01/08/2020"),"house", "pending",
			borrowerInformation);
	LoanInformation loanInformation2 = new LoanInformation(456, 200000, 3, 8, 23456, new Date("01/08/2020"), "house", "approved",
			borrowerInformation);
	LoanDetail loanDetail1 = new LoanDetail(10000, "house", 3, "image");
	LoanDetail loanDetail2 = new LoanDetail(20000, "land", 3, "image");

	@Test
	public void mainMethodTest() {
		
		AppApplication.main(new String[] {"hi","hello"});
		
	}

	@Test
	public void getAllLoanInformationTest() {
		List<LoanInformation> loanInformations = new ArrayList<>();
		loanInformations.add(loanInformation1);
		loanInformations.add(loanInformation2);
		given(loanInformationServiceImpl.getAllLoanInformations()).willReturn(loanInformations);
		List<LoanInformation> loanList = loanInformationController.getAllLoanInformations();
		verify(loanInformationServiceImpl,times(1)).getAllLoanInformations();
		assertEquals(2,loanList.size());
	}
	
	@Test
	public void getLoanInformationTest() throws LoanInformationNotFoundException {
		given(loanInformationServiceImpl.getLoanByNumber(123)).willReturn(loanInformation1);
		LoanInformation loan = loanInformationController.getLoanInformation(123);
		verify(loanInformationServiceImpl,times(1)).getLoanByNumber(123);
		assertEquals("pending",loan.getLoanStatus());
	}
	
	@Test
	public void getAllLoanDetailsTest() {
		List<LoanDetail> loanDetails = new ArrayList<>();
		loanDetails.add(loanDetail1);
		loanDetails.add(loanDetail2);

		given(loanInformationServiceImpl.getLoanDetails()).willReturn(loanDetails);
		ResponseEntity<?> loanDetail = loanInformationController.getLoanDetails();
		assertEquals(HttpStatus.OK,loanDetail.getStatusCode());
		verify(loanInformationServiceImpl, times(1)).getLoanDetails();
	}
	@Test
	public void addNewLoanTest() {
		ResponseEntity<LoanInformation> loanInformation = loanInformationController.addNewLoan(loanInformation1);
		assertEquals(HttpStatus.CREATED,loanInformation.getStatusCode());
		verify(loanInformationServiceImpl, times(1)).addNewLoan(loanInformation1);
	}

	@Test
	public void editLoanTest() {
		loanInformationController.editLoan(loanInformation1);
		verify(loanInformationServiceImpl, times(1)).editLoan(loanInformation1);
	}

}
