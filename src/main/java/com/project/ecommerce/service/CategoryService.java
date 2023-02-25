package com.project.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Category;
import com.project.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		List<Category> categoryList = categoryRepository.findAll();
		return categoryList;
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

}
