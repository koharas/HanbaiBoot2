package com.dicre.hanbai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Shouhin")
public class Shouhin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sid")
	private int sid;

	@Column(name="sname")
	private String sname;

	@Column(name="tanka")
	private int tanka;


	public Shouhin() {
	}


	public Shouhin(String sname, int tanka) {
		this.sname = sname;
		this.tanka = tanka;
	}


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getTanka() {
		return tanka;
	}

	public void setTanka(int tanka) {
		this.tanka = tanka;
	}



}
