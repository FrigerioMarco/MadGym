/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio.pages;

import esempio.Cliente;
import esempio.MainApp;
import esempio.MainApp;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Marco
 */
public class AbbonamentoController {
    @FXML private Button btnEsci;
    
    @FXML private TextField numCarta;
    @FXML private TextField cvc;
    @FXML private TextField scadenzaCarta;
    
    @FXML private ChoiceBox tipoAbb;
    @FXML private ChoiceBox durataAbb;
    
    @FXML private Label prezzoTotale;
    
    private MainApp app;
    private Cliente cliente;
    
    @FXML
    private void initialize(){
        ObservableList<String> tipi=FXCollections.observableArrayList();
        tipi.add("All");
        tipi.add("Solo_mattina");
        tipi.add("Solo_pomeriggio");
        tipi.add("Due_ingressi");
        tipoAbb.setItems(tipi);
        
        ObservableList<String> durate=FXCollections.observableArrayList();
        durate.add("1");
        durate.add("3");
        durate.add("6");
        durate.add("12");
        durataAbb.setItems(durate);
        
        durataAbb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setTotale();
            }
        });
        
        tipoAbb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setTotale();
            }
        });
    }
    
    public void setApp(MainApp app) {
        this.app = app;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setTotale(){
        int totale=0;
        int prezzoMensile=0;
        if(tipoAbb.getValue()==null || durataAbb.getValue()==null){
            return;
        }
        if(tipoAbb.getValue().toString().equals("All")){
            prezzoMensile=40;
        }else if(tipoAbb.getValue().toString().equals("Solo_mattina")){
            prezzoMensile=28;
        }else if(tipoAbb.getValue().toString().equals("Solo_pomeriggio")){
            prezzoMensile=25;
        }else if(tipoAbb.getValue().toString().equals("Due_ingressi")){
            prezzoMensile=20;
        }
            
        totale=prezzoMensile*Integer.parseInt(durataAbb.getValue().toString());
        
        
        prezzoTotale.setText("Prezzo da pagare: "+totale+",00"+"€");
    }
    
    public void confermaAbbonamento(){
        if(numCarta.getText().equals("") || cvc.getText().equals("") || scadenzaCarta.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Errore");
            alert.setContentText("Compilare tutti i campi per confermare!");
            alert.showAndWait();
            return;
        }else if(numCarta.getText().length()!=16 || cvc.getText().length()!=3 || scadenzaCarta.getText().length()!=5){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Errore");
            alert.setContentText("Dati inseriti non validi");
            alert.showAndWait();
            return;
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Grazie!");
        alert.setContentText("Abbonamento acquistato con successo");
        alert.showAndWait();
        
        numCarta.clear();
        cvc.clear();
        scadenzaCarta.clear();

        cliente.aggiungiAbbonamento(Integer.parseInt(durataAbb.getValue().toString()), tipoAbb.getValue().toString());
        app.scriviClienti();
        app.setPage("HomeCliente", cliente);
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
