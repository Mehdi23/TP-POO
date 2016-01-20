package org.mehdi.project.dao.implementation;

import com.googlecode.objectify.annotation.*;

@Entity
@Index

public class Personnage extends ObjectifyGenericDao<Personnage>  {

	@Id
	private String id;
	@Unindex
	private String nom;
	private int niveau;
	private int vie;
	
	
	public Personnage() {
	
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


	public int getNiveau() {
		return niveau;
	}


	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}


	public int getVie() {
		return vie;
	}


	public void setVie(int vie) {
		this.vie = vie;
	}


	public Personnage(String nom, int niveau) {
		this.id = nom;
		this.nom = nom;
		this.niveau = niveau;
		this.vie = 100;
	}
}
