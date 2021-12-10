package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.User;
import com.example.demo.pojo.product;

public interface userDao extends JpaRepository<product, Integer>{

}
