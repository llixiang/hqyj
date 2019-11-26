package com.hqyj.demo.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/test/info")
	@ResponseBody
	public String testinfo(){
		return "This is a springboot";
	}

}
