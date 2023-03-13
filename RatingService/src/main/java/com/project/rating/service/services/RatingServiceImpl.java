package com.project.rating.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rating.service.entities.Rating;
import com.project.rating.service.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		String randomRatingId=UUID.randomUUID().toString();
		rating.setRatingId(randomRatingId);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

	

}
