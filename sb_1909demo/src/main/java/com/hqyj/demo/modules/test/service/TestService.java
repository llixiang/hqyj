package com.hqyj.demo.modules.test.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hqyj.demo.modules.test.entity.City;
import com.hqyj.demo.modules.test.entity.Country;

public interface TestService {
	/*
	 * select all cities by countryid
	 */
	List<City> getCitiesByCountryId(int countryId);
	
	/*
	 * select country by countryid
	 */
	Country getCountryByCountryId(int countryId);
	
	/*
	 * select all cities and country by countryid
	 */
	Country getCountryByCountryId2(int countryId);
	
	Country getCountryByCountryId3(int countryId);
	
	/*
	 * select all cities and country by countryname
	 */
	Country getCountryByCountryName(String countryName);

	/*
	 * select cities by page
	 */
	PageInfo<City> getCitiesByPage(int currentPage,int pageSize);
	
	City insertCity(City city);
	
	City updateCity(City city);
	
	void deleteCity(int cityId);
}
