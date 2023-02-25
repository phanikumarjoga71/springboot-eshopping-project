package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
	
}
