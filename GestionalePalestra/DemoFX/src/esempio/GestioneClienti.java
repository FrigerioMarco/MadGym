/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marco
 */
public class GestioneClienti {
    private ObservableList<Cliente> clienti= FXCollections.observableArrayList();
    String filePath = "src/esempio/assets/fileDataBase.txt";
    
    
    public GestioneClienti() {
        
    }
    
    public void leggiFile(){
        
        try {
            File fileDataBase = new File(filePath);
            Scanner myReader = new Scanner(fileDataBase);
            
                
            
            if(myReader.hasNextLine()){    
                while (myReader.hasNextLine()) {
                    String[] appoggio = myReader.nextLine().split(";");
                    if(appoggio.length==6){
                        clienti.add(new Cliente(appoggio[0], appoggio[1], appoggio[2], appoggio[3], appoggio[4], appoggio[5]));
                    }else if(appoggio.length==8){
                        clienti.add(new Cliente(appoggio[0], appoggio[1], appoggio[2], appoggio[3], appoggio[4], appoggio[5], appoggio[6], appoggio[7]));
                    }else{
                        clienti.add(new Cliente(appoggio[0], appoggio[1], appoggio[2], appoggio[3], appoggio[4], appoggio[5], appoggio[6], appoggio[7], appoggio[8]));
                    }
                }
                myReader.close();       
            }else {
                // Se il file è vuoto, stampa un messaggio di avviso
                System.out.println("Il file è vuoto.");
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }
    
    public void aggiungiCliente(String username, String password, String cognome, String nome, String data, String codFis){
        clienti.add(new Cliente(username, password, cognome, nome, data, codFis));
    }
    
    public void eliminaCliente(Cliente cliente){
        clienti.remove(cliente);
    }

    public ObservableList<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(ObservableList<Cliente> clienti) {
        this.clienti = clienti;
    }
    
    //creazione del cliente alla registrazione
    public void scriviCliente(String username, String password, String cognome, String nome, String data, String codFis){
        try {
            FileWriter myWriter = new FileWriter(filePath,true);
            myWriter.write(username+";"+password+";"+cognome+";"+nome+";"+data+";"+codFis+"\n");
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void riscriviClienti(){
        try {
            FileWriter myWriter = new FileWriter(filePath,false);
            for(Cliente c: clienti){
                if(c.getAbbonamento()==null){
                    myWriter.write(c.getUsername()+";"+c.getPassword()+";"+c.getCognome()+";"+c.getNome()+";"+c.getData()+";"+c.getCodFis()+"\n");
                }else if(c.getScheda()==null){
                    myWriter.write(c.getUsername()+";"+c.getPassword()+";"+c.getCognome()+";"+c.getNome()+";"+c.getData()+";"+c.getCodFis()+";"+c.getAbbonamento().getTipo()+";"+c.getAbbonamento().getScadenza()+"\n");
                }else{
                    myWriter.write(c.getUsername()+";"+c.getPassword()+";"+c.getCognome()+";"+c.getNome()+";"+c.getData()+";"+c.getCodFis()+";"+c.getAbbonamento().getTipo()+";"+c.getAbbonamento().getScadenza()+";"+c.getScheda().getTipoScheda()+"\n");
                }
            }
            myWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(GestioneClienti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
