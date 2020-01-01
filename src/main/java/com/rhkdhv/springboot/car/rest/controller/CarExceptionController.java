package com.rhkdhv.springboot.car.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rhkdhv.springboot.car.rest.exception.CarNotFoundException;

/**
 * 
 * Handles the CarNotFoundException globally for the application
 *
 */
@ControllerAdvice
public class CarExceptionController {
	@ExceptionHandler(value= CarNotFoundException.class)
	public ResponseEntity<Object> exception(CarNotFoundException exception) {
		return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
		
	}

}
