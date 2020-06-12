package com.team9.ordermanagement.product.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team9.ordermanagement.product.dto.ProductDTO;
import com.team9.ordermanagement.product.entity.Product;
import com.team9.ordermanagement.product.repository.ProductRepository;

@Service
public class ProductService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductRepository productRepo;
	
	

		public List<ProductDTO> getAllProducts() {
			List<Product> products = productRepo.findAll();
			List<ProductDTO> productDTOs = new ArrayList<>();
			for (Product product : products) {
				ProductDTO productDTO=ProductDTO.valueOf(product);
				productDTOs.add(productDTO);
			}
			return productDTOs;

		}

	
	public ProductDTO getProductByName(String productName) {
		ProductDTO productDTO=null;
		List<Product> products= productRepo.findAll();
		
		
		for(Product product : products) {
			if(product.getProductName().equals(productName)) {
			productDTO=productDTO.valueOf(product);
			}
			
		}
		
			
		
		return productDTO;
	}
			

	
	public ProductDTO getProductByCategory(String category) {
		ProductDTO productDTO=null;
		List<Product> products = productRepo.findAll();
		
		
		for(Product product : products) {
			if(product.getCategory().equals(category)) {
			productDTO=productDTO.valueOf(product);
			}
			
		}
			
			
		
		return productDTO;
	}

	public void updateProductsinStock(ProductDTO productDTO) {
		logger.info("Updating products in stock {}", productDTO);
		ProductDTO productDTO1=productDTO;
		Product product=productDTO1.createEntity();
		productRepo.save(product);
		
		
	}

	public void addProductinRepo(ProductDTO productDTO) {
		
		Product product =productDTO.createEntity();
		productRepo.save(product);
		
		
	}
	
	public ProductDTO getProductById(Integer prodId) {
		
			ProductDTO productDTO=null;
			List<Product> products= productRepo.findAll();
			
			
			for(Product product : products) {
				if(product.getProdId().equals(prodId)) {
				productDTO=productDTO.valueOf(product);
				}
				
			}
			
			return productDTO;
		
	}




}
