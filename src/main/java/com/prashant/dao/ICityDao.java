package com.prashant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.model.City;

public interface ICityDao extends JpaRepository<City, Integer> {

}
