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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import soccer.Competitie;

/**
 * FXML Controller class
 *
 * @author floris
 */

public class newgamescreenController {
    
    @FXML
    private TextField nameField;
    
    private MainApp mainApp;
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleBackButton(){
        mainApp.showStartScreen();
        
    }
    
    @FXML
    private void handleStartButton(){
        if(isInputValid()){
        String savegame = nameField.getText();
        System.out.println(savegame);
        try{
        Competitie c = soccer.bouwXML.leesXML(new File("src/saves/competitie.xml"));
        soccer.bouwXML.bouwXML(c, new File("src/saves/"+savegame+".xml"));
        }catch(Exception e){System.out.println(e);}
        mainApp.showStartScreen();
        }
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    private boolean isInputValid(){
        String errortext = "";
        if(nameField.getText() == null || nameField.getText().length() == 0)
            errortext = "No valid input";
        if (errortext.length() == 0) {
            return true;
        } else {
            // Show the error message.
            
            return false;
        }
    }
}
