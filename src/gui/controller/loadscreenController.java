/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.io.File;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import soccer.Competitie;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class loadscreenController implements Initializable {
    @FXML
    private AnchorPane loadAnchorPane;
    private MainApp mainApp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Button button1 = new Button();
       button1.setText("Test");
       button1.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event){
               System.out.println("TESTTESTEST");
           }
       });
       loadAnchorPane.getChildren().add(button1);
       
    }  
    
    @FXML
    private void handleBackButton(){
        mainApp.showStartScreen();
        
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
}
