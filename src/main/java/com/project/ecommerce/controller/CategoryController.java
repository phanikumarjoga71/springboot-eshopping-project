package com.project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.model.Category;
import com.project.ecommerce.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/get-all-categories", method=  RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> categoryList = categoryService.getAllCategories();
		HttpStatus status = HttpStatus.FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Category was found successfully!");
		ResponseEntity<List<Category>> response = new ResponseEntity<>(categoryList,headers,status);
		return response;
	}
	
	@RequestMapping(value = "/add-category", method = RequestMethod.POST, produces = "application/json", consumes = "application/json" )
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category cat = categoryService.addCategory(category);
		HttpStatus status = HttpStatus.FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Category was added successfuly");
		ResponseEntity<Category> response = new ResponseEntity<>(cat,headers,status);
		return response;
	}
	
}
