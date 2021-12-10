package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.userDao;
import com.example.demo.pojo.User;

@Service
public class servicesJPA {
	@Autowired
	userDao ud;
	
	public User createUserService(User newuser) {
		return this.ud.save(newuser);
	}
	
	public List<User> getAllUsersService() {
		return this.ud.findAll();
	}
	
	public Optional<User> getDetailsService(int id) {
		return this.ud.findById(id);
	}
	
	public int deleteUserService(int id) {
		try {
			this.ud.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public User updateUserService(User user, int id) {
		Optional<User> foundUser = this.ud.findById(id);
		if (foundUser.isPresent()) {
			User myUser = foundUser.get();
			myUser.setName(user.getName());
			myUser.setEmail(user.getEmail());
			myUser.setPhone(user.getPhone());
			myUser.setAddress(user.getAddress());
			return this.ud.save(myUser);
		}
		else {
			return null;
		}
	}

}
