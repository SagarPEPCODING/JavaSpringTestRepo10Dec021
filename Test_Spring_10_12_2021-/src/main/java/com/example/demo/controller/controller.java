package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.servicesJPA;
import com.example.demo.pojo.User;


@RestController
@RequestMapping("user")
public class controller {
	@Autowired
	servicesJPA us;
	
	@GetMapping("/")
	public String defaultGetRoute() {
		return "Welcome! server is working...";
	}

	public static void main(String[] args) {
		System.out.println("sagar sharma");
	}

	@GetMapping("all")
	public List<User> getAllUser() {
		return this.us.getAllUsersService();
	}

	@PostMapping("addUser")
	public User postUser(@RequestBody User useris) {
		return this.us.createUserService(useris);
	}

	@GetMapping("getUserById/{id}")
	public Optional<User> getUser(@PathVariable("id") int id) {
		return this.us.getDetailsService(id);
	}

	@DeleteMapping("deleteUserById/{id}")
	public int deleteUser(@PathVariable("id") int id) {
		return this.us.deleteUserService(id);
	}
	
	@PutMapping("updateUserById/{id}")
	public User updateUser(@RequestBody User useris, @PathVariable("id") int id) {
		return this.us.updateUserService(useris, id);
	}
}
