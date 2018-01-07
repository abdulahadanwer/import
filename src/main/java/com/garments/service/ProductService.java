package com.garments.service;

import java.util.List;

import com.garments.entities.Product;
import com.garments.entities.ProductsCdtb;
import com.garments.entities.ProductsColorCdtb;

public interface ProductService {
	
	public List<ProductsColorCdtb> findAllProductColors();
	
	public ProductsColorCdtb findByColorCd(String colorCd);
	
	public ProductsColorCdtb saveColorCd(ProductsColorCdtb productsColorCdtb);
	
	public List<ProductsCdtb> findAllProducts();
	
	public ProductsCdtb findByProductCd(String productCd);
	
	public ProductsCdtb saveProduct(ProductsCdtb productsCdtb);
}
