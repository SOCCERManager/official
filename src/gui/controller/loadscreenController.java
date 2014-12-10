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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import soccer.Competitie;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.REMAINING;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class loadscreenController implements Initializable {
    
    @FXML
    private AnchorPane loadAnchorPane;
    @FXML
    private GridPane gameGrid = new GridPane();
    @FXML
    private ScrollPane loadPane;
    private MainApp mainApp;
    
    public static String savegame;
    private int i = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadPane.setStyle("-fx-background:none;");
        loadAnchorPane.setStyle("-fx-background:none;");
        gameGrid.setStyle("-fx-background:none;");
        soccer.ReadFolder.readNames("/src/saves");
        while(i<soccer.ReadFolder.getAantalSaveGames()) {
            //System.out.println("size is:" +soccer.ReadFolder.Read().size());
            addGames(soccer.ReadFolder.readNames("/src/saves").get(i));
        }
        
        
        loadAnchorPane.getChildren().add(gameGrid);
        AnchorPane.setLeftAnchor(gameGrid, 0.0);
        AnchorPane.setRightAnchor(gameGrid, 0.0);
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setVgap(12);
        gameGrid.setAlignment(Pos.CENTER); 
    }
    
    private void addGames(String name) {
        i++;
        final Button temp = new Button(name);
        final int numButton= i;
        temp.setId("" + i);
        temp.setMinWidth(450.0);
        temp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
            Competitie c = soccer.bouwXML.leesXML(new File("src/saves/"+name+".xml"));
            }catch(Exception qq){System.out.println(qq);}
            savegame = name;
            mainApp.showMainHubScreen();
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
