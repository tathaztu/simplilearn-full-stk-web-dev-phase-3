package com.simplilearn.workshop.service.product;

import java.util.List;

import com.simplilearn.workshop.domain.Product;

public interface ProductServiceIF {

	public Product getProductById(long id);

	public Product saveProduct(Product product);

	public void deleteProduct(long id);

	public List<Product> getAllProducts();
}
