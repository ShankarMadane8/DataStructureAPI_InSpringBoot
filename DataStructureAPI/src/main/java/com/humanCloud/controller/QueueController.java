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
import com.humanCloud.customeException.EmptyQueueException;
import com.humanCloud.customeException.EmptyStackException;
import com.humanCloud.dataStructure.CustomeDynamicQueue;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/DataStructure/queue")
public class QueueController {

	@Autowired
	CustomeDynamicQueue queue ;


	// -----------------------------EnQueueAPI----------------------------------------------
	@PostMapping("/enQueue")
	public ResponseEntity<?> enQueue(HttpServletRequest request, HttpServletResponse response) {
		queue.enQueue(Integer.valueOf(request.getParameter("value")));
		return ResponseEntity.ok("enQueue value: " + request.getParameter("value"));
	}

	// -----------------------------DeQueueAPI----------------------------------------------
	@DeleteMapping("/deQueue")
	public ResponseEntity<?> deQueue(HttpServletRequest request, HttpServletResponse response) throws EmptyQueueException {
		int val = queue.deQueue();
		return ResponseEntity.ok("deQueue value: " + val);
	}

	// -----------------------------displayAPI----------------------------------------------
	@GetMapping("/display")
	public ResponseEntity<?> display(HttpServletRequest request, HttpServletResponse response) throws EmptyQueueException {
		int[] arr = queue.display();
		return ResponseEntity.ok(arr);
	}
	
	
	
	//--------------------------------All API Exception Handel---------------------------------------------------
	@ExceptionHandler(EmptyQueueException.class)
	public ResponseEntity<?> exception(EmptyQueueException ex, WebRequest request) {
		ResponseException exception=new ResponseException(HttpStatus.NOT_FOUND,ex.getMessage(),new Date());		 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}

}
