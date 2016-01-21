package org.mehdi.project.dao.implementation;

import com.googlecode.objectify.annotation.*;

@Entity
@Index

public class Manager extends ObjectifyGenericDao<Manager>  {

	@Id
	private String id;
	@Unindex
	private String nom;
	private String cin;
	private String password;
	private String desc;
	
	
	public Manager() {
	
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public Manager(String id, String nom,  String cin, String password, String desc) {
		this.id = id;
		this.nom = nom;
		this.cin = cin;
		this.password = password;
		this.desc = desc;
	}
}
