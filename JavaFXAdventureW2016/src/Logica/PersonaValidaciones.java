/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author mario
 */
public class PersonaValidaciones {
    
    boolean nombreValido;
    boolean apellidoValido;
    boolean numTarjetaValido;
    boolean tipoTarjetaValido;
    boolean correoValido;
    boolean numeroTelefonicoValido;
    
    public boolean validarNombre (String nombre) {
        return nombreValido = nombre.matches("^([A-ZÑ]{1}[a-zñ]+){1}$");
    } 
    
    public boolean validarApellido(String apellido) {
        return apellidoValido = apellido.matches("^([A-ZÑ]{1}[a-zñ]+[ ]?){1,2}$");
    }
    
    public boolean validarNumeroTarjeta (String numTarjeta) {
        return numTarjetaValido = numTarjeta.matches("^[0-9]{10,25}$");
    }
    
    public boolean validarTipoTarjeta (String tipoTarjeta) {
        return tipoTarjetaValido = tipoTarjeta.matches("^[A-Za-z]{4,25}$");
    }
    
    public boolean validarCorreo (String correo) {
        return correoValido = correo.matches("^[(A-Z)(a-z)(0-9)(/)(.)(#)(_)]{5,20}[@]{1}"
                + "[g|m|a|i|l|d|v|e|n|t|u|r|-|w|o|k|s]*[.|c|o|m|x|u|v]{3,6}$");
    }
        
    public boolean validarNumeroTelefonico (String numeroTel) {
        return numeroTelefonicoValido = numeroTel.matches("^[0-9]{8,15}$");
    } 
}
