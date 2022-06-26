package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simplilearn.workshop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Modifying
	@Query(value = "UPDATE PRODUCT SET CATEGORY_ID = 0 WHERE CATEGORY_ID = :categoryId", nativeQuery = true)
	void uncategorizeProductById(@Param("categoryId") long categoryId);
}
