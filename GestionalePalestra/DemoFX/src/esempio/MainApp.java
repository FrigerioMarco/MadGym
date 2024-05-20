/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempio;

import esempio.pages.MainController;
import esempio.pages.RegistrazioneController;
import esempio.pages.HomeAmministratoreController;
import esempio.pages.AbbonamentoController;
import esempio.pages.HomeClienteController;
import esempio.pages.SchedeController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Marco
 */
public class MainApp extends Application{
    private Stage page;
    
    GestioneClienti gestione;
    
    FXMLLoader login_loader;
    FXMLLoader signin_loader;
    FXMLLoader user_loader;
    FXMLLoader admin_loader;
    FXMLLoader subscription_loader;
    FXMLLoader plan_loader;
    
    Scene login_page;
    Scene signin_page;
    Scene user_page;
    Scene admin_page;
    Scene subscription_page;
    Scene plan_page;
    
    @Override
    public void start(Stage page) throws Exception {
        
        this.page = page;
        
        inizializza();
        
    }
    
     public static void main(String[] args) {
        launch(args);
    }

    private void inizializza() {
        
        gestione = new GestioneClienti();
        gestione.leggiFile();
        
        try {
            login_loader = new FXMLLoader();
            login_loader.setLocation(MainApp.class.getResource("pages/Login.fxml"));
            AnchorPane login_scene = (AnchorPane) login_loader.load();
            login_page = new Scene(login_scene);
            
            signin_loader = new FXMLLoader();
            signin_loader.setLocation(MainApp.class.getResource("pages/Registrazione.fxml"));
            AnchorPane signin_scene = (AnchorPane) signin_loader.load();
            signin_page = new Scene(signin_scene);
            
            user_loader = new FXMLLoader();
            user_loader.setLocation(MainApp.class.getResource("pages/HomeCliente.fxml"));
            AnchorPane user_scene = (AnchorPane) user_loader.load();
            user_page = new Scene(user_scene);
            
            admin_loader = new FXMLLoader();
            admin_loader.setLocation(MainApp.class.getResource("pages/HomeAmministratore.fxml"));
            AnchorPane admin_scene = (AnchorPane) admin_loader.load();
            admin_page = new Scene(admin_scene);
            
            subscription_loader = new FXMLLoader();
            subscription_loader.setLocation(MainApp.class.getResource("pages/Abbonamento.fxml"));
            AnchorPane subscription_scene = (AnchorPane) subscription_loader.load();
            subscription_page = new Scene(subscription_scene);
            
            plan_loader = new FXMLLoader();
            plan_loader.setLocation(MainApp.class.getResource("pages/Schede.fxml"));
            AnchorPane plan_scene = (AnchorPane) plan_loader.load();
            plan_page = new Scene(plan_scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        setPage("Login", null);
        
    }
    
    public void setPage(String pagina, Cliente cliente) {
        
        switch (pagina) {
            case "Login":
                MainController controller=login_loader.getController();
                controller.setApp(this);
                controller.setGestione(gestione);
                page.setScene(login_page);
                page.setTitle("Mad Gym Login");
                break;
            case "Registrazione":
                RegistrazioneController sign_controller=signin_loader.getController();
                sign_controller.setApp(this);
                sign_controller.setGestione(gestione);
                page.setScene(signin_page);
                page.setTitle("Mad Gym Registrazione");
                break;
            case "HomeCliente":
                HomeClienteController user_home_controller=user_loader.getController();
                user_home_controller.setApp(this);
                user_home_controller.setCliente(cliente);
                page.setScene(user_page);
                page.setTitle("Mad Gym Home");
                break;
            case "HomeAmministratore":
                HomeAmministratoreController admin_home_controller=admin_loader.getController();
                admin_home_controller.setApp(this);
                admin_home_controller.setGestione(gestione);
                page.setScene(admin_page);
                page.setTitle("Mad Gym Admin Home");
                break;
            case "Abbonamento":
                AbbonamentoController subscription_controller=subscription_loader.getController();
                subscription_controller.setApp(this);
                subscription_controller.setCliente(cliente);
                page.setScene(subscription_page);
                page.setTitle("Mad Gym Abbonamento");
                break;
            case "Schede":
                SchedeController plan_controller=plan_loader.getController();
                plan_controller.setApp(this);
                plan_controller.setCliente(cliente);
                page.setScene(plan_page);
                page.setTitle("Mad Gym Schede");
                break;
                
        }
        page.show();

    }
    
    public void scriviClienti(){
        gestione.riscriviClienti();
    }
    
}
