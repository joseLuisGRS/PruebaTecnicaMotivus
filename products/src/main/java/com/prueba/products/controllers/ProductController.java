package com.prueba.products.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.products.models.dto.ProductDto;
import com.prueba.products.models.dto.ProductsDto;
import com.prueba.products.services.IProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	private IProductService productService;
	
	public ProductController(IProductService productService) {
		this.productService = productService;
	}

	@GetMapping()
	public ResponseEntity<ProductsDto> getProducts() {
		return ResponseEntity.ok().body(this.productService.getProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable Integer id) {
		return ResponseEntity.ok().body(this.productService.getProduct(id));
	}
	
	@PostMapping("/save")
	public ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto product){
		return new ResponseEntity<ProductDto>(this.productService.saveProduct(product),
				HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id, 
			@Valid @RequestBody ProductDto product){
		return new ResponseEntity<ProductDto>(this.productService.updateProduct(id,product),
				HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
		return new ResponseEntity<String>(this.productService.deleteProduct(id),
				HttpStatus.OK);
	}
	
}
