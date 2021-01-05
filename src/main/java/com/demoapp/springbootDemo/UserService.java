package com.demoapp.springbootDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	// List<LoginInfo> LiList = new ArrayList<>();

	public boolean loginValid(String uname, String pass) {
		if (userDao.count() == 0) {
			System.out.println("list is empty");
			return false;
		}

		for (LoginInfo li : userDao.findAll()) {
			String liUname = li.getUname();
			String liPass = li.getPassword();
			if (liUname.equals(uname) && liPass.equals(pass)) {
				System.out.println("Found credentials in database. Username : " + uname);
				return true;
			}
		}
		return false;
	}

	public boolean registerValid(String uname, String pass, String email, String city) {
		LoginInfo newLogInfo = new LoginInfo();

		if ((!uname.equals(null) && !pass.equals(null) && !email.equals(null) && !city.equals(null))) {
			newLogInfo.setUname(uname);
			newLogInfo.setPassword(pass);
			newLogInfo.setEmail(email);
			newLogInfo.setCity(city);
		} else {
			System.out.println("null input detected");
			return false;
		}

		if (userDao.count() > 0) { // size is greater than 1
			for (LoginInfo li : userDao.findAll()) {
				System.out.println(li);
				String liUname = li.getUname();
				String liEmail = li.getEmail();
				System.out.println(liUname + " " + liEmail + " iterating List");
				if (uname.equals(liUname) || email.equals(liEmail)) {
					return false;
				}
			}
			// LiList.add(newLogInfo);

			userDao.save(newLogInfo);
			System.out.println(newLogInfo);
			System.out.println("list has : " + userDao.count() + " credentials");
			return true;
		} else { // size is 0
			userDao.save(newLogInfo);
			// LiList.add(newLogInfo);
			System.out.println(newLogInfo);
			System.out.println("list has : " + userDao.count() + " credentials");
			return true;
		}

	}

	public List<LoginInfo> loadUserInfo() {
		List<LoginInfo> li = (List<LoginInfo>) userDao.findAll();

		return li;

	}

	public boolean findUser(String uname) {
		
		Optional<LoginInfo> logi = userDao.findById(uname);
		if (logi.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateUser(String uname, String email) {
		Optional<LoginInfo> logi = userDao.findById(uname);
		if (logi.isPresent()) {
			LoginInfo login = userDao.findById(uname).get();
			login.setEmail(email);
			userDao.save(login);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteUser(String uname) {
		if (this.findUser(uname)) {
			userDao.deleteById(uname);
			return true;
		}
		return false;
	}

}
