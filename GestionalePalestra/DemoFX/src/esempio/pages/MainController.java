/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio.pages;


import esempio.Cliente;
import esempio.CryptPassword;
import esempio.GestioneClienti;
import esempio.MainApp;
import java.io.IOException;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static javax.xml.bind.DatatypeConverter.parseDate;

/**
 *
 * @author Marco
 */
public class MainController {
    private MainApp app;
    @FXML private Button btnAccedi;
    @FXML private Button btnRegistrati;
    @FXML private TextField usernameA;
    @FXML private PasswordField passwordA;
    
        
    private GestioneClienti gestione;
    
    @FXML
    private void initialize(){
    }
    
    public void setGestione(GestioneClienti gestione) {
        this.gestione = gestione;
    }
    
    public void setApp(MainApp app) {
        this.app = app;
    }
    
    @FXML
    private void apriHome() throws IOException{
        Cliente clienteLog=null;
        String usernameAmministratore="admin";
        String passwordAmministratore="admin";
        if(usernameA.getText().equals(usernameAmministratore)&&passwordA.getText().equals(passwordAmministratore)){
            usernameA.clear();
            passwordA.clear();
            
            app.setPage("HomeAmministratore", null);
        }else{
            
            for(Cliente c: gestione.getClienti()){
                if(c.getUsername().equals(usernameA.getText()) && c.getPassword().equals(CryptPassword.getMd5(passwordA.getText()))){
                    clienteLog=c;
                }
            }if(clienteLog==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("I dati inseriti sono sbagliati!");
                alert.showAndWait();
                return;
            }
            usernameA.clear();
            passwordA.clear();
            app.setPage("HomeCliente", clienteLog);
        }
        
    }
    
    @FXML
    private void apriRegistrazione() throws IOException{
        usernameA.clear();
        passwordA.clear();
        app.setPage("Registrazione", null);
    }   
    
    
}