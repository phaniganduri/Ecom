package com.ecom.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Service;

import com.ecom.entity.Product;
import com.ecom.repo.ProductRepo;
@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;

	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	public List<Product> getAllProducts() {	
		return repo.findAll();
	}
	public Product findProductById(int id) {
		return repo.findById(id).orElse(new Product());
	}
	public void deleteProductById(int id) {
		repo.deleteById(id);
	}
}
