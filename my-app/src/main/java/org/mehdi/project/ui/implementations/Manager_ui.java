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

import org.mehdi.project.dao.implementation.Manager;

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
		return ObjectifyService.ofy().load().type(Manager.class).list();
    }

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(Manager p) {
		p.put(p);
	}
	
	@PUT
    @Consumes({ MediaType.APPLICATION_JSON})
    public void update(Manager p) {
		ObjectifyService.ofy().save().entity(p);
		ObjectifyService.ofy().clear();
    }
 
    @DELETE @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public void remove(@PathParam("id") String id) {
    	ObjectifyService.ofy().delete().type(Manager.class).id(id);
    	ObjectifyService.ofy().clear();
    	
    }

}
