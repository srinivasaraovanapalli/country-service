package com.countryservice.net.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.net.entity.Country;
import com.countryservice.net.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/v1")
@RestController
public class CountryController {
	
	@Autowired
	private CountryService countryService;

	@PostMapping("/insert")
   public void insertCountries(@RequestBody List<Country> countries) {
		log.info("CountryController - insertCountries :: Start");
        countryService.insertDataFromJsonList(countries);
        log.info("CountryController - insertCountries :: End");
    }
	
	@GetMapping("/suggest")
	public List<Country> getCountryList(@RequestParam String input){
		log.info("CountryController - getCountryList() :: Start");
		if (input != null) {
			String[] inputValues = input.split(",");
			if(inputValues.length<=1) {
				return countryService.getCountryDetails(inputValues[0], inputValues[0]);
			}else if(inputValues.length>=2){
				return countryService.getCountryDetails(inputValues[0], inputValues[1]);
			}else {
				log.info("Cant Process Request...");
			}
	    }
		log.info("CountryController - getCountryList() :: End");
		return null;
	}
	
	
	@GetMapping("/suggest-specific")
	public List<Country> getCountryListBasedOnNameAndStateOrBasedOnNameOrBasedOnState(@RequestParam String input){
		log.info("CountryController - getCountryList() :: Start");
		if (input != null) {
			String[] inputValues = input.split(",");
			if(inputValues.length<=1) {
				return countryService.getCountryDetailsBasedOnNameOrStateByOneInputParam(inputValues[0]);//single input parameter might be name or state
			}else if(inputValues.length>=2){
				return countryService.getCountryDetailsBasedOnNameAndState(inputValues[0], inputValues[1]);// first value as name and second value as state
			}else {
				log.info("Cant Process Request...");
			}
	    }
		log.info("CountryController - getCountryList() :: End");
		return null;
	}
	
}
