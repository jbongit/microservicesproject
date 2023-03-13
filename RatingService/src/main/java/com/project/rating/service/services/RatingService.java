package com.project.rating.service.services;

import java.util.List;

import com.project.rating.service.entities.Rating;

public interface RatingService {
	Rating create(Rating rating);

	List<Rating> getRatings();

	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);

}
