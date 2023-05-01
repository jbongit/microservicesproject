package com.project.hotel.service.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {
	@GetMapping
	public ResponseEntity<List<String>> getStaff() {
		List<String> list = Arrays.asList("Example 1", "Example 2", "Example 3", "Example 4","Example 5");
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}
}
