package com.project.hotel.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hotel.service.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{
}
