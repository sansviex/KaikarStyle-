/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.dao;

import Model.Entity.UsuarioPagina;
import java.util.List;

/**
 *
 * @author giova
 */
public interface UsuarioPaginaServices {
    public int crear(UsuarioPagina usuario);
    public UsuarioPagina iniciarSesion(String correo, String clave);
    public boolean registrar(UsuarioPagina usuario);
}
