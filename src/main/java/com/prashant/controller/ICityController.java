package com.prashant.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prashant.model.City;
import com.prashant.response.ResponseDetails;

public interface ICityController {
	ResponseEntity<List<City>> getAllCities();
	ResponseEntity<City> getCityById(Integer id);
	ResponseEntity<ResponseDetails> addCity(City city) throws Exception;
	ResponseEntity<ResponseDetails> updateCityById(Integer id, City city);
	ResponseEntity<ResponseDetails> deleteCityById(Integer id);
}
