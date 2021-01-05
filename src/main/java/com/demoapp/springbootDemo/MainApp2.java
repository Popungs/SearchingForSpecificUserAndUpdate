package com.demoapp.springbootDemo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// RestController -> makes every method in this class to have requestBody
@RequestMapping("/main")
public class MainApp2 {
	@Autowired
	private UserService userService;
	
	//@RequestMapping(value ="/login", method = RequestMethod.POST)
	@PostMapping("/login")
	public String loginValid(@RequestParam("uname") String name, @RequestParam("pass") String pass) {
		if (userService.loginValid(name, pass)) {
			return "login successful";
		}
		return "login failed : Invalid Credentials";
	}
	
	//@RequestMapping(value ="/registration", method = RequestMethod.POST)
	@PostMapping("/registration")
	public String registrationValid(@RequestParam("uname") String name,
			@RequestParam("pass") String pass,
			@RequestParam("email") String email,
			@RequestParam("city") String city) {
		if (userService.registerValid(name,pass,email,city)) {
			return "registration successful";
		}
		return "registration failed it could be : same username or email already exists, or null input detected";
	}
	
	@GetMapping("/loadusers")
	public List<LoginInfo> load() {
		return userService.loadUserInfo();
	}
	@GetMapping("/finduser/{name}")
	public String findUser(@PathVariable("name") String name) {
		if (userService.findUser(name)) {
			return "user found!";
		}
		return "user not found!";
	}
	
	@GetMapping("/updateuser/{name}/{email}")
	public String updateUser(@PathVariable("name") String name, @PathVariable("email") String email) {
		if (userService.updateUser(name,email)) {
			return "user updated";
		}
		return "user NOT updated";
	}
	
	@GetMapping("/deleteuser/{name}")
	public String deleteUser(@PathVariable("name") String name) {
		if (userService.deleteUser(name))
			return "user deleted";
		
		return "user NOT deleted";
	}
	
}
