package org.mehdi.project.dao.implementation;

import com.googlecode.objectify.annotation.*;

@Entity
@Index

public class Article extends ObjectifyGenericDao<Article>  {

	@Id
	private String id;
	@Unindex
	private String nom1;
	private String nom2;
	private String nom3;
	private String prix;
	private String desc1;
	private String desc2;
	private String desc3;
	
	
	public Article() {
	
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNom1() {
		return nom1;
	}


	public void setNom1(String nom1) {
		this.nom1 = nom1;
	}


	public String getNom2() {
		return nom2;
	}


	public void setNom2(String nom2) {
		this.nom2 = nom2;
	}


	public String getNom3() {
		return nom3;
	}


	public void setNom3(String nom3) {
		this.nom3 = nom3;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	public String getDesc1() {
		return desc1;
	}


	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}


	public String getDesc2() {
		return desc2;
	}


	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}


	public String getDesc3() {
		return desc3;
	}


	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}


	public Article(String id, String nom1, String nom2, String nom3, String prix, String desc1, String desc2, String desc3) {
		this.id = id;
		this.nom1 = nom1;
		this.nom2 = nom2;
		this.nom3 = nom3;
		this.prix = prix;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
	}

}
