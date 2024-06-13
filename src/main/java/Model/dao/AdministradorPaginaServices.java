/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.dao;

/**
 *
 * @author giova
 */
import Model.Entity.AdministradorPagina;
import Model.Entity.Prenda;
import Model.Entity.UsuarioPagina;
import java.util.List;

public interface AdministradorPaginaServices {

    public AdministradorPagina iniciarSesion(String id, String claveAcceso);

    public List<Prenda> consultarPrendas();

    public Prenda consultarIdPrenda(Prenda prenda);

    public int agregarPrenda(Prenda prenda);

    public int actualizarPrenda(Prenda prenda);
   public int eliminarPrenda(Prenda prenda);

    public List<UsuarioPagina> consultarUsuarios();

    public UsuarioPagina consultarUsuarioPorId(UsuarioPagina usuarioPagina);

    public int actualizarUsuario(UsuarioPagina usuarioPagina);

    public int eliminarUsuario(UsuarioPagina usuarioPagina);
}
