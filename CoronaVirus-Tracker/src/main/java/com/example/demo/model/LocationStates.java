package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LocationStates")
public class LocationStates 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int CountryId;
	
	private String state;
	
	private String country;

	private int latestTotalDeaths;

	private int differFromPrevay;
	
	
	public int getCountryId() {
		return CountryId;
	}
	public void setCountryId(int countryId) {
		CountryId = countryId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLatestTotalDeaths() {
		return latestTotalDeaths;
	}
	public void setLatestTotalDeaths(int latestTotalDeaths) {
		this.latestTotalDeaths = latestTotalDeaths;
	}
	public int getDifferFromPrevay() {
		return differFromPrevay;
	}
	public void setDifferFromPrevay(int differFromPrevay) {
		this.differFromPrevay = differFromPrevay;
	}
	@Override
	public String toString() {
		return "LocationStates [CountryId=" + CountryId + ", state=" + state + ", country=" + country
				+ ", latestTotalDeaths=" + latestTotalDeaths + ", differFromPrevay=" + differFromPrevay + "]";
	}
	
	
	

	
}
