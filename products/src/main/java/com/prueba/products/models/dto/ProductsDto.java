package com.prueba.products.models.dto;

import java.util.List;
import com.prueba.products.models.entity.Product;

public class ProductsDto {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
