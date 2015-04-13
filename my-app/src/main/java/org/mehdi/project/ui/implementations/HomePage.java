package org.mehdi.project.ui.implementations;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mehdi.project.dao.implementation.Arme;
import org.mehdi.project.dao.implementation.Personnage;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@Path("/home")
public class HomePage {
	
	@PostConstruct
	public void init() {
		ObjectifyService.register(Personnage.class);
		ObjectifyService.register(Arme.class);
	}
	
	
	@GET @Path("{key}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Personnage findByKey(@PathParam("key") String key) {
		Personnage p = new Personnage("Mehdi", 125);
		p.put(p);
		
		Key<Personnage> personnagekey = Key.create(Personnage.class, key);
		/*Personnage p = new Personnage();*/
		try {
			p = p.get(personnagekey);
			return p;
		}

		catch (EntityNotFoundException e) {
			return null;

		}
		
		catch(NullPointerException e2){
			return null;
		}
    }
 
 
/*
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		
		Personnage p = new Personnage("Wiliam", 125);
		p.put(p);
		String output = "Personnage : " + p.getNom() + "Vie :"+ p.getVie();
		return Response.status(200).entity(output).build();

		Key<Personnage> cleGroknan = Key.create(Personnage.class, "knan");
		Personnage p = new Personnage();

		try {
			p = p.get(cleGroknan);
			String output = "Personnage : " + p.getNom() + "Vie :"+ p.getVie();
			return Response.status(200).entity(output).build();
		}

		catch (EntityNotFoundException e) {
			String output = "Entity not found exception : ";
			return Response.status(200).entity(output).build();

		}
		
		catch(NullPointerException e2){
			String output = "Entity not found exception";
			return Response.status(200).entity(output).build();
		}

	}*/
}
