package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.userDao;
import com.example.demo.pojo.User;
import com.example.demo.pojo.product;

@Service
public class servicesJPA {
	@Autowired
	userDao ud;
	
	public product createProductService(product myProductis) {
		return this.ud.save(myProductis);
	}
	
	public List<product> getAllProductService() {
		return this.ud.findAll();
	}
	
	public Optional<product> getDetailsProductService(int id) {
		return this.ud.findById(id);
	}
	
	public int deleteProductService(int id) {
		try {
			this.ud.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public product updateProductService(product myProductis, int id) {
		Optional<product> foundproduct = this.ud.findById(id);
		if (foundproduct.isPresent()) {
			product myProduct = foundproduct.get();
			myProduct.setProductName(myProductis.getProductName());
			myProduct.setBrandName(myProductis.getBrandName());
			return this.ud.save(myProduct);
		}
		else {
			return null;
		}
	}

}
