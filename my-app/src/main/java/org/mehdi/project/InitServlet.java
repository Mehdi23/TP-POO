package org.mehdi.project;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mehdi.project.dao.implementation.Arme;
import org.mehdi.project.dao.implementation.Personnage;

import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;

@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {
    static {
        ObjectifyService.register(Personnage.class);
        ObjectifyService.register(Arme.class);
        
        /*Personnage p = new Personnage("groknan", 25);
        ofy().save().entity(p);*/ // Asynchrone (pas enregistré immédiatement)
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // ...
    }
}
