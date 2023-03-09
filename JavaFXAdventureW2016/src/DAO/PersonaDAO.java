/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.ConexionBD;
import Poco.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author mario
 */
public class PersonaDAO {
    
   
    public int registrarPersona(String tipoPersona, int estiloNombre, String primerNombre, String segundoNombre, 
            String apellido, int emailPromotion, String numeroTarjeta, String tipoTarjeta, String correo, 
            String numeroTelefono, String tipoNumero, int mesVencimiento, int anioVencimiento){
        
        int rows = 0;
        
        try{
            Connection con = ConexionBD.getConexion();
            
            CallableStatement ps = con.prepareCall("{call [Person].[insertPersonalData](?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            
            ps.setInt(1, java.sql.Types.INTEGER);
            ps.setInt(2, java.sql.Types.INTEGER);
            ps.setString(3,tipoPersona);
            ps.setInt(4, estiloNombre);
            ps.setString(5,primerNombre);
            ps.setString(6,segundoNombre);
            ps.setString(7,apellido);
            ps.setInt(8, emailPromotion);
            ps.setString(9, numeroTarjeta);
            ps.setString(10, tipoTarjeta);
            ps.setString(11, correo);
            ps.setString(12, numeroTelefono);
            ps.setString(13, tipoNumero);
            ps.setInt(14, mesVencimiento);
            ps.setInt(15, anioVencimiento);
            ps.setInt(16, java.sql.Types.INTEGER);
            ps.setString(17, "");
            rows = ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return rows;    
        
    }
    
    
    public ObservableList<Persona> obtenerListaPersonas (ObservableList<Persona> informacion){
        Connection con = ConexionBD.getConexion();
        Persona persona = null;
        if(con != null){
            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM [Person].[vistaPersona];");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {                    
                    persona = new Persona();
                    persona.setPersonType(rs.getString("PersonType"));
                    persona.setFirstName(rs.getString("FirstName"));
                    persona.setMiddleName(rs.getString("MiddleName"));
                    persona.setLastName(rs.getString("LastName"));
                    persona.setCreditCardNumber(rs.getString("CardNumber"));
                    persona.setCardType(rs.getString("CardType"));
                    persona.setCreditCardExpMonth(rs.getInt("ExpMonth"));
                    persona.setCreditCardExpYear(rs.getInt("ExpYear"));
                    persona.setEmailAddress(rs.getString("EmailAddress"));
                    persona.setPhoneNumber(rs.getString("PhoneNumber"));
                    persona.setPhoneNumberTypeID(rs.getString("Name"));
                    persona.setBusinessEntityID(rs.getInt("BusinessEntityID"));
                    persona.setCreditCardID(rs.getInt("CreditCardID"));
                    informacion.add(persona);
                }
                return informacion;
            } catch (SQLException excepcionSQL){
                System.err.println("Error" + excepcionSQL);
            }
        }
        return informacion;
    }
    
    public int eliminarPersona(int businessEntityID, int creditCardID){
        
        int rows = 0;
        
        try{
            Connection con = ConexionBD.getConexion();
            
            CallableStatement ps = con.prepareCall("{call [Person].[deletePersonalData](?, ?, ?, ?)}");
            
            ps.setInt(1, businessEntityID);
            ps.setInt(2, creditCardID);
            ps.setInt(3, java.sql.Types.INTEGER);
            ps.setString(4, "");
            rows = ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return rows;    
        
    }

}