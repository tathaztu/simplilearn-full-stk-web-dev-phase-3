package com.simplilearn.workshop.service.product;

import java.util.List;

import com.simplilearn.workshop.domain.ProductCategory;

public interface ProductCategoryServiceIF  {

	public ProductCategory getCategoryById(long id);

	public ProductCategory saveCategory(ProductCategory productCategory);

	public void deleteCategory(long id);

	public List<ProductCategory> getAllCategories();

}
