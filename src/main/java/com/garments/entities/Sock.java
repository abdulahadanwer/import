package com.garments.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the socks database table.
 * 
 */
@Entity
@Table(name="socks")
@NamedQuery(name="Sock.findAll", query="SELECT s FROM Sock s")
public class Sock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sock_id")
	private int sockId;

	@Column(name="is_sold")
	private String isSold;

	@Lob
	@Column(name="sock_image")
	private byte[] sockImage;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to SocksSizeCdtb
	@ManyToOne
	@JoinColumn(name="socks_size_cd")
	private SocksSizeCdtb socksSizeCdtb;

	//bi-directional many-to-one association to SocksTypeCdtb
	@ManyToOne
	@JoinColumn(name="socks_type_id")
	private SocksTypeCdtb socksTypeCdtb;

	public Sock() {
	}

	public int getSockId() {
		return this.sockId;
	}

	public void setSockId(int sockId) {
		this.sockId = sockId;
	}

	public String getIsSold() {
		return this.isSold;
	}

	public void setIsSold(String isSold) {
		this.isSold = isSold;
	}

	public byte[] getSockImage() {
		return this.sockImage;
	}

	public void setSockImage(byte[] sockImage) {
		this.sockImage = sockImage;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SocksSizeCdtb getSocksSizeCdtb() {
		return this.socksSizeCdtb;
	}

	public void setSocksSizeCdtb(SocksSizeCdtb socksSizeCdtb) {
		this.socksSizeCdtb = socksSizeCdtb;
	}

	public SocksTypeCdtb getSocksTypeCdtb() {
		return this.socksTypeCdtb;
	}

	public void setSocksTypeCdtb(SocksTypeCdtb socksTypeCdtb) {
		this.socksTypeCdtb = socksTypeCdtb;
	}

}