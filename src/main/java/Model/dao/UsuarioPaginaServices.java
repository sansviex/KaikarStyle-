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

    public List<UsuarioPagina> consultar();

    public UsuarioPagina consultarId(UsuarioPagina usuarioPagina);

    public int crear(UsuarioPagina usuarioPagina);

    public int eliminar(UsuarioPagina usuarioPagina);

    public int actualizar(UsuarioPagina usuarioPagina);

}
