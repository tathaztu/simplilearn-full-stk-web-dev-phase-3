package com.simplilearn.workshop.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Product;
import com.simplilearn.workshop.repository.ProductRepository;

@Service(value = "Product Service")
public class ProductServiceImpl implements ProductServiceIF {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductById(long id) {

		Optional<Product> optProduct = productRepository.findById(id);
		return optProduct.isPresent()? optProduct.get() : null;
	}

	@Override
	public Product saveProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
