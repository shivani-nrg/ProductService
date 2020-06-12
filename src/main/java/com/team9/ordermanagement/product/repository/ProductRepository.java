package com.team9.ordermanagement.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team9.ordermanagement.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> getByProductName(String category);
	
}
