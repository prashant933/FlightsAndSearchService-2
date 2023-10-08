package com.prashant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.model.City;
import com.prashant.response.ResponseDetails;
import com.prashant.service.ICityService;

@RestController
@RequestMapping("/flightService/api/cities")
public class CityControllerImpl implements ICityController {
	
	@Autowired
	private ICityService service;

	@GetMapping("/")
	public ResponseEntity<List<City>> getAllCities() {
		return new ResponseEntity<List<City>>(service.getAllCities(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<City> getCityById(@PathVariable Integer id) {
		return new ResponseEntity<City>(service.getCityById(id), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDetails> addCity(@RequestBody City city) throws Exception {
		ResponseDetails response = service.addCity(city);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ResponseDetails> updateCityById(@PathVariable Integer id,@RequestBody City city) {
		ResponseDetails response = service.updateCityById(id, city);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDetails> deleteCityById(@PathVariable Integer id) {
		ResponseDetails response = service.deleteCityById(id);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.OK);
	}
}
