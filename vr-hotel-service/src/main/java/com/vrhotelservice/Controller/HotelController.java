package com.vrhotelservice.Controller;

import com.vrhotelservice.Entity.HotelEntity;
import com.vrhotelservice.Service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/hotels")
@Tag(name = "Hotel", description = "The Hotel api")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
	@Operation(description = "Find all hotels", summary = "Returns a list of hotels" ,tags = {"Hotel"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = HotelEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public List<HotelEntity> findAllHotels(){
		logger.info("inside findAllHotels of HotelController");
		return hotelService.findAllHotels();
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Find hotel by Id", summary = "Returns a single hotel" ,tags = {"Hotel"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = HotelEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public HotelEntity findHotel(@PathVariable("id") Long hotelId) {
		logger.info("inside findHotel of HotelController");
		return hotelService.findHotel(hotelId);		
	}
	
	@PostMapping
	@Operation(description = "Create Hotel", summary = "returns the created hotel" ,tags = {"Hotel"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = HotelEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public HotelEntity createHotel(@RequestBody HotelEntity hotel) {
		logger.info("inside create of HotelController");
		return hotelService.createHotel(hotel);
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "Delete Hotel", summary = "Returns Delete success message" ,tags = {"Hotel"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = HotelEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public String deleteHotel(@PathVariable("id") Long hotelId ) {
		logger.info("inside deleteHotel of HotelController");
		return hotelService.deleteHotel(hotelId);
	}
	
	@PutMapping("{id}")
	@Operation(description = "Update a hotel", summary = "returns the updated hotel" ,tags = {"Hotel"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = HotelEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public ResponseEntity<HotelEntity> updateHotel(@PathVariable("id") Long hotelId, @RequestBody HotelEntity hotel) {
		logger.info("inside updateHotel of HotelController");
		return ResponseEntity.ok(this.hotelService.updateHotel(hotel, hotelId));
	}
	
	@PostMapping("/approve/{id}")
	@Operation(description = "Approve a hotel", summary = "returns the approved hotel" ,tags = {"Hotel"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Successful Operation",content = @Content(schema = @Schema(implementation = HotelEntity.class))),
			@ApiResponse(responseCode = "400",description = "Failure Operation")
	})
	public HotelEntity approveHotel(@PathVariable("id") Long hotelId) {
		return hotelService.approveHotel(hotelId);
	}
}
