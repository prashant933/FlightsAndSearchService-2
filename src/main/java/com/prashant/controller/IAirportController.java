package com.prashant.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prashant.model.Airport;
import com.prashant.response.ResponseDetails;

public interface IAirportController {
	ResponseEntity<List<Airport>> getAllAirports();
	ResponseEntity<Airport> getAirportById(Integer id);
	ResponseEntity<ResponseDetails> addAirport(Airport airport) throws Exception;
	ResponseEntity<ResponseDetails> updateAirportById(Integer id, Airport airport);
	ResponseEntity<ResponseDetails> deleteAirportById(Integer id);
}
