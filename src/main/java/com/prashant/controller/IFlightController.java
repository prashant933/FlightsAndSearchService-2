package com.prashant.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prashant.model.Flight;
import com.prashant.response.ResponseDetails;

public interface IFlightController {
	ResponseEntity<List<Flight>> getAllFlights();
	ResponseEntity<Flight> getFlightById(Integer id);
	ResponseEntity<ResponseDetails> addFlight(Flight flight) throws Exception;
	ResponseEntity<ResponseDetails> updateFlightById(Integer id, Flight flight);
	ResponseEntity<ResponseDetails> deleteFlightById(Integer id);
}
