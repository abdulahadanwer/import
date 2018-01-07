package com.garments.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sex_cdtb database table.
 * 
 */
@Entity
@Table(name="sex_cdtb")
@NamedQuery(name="SexCdtb.findAll", query="SELECT s FROM SexCdtb s")
public class SexCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sex_cd")
	private String sexCd;

	@Column(name="sex_long_desc")
	private String sexLongDesc;

	@Column(name="sex_short_desc")
	private String sexShortDesc;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="sexCdtb")
	private List<Product> products;

	public SexCdtb() {
	}

	public String getSexCd() {
		return this.sexCd;
	}

	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}

	public String getSexLongDesc() {
		return this.sexLongDesc;
	}

	public void setSexLongDesc(String sexLongDesc) {
		this.sexLongDesc = sexLongDesc;
	}

	public String getSexShortDesc() {
		return this.sexShortDesc;
	}

	public void setSexShortDesc(String sexShortDesc) {
		this.sexShortDesc = sexShortDesc;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSexCdtb(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSexCdtb(null);

		return product;
	}

}