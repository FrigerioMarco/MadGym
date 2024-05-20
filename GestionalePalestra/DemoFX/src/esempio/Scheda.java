/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marco
 */
public class Scheda {
    private String tipo;
    private ArrayList<String> giorno1;
    private ArrayList<String> giorno2;
    private ArrayList<String> giorno3;
    
    public Scheda(String tipo) {
        this.tipo = tipo;
        giorno1 = new ArrayList<String>();
        giorno2 = new ArrayList<String>();
        giorno3 = new ArrayList<String>();
        
        if(tipo.equals("calisthenics")){
            eserciziGiorno1Calisthenics();
            eserciziGiorno2Calisthenics();
            eserciziGiorno3Calisthenics();
        }else if(tipo.equals("bodybuilding")){
            eserciziGiorno1Bodybuilding();
            eserciziGiorno2Bodybuilding();
            eserciziGiorno3Bodybuilding();
        }else if(tipo.equals("powerlifting")){
            eserciziGiorno1Powerlifting();
            eserciziGiorno2Powerlifting();
            eserciziGiorno3Powerlifting();
        }
    }
    
    public String getTipoScheda(){
        return tipo;
    }
    
    public String getGiorno1(){
        return String.join("\n", giorno1);
    }
    
    public String getGiorno2(){
        return String.join("\n", giorno2);
    }
    
    public String getGiorno3(){
        return String.join("\n", giorno3);
    }
    
    public void eserciziGiorno1Calisthenics(){
        giorno1.add("***Petto e tricipiti***");
        giorno1.add("Riscaldamento bike");
        giorno1.add("Riscaldamento spalle");
        giorno1.add("\n");
        giorno1.add("Dips 3x max");
        giorno1.add("Russian dips 4x6");
        giorno1.add("Push ups 3x20");
        giorno1.add("Diamond push ups 3x15");
        giorno1.add("plank 4x 30sec.");
    }
    
    public void eserciziGiorno2Calisthenics(){
        giorno2.add("***Schiena e bicipiti***");
        giorno2.add("Riscaldamento bike");
        giorno2.add("Riscaldamento back");
        giorno1.add("\n");
        giorno2.add("Pull ups 3x max");
        giorno2.add("Australian pull ups 3x8");
        giorno2.add("Chin ups 4x12");
        giorno2.add("Muscle ups anelli 4x3"); 
    }
    
    public void eserciziGiorno3Calisthenics(){
        giorno3.add("***Gambe e spalle***");
        giorno3.add("Riscaldamento bike");
        giorno3.add("Stretching dinamico");
        giorno3.add("\n");
        giorno3.add("Squat 3x20");
        giorno3.add("One leg squat 3x8");
        giorno3.add("Dragon squt 3x3");
        giorno3.add("Calf raises 3x max");
    }
    
    public void eserciziGiorno1Bodybuilding(){
        giorno1.add("***Schiena***");
        giorno1.add("Riscaldamento bike");
        giorno1.add("Lat machine 3x8");
        giorno1.add("Pulley 3x16");
        giorno1.add("Low row 3x15");
        giorno1.add("Rematore 4x5");
        giorno1.add("Face pull 3x7");
        giorno1.add("\n");
        giorno1.add("***Bicipiti***");
        giorno1.add("Hammer curl 3x8");
        giorno1.add("Curl bilanciere 4x6");
        giorno1.add("Curl cavo basso 3xMax");
    }
    
    public void eserciziGiorno2Bodybuilding(){
        giorno2.add("***Petto***");
        giorno2.add("Riscaldamento mobilità");
        giorno2.add("Chest press 4x15");
        giorno2.add("Croci ai cavi 2x12");
        giorno2.add("Pectoral machine 2x20");
        giorno2.add("Panca piana 3x10");
        giorno2.add("Pullover 4x6");
        giorno2.add("\n");
        giorno2.add("***Tricipiti***");
        giorno2.add("Push down 4x12");
        giorno2.add("French press 4x10");
        giorno2.add("Diamond push up 3x10");
    }
    
    public void eserciziGiorno3Bodybuilding(){
        giorno3.add("***Gambe***");
        giorno3.add("Riscaldamento tap roulant");
        giorno3.add("Leg curl 4x12");
        giorno3.add("Affondi 3x15");
        giorno3.add("Leg extension 3x16");
        giorno3.add("Leg press 4x12");
        giorno3.add("Calf raises 4xMax");
        giorno3.add("\n");
        giorno3.add("***Spalle***");
        giorno3.add("Alzate laterali 4xMax");
        giorno3.add("Military press 3x10");
        giorno3.add("Arnold press 3x12");
    }
    
    public void eserciziGiorno1Powerlifting(){
        giorno1.add("Allenamento di Forza");
        giorno1.add("Riscaldamento bike");
        giorno1.add("Streatching dinamico");
        giorno1.add("\n");
        giorno1.add("Squat 5x5");
        giorno1.add("Panca Piana 5x5 ");
        giorno1.add("Stacchi da Terra 5x5");
        giorno1.add("Leg curl 3x8");
        giorno1.add("Affondi con manubri 3x8");
        giorno1.add("Crunch: 3x12");
    }
    
    public void eserciziGiorno2Powerlifting(){
        giorno2.add("Allenamento di Potenza");
        giorno2.add("Riscaldamento bike");
        giorno2.add("Streatching dinamico");
        giorno2.add("\n");
        giorno2.add("Stacco 5x3");
        giorno2.add("Power clena 5x3");
        giorno2.add("Squat Frontale 4x6 ");
        giorno2.add("Trazioni 4x6 ");
        giorno2.add("Dip 4x6");
        giorno2.add("Plank 3x30sec");
        giorno2.add("Stacco 5x3");        
    }
    
    public void eserciziGiorno3Powerlifting(){
        giorno3.add("Allenamento di Ipertrfofia");
        giorno3.add("Riscaldamento bike");
        giorno3.add("Streatching dinamico");
        giorno3.add("\n");
        giorno3.add("Panca 4x8");
        giorno3.add("Squat 4x8");
        giorno3.add("Rematore bilanciere 4x8");
        giorno3.add("Leg press 4x10");
        giorno3.add("Curl EZ 3x10");
        giorno3.add("French Press 3x10");
    }
}
