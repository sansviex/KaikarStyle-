/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.UsuarioPagina;
import Model.dao.UsuarioPaginaDao;
import java.util.List;

/**
 *
 * @author giova
 */
public class UsuarioPaginaController {

    UsuarioPaginaDao ud = new UsuarioPaginaDao();

    public int crear(UsuarioPagina usuarioPagina) {
        return ud.crear(usuarioPagina);
    }

    public boolean registrar(UsuarioPagina usuarioPagina) {
        return ud.registrar(usuarioPagina);
    }

    public UsuarioPagina iniciarSesion(String correo, String clave) {
        return ud.iniciarSesion(correo, clave);
    }
}
