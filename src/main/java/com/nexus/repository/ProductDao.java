package com.nexus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexus.domain.Product;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	Product findByName(String productName);

	Product findById(int productId);

	List<Product> findAll();
}
