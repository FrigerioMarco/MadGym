/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio.pages;

import esempio.Cliente;
import esempio.MainApp;
import esempio.Scheda;
import java.util.HashMap;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;

/**
 *
 * @author Marco
 */
public class SchedeController {

    private MainApp app;
    private Cliente cliente;
    
    @FXML private RadioButton rbCali;
    @FXML private RadioButton rbBody;
    @FXML private RadioButton rbPower;
    
    
    
    @FXML
    private void initialize(){
        
    }
    
    public void confermaScheda(){
        if(!rbCali.isSelected() && !rbBody.isSelected() && !rbPower.isSelected()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Non hai selezionato nessuna scheda!");
            alert.showAndWait();
            return;
        }
        if(rbCali.isSelected()){
            cliente.setScheda(new Scheda("calisthenics"));
        }else if(rbBody.isSelected()){
            cliente.setScheda(new Scheda("bodybuilding"));
        }else if(rbPower.isSelected()){
            cliente.setScheda(new Scheda("powerlifting"));
        }
        
        app.scriviClienti();
        app.setPage("HomeCliente", cliente);
    }
    
    public void setApp(MainApp app) {
        this.app = app;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @FXML
    private void esci(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Sei sicuro di voler uscire?");
        Optional<ButtonType> res = alert.showAndWait();

        if(res.isPresent()) {
            if(res.get().equals(ButtonType.OK))
                app.setPage("HomeCliente", cliente);
        }
    }
    
    
}
