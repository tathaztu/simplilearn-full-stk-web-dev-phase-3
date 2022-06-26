package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.domain.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {


	// Find By ID - provided
	//
	// Insert - provided
	// Update
	//
	// [Unassign Product from Category]
	// Delete Category
	//
	// Find All
	//
}
