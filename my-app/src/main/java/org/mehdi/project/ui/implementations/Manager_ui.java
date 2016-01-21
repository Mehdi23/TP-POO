package org.mehdi.project.ui.implementations;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.mehdi.project.dao.implementation.Arme;
import org.mehdi.project.dao.implementation.Manager;
import org.mehdi.project.dao.implementation.Personnage;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Path("/manager")
public class Manager_ui {

	@PostConstruct
	public void init() {
		ObjectifyService.register(Manager.class);
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Manager> findAll() {
		Manager p = new Manager();
        return p.get(P.id) T get(Key<T> key);
    }

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(Manager p) {
		p.put(p);
	}

}
