/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

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
public class UsuarioPaginaDao implements UsuarioPaginaServices {

    private final String SQL_CONSULTA = "SELECT * FROM usuariopagina";
    private final String SQL_INSERTAR = "INSERT INTO usuariopagina(id,nombre,apellido,correo,clave) VALUES(?, ?, ?, ?, ?)";
    private final String SQL_ELIMINAR = "DELETE FROM usuariopagina WHERE id = ?";
    private final String SQL_ACTUALIZAR = "UPDATE usuariopagina SET nombre = ?, apellido = ?, correo = ? WHERE id = ?";
    private final String SQL_CONSULTAID = "SELECT * FROM usuariopagina WHERE id = ?";

    @Override
    public List<UsuarioPagina> consultar() {
        List<UsuarioPagina> usuarios = new ArrayList<>();
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTA);
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
    public UsuarioPagina consultarId(UsuarioPagina usuario) {
        UsuarioPagina nUsuario = null;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultado = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
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
    public int crear(UsuarioPagina usuario) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_INSERTAR);
            stm.setString(1, usuario.getId());
            stm.setString(2, usuario.getNombre());
            stm.setString(3, usuario.getApellido());
            stm.setString(4, usuario.getCorreo());
            stm.setString(5, usuario.getClave());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPaginaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    @Override
    public int eliminar(UsuarioPagina usuario) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ELIMINAR);
            stm.setString(1, usuario.getId());
            registro = stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPaginaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    @Override
    public int actualizar(UsuarioPagina usuario) {
        int registro = 0;
        BaseDeDatos bd = null;
        Connection connection = null;
        PreparedStatement stm = null;
        bd = BaseDeDatos.getInstance();
        try {
            connection = bd.getConnection();
            stm = connection.prepareStatement(SQL_ACTUALIZAR);
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

}
