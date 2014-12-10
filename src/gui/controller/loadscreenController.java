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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import soccer.Competitie;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class loadscreenController implements Initializable {
    @FXML
    private AnchorPane loadAnchorPane;
    private GridPane loadGameGrid;
    private GridPane gameGrid = new GridPane();
    private MainApp mainApp;
    private int i = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        soccer.ReadFolder.Read();
        while(i<soccer.ReadFolder.getAantalSaveGames()) {
            //System.out.println("size is:" +soccer.ReadFolder.Read().size());
            addGames(soccer.ReadFolder.Read().get(i));
        }
        loadAnchorPane.getChildren().add(gameGrid);
    }
    
    private void addGames(String name) {
        i++;
        final Button temp = new Button(name);
        final int numButton= i;
        temp.setId("" + i);
        temp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("LAAD SPEL: " + name);
            }
        });
        gameGrid.add(temp, 1, i);
    }
    
    
    
    @FXML
    private void handleBackButton(){
        mainApp.showStartScreen();
        
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
}
