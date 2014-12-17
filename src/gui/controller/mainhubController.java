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

/**
 * FXML Controller class
 *
 * @author floris
 */
public class mainhubController implements Initializable {
    private Team userteam = Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex());
    private ObservableList<Speler> teamData = FXCollections.observableArrayList();
    @FXML
    private TableView<Speler> teamTable;
    @FXML
    private TableColumn<Speler, String> zijteamColumn;
    @FXML
    private TableColumn<Speler, Integer> zijrugColumn;
    @FXML
    private TableColumn<Speler, String> zijnaamColumn;
    
    private ObservableList<PosPlayer> opstelData = FXCollections.observableArrayList();
    @FXML
    private TableView<PosPlayer> opstelTable;
    @FXML
    private TableColumn<PosPlayer, Integer> opstelrugColumn;
    @FXML
    private TableColumn<PosPlayer, String> opstelnaamColumn;
    @FXML
    private TableColumn<PosPlayer, String> opstelposColumn;
    
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
    private Label gameLabel;
    
    @FXML
    private AnchorPane hubBanner;
    @FXML
    private AnchorPane viewPane;
    
    private MainApp mainApp;
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        Competitie.getCompetitie().playGamesTilPlayerGameIsDue();
        teamData.addAll(userteam.getSpelers());
        if(!userteam.OpstellingIsValide())
            userteam.generateOpstelling();
        opstelData.addAll(userteam.getOpstelling());
        
        zijteamColumn.setText(userteam.getName());
        zijnaamColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        zijrugColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getNummer()).asObject());
        
        opstelnaamColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        opstelrugColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getNummer()).asObject());
        opstelposColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(""+cellData.getValue().getPosSpelertype()));
        
        
        teamTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSpelerDetails(newValue));
        opstelTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showOpstellingDetails(newValue));
        // TODO
        gameLabel.setText(loadscreenController.savegame);
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
    private void handlePlay(){
        try{
            Competitie.getCompetitie().playPlayerGame();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/currentgameframe.fxml"));
            paneAdd(loader); 
            System.out.println("kkk");
        }catch(Exception e){e.printStackTrace();}
    }
    
    @FXML
    private void handleBackButton(){
        mainApp.showStartScreen();
        
    }
    
    @FXML
    private void handleExit(){
        System.exit(0);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        opstelTable.setItems(opstelData);
        teamTable.setItems(teamData);
    }
    private void showSpelerDetails(Speler speler){
        
    }
    private void showOpstellingDetails(PosPlayer speler){
        
    }
}
