/**
 * 
 */
package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Component
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<String> handleException(RuntimeException exception) {
		
		exception.printStackTrace();      
		return new ResponseEntity<>("Error",HttpStatus.OK);
    }  
   
}

