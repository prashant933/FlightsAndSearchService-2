package com.prashant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.prashant.model.Flight;

public interface IFlightDao extends JpaRepository<Flight, Integer> {
	// We need to use table name and attribute name to be same as present in code. For example
	// flights table is created from class Flight, so we used Flight below instead of flights
	@Query("select f from Flight f where f.arrivalAirportId in (select a.id from Airport a where a.cityId=?2) and f.departureAirportId in (select a.id from Airport"
			+ " a where a.cityId=?1)")
	List<Flight> findByArrivalAirportIdAndDepartureAirportId(String srcCityId, 
			String destCityId);
	
	@Transactional
	@Modifying // we need to add @Modifying to tell data jpa that this query is not a select query
	@Query("update Flight set totalSeats=totalSeats-?2 where id=?1")
	void updateSeatsInFlight(Integer id, Integer decrement);
}
