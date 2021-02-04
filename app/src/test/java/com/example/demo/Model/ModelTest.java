package com.example.demo.Model;



import static org.junit.Assert.*;

import java.util.Date;


import org.junit.Test;

import com.LoanManagementSystem.model.BorrowerInformation;
import com.LoanManagementSystem.model.LoanDetail;
import com.LoanManagementSystem.model.LoanInformation;

public class ModelTest {

	@Test
	public void test() {
		BorrowerInformation borrowerInformation1 = new BorrowerInformation();
		BorrowerInformation borrowerInformation2 = null;
		LoanInformation loanInformation1 = new LoanInformation();
		LoanInformation loanInformation2 = null;
		LoanDetail loanDetail1 = new LoanDetail();
		LoanDetail loanDetail2 = null;

	
			borrowerInformation1.setAddressLine1("3/76,raj nagar");
			borrowerInformation1.setAddressLine2("madipakkam");
			borrowerInformation1.setCity("chennai");
			borrowerInformation1.setFirstName("arjun");
			borrowerInformation1.setLastName("dass");
			borrowerInformation1.setMobileNumber(4545d);
			borrowerInformation1.setPincode(444444);
			
			loanInformation1.setLoanAmount(10000);
			loanInformation1.setLoanManagementFees(8);
			loanInformation1.setLoanNumber(345678);
			loanInformation1.setLoanStatus("approved");
			loanInformation1.setLoanTerm(12);
			loanInformation1.setLoanType("Bike");
			loanInformation1.setOriginationAccount(345677);
			loanInformation1.setOriginationDate(new Date());
			loanInformation1.setBorrowerInformation(borrowerInformation1);
			
			loanDetail1.setLoanAmount(10000);
			loanDetail1.setLoanTerm(12);
			loanDetail1.setLoanType("Car");
			loanDetail1.setLoanImage("image");
			
			 borrowerInformation2 = new BorrowerInformation("arun", "kumar", 5454d, "3/7,raja angar",
					"madipakkam", "chennai", 60091);
			 loanInformation2 = new LoanInformation(123, 200000, 3, 8, 23456, new Date("01/08/2020"),"house", "pending",
					borrowerInformation2);
			 loanDetail2 = new LoanDetail(20000, "land", 3, "image");
			 
			 assertEquals("arun",borrowerInformation2.getFirstName());
			 assertNotEquals("kuma",borrowerInformation2.getFirstName());
			 assertEquals("3/7,raja angar",borrowerInformation2.getAddressLine1());
			 assertNotEquals("madipakka",borrowerInformation2.getAddressLine2());
			 assertEquals("chennai",borrowerInformation2.getCity());
			 assertNotNull(borrowerInformation2.getMobileNumber());
			
	}

}
