package com.countryservice.net.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CountryTest {

	@Test
	public void test1() {
		Country country1 = new Country();
		Country country2 = new Country();
		assertEquals(country1, country2);
		assertTrue(country1.hashCode() == country2.hashCode());
	}
	
	@Test
	public void test2() {
		Country country1 = new Country();
		Country country2 = new Country();
		country1.setFips("1");
		country1.setName("Alabia");
		country1.setState("HL");
		assertNotEquals(country1, country2);
		assertFalse(country1.hashCode() == country2.hashCode());
	}
}
