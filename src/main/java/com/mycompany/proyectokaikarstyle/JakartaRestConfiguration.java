package com.mycompany.proyectokaikarstyle;

import com.mycompany.proyectokaikarstyle.resources.CorsFilter;
import com.mycompany.proyectokaikarstyle.resources.UsuarioPaginaResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilter.class);
        classes.add(UsuarioPaginaResource.class);

        return classes;

    }

}
