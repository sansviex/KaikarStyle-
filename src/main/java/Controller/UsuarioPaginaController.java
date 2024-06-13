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
    
    public List<UsuarioPagina> consultar() {
        return ud.consultar();
    }
    
    public UsuarioPagina consultarId(UsuarioPagina usuarioPagina) {
        return ud.consultarId(usuarioPagina);
    }
    
    public int crear(UsuarioPagina usuarioPagina) {
        return ud.crear(usuarioPagina);
    }
    
    public int borrar(UsuarioPagina usuarioPagina) {
        return ud.eliminar(usuarioPagina);
    }
    
    public int actualizar(UsuarioPagina usuarioPagina){
        return ud.actualizar(usuarioPagina);
    }
}
