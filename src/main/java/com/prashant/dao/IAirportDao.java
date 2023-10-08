package com.prashant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.model.Airport;

public interface IAirportDao extends JpaRepository<Airport, Integer> {

}
