package com.project.hotel.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotel.service.entities.Hotel;
import com.project.hotel.service.services.HotelSerivce;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	HotelSerivce hotelService;
	@PostMapping
	public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel){
		Hotel hotel1=hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllUser(){
		List<Hotel> allUsers=hotelService.getAll();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getUserById(@PathVariable String hotelId){
		Hotel hotel1=hotelService.getHotel(hotelId);
		return ResponseEntity.ok(hotel1);
	}

}
