package com.prashant.service;

import java.util.List;

import com.prashant.model.City;
import com.prashant.response.ResponseDetails;

public interface ICityService {
	List<City> getAllCities();
	City getCityById(Integer id);
	ResponseDetails addCity(City city) throws Exception;
	ResponseDetails updateCityById(Integer id, City city);
	ResponseDetails deleteCityById(Integer id);
	City findCityByCityName(String cityName);
}
