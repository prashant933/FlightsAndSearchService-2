package com.prashant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashant.dao.IAirportDao;
import com.prashant.exception.NotFoundException;
import com.prashant.model.Airport;
import com.prashant.response.ResponseDetails;

@Service
public class AirportServiceImpl implements IAirportService {
	
	@Autowired
	IAirportDao dao;

	@Override
	public List<Airport> getAllAirports() {
		return dao.findAll();
	}

	@Override
	public Airport getAirportById(Integer id) {
		Optional<Airport> airport = dao.findById(id);
		if(airport.isPresent())
			return airport.get();
		else
			throw new NotFoundException("Airport with id: " +id + " not present");
	}

	@Override
	public ResponseDetails addAirport(Airport airport) throws Exception {
		Airport ret = dao.save(airport);
		if(ret != null)
		{
			ResponseDetails details = new ResponseDetails();
			details.setMessage("Airport added successfully");
			details.setSuccess(true);
			return details;
		}
		else
			throw new Exception("Airport failed to save");
	}

	@Override
	public ResponseDetails updateAirportById(Integer id, Airport airport) {
		Airport existingAirport = dao.findById(id).get();
		if(existingAirport == null)
			throw new NotFoundException("Airport with id: " +id + " not present");
		else
		{
			if(airport.getName() != null)
				existingAirport.setName(airport.getName());
			if(airport.getCityId() != null)
				existingAirport.setCityId(airport.getCityId());
			
			dao.save(existingAirport);
			ResponseDetails details = new ResponseDetails();
			details.setMessage("Airport updated successfully");
			details.setSuccess(true);
			return details;
		}
	}

	@Override
	public ResponseDetails deleteAirportById(Integer id) {
		if(getAirportById(id) == null)
			throw new NotFoundException("Airport with id: " +id + " not present");
		else
		{
			dao.deleteById(id);
			ResponseDetails details = new ResponseDetails();
			details.setMessage("Airport deleted successfully");
			details.setSuccess(true);
			return details;
		}
	}

}
