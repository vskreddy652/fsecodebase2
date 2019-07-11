package com.hackfse.giveaway.exception;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hackfse.giveaway.bean.ErrorResponse;

@ControllerAdvice
public class ExceptionControllerAdvice {
 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		if(ex instanceof SQLException) {
			error.setErrorCode(HttpStatus.NO_CONTENT.value());
		}else if(ex instanceof IOException) {
			error.setErrorCode(HttpStatus.NOT_FOUND.value());
		}else{
			error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		
		error.setMessage("Please contact your administrator for details. "+ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
