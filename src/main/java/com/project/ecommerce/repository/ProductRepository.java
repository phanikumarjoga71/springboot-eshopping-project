package com.project.ecommerce.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	@Autowired
	//custom defined query
	public abstract List<Product> findByCategory(int categoryId);

}
