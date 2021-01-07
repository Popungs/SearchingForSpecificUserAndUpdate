package com.demoapp.springbootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/main")
public class MainApp {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value ="/updateuser", method = RequestMethod.GET)
	public String updateuser() {
		return "updateuser";
	}
	@RequestMapping(value ="/navigation", method = RequestMethod.GET)
	public String navigation() {
		return "navigation";
	}

	
	
	
	
	@RequestMapping(value ="/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}

	@RequestMapping(value ="/hi", method = RequestMethod.GET)
	@ResponseBody
	public String sayHi() {
		return "welcome!!!!";
	}
}
