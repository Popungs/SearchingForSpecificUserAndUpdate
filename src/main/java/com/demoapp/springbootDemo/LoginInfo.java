package com.demoapp.springbootDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginInfo {
	@Id
	private String uname;
	
	private String password;
	private String email;
	private String city;
	public String getUname() {
		return uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public LoginInfo(String uname, String password, String email, String city) {
		super();
		this.uname = uname;
		this.password = password;
		this.email = email;
		this.city = city;
	}
	public LoginInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginInfo [uname=" + uname + ", password=" + password + ", email=" + email + ", city=" + city + "]";
	}
	
}
