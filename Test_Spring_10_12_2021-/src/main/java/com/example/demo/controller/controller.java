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
import com.example.demo.pojo.product;


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
	public List<product> getAllProduct() {
		return this.us.getAllProductService();
	}

	@PostMapping("addProduct")
	public product postProduct(@RequestBody product myProductis) {
		return this.us.createProductService(myProductis);
	}

	@GetMapping("getProductById/{id}")
	public Optional<product> getUser(@PathVariable("id") int id) {
		return this.us.getDetailsProductService(id);
	}

	@DeleteMapping("deleteProductById/{id}")
	public int deleteProduct(@PathVariable("id") int id) {
		return this.us.deleteProductService(id);
	}
	
	@PutMapping("updateProductById/{id}")
	public product updateProduct(@RequestBody product myProductis, @PathVariable("id") int id) {
		return this.us.updateProductService(myProductis, id);
	}
}
