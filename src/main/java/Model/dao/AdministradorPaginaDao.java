/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Model.Entity.AdministradorPagina;
import Model.Entity.Prenda;
import Model.Entity.UsuarioPagina;
import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giova
 */
public class AdministradorPaginaDao implements AdministradorPaginaServices {

    private final String SQL_CONSULTARPRENDA = "SELECT * FROM prenda";
    private final String SQL_INSERTARPRENDA = "INSERT INTO prenda(id,nombre,descripcion,precio,stock) VALUES(?, ?, ?, ?, ?)";
    private final String SQL_ELIMINARPRENDA = "DELETE FROM prenda WHERE id = ?";
    private final String SQL_ACTUALIZARPRENDA = "UPDATE prenda SET nombre = ?, descripcion = ?, precio = ?, stock = ? WHERE id = ?";
    private final String SQL_CONSULTAIDPRENDA = "SELECT * FROM prenda WHERE id = ?";
    private final String SQL_CONSULTAUSUARIO = "SELECT * FROM usuariopagina";
    private final String SQL_ELIMINARUSUARIO = "DELETE FROM usuariopagina WHERE id = ?";
    private final String SQL_ACTUALIZARUSUARIO = "UPDATE usuariopagina SET nombre = ?, apellido = ?, correo = ? WHERE id = ?";
    private final String SQL_CONSULTAIDUSUARIO = "SELECT * FROM usuariopagina WHERE id = ?";

    @Override
    public AdministradorPagina iniciarSesion(String id, String claveAcceso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Prenda> consultarPrendas() {
        List<Prenda> prendas = new ArrayList<>();
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTARPRENDA);
            resultado = stm.executeQuery();
            while (resultado.next()) {
                String id = resultado.getString("id");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                Double precio = resultado.getDouble("precio");
                Integer stock = resultado.getInt("stock");
                Prenda prenda = new Prenda(id, nombre, descripcion, precio, stock);
                prendas.add(prenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prendas;

    }

    @Override
    public Prenda consultarIdPrenda(Prenda prenda) {
        Prenda nPrenda = null;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTAIDPRENDA, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setString(1, prenda.getId());
            resultado = stm.executeQuery();
            resultado.absolute(1);
            String id = resultado.getString("id");
            String nombre = resultado.getString("nombre");
            String descripcion = resultado.getString("descripcion");
            Double precio = resultado.getDouble("precio");
            Integer stock = resultado.getInt("stock");
            nPrenda = new Prenda(id, nombre, descripcion, precio, stock);
        } catch (SQLException ex) {
            Logger.getLogger(Prenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nPrenda;
    }

    @Override
    public int agregarPrenda(Prenda prenda) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_INSERTARPRENDA);
            stm.setString(1, prenda.getId());
            stm.setString(2, prenda.getNombre());
            stm.setString(3, prenda.getDescripcion());
            stm.setDouble(4, prenda.getPrecio());
            stm.setInt(5, prenda.getStock());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Prenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    @Override
    public int actualizarPrenda(Prenda prenda) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ACTUALIZARPRENDA);
            stm.setString(5, prenda.getId());
            stm.setString(1, prenda.getNombre());
            stm.setString(2, prenda.getDescripcion());
            stm.setDouble(3, prenda.getPrecio());
            stm.setInt(4, prenda.getStock());

            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Prenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    @Override
    public int eliminarPrenda(Prenda prenda) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ELIMINARPRENDA);
            stm.setString(1, prenda.getId());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Prenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    @Override
    public List<UsuarioPagina> consultarUsuarios() {
        List<UsuarioPagina> usuarios = new ArrayList<>();
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTAUSUARIO);
            resultado = stm.executeQuery();
            while (resultado.next()) {
                String id = resultado.getString("id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String correo = resultado.getString("correo");
                String clave = resultado.getString("clave");
                UsuarioPagina usuario = new UsuarioPagina(id, nombre, apellido, clave, correo);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPaginaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;

    }

    @Override
    public int actualizarUsuario(UsuarioPagina usuario) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ACTUALIZARUSUARIO);
            stm.setString(4, usuario.getId());
            stm.setString(1, usuario.getNombre());
            stm.setString(2, usuario.getApellido());
            stm.setString(3, usuario.getCorreo());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPaginaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    @Override
    public UsuarioPagina consultarUsuarioPorId(UsuarioPagina usuario) {
        UsuarioPagina nUsuario = null;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTAIDUSUARIO, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setString(1, usuario.getId());
            resultado = stm.executeQuery();
            resultado.absolute(1);
            String id = resultado.getString("id");
            String nombre = resultado.getString("nombre");
            String apellido = resultado.getString("apellido");
            String correo = resultado.getString("correo");
            String clave = resultado.getString("clave");
            nUsuario = new UsuarioPagina(id, nombre, apellido, clave, correo);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPaginaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nUsuario;
    }

    @Override
    public int eliminarUsuario(UsuarioPagina usuario) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ELIMINARUSUARIO);
            stm.setString(1, usuario.getId());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPaginaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

}
