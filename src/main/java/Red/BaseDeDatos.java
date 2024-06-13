/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Red;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author giova
 */
public class BaseDeDatos {

    private final static String URL = "jdbc:mysql://18.209.45.69:3306/KaikarStyle?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final static String USERNAME = "test";
    private final static String PASSWORD = "test1_*";
    private static BasicDataSource bds = new BasicDataSource();
    private static BaseDeDatos instance;

    public BaseDeDatos() {
        bds.setUrl(URL);
        bds.setUsername(USERNAME);
        bds.setPassword(PASSWORD);
        bds.setMinIdle(5);
        bds.setMaxIdle(10);
        bds.setMaxOpenPreparedStatements(100);
    }

    public static BaseDeDatos getInstance() {
        if (instance == null) {
            instance = new BaseDeDatos();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        return bds.getConnection();
    }

}
