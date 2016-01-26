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

import org.mehdi.project.dao.implementation.Article;

import com.googlecode.objectify.ObjectifyService;

@Path("/article")
public class Article_ui {

	@PostConstruct
	public void init() {
		ObjectifyService.register(Article.class);
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Article> findAll() {
		return ObjectifyService.ofy().load().type(Article.class).list();
    }

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(Article p) {
		p.put(p);
	}
	
	@PUT
    @Consumes({ MediaType.APPLICATION_JSON})
    public void update(Article p) {
		ObjectifyService.ofy().save().entity(p);
		ObjectifyService.ofy().clear();
    }
 
    @DELETE @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public void remove(@PathParam("id") String id) {
    	ObjectifyService.ofy().delete().type(Article.class).id(id);
    	ObjectifyService.ofy().clear();
    	
    }

}
