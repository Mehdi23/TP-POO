package org.mehdi.project.dao.implementation;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.*;

@Entity

public class Arme {
    @Id Long id;
    @Parent Key<Personnage> parent;
    String nom;
    int degats;

    public Arme(String nom, int degats, Key<Personnage> parent) {
        this.nom = nom;
        this.degats = degats;
        this.parent = parent;
    }
}