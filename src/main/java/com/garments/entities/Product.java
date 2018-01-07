package com.garments.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int productId;

	@Temporal(TemporalType.DATE)
	@Column(name="cret_date")
	private Date cretDate;

	@Column(name="cret_uid")
	private String cretUid;

	@Column(name="included_year")
	private int includedYear;

	@Column(name="price_per_unit")
	private float pricePerUnit;

	@Column(name="total_items")
	private int totalItems;

	//bi-directional many-to-one association to ProductsCdtb
	@ManyToOne
	@JoinColumn(name="product_cd")
	private ProductsCdtb productsCdtb;

	//bi-directional many-to-one association to ProductsColorCdtb
	@ManyToOne
	@JoinColumn(name="color_cd")
	private ProductsColorCdtb productsColorCdtb;

	//bi-directional many-to-one association to Sock
	@OneToMany(mappedBy="product")
	private List<Sock> socks;

	//bi-directional many-to-one association to SexCdtb
	@ManyToOne
	@JoinColumn(name="sex_cd")
	private SexCdtb sexCdtb;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getCretDate() {
		return this.cretDate;
	}

	public void setCretDate(Date cretDate) {
		this.cretDate = cretDate;
	}

	public String getCretUid() {
		return this.cretUid;
	}

	public void setCretUid(String cretUid) {
		this.cretUid = cretUid;
	}

	public int getIncludedYear() {
		return this.includedYear;
	}

	public void setIncludedYear(int includedYear) {
		this.includedYear = includedYear;
	}

	public float getPricePerUnit() {
		return this.pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public int getTotalItems() {
		return this.totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public ProductsCdtb getProductsCdtb() {
		return this.productsCdtb;
	}

	public void setProductsCdtb(ProductsCdtb productsCdtb) {
		this.productsCdtb = productsCdtb;
	}

	public ProductsColorCdtb getProductsColorCdtb() {
		return this.productsColorCdtb;
	}

	public void setProductsColorCdtb(ProductsColorCdtb productsColorCdtb) {
		this.productsColorCdtb = productsColorCdtb;
	}

	public List<Sock> getSocks() {
		return this.socks;
	}

	public void setSocks(List<Sock> socks) {
		this.socks = socks;
	}

	public Sock addSock(Sock sock) {
		getSocks().add(sock);
		sock.setProduct(this);

		return sock;
	}

	public Sock removeSock(Sock sock) {
		getSocks().remove(sock);
		sock.setProduct(null);

		return sock;
	}

	public SexCdtb getSexCdtb() {
		return this.sexCdtb;
	}

	public void setSexCdtb(SexCdtb sexCdtb) {
		this.sexCdtb = sexCdtb;
	}

}