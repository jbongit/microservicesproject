package com.project.hotel.service.services;

import java.util.List;

import com.project.hotel.service.entities.Hotel;

public interface HotelSerivce {
	Hotel create(Hotel hotel);

	List<Hotel> getAll();

	Hotel getHotel(String hotelId);

}
