package com.LoanManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Loan Information Not Found")
public class LoanInformationNotFoundException extends Exception {
		private static final long serialVersionUID = 1L;
}
