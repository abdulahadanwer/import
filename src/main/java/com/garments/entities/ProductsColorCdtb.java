package com.garments.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the products_color_cdtb database table.
 * 
 */
@Entity
@Table(name="products_color_cdtb")
@NamedQuery(name="ProductsColorCdtb.findAll", query="SELECT p FROM ProductsColorCdtb p")
public class ProductsColorCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="color_cd")
	@NotNull
    @Size(min=1, max=2)
	private String colorCd;

	@Column(name="color_short_desc")
	@NotNull
	@Size(min=1, max=45)
	private String colorShortDesc;
	
	@Column(name="color_long_desc")
	@NotNull
	@Size(min=1, max=60)
	private String colorLongDesc;	
	

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productsColorCdtb")
	private List<Product> products;

	public ProductsColorCdtb() {
	}

	public String getColorCd() {
		return this.colorCd;
	}

	public void setColorCd(String colorCd) {
		this.colorCd = colorCd;
	}

	public String getColorLongDesc() {
		return this.colorLongDesc;
	}

	public void setColorLongDesc(String colorLongDesc) {
		this.colorLongDesc = colorLongDesc;
	}

	public String getColorShortDesc() {
		return this.colorShortDesc;
	}

	public void setColorShortDesc(String colorShortDesc) {
		this.colorShortDesc = colorShortDesc;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductsColorCdtb(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductsColorCdtb(null);

		return product;
	}

}