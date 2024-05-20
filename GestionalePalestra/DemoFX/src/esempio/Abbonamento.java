/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Marco
 */
public class Abbonamento {
    private String tipo;
    private LocalDate scadenza;
    
    
    
    public Abbonamento(int durata, String tipo) {
        this.tipo = tipo;
        this.scadenza = LocalDate.now().plusMonths(durata);
    }
    
    public Abbonamento(String tipo, String scadenza) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.tipo = tipo;
        this.scadenza = LocalDate.parse(scadenza, formatter);
    }
   
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getScadenza(){
        return scadenza.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
