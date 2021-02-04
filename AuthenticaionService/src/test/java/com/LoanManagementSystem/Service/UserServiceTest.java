package com.LoanManagementSystem.Service;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.LoanManagementSystem.Model.User;
import com.LoanManagementSystem.Repository.UserRepository;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	
	@Test
	public void test() {
		User user1 = new User(1234567,"vinith","vinith");
		User user2 = new User(1234568,"varun","varun");
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		
		given(userRepository.findAll()).willReturn(users);
		List<User> users1 = userServiceImpl.getUsers();
		assertEquals(2,users1.size());
		verify(userRepository,times(1)).findAll();
	}

}
