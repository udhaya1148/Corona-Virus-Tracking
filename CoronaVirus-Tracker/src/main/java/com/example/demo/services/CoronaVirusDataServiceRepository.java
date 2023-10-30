package com.example.demo.services;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LocationStates;

import java.util.List;

@Repository
public interface CoronaVirusDataServiceRepository extends CrudRepository<LocationStates, Integer> {
    List<LocationStates> findByCountry(String countryName);
	List<LocationStates> findTopByLatestTotalDeaths(int count);
	
}
