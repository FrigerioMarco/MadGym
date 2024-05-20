/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio;

import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Marco
 */
public class Cliente {
    
    private StringProperty username;
    private StringProperty password;
    private StringProperty cognome;
    private StringProperty nome;
    private StringProperty data;
    private StringProperty codFis;
    
    private Abbonamento abbonamento;
    private Scheda scheda;
    
    //Costruttore per la lettura del file(clienti con abbonamento)
    public Cliente(String username, String password, String cognome, String nome, String data, String codFis, String tipo, String scadenza) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.cognome = new SimpleStringProperty(cognome);
        this.nome = new SimpleStringProperty(nome);
        this.data = new SimpleStringProperty(data);
        this.codFis = new SimpleStringProperty(codFis);
        
        this.abbonamento = new Abbonamento(tipo, scadenza);
        this.scheda=null;
    }
    
    //Costruttore per creare clienti alla registrazione e leggere clienti senza abbonamento
    public Cliente(String username, String password, String cognome, String nome, String data, String codFis) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.cognome = new SimpleStringProperty(cognome);
        this.nome = new SimpleStringProperty(nome);
        this.data = new SimpleStringProperty(data);
        this.codFis = new SimpleStringProperty(codFis);
        this.abbonamento=null;
        this.scheda=null;
    }
    
    //Costruttore per creare clienti con abbonamento e con scheda
    public Cliente(String username, String password, String cognome, String nome, String data, String codFis, String tipoAbbonamento, String scadenza, String tipoScheda) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.cognome = new SimpleStringProperty(cognome);
        this.nome = new SimpleStringProperty(nome);
        this.data = new SimpleStringProperty(data);
        this.codFis = new SimpleStringProperty(codFis);
        
        this.abbonamento = new Abbonamento(tipoAbbonamento, scadenza);
        this.scheda = new Scheda(tipoScheda);
    }
    
    public void setScheda(Scheda scheda){
        this.scheda=scheda;
    }
    
    public Scheda getScheda(){
        return scheda;
    }
    
    public StringProperty getGiorno1Property(){
        if(scheda==null){
            return new SimpleStringProperty("");
        }
        return new SimpleStringProperty(scheda.getGiorno1());
    }
    
    public StringProperty getGiorno2Property(){
        if(scheda==null){
            return new SimpleStringProperty("");
        }
        return new SimpleStringProperty(scheda.getGiorno2());
    }
    
    public StringProperty getGiorno3Property(){
        if(scheda==null){
            return new SimpleStringProperty("");
        }
        return new SimpleStringProperty(scheda.getGiorno3());
    }
    
    public StringProperty getUsernameProperty() {
        return username;
    }
    
    public String getUsername(){
        return username.get();
    }

    public void setUsername(StringProperty username) {
        this.username = username;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }
    
    public String getPassword(){
        return password.get();
    }

    public void setPassword(StringProperty password) {
        this.password = password;
    }

    public StringProperty getCognomeProperty() {
        return cognome;
    }
    
    public String getCognome(){
        return cognome.get();
    }

    public void setCognome(StringProperty cognome) {
        this.cognome = cognome;
    }

    public StringProperty getNomeProperty() {
        return nome;
    }

    public String getNome(){
        return nome.get();
    }
    
    public void setNome(StringProperty nome) {
        this.nome = nome;
    }

    public StringProperty getDataProperty() {
        return data;
    }
    
    public String getData(){
        return data.get();
    }
    
    public void setData(StringProperty data) {
        this.data = data;
    }

    public StringProperty getCodFisProperty() {
        return codFis;
    }

    public String getCodFis(){
        return codFis.get();
    }
    
    public void setCodFis(StringProperty codFis) {
        this.codFis = codFis;
    }
    
    public StringProperty getScadenzaProperty(){
        return new SimpleStringProperty(abbonamento==null ? "" : abbonamento.getScadenza());
    }
    
    public String getScadenza(){
        return abbonamento.getScadenza();
    }
    
    public void aggiungiAbbonamento(int durata, String tipo){
        abbonamento = new Abbonamento(durata, tipo);
    }
    
    public Abbonamento getAbbonamento(){
        return abbonamento;
    }
    
    public void rimuoviAbbonamento(){
        scheda = null;
        abbonamento = null;
    }
}
