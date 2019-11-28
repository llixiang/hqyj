package com.hqyj.demo.modules.test.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.demo.modules.test.dao.TestDao;
import com.hqyj.demo.modules.test.entity.City;
import com.hqyj.demo.modules.test.entity.Country;
import com.hqyj.demo.modules.test.service.TestService;
import com.jayway.jsonpath.Option;
@Service
public class TestServiceImpl implements TestService{
	@Autowired
	TestDao testDao;

	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		return Optional.ofNullable(testDao.getCitiesByCountryId(countryId))
				.orElse(Collections.emptyList());
	}

	@Override
	public Country getCountryByCountryId(int countryId) {
		return testDao.getCountryByCountryId(countryId);
	}

	@Override
	public Country getCountryByCountryId2(int countryId) {
		return testDao.getCountryByCountryId2(countryId);
	}

	@Override
	public Country getCountryByCountryName(String countryName) {
		return testDao.getCountryByCountryName(countryName);
	}

	@Override
	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<City> cities=Optional.ofNullable(testDao.getCitiesByPage())
				.orElse(Collections.emptyList());
		return new PageInfo<>(cities);
	}

	@Override
	public City insertCity(City city) {
		 testDao.insertCity(city);
		 return city;
	}

	/*
	 * @Transactional--------事务控制
	 * (non-Javadoc)
	 * @see com.hqyj.demo.modules.test.service.TestService#updateCity(com.hqyj.demo.modules.test.entity.City)
	 */
	@Override
	@Transactional
	public City updateCity(City city) {
		testDao.updateCity(city);
		return city;
	}

	@Override
	public void deleteCity(int cityId) {
		testDao.deleteCity(cityId);
	}

	@Override
	public Country getCountryByCountryId3(int countryId) {
		return testDao.getCountryByCountryId3(countryId);
	}

	

}
