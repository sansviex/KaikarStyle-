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

    private final String SQL_INSERTAR = "INSERT INTO usuariopagina(id,nombre,apellido,correo,clave) VALUES(?, ?, ?, ?, ?)";
    private final String SQL_CONSULTARCORREO = "SELECT COUNT(*) FROM usuariopagina WHERE correo = ?";
    private final String SQL_INICIAR_SESION = "SELECT * FROM usuariopagina WHERE correo = ? AND clave = ?";

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
    public UsuarioPagina iniciarSesion(String correo, String clave) {
        UsuarioPagina usuario = null;
        BaseDeDatos bd = BaseDeDatos.getInstance();
        try (Connection connection = bd.getConnection(); PreparedStatement stm = connection.prepareStatement(SQL_INICIAR_SESION)) {
            stm.setString(1, correo);
            stm.setString(2, clave);
            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next()) {
                    String id = resultado.getString("id");
                    String nombre = resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");
                    usuario = new UsuarioPagina(id, nombre, apellido, clave, correo);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPaginaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public boolean registrar(UsuarioPagina usuario) {
        boolean registrado = false;
        BaseDeDatos bd = BaseDeDatos.getInstance();
        try (Connection connection = bd.getConnection(); PreparedStatement stm = connection.prepareStatement(SQL_CONSULTARCORREO)) {
            stm.setString(1, usuario.getCorreo());
            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next() && resultado.getInt(1) == 0) {
                    registrado = crear(usuario) > 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPaginaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registrado;
    }
}
