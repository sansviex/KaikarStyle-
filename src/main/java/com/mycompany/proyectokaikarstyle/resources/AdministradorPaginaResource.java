/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectokaikarstyle.resources;

import Controller.AdministradorPaginaController;
import Controller.UsuarioPaginaController;
import Model.Entity.Prenda;
import Model.Entity.UsuarioPagina;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giova
 */
@Path("/administrador")
public class AdministradorPaginaResource {

    AdministradorPaginaController ac = new AdministradorPaginaController();
    UsuarioPaginaController uc = new UsuarioPaginaController();

    @GET
    @Path("/ping")
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @POST
    @Path("/prendas/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarPrenda(Prenda prenda) {
        int registro = ac.agregarPrenda(prenda);
        if (registro > 0) {
            return Response.status(Response.Status.CREATED).entity("Prenda agregada exitosamente").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo agregar la prenda").build();
        }
    }

    @GET
    @Path("/prendas/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPrenda(@PathParam("id") String idPrenda) {
        Prenda prenda = ac.consultarPrenda(idPrenda);
        if (prenda != null) {
            return Response.status(Response.Status.OK).entity(prenda).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Prenda no encontrada").build();
        }
    }

    @PUT
    @Path("/prendas/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarPrenda(Prenda prenda) {
        int registro = ac.actualizarPrenda(prenda);
        if (registro > 0) {
            return Response.status(Response.Status.OK).entity("Prenda actualizada exitosamente").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo actualizar la prenda").build();
        }
    }

    @DELETE
    @Path("/prendas/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarPrenda(@PathParam("id") String idPrenda) {
        int registro = ac.eliminarPrenda(idPrenda);
        if (registro > 0) {
            return Response.status(Response.Status.OK).entity("Prenda eliminada exitosamente").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No se pudo eliminar la prenda").build();
        }
    }

    @GET
    @Path("/prendas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPrendas() {
        List<Prenda> prendas = ac.consultarPrendas();
        return Response.status(Response.Status.OK).entity(prendas).build();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        List<UsuarioPagina> usuarios = new ArrayList();
        usuarios = ac.consultarUsuarios();
        System.out.println("mm" + usuarios);
        return Response
                .status(200)
                .entity(usuarios)
                .build();
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioId(@PathParam("id") String id) {
        UsuarioPagina usuario = new UsuarioPagina(id);
        UsuarioPagina usuarioR = ac.consultarUsuarioPorId(id);
        return Response
                .status(200)
                .entity(usuarioR)
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

    @DELETE
    @Path("/deleteUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") String id) {
        UsuarioPagina usuario = new UsuarioPagina(id);
        int i = ac.eliminarUsuario(id);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("no se encontró el destino")
                    .build();
        } else {
            return Response
                    .ok("Correcto")
                    .build();
        }

    }

    @DELETE
    @Path("/editUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editar(UsuarioPagina usuario) {
        try {
            ac.actualizarUsuario(usuario);
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

}
