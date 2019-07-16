package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Products;

@Repository

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
