package com.cg.bookStore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController {

	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Object> firstException(RecordAlreadyPresentException exception) {
	      return new ResponseEntity<>("Record already present", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Object> secondException(RecordNotFoundException exception) {
	      return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullArgumentException.class)
	public ResponseEntity<Object> thirdException(NullArgumentException exception) {
	      return new ResponseEntity<>("Null arguments passed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@ExceptionHandler(value = { InvalidCustomerIdException.class })
//	public String handleException(Exception ex) {
//		return ex.getMessage();
//	}
	
	@ExceptionHandler(value = { BookNotFoundException.class })
	public String handleException2(Exception ex) {
		return ex.getMessage();
	}

}
