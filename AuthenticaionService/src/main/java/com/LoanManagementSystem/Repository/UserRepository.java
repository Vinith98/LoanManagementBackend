package com.LoanManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LoanManagementSystem.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
 
	User findByMobileNumber(Integer mobileNumber);
}
