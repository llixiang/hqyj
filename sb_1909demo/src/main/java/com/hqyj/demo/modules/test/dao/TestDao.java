package com.hqyj.demo.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.demo.modules.test.entity.City;
import com.hqyj.demo.modules.test.entity.Country;
/**
 * test dao
 * @author Li Xiang
 *
 */
@Repository
@Mapper
public interface TestDao {
	
	/**
	 * select all cities by countryid
	 * @param countryId
	 * @return
	 */
	@Select("select * from m_city where m_city.country_id=#{countryId}")
	List<City> getCitiesByCountryId(int countryId);
	
	/**
	 * select country by countryid
	 * @param countryId
	 * @return
	 */
	@Select("select * from m_country where country_id=#{countryId}")
	Country getCountryByCountryId(int countryId);
	
	/**
	 * select all cities and country by countryid
	 * @param countryId
	 * @return
	 * @Results ---- 封装结果集，对于联表查询的字段，可调用已有的方法getCitiesByCountryId
	 * column ---- 对应 select 查询后的某个字段名，作为映射实体bean属性 或者 作为调用方法的参数
	 * property ---- 对应 实体 bean 属性
	 * 1、country_id封装了两次，分别对应countryId和cities，而cities属性通过getCitiesByCountryId方法来实现，country_id作为参数
	 * 2、结果集共享，设置id属性，调用是使用@ResultMap(value="countryResult")
	 */
	@Select("select * from m_country where country_id=#{countryId}")
	@Results(id="countryResult",value={
			@Result(column="country_id",property="countryId"),
			@Result(column="country_id",property="cities",
			javaType=List.class,
			many=@Many(select="com.hqyj.demo.modules.test.dao.TestDao.getCitiesByCountryId"))
	})
	Country getCountryByCountryId2(int countryId);
	
	Country getCountryByCountryId3(int countryId);
	
	/**
	 * select all cities and country by countryname
	 * @param countryName
	 * @return
	 */
	@Select("select * from m_country where m_country.country_name=#{countryName}")
	@ResultMap(value="countryResult")
	Country getCountryByCountryName(String countryName);

	/**
	 * select cities by page
	 * @return
	 * @Options----配置属性值
	 * useGeneratedKeys------采用生成的key（主键）=true,表示已经插入的主键值
	 */
	@Select("select * from m_city")
	List<City> getCitiesByPage();
	
	@Insert("insert into m_city(city_name,local_city_name,country_id,date_created) "
			+ "values "
			+ "(#{cityName},#{localCityName},#{countryId},#{dateCreated})")
	@Options(useGeneratedKeys=true,keyColumn="city_id",keyProperty="cityId")
	void insertCity(City city);
	
	@Update("update m_city set local_city_name=#{localCityName} where city_id=#{cityId}")
	void updateCity(City city);
	
	@Delete("delete from m_city where city_id=#{cityId}")
	void deleteCity(int cityId);
}

