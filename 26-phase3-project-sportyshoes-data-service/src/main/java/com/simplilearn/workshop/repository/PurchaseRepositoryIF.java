package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.domain.Purchase;

public interface PurchaseRepositoryIF extends JpaRepository<Purchase, Long>{

	// Get Purchase by ID

	// Get All Purchases

	// Get All Purchases by User ID
	List<Purchase> findByStrUserId(String strUserId);

	// Save
}
