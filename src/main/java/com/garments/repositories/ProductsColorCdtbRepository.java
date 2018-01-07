package com.garments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garments.entities.ProductsColorCdtb;

public interface ProductsColorCdtbRepository extends JpaRepository<ProductsColorCdtb, String>{
	
	public ProductsColorCdtb findByColorCd(String colorCd);
	
}
