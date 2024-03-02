package com.countryservice.net.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {
	@Id
	private String fips;
	private String state;
	private String name;
	public Country(String state, String name) {
		super();
		this.state = state;
		this.name = name;
	}
}
