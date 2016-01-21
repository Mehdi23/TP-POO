package org.mehdi.project.ui.implementations;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.core.MediaType;

import org.mehdi.project.dao.implementation.Article;

import com.googlecode.objectify.ObjectifyService;

@Path("/article")
public class Article_ui {

	@PostConstruct
	public void init() {
		ObjectifyService.register(Article.class);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(Article p) {
		p.put(p);
	}

}
