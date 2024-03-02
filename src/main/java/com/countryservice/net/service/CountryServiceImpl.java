package com.countryservice.net.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.countryservice.net.entity.Country;
import com.countryservice.net.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public void insertDataFromJsonList(List<Country> jsonDataList) {
		countryRepository.saveAll(jsonDataList);
	}
	
	public List<Country> getCountryDetails(String value1, String value2) {
		List<Country> result = null;
		if (value1 != null && value2 != null) {
			List<Country> countryList = countryRepository
					.findByNameContainingIgnoreCaseOrStateContainingIgnoreCase(value1, value2);
			return countryList.stream().limit(5).collect(Collectors.toList());
		}
		return result;
	}

	@Override
	public List<Country> getCountryDetailsBasedOnNameAndState(String name, String state) {
		List<Country> result = null;
		if (name != null && state != null) {
			List<Country> countryList = countryRepository
					.findByNameInIgnoreCaseOrStateInIgnoreCase(name, state);
			return countryList.stream().limit(5).collect(Collectors.toList());
		}
		return result;
	}

	@Override
	public List<Country> getCountryDetailsBasedOnNameOrStateByOneInputParam(String param) {
		List<Country> result = null;
		if (param != null) {
			List<Country> countryList = countryRepository
					.findByNameInIgnoreCaseOrStateInIgnoreCaseByOneParam(param);
			return countryList.stream().limit(5).collect(Collectors.toList());
		}
		return result;
	}

	
}
