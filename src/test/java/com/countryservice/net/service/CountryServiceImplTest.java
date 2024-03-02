package com.countryservice.net.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.countryservice.net.entity.Country;
import com.countryservice.net.repository.CountryRepository;

@ExtendWith(MockitoExtension.class)
public class CountryServiceImplTest {

	@InjectMocks
	CountryServiceImpl countryServiceImpl;
	
	@Autowired
	CountryRepository countryRepository = Mockito.mock(CountryRepository.class);
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void getCountryDetailsTest() {
		Mockito.when(countryRepository.findByNameContainingIgnoreCaseOrStateContainingIgnoreCase(anyString(), anyString())).thenReturn(getCountryList());
		List<Country> countyList = countryServiceImpl.getCountryDetails("HL", "Law");
		assertNotNull(countyList);
	}
	
	public List<Country> getCountryList(){
		Country country1 = new Country();
		country1.setFips("1");
		country1.setName("Alabia");
		country1.setState("HL");
		List<Country> list = new ArrayList<>();
		list.add(country1);
		Country country2 = new Country();
		country2.setFips("1");
		country2.setName("Alabia");
		country2.setState("HL");
		list.add(country2);
		return list;
	}
}
