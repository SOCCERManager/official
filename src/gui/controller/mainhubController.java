/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.Team;
import soccer.Wedstrijd;
import soccer.bouwXML;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class mainhubController implements Initializable {
    
    
    private static mainhubController mch;
    
    @FXML
    private Label nameLabel;
    @FXML
    private Label budgetLabel;
    @FXML
    private Label comppuntenLabel;
    @FXML
    private Label gespeeldLabel;
    @FXML
    private Label winsLabel;
    @FXML
    private Label kaartenLabel;
    
    
    @FXML
    private AnchorPane hubBanner;
    @FXML
    private AnchorPane viewPane;
    
    private Wedstrijd currentgame;
    
    private MainApp mainApp;
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        Competitie.getCompetitie().playGamesTilPlayerGameIsDue();
        
        mainhubController.mch = this;
    }    
    
    @FXML
    private void paneAdd(FXMLLoader loader) throws IOException{
        AnchorPane frame = (AnchorPane) loader.load();
           AnchorPane.setTopAnchor(frame, 0.0);
           AnchorPane.setBottomAnchor(frame, 0.0);
           AnchorPane.setLeftAnchor(frame, 0.0);
           AnchorPane.setRightAnchor(frame, 0.0);
           // Set person overview into the center of root layout.
        viewPane.getChildren().clear();
        viewPane.getChildren().setAll(frame);
    }
    @FXML
    private void handleKoop() throws IOException{
        FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("view/koopframe.fxml"));
           paneAdd(loader);
           
    }
    
    @FXML
    private void handleVeranderOpstelling() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/veranderopstelling.fxml"));
        paneAdd(loader);
                
    }
    @FXML
    private void handleVerkoop() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/verkoopframe.fxml"));
        paneAdd(loader);
    }
    @FXML
    private void handleOpstelling(){
        mainApp.showOpstellingScreen();
    }
    @FXML
    private void handleCompetitie() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/competitieframe.fxml"));
        paneAdd(loader); 
    }
    @FXML
    private void handleHistory(){
    }
    @FXML
    private void handlePlay(){
        try{
            this.currentgame = Competitie.getCompetitie().playPlayerGame();
            currentgameframeController.currentgame = currentgame;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/currentgameframe.fxml"));
            paneAdd(loader); 
            System.out.println("kkk");
        }catch(Exception e){e.printStackTrace();}
        bouwXML.SaveGame();
    }
    
    @FXML
    private void handleBackButton(){
        bouwXML.SaveGame();
        mainApp.showStartScreen();
        
    }
    
    @FXML
    private void handleTeam() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/teamframe.fxml"));
        paneAdd(loader);
    }
    
    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
//        NAAR BOVEN GEPLAATST IN INITILIZE VOOR SORTEREN.        
//        opstelTable.setItems(opstelData);
//        teamTable.setItems(teamData);
    }
    private void showSpelerDetails(Speler speler){
        
    }
    private void showOpstellingDetails(PosPlayer speler){
        
    }
    public Wedstrijd getCurrentGame(){
        return this.currentgame;
    }
}
