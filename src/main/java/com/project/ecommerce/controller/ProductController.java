package com.project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.model.Product;
import com.project.ecommerce.service.ProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {
	
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/get-product-by-id/{eid}",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Product> getProductById(@PathVariable(name = "eid") int productId) {
		Product product = productService.getProductById(productId);
		HttpStatus status = HttpStatus.FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Product found successfully by ID!");
		ResponseEntity<Product> response = new ResponseEntity<>(product, headers, status);
		return response;
	}
	
	@RequestMapping(value = "/get-all-products",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		HttpStatus status = HttpStatus.FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Product found successfully!");
		ResponseEntity<List<Product>> response = new ResponseEntity<>(productList, headers, status);
		return response;
	}
	
	@RequestMapping(value="/add-product",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		HttpStatus status = HttpStatus.FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Product added successfully!");
		ResponseEntity<Product> response = new ResponseEntity<>(productService.addProduct(product), headers, status);
		return response;
	}
	
	@RequestMapping(value="/update-product",method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		HttpStatus status = HttpStatus.FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Product updated successfully!");
		ResponseEntity<Product> response = new ResponseEntity<>(productService.updateProduct(product), headers, status);
		return response;
	}
}
