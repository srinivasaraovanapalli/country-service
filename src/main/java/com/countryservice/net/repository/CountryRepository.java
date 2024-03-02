package com.countryservice.net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.countryservice.net.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	//name and country searching from name column and state column and reverse for both columns
	@Query("SELECT NEW com.countryservice.net.entity.Country(c.fips, c.name, c.state) FROM Country c "
			+ "WHERE UPPER(c.name) LIKE UPPER(CONCAT('%',:param1,'%')) OR UPPER(c.state) LIKE UPPER(CONCAT('%',:param2,'%'))"
			+ "or UPPER(c.name) LIKE UPPER(CONCAT('%',:param2,'%')) OR UPPER(c.state) LIKE UPPER(CONCAT('%',:param1,'%'))")
	List<Country> findByNameContainingIgnoreCaseOrStateContainingIgnoreCase(@Param("param1") String param1,
			@Param("param2") String param2);

	//name and country searching from name column and state column
	@Query("SELECT NEW com.countryservice.net.entity.Country(c.fips, c.name, c.state) FROM Country c "
			+ "WHERE UPPER(c.name) LIKE UPPER(CONCAT('%',:name,'%')) OR UPPER(c.state) LIKE UPPER(CONCAT('%',:state,'%'))")
	List<Country> findByNameInIgnoreCaseOrStateInIgnoreCase(@Param("name") String name, @Param("state") String state);

	//name or country as a single parameter
	@Query("SELECT NEW com.countryservice.net.entity.Country(c.fips, c.name, c.state) FROM Country c " +
	           "WHERE UPPER(c.name) LIKE UPPER(CONCAT('%',:query,'%')) OR UPPER(c.state) LIKE UPPER(CONCAT('%',:query,'%'))")
	List<Country> findByNameInIgnoreCaseOrStateInIgnoreCaseByOneParam(@Param("query") String query);
	    
}
