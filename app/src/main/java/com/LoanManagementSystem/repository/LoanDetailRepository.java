package com.LoanManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LoanManagementSystem.model.LoanDetail;

@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetail, Integer> {

}
