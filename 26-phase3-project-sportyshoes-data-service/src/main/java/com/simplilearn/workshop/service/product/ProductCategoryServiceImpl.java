package com.simplilearn.workshop.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.workshop.domain.ProductCategory;
import com.simplilearn.workshop.repository.ProductCategoryRepository;
import com.simplilearn.workshop.repository.ProductRepository;

@Service(value = "Product Category Service")
public class ProductCategoryServiceImpl implements ProductCategoryServiceIF {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductCategory getCategoryById(long id) {
		return productCategoryRepository.findById(id).get();
	}

	@Override
	public ProductCategory saveCategory(ProductCategory productCategory) {
		productCategoryRepository.save(productCategory);
		return productCategory;
	}

	@Transactional
	@Override
	public void deleteCategory(long id) {
		productRepository.uncategorizeProductById(id);
		productCategoryRepository.deleteById(id);
	}

	@Override
	public List<ProductCategory> getAllCategories() {
		return productCategoryRepository.findAll();
	}
}
