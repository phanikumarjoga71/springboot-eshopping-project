package com.project.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.exception.ProductNotFoundException;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductRepository productRepository;
	
	public Product getProductById(int productId) {
		Optional<Product> productOptional = productRepository.findById(productId);
		if (productOptional.isPresent()) {
			LOG.info(productOptional.get().toString());
			return productOptional.get();
		} 
		else {
			String errorMessage = "Product with id " + productId + " was not found.";
			LOG.warn(errorMessage);
			throw new ProductNotFoundException(errorMessage);
		}
	}
	
	public List<Product> getAllProducts(){
		List<Product> productList = productRepository.findAll();
		LOG.info(productList.toString());
		System.out.println("Products are listed");
		return productList;
	}
	
	public Product addProduct(Product product) {
		LOG.info(product.toString());
		System.out.println("Product Added");
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) {
		LOG.info(product.toString());
		this.getProductById(product.getProductId());
		System.out.println("Product is updated");
		return productRepository.save(product);
	}
}
