package org.mehdi.project.ui.implementations;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.core.MediaType;


import org.mehdi.project.dao.implementation.Arme;
import org.mehdi.project.dao.implementation.Personnage;
import com.googlecode.objectify.ObjectifyService;

@Path("/personnage")
public class Personnage_ui {

	@PostConstruct
	public void init() {
		ObjectifyService.register(Personnage.class);
		ObjectifyService.register(Arme.class);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(Personnage p) {
		p.put(p);
	}

}
