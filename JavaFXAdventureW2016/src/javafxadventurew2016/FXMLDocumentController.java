/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxadventurew2016;

import Conexion.ConexionBD;
import DAO.PersonaDAO;
import Logica.PersonaValidaciones;
import Poco.Persona;
import Util.Herramientas;
import java.net.URL;
import java.sql.Connection;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author mario
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private TextField txtPrimerNombre;
    @FXML
    private TextField txtSegundoNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtNumeroTarjeta;
    @FXML
    private TextField txtTipoTarjeta;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtNumeroTel;
    @FXML
    private ComboBox<String> cbTipoPersona;
    @FXML
    private ComboBox<String> cbMesVencimiento;
    @FXML
    private ComboBox<String> cbAnioVencimiento;
    @FXML
    private ComboBox<String> cbTipoTel;
 
    
    Connection conectarDB= ConexionBD.getConexion();

    @FXML
    private TableView<Persona> tbInformacionPersonas;
    @FXML
    private TableColumn colTipoPersona;
    @FXML
    private TableColumn colPrimerNombre;
    @FXML
    private TableColumn colSegundoNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn colNumTarjeta;
    @FXML
    private TableColumn colTipoTarjeta;
    @FXML
    private TableColumn colMesVen;
    @FXML
    private TableColumn colAnioVencimiento;
    @FXML
    private TableColumn colCorreo;
    @FXML
    private TableColumn colNumTelefono;
    @FXML
    private TableColumn colTipoTel;
    
    private ObservableList<Persona> listaPersonas;
    
    PersonaDAO personaDAO = new PersonaDAO();
    
    PersonaValidaciones personaValidacion = new PersonaValidaciones();
    
    //Listas para cargar combos
    ObservableList<String> opcionesComboTipoPersona = FXCollections.observableArrayList("IN", "EM", "SP", "SC", "VC", "GC");
    ObservableList<String> opcionesComboMes= FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
    ObservableList<String> opcionesComboAnio = FXCollections.observableArrayList("2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030");
    ObservableList<String> opcionesComboTipoTel = FXCollections.observableArrayList("Celular", "Casa", "Trabajo");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(conectarDB != null){
            System.out.println("Conexión a BD exitosa");
        }
        else{
            System.err.println("Error al conectar a la BD");
        }
        setViewTable();
        tbInformacionPersonas.setItems(personaDAO.obtenerListaPersonas(listaPersonas));
        llenarValoresCombo();
    }    
    
    private void llenarValoresCombo () {
        cbTipoPersona.setItems(opcionesComboTipoPersona);
        cbMesVencimiento.setItems(opcionesComboMes);
        cbAnioVencimiento.setItems(opcionesComboAnio);
        cbTipoTel.setItems(opcionesComboTipoTel);
        
    }
    
    String auxTipoTel;
    
    private String gestionarComboTipoTelefono(){
        String tipoTel = cbTipoTel.getValue();
        
        if(tipoTel.equals("Celular")){
            auxTipoTel = "1";
        } else if(tipoTel.equals("Casa")){
            auxTipoTel = "2";
        }else{
            auxTipoTel = "3";
        }
        return auxTipoTel;
    }
    
    @FXML
    private void clicRegistrarPersona(ActionEvent event) {
                
        String tipoPersona = cbTipoPersona.getValue();
        String primerNombre = txtPrimerNombre.getText();
        String segundoNombre = txtSegundoNombre.getText();
        String apellido = txtApellido.getText();
        String numTarjeta = txtNumeroTarjeta.getText();
        String tipoTarjeta = txtTipoTarjeta.getText();
        String mesVencimiento = cbMesVencimiento.getValue();
        String anioVencimiento = cbAnioVencimiento.getValue();
        String correo = txtCorreo.getText();
        String numTel = txtNumeroTel.getText();
        String tipoTel = cbTipoTel.getValue();
        
        
        if(primerNombre.isEmpty() || apellido.isEmpty() || numTarjeta.isEmpty() || tipoTarjeta.isEmpty() || correo.isEmpty() || numTel.isEmpty()){
            Alert alertConexion = Herramientas.creadorDeAlerta("Campos obligatorios", "Por favor llena los campos para continuar", Alert.AlertType.ERROR);
            alertConexion.showAndWait();
        } else if(tipoPersona == null || mesVencimiento == null || anioVencimiento == null || tipoTel == null){
            Alert alertConexion = Herramientas.creadorDeAlerta("Campos obligatorios", "Por favor llena los campos para continuar", Alert.AlertType.ERROR);
            alertConexion.showAndWait();
        }else{
            if((personaValidacion.validarNombre(primerNombre)) && (personaValidacion.validarApellido(apellido)) 
                    && (personaValidacion.validarNumeroTarjeta(numTarjeta)) && (personaValidacion.validarTipoTarjeta(tipoTarjeta)) 
                    && (personaValidacion.validarCorreo(correo)) && (personaValidacion.validarNumeroTelefonico(numTel))){
                
                int estiloNombre = 0;
                int emailPromotion = 0;

                int mesAux = Integer.parseInt(mesVencimiento);
                int anioAux = Integer.parseInt(anioVencimiento);

                gestionarComboTipoTelefono();

                int resultado;

                resultado = personaDAO.registrarPersona(tipoPersona, estiloNombre, primerNombre, segundoNombre, apellido, emailPromotion, numTarjeta, tipoTarjeta, correo, numTel, auxTipoTel, mesAux, anioAux );

                if(resultado > 0){
                   Alert alertConexion = Herramientas.creadorDeAlerta("Registro", "Registro exitoso", Alert.AlertType.INFORMATION);
                   alertConexion.showAndWait();
                   limpiarCampos();
                   refrescarTabla();
                }else{
                   Alert alertConexion = Herramientas.creadorDeAlerta("Error", "Error al registrar en la base de datos", Alert.AlertType.ERROR);
                   alertConexion.showAndWait();
                }
            } else if(!personaValidacion.validarNombre(primerNombre)){
                Alert alertConexion = Herramientas.creadorDeAlerta("Campo no válido", "Ingrese un nombre válido", Alert.AlertType.ERROR);
                alertConexion.showAndWait();
            } else if(!personaValidacion.validarApellido(apellido)){
                Alert alertConexion = Herramientas.creadorDeAlerta("Campo no válido", "Ingrese un apellido válido", Alert.AlertType.ERROR);
                alertConexion.showAndWait();
            } else if(!personaValidacion.validarNumeroTarjeta(numTarjeta)){
                Alert alertConexion = Herramientas.creadorDeAlerta("Campo no válido", "Ingrese un número de tarjeta válido", Alert.AlertType.ERROR);
                alertConexion.showAndWait();
            } else if(!personaValidacion.validarTipoTarjeta(tipoTarjeta)){
                Alert alertConexion = Herramientas.creadorDeAlerta("Campo no válido", "Ingrese un tipo de tarjeta válido", Alert.AlertType.ERROR);
                alertConexion.showAndWait();
            } else if(!personaValidacion.validarCorreo(correo)){
                Alert alertConexion = Herramientas.creadorDeAlerta("Campo no válido", "Ingrese un correo válido", Alert.AlertType.ERROR);
                alertConexion.showAndWait();
            } else if(!personaValidacion.validarNumeroTelefonico(numTel)){
                Alert alertConexion = Herramientas.creadorDeAlerta("Campo no válido", "Ingrese un número telefónico válido", Alert.AlertType.ERROR);
                alertConexion.showAndWait();
            }
            
        }
    }
    
    
    public void setViewTable(){
        listaPersonas = FXCollections.observableArrayList();
        this.colTipoPersona.setCellValueFactory(new PropertyValueFactory("personType"));
        this.colPrimerNombre.setCellValueFactory(new PropertyValueFactory("firstName"));
        this.colSegundoNombre.setCellValueFactory(new PropertyValueFactory("middleName"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("lastName"));
        this.colNumTarjeta.setCellValueFactory(new PropertyValueFactory("creditCardNumber"));
        this.colTipoTarjeta.setCellValueFactory(new PropertyValueFactory("cardType"));
        this.colMesVen.setCellValueFactory(new PropertyValueFactory("creditCardExpMonth"));
        this.colAnioVencimiento.setCellValueFactory(new PropertyValueFactory("creditCardExpYear"));
        this.colCorreo.setCellValueFactory(new PropertyValueFactory("emailAddress"));
        this.colNumTelefono.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
        this.colTipoTel.setCellValueFactory(new PropertyValueFactory("phoneNumberTypeID"));
        
    }
    
    
    private void limpiarCampos(){
        cbTipoPersona.setValue("");
        txtPrimerNombre.clear();
        txtSegundoNombre.clear();
        txtApellido.clear();
        txtNumeroTarjeta.clear();
        txtTipoTarjeta.clear();
        cbMesVencimiento.setValue("");
        cbAnioVencimiento.setValue("");
        txtCorreo.clear();
        txtNumeroTel.clear();
        cbTipoTel.setValue("");
        
    }
    
    private void refrescarTabla(){
        tbInformacionPersonas.getItems().clear(); 
        setViewTable();
        tbInformacionPersonas.setItems(personaDAO.obtenerListaPersonas(listaPersonas));
    }

    @FXML
    private void clicEliminarPersona(ActionEvent event) {
        int seleccion = tbInformacionPersonas.getSelectionModel().getSelectedIndex();
        if (seleccion >= 0) {
            Persona personaAEliminar = listaPersonas.get(seleccion);
            Alert alertConfirmacion = Herramientas.creadorDeAlerta("Confirmar eliminación", "¿Seguro que desea eliminar a la persona: " + personaAEliminar.getFirstName() + " " + personaAEliminar.getLastName() + "?", Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> resultadoDialogo = alertConfirmacion.showAndWait();

            if (resultadoDialogo.get() == ButtonType.OK) {
                int resultado;
                resultado = personaDAO.eliminarPersona(personaAEliminar.getBusinessEntityID(), personaAEliminar.getCreditCardID());
                
                if(resultado > 0){
                    Alert alertConexion = Herramientas.creadorDeAlerta("Eliminado", "Persona eliminada exitosamente", Alert.AlertType.INFORMATION);
                    alertConexion.showAndWait();
                    limpiarCampos();
                    refrescarTabla();
                }else{
                    Alert alertConexion = Herramientas.creadorDeAlerta("Error", "Error al eliminar en la base de datos", Alert.AlertType.ERROR);
                    alertConexion.showAndWait();
                }
            }
        } else {
            Alert alertaVacio = Herramientas.creadorDeAlerta("Sin selección", "Para eliminar un registro, debe seleccionarlo de la tabla", Alert.AlertType.WARNING);
            alertaVacio.showAndWait();
        }
    }
    
}
