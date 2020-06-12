package com.team9.ordermanagement.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import com.team9.ordermanagement.product.dto.ProductDTO;
import com.team9.ordermanagement.product.repository.ProductRepository;
import com.team9.ordermanagement.product.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class ProductController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping(value = "/products",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping(value = "/products/name/{productName}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getProductByName(@PathVariable String productName) {
		return productService.getProductByName(productName);
	}
	

	@GetMapping(value = "/products/id/{prodId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getProdById(@PathVariable Integer prodId) {
		return productService.getProductById(prodId);
	}
	@GetMapping(value = "/products/category/{category}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getProductByCategory(@PathVariable String category) {
		return productService.getProductByCategory(category);
	}

	@PutMapping(value="/update/{prodId}")
	public void updateProductsinStock (@PathVariable("prodId") Integer prodId, @RequestBody ProductDTO productDTO) {
		logger.info("Updating products in stock {}", productDTO);
		productService.updateProductsinStock(productDTO);
		
		
	}
	

	@PostMapping(value = "products/add/{prodId}",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addProduct(@RequestBody ProductDTO productDTO) {
		logger.info("Creation request for customer {}", productDTO);
		productService.addProductinRepo(productDTO);
	}
	@DeleteMapping(value = "products/delete/{prodId}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void removeProductfromRepo(@PathVariable Integer prodId)
	{
		productRepo.deleteById(prodId);
	}

}