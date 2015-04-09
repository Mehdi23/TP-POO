package org.mehdi.project.dao.implementation;

import com.googlecode.objectify.annotation.*;

@Entity
@Index
public class Personnage {

	@Id
	String id;
	@Unindex
	String nom;
	int niveau;
	int vie;
	
	public Personnage(String nom, int niveau) {
		this.id = nom;
		this.nom = nom;
		this.niveau = niveau;
		this.vie = 100;
	}
}
