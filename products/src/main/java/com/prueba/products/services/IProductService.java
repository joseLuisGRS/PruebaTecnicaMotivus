package com.prueba.products.services;

import com.prueba.products.models.dto.ProductDto;
import com.prueba.products.models.dto.ProductsDto;

public interface IProductService {

	ProductsDto getProducts();
	ProductDto getProduct(Integer id);
	ProductDto saveProduct(ProductDto product);
	ProductDto updateProduct(Integer id,ProductDto product);
	String deleteProduct(Integer id);
}
