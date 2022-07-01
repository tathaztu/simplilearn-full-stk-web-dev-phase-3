package com.simplilearn.workshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.domain.ProductCategory;


@Controller
public class ProductCategoryController {

	private static final String BASE_URL = "http://localhost:8080/productcategory";

	private RestTemplate restTemplate;

	@Autowired
	public ProductCategoryController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	@GetMapping(path="/productcategory/list")
	public ModelAndView listOfProductCategories() {
		ResponseEntity<List<ProductCategory>> responseEntity =
			restTemplate.exchange(
				BASE_URL + "/all",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<ProductCategory>>() {}
			);

		ModelAndView modelAndView = new ModelAndView("list-product-categories");
		modelAndView.addObject("prodCategories", responseEntity.getBody());

		return modelAndView;
	}

	@GetMapping(path="/productcategory/add")
	public ModelAndView addProductCategory() {
		ModelAndView modelAndView = new ModelAndView("product-category-form");
		modelAndView.addObject("productCategory", (new ProductCategory()));
		modelAndView.addObject("pageHeader", "Add Product Category");

		return modelAndView;
	}

	@PostMapping(path="/productcategory/save")
	public ModelAndView saveProductCategory(@ModelAttribute("productCategory") ProductCategory productCategory) {
		restTemplate.postForObject(BASE_URL + "/save", productCategory, ProductCategory.class);
		ModelAndView modelAndView = new ModelAndView("redirect:/productcategory/list");
		return modelAndView;
	}

	@GetMapping(path = "/productcategory/update")
	public ModelAndView showFormForUpdateTodos(@RequestParam("prodCategoryId") Long theId, Model theModel) {

		Map<String, Long> params = new HashMap<>();
		params.put("id", theId);

		ProductCategory productCategory = restTemplate.getForObject(BASE_URL + "/find/{id}", ProductCategory.class, params);
		theModel.addAttribute("productCategory", productCategory);
		theModel.addAttribute("pageHeader", "Edit Product Category");
		return new ModelAndView("product-category-form");
	}


	@GetMapping(path = "/productcategory/delete")
	public ModelAndView deleteTodo(@RequestParam("prodCategoryId") Long theId) {
		restTemplate.delete(BASE_URL + "/delete/" + theId);

		ModelAndView modelAndView = new ModelAndView("redirect:/productcategory/list");
		return modelAndView;
	}

}
