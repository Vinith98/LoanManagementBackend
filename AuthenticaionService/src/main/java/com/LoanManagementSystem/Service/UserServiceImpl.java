package com.LoanManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoanManagementSystem.Model.User;
import com.LoanManagementSystem.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}
}
