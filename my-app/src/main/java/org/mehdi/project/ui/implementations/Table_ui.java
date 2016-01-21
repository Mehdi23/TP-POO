package org.mehdi.project.ui.implementations;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.core.MediaType;


import org.mehdi.project.dao.implementation.Arme;
import org.mehdi.project.dao.implementation.Personnage;
import org.mehdi.project.dao.implementation.Serveur;
import org.mehdi.project.dao.implementation.Table;

import com.googlecode.objectify.ObjectifyService;

@Path("/table")
public class Table_ui {

	@PostConstruct
	public void init() {
		ObjectifyService.register(Table.class);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(Table p) {
		p.put(p);
	}

}
