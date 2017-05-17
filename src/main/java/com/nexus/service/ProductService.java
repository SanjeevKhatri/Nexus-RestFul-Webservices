package com.nexus.service;

import java.util.List;

import com.nexus.domain.Product;


public interface ProductService {
	Product save(Product product);

	void delete(int productId);

	Product findByProductName(String productName);

	List<Product> findAll();

	Product findByProductId(int productId);
}
