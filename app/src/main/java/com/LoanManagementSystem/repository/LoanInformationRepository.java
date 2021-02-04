package com.LoanManagementSystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.LoanManagementSystem.model.LoanInformation;



@Repository
public interface LoanInformationRepository extends JpaRepository<LoanInformation,Integer>{

	LoanInformation findByLoanNumber(Integer loanNumber);
   
}
   