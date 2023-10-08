package com.prashant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.model.Flight;

public interface IFlightDao extends JpaRepository<Flight, Integer> {

}
