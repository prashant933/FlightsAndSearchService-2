package com.prashant.service;

import java.util.List;

import com.prashant.model.Airport;
import com.prashant.response.ResponseDetails;

public interface IAirportService {
	List<Airport> getAllAirports();
	Airport getAirportById(Integer id);
	ResponseDetails addAirport(Airport airport) throws Exception;
	ResponseDetails updateAirportById(Integer id, Airport airport);
	ResponseDetails deleteAirportById(Integer id);
}
