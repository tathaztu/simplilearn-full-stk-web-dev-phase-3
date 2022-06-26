package com.simplilearn.workshop.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.domain.ProductCategory;
import com.simplilearn.workshop.service.product.ProductCategoryServiceIF;

@RestController
public class ProductCategoryResource {

	@Autowired
	private ProductCategoryServiceIF productCategoryServiceIF;

	@GetMapping("/productcategory/find/{id}")
	public ProductCategory getProductCategoryById(@PathVariable("id") long longId) {
		return productCategoryServiceIF.getCategoryById(longId);
	}

	@PostMapping("/productcategory/save")
	public ProductCategory saveProductCategory(@Valid @RequestBody ProductCategory productCategory) {
		return productCategoryServiceIF.saveCategory(productCategory);
	}

	@GetMapping("/productcategory/delete/{id}")
	public void deleteProductCategory(@PathVariable("id") long id) {
		productCategoryServiceIF.deleteCategory(id);
	}

	@GetMapping("/productcategory/all")
	public List<ProductCategory> findAllProductCategories() {
		return productCategoryServiceIF.getAllCategories();
	}

}
