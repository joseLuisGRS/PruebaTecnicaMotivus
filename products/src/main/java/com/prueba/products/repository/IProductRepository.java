package com.prueba.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba.products.models.entity.Product;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

}
