package com.garments.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the socks_size_cdtb database table.
 * 
 */
@Entity
@Table(name="socks_size_cdtb")
@NamedQuery(name="SocksSizeCdtb.findAll", query="SELECT s FROM SocksSizeCdtb s")
public class SocksSizeCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="socks_size_cd")
	private String socksSizeCd;

	@Column(name="socks_size_long_desc")
	private String socksSizeLongDesc;

	@Column(name="socks_size_short_desc")
	private String socksSizeShortDesc;

	//bi-directional many-to-one association to Sock
	@OneToMany(mappedBy="socksSizeCdtb")
	private List<Sock> socks;

	public SocksSizeCdtb() {
	}

	public String getSocksSizeCd() {
		return this.socksSizeCd;
	}

	public void setSocksSizeCd(String socksSizeCd) {
		this.socksSizeCd = socksSizeCd;
	}

	public String getSocksSizeLongDesc() {
		return this.socksSizeLongDesc;
	}

	public void setSocksSizeLongDesc(String socksSizeLongDesc) {
		this.socksSizeLongDesc = socksSizeLongDesc;
	}

	public String getSocksSizeShortDesc() {
		return this.socksSizeShortDesc;
	}

	public void setSocksSizeShortDesc(String socksSizeShortDesc) {
		this.socksSizeShortDesc = socksSizeShortDesc;
	}

	public List<Sock> getSocks() {
		return this.socks;
	}

	public void setSocks(List<Sock> socks) {
		this.socks = socks;
	}

	public Sock addSock(Sock sock) {
		getSocks().add(sock);
		sock.setSocksSizeCdtb(this);

		return sock;
	}

	public Sock removeSock(Sock sock) {
		getSocks().remove(sock);
		sock.setSocksSizeCdtb(null);

		return sock;
	}

}