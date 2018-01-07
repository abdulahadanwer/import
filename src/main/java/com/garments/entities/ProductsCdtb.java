package com.garments.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the products_cdtb database table.
 * 
 */
@Entity
@Table(name="products_cdtb")
@NamedQuery(name="ProductsCdtb.findAll", query="SELECT p FROM ProductsCdtb p")
public class ProductsCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_cd")
	@NotNull
    @Size(min=1, max=2)
	private String productCd;
	
	@Column(name="product_long_desc")
	@NotNull
    @Size(min=1, max=60)
	private String productLongDesc;

	@Column(name="product_name")
	@NotNull
    @Size(min=1, max=45)
	private String productName;

	@Column(name="product_short_desc")
	@NotNull
    @Size(min=1, max=45)
	private String productShortDesc;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productsCdtb")
	private List<Product> products;

	public ProductsCdtb() {
	}

	public String getProductCd() {
		return this.productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}

	public String getProductLongDesc() {
		return productLongDesc;
	}

	public void setProductLongDesc(String productLongDesc) {
		this.productLongDesc = productLongDesc;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductShortDesc() {
		return this.productShortDesc;
	}

	public void setProductShortDesc(String productShortDesc) {
		this.productShortDesc = productShortDesc;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductsCdtb(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductsCdtb(null);

		return product;
	}

}