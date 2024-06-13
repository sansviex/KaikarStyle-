package com.mycompany.proyectokaikarstyle.resources;

import Controller.UsuarioPaginaController;
import Model.Entity.UsuarioPagina;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("user")
public class UsuarioPaginaResource {

    UsuarioPaginaController uc = new UsuarioPaginaController();

    @GET
    @Path("/ping")
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @POST
    @Path("/createUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(UsuarioPagina usuario) {
        try {
            uc.crear(usuario);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(usuario)
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(UsuarioPagina usuarioPagina) {
        if (uc.registrar(usuarioPagina)) {
            return Response.status(Response.Status.CREATED).entity(usuarioPagina).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity("Usuario ya existe").build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarSesion(UsuarioPagina usuarioPagina) {
        usuarioPagina = uc.iniciarSesion(usuarioPagina.getCorreo(), usuarioPagina.getClave());
        if (usuarioPagina != null) {
            return Response.ok(usuarioPagina).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Correo o clave incorrectos").build();
        }
    }

}
