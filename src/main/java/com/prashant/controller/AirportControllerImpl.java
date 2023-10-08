package com.prashant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.model.Airport;
import com.prashant.response.ResponseDetails;
import com.prashant.service.IAirportService;

@RestController
@RequestMapping("/flightService/api/airport")
public class AirportControllerImpl implements IAirportController {
	
	@Autowired
	private IAirportService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Airport>> getAllAirports() {
		return new ResponseEntity<List<Airport>>(service.getAllAirports(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Airport> getAirportById(@PathVariable Integer id) {
		return new ResponseEntity<Airport>(service.getAirportById(id), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDetails> addAirport(@RequestBody Airport airport) throws Exception {
		ResponseDetails response = service.addAirport(airport);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ResponseDetails> updateAirportById(@PathVariable Integer id, @RequestBody Airport airport) {
		ResponseDetails response = service.updateAirportById(id, airport);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDetails> deleteAirportById(@PathVariable Integer id) {
		ResponseDetails response = service.deleteAirportById(id);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.OK);
	}
	
	
}
