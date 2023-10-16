package com.prashant.service;

import java.util.List;

import com.prashant.model.Flight;
import com.prashant.response.ResponseDetails;

public interface IFlightService {
	List<Flight> getAllFlights();
	Flight getFlightById(Integer id);
	ResponseDetails addFlight(Flight flight) throws Exception;
	ResponseDetails updateFlightById(Integer id, Flight flight);
	ResponseDetails deleteFlightById(Integer id);
	List<Flight> findAllFlightsBetweenTwoCities(String source, String destination);
}
