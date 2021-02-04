package com.LoanManagementSystem.service;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.LoanManagementSystem.Exception.LoanInformationNotFoundException;
import com.LoanManagementSystem.model.BorrowerInformation;
import com.LoanManagementSystem.model.LoanDetail;
import com.LoanManagementSystem.model.LoanInformation;
import com.LoanManagementSystem.repository.LoanDetailRepository;
import com.LoanManagementSystem.repository.LoanInformationRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoanInformationTest {

	@Mock
	private LoanInformationRepository loanInformationRepository;

	@Mock
	private LoanDetailRepository loanDetailRepository;

	@InjectMocks
	private LoanInformationService loanInformationService = new LoanInformationServiceImpl();
	
	BorrowerInformation borrowerInformation = new BorrowerInformation("arun", "kumar", 5454d, "3/7,raja angar",
			"madipakkam", "chennai", 60091);
	LoanInformation loanInformation1 = new LoanInformation(123, 200000, 3, 8, 23456, new Date("01/08/2020"),"house", "pending",
			borrowerInformation);
	LoanInformation loanInformation2 = new LoanInformation(456, 200000, 3, 8, 23456, new Date("01/08/2020"), "house", "approved",
			borrowerInformation);

	LoanDetail loanDetail1 = new LoanDetail(10000, "house", 3, "image");
	LoanDetail loanDetail2 = new LoanDetail(20000, "land", 3, "image");

	@Test
	public void getAllLoanInformationsTest() {
		List<LoanInformation> loanInformations = new ArrayList<>();
		loanInformations.add(loanInformation1);
		loanInformations.add(loanInformation2);

		given(loanInformationRepository.findAll()).willReturn(loanInformations);
		List<LoanInformation> l = loanInformationService.getAllLoanInformations();
		assertEquals(2, l.size());
		verify(loanInformationRepository, times(1)).findAll();
	}
	@Test
	public void getLoanInformationTest() throws LoanInformationNotFoundException {

		given(loanInformationRepository.findByLoanNumber(123)).willReturn(loanInformation1);
		LoanInformation l1 = loanInformationService.getLoanByNumber(123);
		assertEquals("pending", l1.getLoanStatus());
		verify(loanInformationRepository, times(1)).findByLoanNumber(123);
	}
	@Test(expected=LoanInformationNotFoundException.class)
	public void getLoanInformationTest1() throws LoanInformationNotFoundException {
		loanInformationService.getLoanByNumber(3456);
		verify(loanInformationRepository, times(1)).findByLoanNumber(123);
	}
	@Test
	public void getAllLoandetailsTest() {
		List<LoanDetail> loanDetails = new ArrayList<>();
		loanDetails.add(loanDetail1);
		loanDetails.add(loanDetail2);

		given(loanDetailRepository.findAll()).willReturn(loanDetails);
		List<LoanDetail> loanDetail = loanInformationService.getLoanDetails();
		assertEquals(2, loanDetail.size());
		verify(loanDetailRepository, times(1)).findAll();
	}

	@Test
	public void addNewLoanTest() {
		loanInformationService.addNewLoan(loanInformation1);
		verify(loanInformationRepository, times(1)).save(loanInformation1);
	}

	@Test
	public void editLoanTest() {
		loanInformationService.editLoan(loanInformation1);
		verify(loanInformationRepository, times(1)).save(loanInformation1);
	}
	
}
