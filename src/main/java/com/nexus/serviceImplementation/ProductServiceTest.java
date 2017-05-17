package com.nexus.serviceImplementation;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nexus.domain.Product;
import com.nexus.repository.ProductDao;
import com.nexus.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class ProductServiceTest {
	@Mock
	private ProductDao productDao;
	
	
	ProductService productService;
	
	@Before
	public void setup(){
		productService = new ProductServiceImpl(productDao);
	}
	
	/**/
	
	@Test
	public void testNullPointer(){
		assertNotNull(productDao);
		assertNotNull(productService);
	}
	
	@Test
	public void testSave(){
		
		Product product = new Product();
		product.setName("biscuit");
		Product product1 = new Product();
		product.setId(1);
		product.setName("biscuit1");
		productService.save(product);
		productService.save(product1);
		when(productDao.findByName("biscuit")).thenReturn(product);
		assertEquals(product, productService.findByProductName("biscuit"));
		
		productService.delete(1);
		assertNull(productService.findByProductName("biscuit"));
	}

}
