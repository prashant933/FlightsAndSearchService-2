package com.prashant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashant.dao.ICityDao;
import com.prashant.exception.NotFoundException;
import com.prashant.model.City;
import com.prashant.response.ResponseDetails;

@Service
public class CityServiceImpl implements ICityService {
	
	@Autowired
	private ICityDao dao;

	@Override
	public List<City> getAllCities() {
		return dao.findAll();
	}

	@Override
	public City getCityById(Integer id) {
		Optional<City> city = dao.findById(id);
		if(city.isPresent())
			return city.get();
		else
			throw new NotFoundException("City with id: "+id + " not found");
	}

	@Override
	public ResponseDetails addCity(City city) throws Exception {
		City ret = dao.save(city);
		if(ret != null)
		{
			ResponseDetails details = new ResponseDetails();
			details.setMessage("City added successfully");
			details.setSuccess(true);
			return details;
		}
		else
			throw new Exception("City failed to save");
	}

	@Override
	public ResponseDetails updateCityById(Integer id, City city) {
		Optional<City> ret = dao.findById(id);
		if(ret.isEmpty())
		{
			throw new NotFoundException("City with id: "+id + " not found");
		}
		else
		{
			City existingCity = ret.get();
			if(city.getName() != null)
				existingCity.setName(city.getName());
			
			dao.save(existingCity);
			ResponseDetails details = new ResponseDetails();
			details.setMessage("City updated successfully");
			details.setSuccess(true);
			return details;
		}
	}

	@Override
	public ResponseDetails deleteCityById(Integer id) {
		if(getCityById(id) == null)
			throw new NotFoundException("City with id: " +id + " not present");
		else
		{
			dao.deleteById(id);
			ResponseDetails details = new ResponseDetails();
			details.setMessage("City deleted successfully");
			details.setSuccess(true);
			return details;
		}
	}

}
