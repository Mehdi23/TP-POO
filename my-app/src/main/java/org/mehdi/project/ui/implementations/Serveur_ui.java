package org.mehdi.project.ui.implementations;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mehdi.project.dao.implementation.Serveur;

import com.googlecode.objectify.ObjectifyService;

@Path("/serveur")
public class Serveur_ui {

	@PostConstruct
	public void init() {
		ObjectifyService.register(Serveur.class);
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Serveur> findAll() {
		return ObjectifyService.ofy().load().type(Serveur.class).list();
    }

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(Serveur p) {
		p.put(p);
	}
	
	@PUT
    @Consumes({ MediaType.APPLICATION_JSON})
    public void update(Serveur p) {
		ObjectifyService.ofy().save().entity(p);
		ObjectifyService.ofy().clear();
    }
 
    @DELETE @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public void remove(@PathParam("id") String id) {
    	ObjectifyService.ofy().delete().type(Serveur.class).id(id);
    	ObjectifyService.ofy().clear();
    	
    }

}
