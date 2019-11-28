package com.hqyj.demo.modules.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.demo.modules.test.entity.City;
import com.hqyj.demo.modules.test.entity.Country;
import com.hqyj.demo.modules.test.service.impl.TestServiceImpl;
import com.hqyj.demo.modules.test.vo.ApplicationConfigTestBean;

/**
 * 测试类控制器
 * @author Li Xiang
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private ApplicationConfigTestBean applicationConfigTestBean;
	@Autowired
	TestServiceImpl testServiceImpl;
	
	private final static Logger LOGGER=LoggerFactory.getLogger(TestController.class);
	
	@DeleteMapping(value="/city/{cityId}")
	@ResponseBody
	public void deleteCity(@PathVariable int cityId){
		testServiceImpl.deleteCity(cityId);
	}
	
	/**
	 * form表单方式提交   
	 * 接收form表单用@ModelAttribute
	 * update用put
	 * @param city
	 * @return
	 */
	@PutMapping(value="/city",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public City updateCity(@ModelAttribute City city){
		return testServiceImpl.updateCity(city);
		
	}
	
	
	/**
	 * json格式提交
	 * insert用post
	 * 接受前台传过来的json格式用@RequestBody  
	 * @param city
	 * @return
	 */
	@PostMapping(value="/city",consumes="application/json")
	@ResponseBody
	public City insertCity(@RequestBody City city){
		return testServiceImpl.insertCity(city);
		
	}
	
	@RequestMapping("/cities/{currentPage}/{pageSize}")
	@ResponseBody
	public PageInfo<City> getCitiesByPage(@PathVariable int currentPage,@PathVariable int pageSize){
		return testServiceImpl.getCitiesByPage(currentPage, pageSize);
		
	}
	
	/**
	 * 根据国家id查询所有城市
	 * @PathVariable --- 获取url路径上的参数
	 */
	@RequestMapping("/cities/{countryId}")
	@ResponseBody
	public List<City> getCitiesByCountryid(@PathVariable int countryId){
		return testServiceImpl.getCitiesByCountryId(countryId);
		
	}
	
	/**
	 * 根据国家id查询国家
	 * @param countryId
	 * @return
	 */
	@RequestMapping("/country/{countryId}")
	@ResponseBody
	public Country getCountryByCountryId(@PathVariable int countryId){
		return testServiceImpl.getCountryByCountryId(countryId);
	}
	
	/**
	 * 根据国家id查询国家信息（包括国家所包含城市）
	 * @param countryId
	 * @return
	 */
	@RequestMapping("/country2/{countryId}")
	@ResponseBody
	public Country getCountryByCountryId2(@PathVariable int countryId){
		return testServiceImpl.getCountryByCountryId2(countryId);
		
	}
	
	@RequestMapping("/country3/{countryId}")
	@ResponseBody
	public Country getCountryByCountryId3(@PathVariable int countryId){
		return testServiceImpl.getCountryByCountryId2(countryId);
		
	}
	
	/**
	 * 根据国家名字查询国家信息（包括国家所包含城市）
	 * @param countryName
	 * @return
	 */
	@RequestMapping("/country")
	@ResponseBody
	public Country getCountryByCountryName(@RequestParam String countryName) {
		return testServiceImpl.getCountryByCountryName(countryName);
		
	}
	
	@PostMapping("/post")
	@ResponseBody
	public String postTest(){
		return "This is a post interface";
	}
	
	// 针对 application.properties文件，直接使用@Value注解获得属性值
	@Value("${server.port}") 
	private int port; 
	@Value("${com.hqyj.name}") 
	private String name; 
	@Value("${com.hqyj.age}") 
	private int age; 
	@Value("${com.hqyj.description}") 
	private String description; 
	@Value("${com.hqyj.random}") 
	private String random;
	
	// 针对其他配置文件，注入其对应的配置类 
		@Autowired 
		private ApplicationConfigTestBean configTestBean;
		
		
	@RequestMapping("/config") 
	@ResponseBody 
	public String getConfig() { 
		StringBuffer sb = new StringBuffer(); 
		sb.append(port) 
		.append("‐‐‐‐").append(name) 
		.append("‐‐‐‐").append(age).append("‐‐‐‐") 
		.append(description).append("‐‐‐‐") 
		.append(random).append("</br>"); 
		sb.append(configTestBean.getName()) 
		.append("‐‐‐‐").append(configTestBean.getAge()) 
		.append("‐‐‐‐").append(configTestBean.getDescription())
		.append("‐‐‐‐").append(configTestBean.getRandom()).append("</br>");
		return sb.toString(); 
		}
	
		
	
		@RequestMapping("/log") 
		@ResponseBody 
		public String logTest() { 
			LOGGER.trace("This is trace log."); 
			LOGGER.debug("This is debug log."); 
			LOGGER.info("This is info log."); 
			LOGGER.warn("This is warn log."); 
			LOGGER.error("This is error log."); 
			return "This is log test.88882"; 
			} 
		
	
	@RequestMapping("/info")
	@ResponseBody
	public String testinfo(){
		return "This is a springboot";
	}

}
