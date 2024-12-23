package com.prueba.products.services.impl;

import java.time.LocalDate;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.prueba.products.exceptions.GenericException;
import com.prueba.products.models.dto.ProductDto;
import com.prueba.products.models.dto.ProductsDto;
import com.prueba.products.models.entity.Product;
import com.prueba.products.repository.IProductRepository;
import com.prueba.products.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	private IProductRepository productRepository;
	private ModelMapper modelMapper;
	
	public ProductServiceImpl(IProductRepository productRepository, ModelMapper modelMapper) {
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public ProductsDto getProducts() {
		ProductsDto products = new ProductsDto();
		products.setProducts(this.productRepository.findAll());
		if(products.getProducts().isEmpty()) {
			throw new GenericException("No products found", "No content", 204);
		}
		return products;		
	}

	@Override
	public ProductDto saveProduct(ProductDto productdto) {
		Product newProduct;
		try {
			newProduct = modelMapper.map(productdto, Product.class);
			newProduct.setFechaCreacion(LocalDate.now());
			newProduct = this.productRepository.save(newProduct);			
		} catch(DataAccessException e) {
			throw new GenericException(e.getMessage(), "Error saving product", 400);
		}
		return modelMapper.map(newProduct, ProductDto.class);
	}

	@Override
	public ProductDto getProduct(Integer id) {
		Optional<Product> product = this.productRepository.findById(id);
		if(!product.isPresent()) {
			throw new GenericException("No product found", "We don't", 404);
		}
		return modelMapper.map(product.get(), ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(Integer id, ProductDto productDto) {
		ProductDto productDtoC = this.getProduct(id);
		Product product;
		try {
			product = modelMapper.map(productDtoC, Product.class);
			product.setNombre(productDto.getNombre());
			product.setDescripcion(productDto.getDescripcion());
			product.setPrecio(productDto.getPrecio());
			product = this.productRepository.save(product);
		} catch(DataAccessException e) {
			throw new GenericException(e.getMessage(), "Error saving product", 400);
		}
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public String deleteProduct(Integer id) {
		String message = "successful removal";
		try {
			this.getProduct(id);
			this.productRepository.deleteById(id);
		}
		catch (Exception e) {
			message = "remove error";
			throw new GenericException(e.getMessage(), message, 404);
		}
		return message;
	}
	
}
