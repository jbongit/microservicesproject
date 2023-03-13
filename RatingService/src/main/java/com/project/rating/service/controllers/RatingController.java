package com.project.rating.service.controllers;

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

import com.project.rating.service.entities.Rating;
import com.project.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	RatingService ratingService;
	@PostMapping
	public ResponseEntity<Rating> createUser(@RequestBody Rating rating){
		Rating rating1=ratingService.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> allUsers=ratingService.getRatings();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getUserById(@PathVariable String userId){
		List<Rating> rating1=ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(rating1);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getHotelById(@PathVariable String hotelId){
		List<Rating> rating1=ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(rating1);
	}

}
