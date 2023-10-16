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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.model.Flight;
import com.prashant.response.ResponseDetails;
import com.prashant.service.IFlightService;

@RestController
@RequestMapping("/flightService/api/flights")
public class FlightControllerImpl implements IFlightController {
	
	@Autowired
	private IFlightService service;

	@GetMapping("/")
	public ResponseEntity<List<Flight>> getAllFlights() {
		return new ResponseEntity<List<Flight>>(service.getAllFlights(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Flight> getFlightById(@PathVariable Integer id) {
		return new ResponseEntity<Flight>(service.getFlightById(id), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDetails> addFlight(@RequestBody Flight flight) throws Exception {
		ResponseDetails response = service.addFlight(flight);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ResponseDetails> updateFlightById(@PathVariable Integer id, @RequestBody Flight flight) {
		ResponseDetails response = service.updateFlightById(id, flight);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDetails> deleteFlightById(@PathVariable Integer id) {
		ResponseDetails response = service.deleteFlightById(id);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.OK);
	}

	@GetMapping("/findFlights")
	public ResponseEntity<List<Flight>> findAllFlightBetweenTwoCities(
			@RequestParam(name = "from") String source,
			@RequestParam(name = "to") String destination) {
		List<Flight> flights = service.findAllFlightsBetweenTwoCities(source, destination);
		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
	}
}
