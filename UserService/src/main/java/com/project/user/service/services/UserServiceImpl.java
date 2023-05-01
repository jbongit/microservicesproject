package com.project.user.service.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.user.service.entities.Hotel;
import com.project.user.service.entities.Rating;
import com.project.user.service.entities.User;
import com.project.user.service.exceptions.ResourceNotFoundException;
import com.project.user.service.external.services.HotelService;
import com.project.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAlUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {

		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on Server " + userId));
		// fetch rating for the above user from RATING SERVICE
		Rating[] ratingsForUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(),
				Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingsForUser).toList();
		logger.info("{}", ratingsForUser);

		List<Rating> ratingList = ratings.stream().map(rating -> {
			// API call to hotel service to get the hotel 
			
			//API Call Using Rest Template
			/*
			 * ResponseEntity<Hotel> forEntity = restTemplate
			 * .getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
			 * Hotel.class); Hotel hotel = forEntity.getBody();
			 * logger.info("Response Status Code :{}", forEntity.getStatusCode());
			 */
			
			//API Call Using Feign Client
			Hotel hotel=hotelService.getHotel(rating.getHotelId());
		
			// Set the hotel to rating
			rating.setHotel(hotel);
			// Return the rating
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratings);

		return user;

	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

}
