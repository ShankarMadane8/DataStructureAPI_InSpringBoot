package com.humanCloud.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.humanCloud.Entity.ResponseException;
import com.humanCloud.customeException.DynamicArrayIndexOutOfBoundException;
import com.humanCloud.customeException.EmptyArrayException;
import com.humanCloud.dataStructure.CustomeDynamicArray;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.humanCloud.dataStructure.CustomeDynamicArray;

@RestController
@RequestMapping("/DataStructure/array")
public class ArrayController {

	@Autowired
	CustomeDynamicArray array;

	// ---------------------------AppendIPI-------------------------------------
	@PostMapping("/append")
	public ResponseEntity<?> append(HttpServletRequest request, HttpServletResponse response) {
		array.append(Integer.valueOf(request.getParameter("value")));
		return ResponseEntity.ok("append value: " + request.getParameter("value"));
	}

	// ---------------------------DeletedIPI-------------------------------------
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(HttpServletRequest request, HttpServletResponse response)
			throws EmptyArrayException, NumberFormatException, DynamicArrayIndexOutOfBoundException {
		if (request.getParameter("index")==null) {
			array.delete();
		} else {
			array.delete(Integer.valueOf(request.getParameter("index")));
		}
		return ResponseEntity.ok("Delete Value Successfully");
	}

	// ---------------------------DisplayAPI-------------------------------------
	@GetMapping("/display")
	public ResponseEntity<?> display(HttpServletRequest request, HttpServletResponse response)
			throws EmptyArrayException {
		int[] arr = array.display();
		return ResponseEntity.ok(arr);
	}

	// --------------------------------All API Exception Handel---------------------------------------------------
	@ExceptionHandler(EmptyArrayException.class)
	public ResponseEntity<?> emptyArrayException(EmptyArrayException ex, WebRequest request) {
		ResponseException exception = new ResponseException(HttpStatus.NOT_FOUND, ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}

	// --------------------------------All API Exception Handel---------------------------------------------------
	@ExceptionHandler(DynamicArrayIndexOutOfBoundException.class)
	public ResponseEntity<?> dynamicArrayIndexOutOfBoundException(DynamicArrayIndexOutOfBoundException ex, WebRequest request) {
		ResponseException exception = new ResponseException(HttpStatus.NOT_FOUND, ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}

}
