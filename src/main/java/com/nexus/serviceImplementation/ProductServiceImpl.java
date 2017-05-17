package com.nexus.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexus.domain.Product;
import com.nexus.repository.ProductDao;
import com.nexus.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public ProductServiceImpl(ProductDao productDao){
		this.productDao = productDao;
	}

	@Override
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	public void delete(int productId) {
		productDao.delete(productId);
	}

	@Override
	public Product findByProductName(String productName) {
		return productDao.findByName(productName);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product findByProductId(int productId) {
		return productDao.findById(productId);
	}

}
