package com.nexus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nexus.domain.Product;
import com.nexus.service.ProductService;



@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	/**
	 * this method is used to list the all product list.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> getProducts() {

		try {

			System.out.println("Successfully listed product list with " + productService.findAll().size() + " rows");
			return productService.findAll();

		} catch (Exception e) {
			System.err.println("Error in lising product: " + e.getMessage());
			return null;

		}

	}
	
	/**
	 * this method is used to add product.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		try {
			return productService.save(product);

		} 
		catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * this method is used to list particular product by id.
	 * 
	 * @return
	 */

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET,  headers = "Accept=application/json")
	public Product getProduct(@PathVariable("id") int id) {
		return productService.findByProductId(id);
	}
	
	
	/**
	 * this method is used to update product.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		String productId="";
		try {
			productId=String.valueOf(product.getId());
			System.out.println("Successfully updated product with id: " +productId);
			return productService.save(product);

		} catch (Exception e) {
			System.err.println("Error in updating product with id: " +productId);
			return null;

		}

	}
	
	/**
	 * this method is used to delete product.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void updateProduct(@PathVariable int id) {
		try {
			System.out.println("Successfully deleted product with id: " +id);
			productService.delete(id);

		} catch (Exception e) {
			System.err.println("Error in updating product with id: " +id);
		}

	}
	

}
