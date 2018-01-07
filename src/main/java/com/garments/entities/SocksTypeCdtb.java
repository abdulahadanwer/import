package com.garments.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the socks_type_cdtb database table.
 * 
 */
@Entity
@Table(name="socks_type_cdtb")
@NamedQuery(name="SocksTypeCdtb.findAll", query="SELECT s FROM SocksTypeCdtb s")
public class SocksTypeCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="socks_type_id")
	private int socksTypeId;

	@Column(name="socks_type_long_desc")
	private String socksTypeLongDesc;

	@Column(name="socks_type_short_desc")
	private String socksTypeShortDesc;

	//bi-directional many-to-one association to Sock
	@OneToMany(mappedBy="socksTypeCdtb")
	private List<Sock> socks;

	public SocksTypeCdtb() {
	}

	public int getSocksTypeId() {
		return this.socksTypeId;
	}

	public void setSocksTypeId(int socksTypeId) {
		this.socksTypeId = socksTypeId;
	}

	public String getSocksTypeLongDesc() {
		return this.socksTypeLongDesc;
	}

	public void setSocksTypeLongDesc(String socksTypeLongDesc) {
		this.socksTypeLongDesc = socksTypeLongDesc;
	}

	public String getSocksTypeShortDesc() {
		return this.socksTypeShortDesc;
	}

	public void setSocksTypeShortDesc(String socksTypeShortDesc) {
		this.socksTypeShortDesc = socksTypeShortDesc;
	}

	public List<Sock> getSocks() {
		return this.socks;
	}

	public void setSocks(List<Sock> socks) {
		this.socks = socks;
	}

	public Sock addSock(Sock sock) {
		getSocks().add(sock);
		sock.setSocksTypeCdtb(this);

		return sock;
	}

	public Sock removeSock(Sock sock) {
		getSocks().remove(sock);
		sock.setSocksTypeCdtb(null);

		return sock;
	}

}