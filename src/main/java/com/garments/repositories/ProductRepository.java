package com.garments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garments.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
