package com.prashant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashant.dao.IFlightDao;
import com.prashant.exception.NotFoundException;
import com.prashant.exception.SeatsNotAvailableException;
import com.prashant.model.Flight;
import com.prashant.response.ResponseDetails;

@Service
public class FlightServiceImpl implements IFlightService {
	
	@Autowired
	private IFlightDao dao;
	
	@Autowired
	private ICityService cityService;

	@Override
	public List<Flight> getAllFlights() {
		return dao.findAll();
	}

	@Override
	public Flight getFlightById(Integer id) {
		Optional<Flight> flight = dao.findById(id);
		if(flight.isPresent())
			return flight.get();
		else
			throw new NotFoundException("Flight with id: "+id + " not found");
	}

	@Override
	public ResponseDetails addFlight(Flight flight) throws Exception {
		if(validateFlight(flight) == false)
			throw new Exception("Flight data is invalid");
		Flight ret = dao.save(flight);
		if(ret != null)
		{
			ResponseDetails details = new ResponseDetails();
			details.setMessage("Flight added successfully");
			details.setSuccess(true);
			return details;
		}
		else
			throw new Exception("Flight failed to save");
	}

	@Override
	public ResponseDetails updateFlightById(Integer id, Flight flight) {
		Optional<Flight> ret = dao.findById(id);
		if(ret == null)
			throw new NotFoundException("Flight with id: "+id + " not found");
		else
		{
			Flight existingFlight = ret.get();
			if(flight.getFlightNumber() != null)
				existingFlight.setFlightNumber(flight.getFlightNumber());
			if(flight.getAirplaneId() != null)
				existingFlight.setAirplaneId(flight.getAirplaneId());
			if(flight.getArrivalAirportId() != null)
				existingFlight.setArrivalAirportId(flight.getArrivalAirportId());
			if(flight.getArrivalTime() != null)
				existingFlight.setArrivalTime(flight.getArrivalTime());
			if(flight.getDepartureAirportId() != null)
				existingFlight.setDepartureAirportId(flight.getDepartureAirportId());
			if(flight.getDepartureTime() != null)
				existingFlight.setDepartureTime(flight.getDepartureTime());
			if(flight.getTotalSeats() != null)
				existingFlight.setTotalSeats(flight.getTotalSeats());
			if(flight.getPrice() != null)
				existingFlight.setPrice(flight.getPrice());
			
			dao.save(existingFlight);
			ResponseDetails details = new ResponseDetails();
			details.setMessage("Flight updated successfully");
			details.setSuccess(true);
			return details;
		}
	}

	@Override
	public ResponseDetails deleteFlightById(Integer id) {
		if(getFlightById(id) == null)
			throw new NotFoundException("Flight with id: " +id + " not present");
		else
		{
			dao.deleteById(id);
			ResponseDetails details = new ResponseDetails();
			details.setMessage("Flight deleted successfully");
			details.setSuccess(true);
			return details;
		}
	}
	
	private boolean validateFlight(Flight flight) {
		if(flight.getArrivalTime().compareTo(flight.getDepartureTime()) < 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<Flight> findAllFlightsBetweenTwoCities(String source, String destination) {
		Integer sourceCityId = cityService.findCityByCityName(source).getId();
		Integer destinationCityId = cityService.findCityByCityName(destination).getId();
		
		List<Flight> flights = dao.findByArrivalAirportIdAndDepartureAirportId(sourceCityId.toString()
				, destinationCityId.toString());
		return flights;
	}

	@Override
	public ResponseDetails updateSeatsForFlight(Integer id, Integer decrement) {
		Flight flight = getFlightById(id);
		if(flight.getTotalSeats() < decrement)
			throw new SeatsNotAvailableException("Enough empty seats are not available");
		dao.updateSeatsInFlight(id, decrement);
		ResponseDetails response = new ResponseDetails();
		response.setMessage(String.format("Successfully decremented %d number of seats for flight with ID: %d", decrement, id));
		response.setSuccess(true);
		return response;
	}

}
