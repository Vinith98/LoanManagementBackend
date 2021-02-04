package com.LoanManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "User Credentials Incorrect")
public class UserCredentialsMismatchException extends Exception{
	private static final long serialVersionUID = 1L;

}
