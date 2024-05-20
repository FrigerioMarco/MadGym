/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio.pages;


import esempio.Cliente;
import esempio.MainApp;
import esempio.Scheda;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class HomeClienteController {

    @FXML private Button btnEsci;
    @FXML private Button btnAcquista;
    @FXML private Button btnDisdici;
    @FXML private Button btnScheda;
    
    @FXML private Label lbMessaggio;
    @FXML private Label lbScadenzaAbb;
    
    @FXML private TableView<Cliente> schedaCliente;
    @FXML private TableColumn<Cliente, String> giorno1;
    @FXML private TableColumn<Cliente, String> giorno2;
    @FXML private TableColumn<Cliente, String> giorno3;
    
    private MainApp app;
    private Cliente cliente;
    
    
    
    @FXML
    private void initialize(){
        giorno1.setCellValueFactory(cellData -> cellData.getValue().getGiorno1Property());
        giorno2.setCellValueFactory(cellData -> cellData.getValue().getGiorno2Property());
        giorno3.setCellValueFactory(cellData -> cellData.getValue().getGiorno3Property());
    }
    
    public void setApp(MainApp app) {
        this.app = app;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
        System.out.println(cliente);
        lbMessaggio.setText("Benvenuto\n"+cliente.getNome()+" "+cliente.getCognome());
        
        if(cliente.getAbbonamento()==null){
            lbScadenzaAbb.setText("");
            btnScheda.setVisible(false);
            btnDisdici.setVisible(false);
            btnAcquista.setVisible(true);
        }else if(cliente.getAbbonamento()!=null){
            lbScadenzaAbb.setText("Scadenza abbonameto\n"+cliente.getScadenza());
            btnScheda.setVisible(true);
            btnDisdici.setVisible(true);
            btnAcquista.setVisible(false);
        }
        
        ObservableList<Cliente> clienti= FXCollections.observableArrayList();
        if(cliente.getScheda()!=null){
            clienti.add(cliente);
        }
        schedaCliente.setItems(clienti);
        schedaCliente.refresh();
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
    private void paginaAbbonamento(){
        app.setPage("Abbonamento", cliente);
    }
    
    @FXML
    private void paginaSchede(){
        app.setPage("Schede", cliente);
    }
    
    @FXML
    public void disdiciAbbonamento(){
        
        cliente.rimuoviAbbonamento();
        app.scriviClienti();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Hai correttamente disdetto l'abbonamento!");
        alert.showAndWait();
        app.setPage("HomeCliente", cliente);
    }
}