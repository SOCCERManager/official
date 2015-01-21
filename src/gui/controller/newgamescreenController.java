/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.io.File;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import soccer.Competitie;
import soccer.ReadFolder;

/**
 * FXML Controller class
 *
 * @author floris
 */

public class newgamescreenController implements Initializable{
    
    @FXML
    private TextField nameField;
    @FXML
    private Button newGameButton;
    @FXML
    private Button backButton;
    
    private MainApp mainApp;
    /**
     * Initilaizeerd de nieuwscreencontrolooer
     * @param url Url naar path
     * @param rb de recources die gebruikt worden
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newGameButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        newGameButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
        backButton.addEventFilter(MouseEvent.MOUSE_ENTERED, MainApp.clickSoundHandler);
        backButton.addEventFilter(MouseEvent.MOUSE_PRESSED, MainApp.clickSoundHandler);
    }    
    
    @FXML
    private void handleBackButton(){
        mainApp.showStartScreen();
        
    }
    
    @FXML
    private void handleStartButton(){
        String savegame = "";
        if(isInputValid()){
            if(!nameExists())
                savegame = nameField.getText();
            else
                savegame = nameField.getText() + "1";
        try{
            
        Competitie c = soccer.bouwXML.leesXML(new File("src/competitie.xml"));
        
        soccer.bouwXML.bouwXML(c, new File("src/saves/"+savegame+".xml"));
        Competitie.setCompetitie(c);
        }catch(Exception e){System.out.println(e);}
        loadscreenController.savegame = savegame;
        mainApp.showNewTeamScreen();
        }
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    private boolean isInputValid(){
        String errortext = "";
        if(nameField.getText() == null || nameField.getText().length() == 0 || !nameField.getText().matches("[a-zA-Z0-9_]+"))
            errortext = "No valid input";
        if (errortext.length() == 0) {
            return true;
        } else {
            // Show the error message.
            System.out.println(errortext);
            nameField.setText(errortext);
            return false;
        }
    }
    
    private boolean nameExists(){
        ArrayList<String> ret = ReadFolder.readNames("src/saves/");
        if(ret.contains(nameField.getText()))
            return true;
        return false;
    }
}
