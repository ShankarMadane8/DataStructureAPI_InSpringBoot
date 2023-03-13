package com.humanCloud.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.humanCloud.customeException.EmptyStackException;
import com.humanCloud.dataStructure.CustomeStack;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/DataStructure/stack")
public class StackController {
	
	
	@Autowired
	CustomeStack stack;
	
	//----------------pushAPI-------------------
	@PostMapping("/push")
	public ResponseEntity<?> push(HttpServletRequest request , HttpServletResponse response) {
		
		stack.push(Integer.valueOf(request.getParameter("value")));
		return  ResponseEntity.ok("push value: "+request.getParameter("value"));
		
	}
    
	//--------------PeekAPI--------------------
	@GetMapping("/peek")
	public  ResponseEntity<?> peek() throws EmptyStackException {
		int peek = stack.peek();
		return  ResponseEntity.ok(peek);
//		try {
//			int peek = stack.peek();
//			return  ResponseEntity.ok(peek);
//		} catch (EmptyStackException e) {
//			e.printStackTrace();
//			return  ResponseEntity.ok(e);
//		}
	}
	
	//------------popAPI------------------------
	@DeleteMapping("/pop")
	public  ResponseEntity<?> pop() throws EmptyStackException {
		int pop = stack.pop();
		return  ResponseEntity.ok(pop);
//		try {
//			int pop = stack.pop();
//			return  ResponseEntity.ok(pop);
//		} catch (EmptyStackException e) {
//			e.printStackTrace();
//			return  ResponseEntity.ok(e);
//		}	 
	}
	
	
	///------------------DuspplayAPI--------------------------
	@GetMapping("/display")
	public ResponseEntity<?> display() throws EmptyStackException {
		int[] arr = stack.display();
		return  ResponseEntity.ok(arr);
//		try {
//			int[] arr = stack.display();
//			return  ResponseEntity.ok(arr);
//		} catch (EmptyStackException e) {			
//			e.printStackTrace();
//			return  ResponseEntity.ok(e);
//		}
	}
	
	@ExceptionHandler(EmptyStackException.class)
	public ResponseEntity<?> exception(EmptyStackException ex, WebRequest request) {
		ResponseException exception=new ResponseException(HttpStatus.NOT_FOUND,ex.getMessage(),new Date());		 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}
	
	
	
}
