package com.project.hotel.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotel.service.entities.Hotel;
import com.project.hotel.service.repository.HotelRepository;
import com.project.hotel.service.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelSerivce{
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		String randomHotelId=UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel with given id is not found on Server "+hotelId));
	}

}
