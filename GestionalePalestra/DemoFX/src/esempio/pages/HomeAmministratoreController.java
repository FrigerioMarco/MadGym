/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio.pages;


import esempio.Cliente;
import esempio.Cliente;
import esempio.Cliente;
import esempio.GestioneClienti;
import esempio.GestioneClienti;
import esempio.GestioneClienti;
import esempio.MainApp;
import esempio.MainApp;
import esempio.MainApp;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
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
public class HomeAmministratoreController {
    @FXML private Button btnEsci;
    @FXML private TableView<Cliente> elencoClienti;
    @FXML private TableColumn<Cliente, String> cognome;
    @FXML private TableColumn<Cliente, String> nome;
    @FXML private TableColumn<Cliente, String> dataDiNascita;
    @FXML private TableColumn<Cliente, String> scadenzaAbb;
    @FXML private TableColumn<Cliente, String> scadenzaCM;
    
    private GestioneClienti gestione;
    
    private MainApp app;
    
    @FXML
    private void initialize(){
        
        nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
        cognome.setCellValueFactory(cellData -> cellData.getValue().getCognomeProperty());
        dataDiNascita.setCellValueFactory(cellData -> cellData.getValue().getDataProperty());
        //scadenzaCM.setCellValueFactory(cellData -> cellData.getValue().getScadenzaCMProperty()));
        scadenzaAbb.setCellValueFactory(cellData -> cellData.getValue().getScadenzaProperty());
    }
    
    public void setApp(MainApp app) {
        this.app = app;
    }
    
    public void setGestione(GestioneClienti gestione){
        this.gestione=gestione;
        riempiTabella();
    } 
    
    @FXML
    public void rimuoviCliente(){
        Cliente clienteSelezionato=elencoClienti.getSelectionModel().getSelectedItem();
        if(clienteSelezionato==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Cliente non selezionato");
            alert.showAndWait();
            return;
        }
        
        gestione.eliminaCliente(clienteSelezionato);
        gestione.riscriviClienti();
        elencoClienti.setItems(gestione.getClienti());
        
    }
    
    @FXML
    private void esci(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Sei sicuro di voler uscire?");
        Optional<ButtonType> res = alert.showAndWait();

            if(res.isPresent()) {
                if(res.get().equals(ButtonType.OK))
                    app.setPage("Login", null);
            }
    }
    
    @FXML
    public void riempiTabella(){
        System.out.println(gestione);
        elencoClienti.setItems(gestione.getClienti());
    }
    
    
}