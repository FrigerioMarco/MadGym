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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import sun.security.util.Password;

/**
 *
 * @author Marco
 */
public class RegistrazioneController {
    
    @FXML private TextField usernameR;
    @FXML private PasswordField passwordR;
    @FXML private PasswordField confermaPassword;
    @FXML private TextField cognome;
    @FXML private TextField nome;
    @FXML private TextField codFis;
    @FXML private DatePicker dataDiNascita;
    @FXML private Button confermaRegistrazione;
    
    private GestioneClienti gestione;
    
    private MainApp app;
    
    @FXML
    private void initialize(){
        dataDiNascita.setDayCellFactory(d ->
           new DateCell() {
               @Override 
               public void updateItem(LocalDate item, boolean empty) {
                   super.updateItem(item, empty);
                   setDisable(item.isAfter(LocalDate.of(2010, 12, 31)));
               }});
        
        dataDiNascita.setValue(LocalDate.of(2000, 1, 1));
    } 
    
    public void setGestione(GestioneClienti gestione){
        this.gestione=gestione;
    } 
    
    public void setApp(MainApp app) {
        this.app = app;
    }
            
            
    @FXML
    private void aggiungiCliente(){
        Alert alert;
        if(usernameR.getText().equals("") || passwordR.getText().equals("") || confermaPassword.getText().equals("") || cognome.getText().equals("") || nome.getText().equals("") || codFis.getText().equals("") || dataDiNascita.getValue()==null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Compila tutti i campi!");
            alert.showAndWait();
            return;
        }
        if(verificaDati()==false){
            return;
        }
        if(codFis.getText().length()!=16){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Codice fiscale non valido!");
            alert.showAndWait();
            return;
        }
        if(!passwordR.getText().equals(confermaPassword.getText())){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Le password non corrispondono!");
            alert.showAndWait();
            return;
        }
        
        String passHash=CryptPassword.getMd5(passwordR.getText());
        
        
        gestione.scriviCliente(usernameR.getText(), passHash,cognome.getText(), nome.getText(), dataDiNascita.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), codFis.getText());
        gestione.aggiungiCliente(usernameR.getText(), passHash, cognome.getText(), nome.getText(), dataDiNascita.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), codFis.getText());
        
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Registrazione avvenuta con successo");
        alert.showAndWait();
        usernameR.clear();
        passwordR.clear();
        confermaPassword.clear();
        cognome.clear();
        nome.clear();
        dataDiNascita.getEditor().clear();
        codFis.clear();
        app.setPage("Login", null);
    }
    
    @FXML
    public boolean verificaDati(){
        for(Cliente c: gestione.getClienti()){
            if(c.getUsername().equals(usernameR.getText())){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Username già esistente");
                alert.showAndWait();
                usernameR.clear();
                return false;
            }
        }
        return true;
    }
}
