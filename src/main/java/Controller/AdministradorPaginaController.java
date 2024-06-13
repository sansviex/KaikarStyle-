/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Entity.Prenda;
import Model.Entity.UsuarioPagina;
import Model.dao.AdministradorPaginaDao;
import java.util.List;

/**
 *
 * @author giova
 */
public class AdministradorPaginaController {

    private AdministradorPaginaDao ad;

    public int agregarPrenda(Prenda prenda) {
        return ad.agregarPrenda(prenda);
    }

    public Prenda consultarPrenda(String idPrenda) {
        Prenda prenda = new Prenda();
        prenda.setId(idPrenda);
        return ad.consultarIdPrenda(prenda);
    }

    public int actualizarPrenda(Prenda prenda) {
        return ad.actualizarPrenda(prenda);
    }

    public int eliminarPrenda(String idPrenda) {
        Prenda prenda = new Prenda();
        prenda.setId(idPrenda);
        return ad.eliminarPrenda(prenda);
    }

    public List<Prenda> consultarPrendas() {
        return ad.consultarPrendas();
    }
    public int actualizarUsuario(UsuarioPagina usuario) {
        return ad.actualizarUsuario(usuario);
    }

    public UsuarioPagina consultarUsuarioPorId(String idUsuario) {
        UsuarioPagina usuario = new UsuarioPagina();
        usuario.setId(idUsuario);
        return ad.consultarUsuarioPorId(usuario);
    }

    public int eliminarUsuario(String idUsuario) {
        UsuarioPagina usuario = new UsuarioPagina();
        usuario.setId(idUsuario);
        return ad.eliminarUsuario(usuario);
    }

    public List<UsuarioPagina> consultarUsuarios() {
        return ad.consultarUsuarios();
    }
}
