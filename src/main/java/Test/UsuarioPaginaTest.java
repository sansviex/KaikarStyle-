/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Test;

import Model.Entity.UsuarioPagina;
import Model.dao.UsuarioPaginaDao;
import java.util.List;

/**
 * 
 * @author giova
 */
public class UsuarioPaginaTest {
    public static void main(String[] args) {
        UsuarioPaginaDao usuario = new UsuarioPaginaDao();
        List<UsuarioPagina> usuarios = usuario.consultar();
        System.out.println("--"+ usuarios);
        System.out.println("Usuario: " + usuario.consultarId(new UsuarioPagina("1052")));
        //System.out.println("Usuario: " + usuario.eliminar(new Usuario("1052")));
        System.out.println("Usuario: " + usuario.actualizar(new UsuarioPagina("10","JOSE","LOPEZ","j@gmail.com")));
        System.out.println("Usuario: " + usuario.crear(new UsuarioPagina("100","JOSE","LOPEZ","123456","j@gmail.com")));
       
    }
    
}
