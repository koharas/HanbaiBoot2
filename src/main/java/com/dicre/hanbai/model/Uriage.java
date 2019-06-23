package com.dicre.hanbai.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Uriage")
public class Uriage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
	private int uid;

	@Column(name="sid")
	private int sid;

	@Column(name="kosu")
	private int kosu;

	@Column(name="hi")
	private Date hi;



	public Uriage() {
	}

	public Uriage(int sid, int kosu) {
		this.sid = sid;
		this.kosu = kosu;
		this.hi = new Date();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getKosu() {
		return kosu;
	}

	public void setKosu(int kosu) {
		this.kosu = kosu;
	}

	public Date getHi() {
		return hi;
	}

	public void setHi(Date hi) {
		this.hi = hi;
	}


}
