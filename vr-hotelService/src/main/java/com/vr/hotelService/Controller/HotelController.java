package com.vr.hotelService.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vr.hotelService.Service.HotelService;
import com.vr.hotelService.Entity.HotelEntity;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
	public List<HotelEntity> findAllHotels(){
		logger.info("inside findAllHotels of HotelController");
		return hotelService.findAllHotels();
	}
	

}
