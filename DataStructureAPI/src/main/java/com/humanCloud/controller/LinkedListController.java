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
import com.humanCloud.customeException.EmptyLinkedListException;
import com.humanCloud.customeException.LinkedListIndexOutOfBoundException;
import com.humanCloud.dataStructure.CustomeLinkedList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("DataStructure/linkedList")
public class LinkedListController {

	CustomeLinkedList linkedList = new CustomeLinkedList();

	
	//-----------------------InsertAPI-----------------------------
	@PostMapping("/insert")
	public ResponseEntity<?> insert(HttpServletRequest request, HttpServletResponse response) {
		linkedList.insert(Integer.valueOf(request.getParameter("value")));
		return ResponseEntity.ok("insert value: " + request.getParameter("value"));
	}
    
	//-----------------------DeleteAPI-----------------------------
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(HttpServletRequest request, HttpServletResponse response)
			throws EmptyLinkedListException, NumberFormatException, LinkedListIndexOutOfBoundException {
		if (request.getParameter("index") == null) {
			linkedList.delete();
		} else {
			linkedList.delete(Integer.valueOf(request.getParameter("index")));
		}
		return ResponseEntity.ok("delete value Successfully...");
	}
	
    //-----------------------displayAPI-----------------------------
	@GetMapping("/display")
	public ResponseEntity<?> display() throws EmptyLinkedListException {
		int[] arr = linkedList.display();
		return ResponseEntity.ok(arr);
	}

	// --------------------------------All API Exception Handel---------------------------------------------------
	@ExceptionHandler(EmptyLinkedListException.class)
	public ResponseEntity<?> exception(EmptyLinkedListException ex, WebRequest request) {
		ResponseException exception = new ResponseException(HttpStatus.NOT_FOUND, ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}

	// --------------------------------All API Exception Handel---------------------------------------------------
	@ExceptionHandler(LinkedListIndexOutOfBoundException.class)
	public ResponseEntity<?> exception(LinkedListIndexOutOfBoundException ex, WebRequest request) {
		ResponseException exception = new ResponseException(HttpStatus.NOT_FOUND, ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
	}

}
