/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mario
 */
public class ConexionBD {
    
    public static Connection getConexion(){

        String url ="jdbc:sqlserver://192.XXX.XXX.XX:1433;"
                + "database=XXXXXXXXXXXXXXX;"
                + "user=sa;"
                + "password=XXXXXXXXXXXXXXXX;";
        try{
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
}
