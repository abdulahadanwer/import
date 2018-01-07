package com.garments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garments.entities.ProductsCdtb;

public interface ProductsCdtbRepository extends JpaRepository<ProductsCdtb, String>{
	
	public ProductsCdtb findByProductCd(String productCd);
	
}
