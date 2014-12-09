/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author codesalad
 */
public class mainController implements Initializable {
    
    @FXML
    private Label label;
    
    private MainApp mainApp;
    
    @FXML
    private void handleLoadButton(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        mainApp.showLoadScreen();
    }
    
    @FXML
    private void handleNewGameButton(ActionEvent event) {
        mainApp.showNewGameScreen();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
