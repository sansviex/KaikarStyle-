/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Red;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author giova
 */
public class Test {
    public static void main(String[] args) {
        try{
        BaseDeDatos bd = BaseDeDatos.getInstance();
        Connection connection = bd.getConnection();
        String sql = "SELECT * FROM usuario";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Nombre: " + resultado.getString("nombre"));
            System.out.println("Apellido: " + resultado.getString("apellido"));

        }
    } catch (SQLException ex){
            System.out.println("Conexion no exitosa");
        Logger.getLogger(Test.class.getName()). log(Level.SEVERE, null, ex);
        
    }
   }
}

