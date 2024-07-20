package com.springData.Jpa.SpringJpa;

import com.springData.Jpa.SpringJpa.Repositries.ProductRepositories;
import com.springData.Jpa.SpringJpa.entites.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
@SpringBootTest
class SpringJpaApplicationTests {
	@Autowired
	ProductRepositories productRepositories;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepositry(){
		Products products= Products.builder()
				.sku("test124")
				.price(BigDecimal
						.valueOf(123.67))
				.quantity(34)
				.build();
		Products saveProduct=productRepositories.save(products);
		System.out.println(saveProduct);
	}

	@Test
	void  getRepo(){
		List<Products> entites=productRepositories.findAll();
		System.out.println(entites);
	}

}
