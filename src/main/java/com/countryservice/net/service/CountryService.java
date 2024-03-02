package com.countryservice.net.service;

import java.util.List;

import com.countryservice.net.entity.Country;

public interface CountryService {

	public void insertDataFromJsonList(List<Country> jsonDataList);

	public List<Country> getCountryDetails(String input1, String input2);
	
	public List<Country> getCountryDetailsBasedOnNameAndState(String name, String state);
	
	public List<Country> getCountryDetailsBasedOnNameOrStateByOneInputParam(String param);

}
