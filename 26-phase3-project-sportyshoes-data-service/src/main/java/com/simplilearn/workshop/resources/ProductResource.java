package com.simplilearn.workshop.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.domain.Product;
import com.simplilearn.workshop.service.product.ProductServiceIF;

@RestController
public class ProductResource {

	@Autowired
	private ProductServiceIF productServiceIF;

	@GetMapping("/product/find/{id}")
	public Product getProductById(@PathVariable("id") long longId) {
		return productServiceIF.getProductById(longId);
	}

	@PostMapping("/product/save")
	public Product saveProduct(@Valid @RequestBody Product product) {
		return productServiceIF.saveProduct(product);
	}

	@GetMapping("/product/delete/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		productServiceIF.deleteProduct(id);
	}

	@GetMapping("/product/all")
	public List<Product> findAllProducts() {
		return productServiceIF.getAllProducts();
	}
}
