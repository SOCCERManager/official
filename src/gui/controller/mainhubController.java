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
import soccer.Team;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class mainhubController implements Initializable {
    
    
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
    
//    @FXML
//    private ObservableList<Team> resultatenList = FXCollections.observableArrayList();
//    
//    @FXML
//    private TableView<Team> resultatenTable;
//    @FXML
//    private TableColumn<Team, String> teamColumn;
//    @FXML
//    private TableColumn<Team, String> puntenColumn;
//    @FXML    
//    private TableColumn<Team, String> gespeeldColumn;
//    @FXML
//    private TableColumn<Team, String> gewonnenColumn;
//    @FXML
//    private TableColumn<Team, String> gelijkspelColumn;
//    @FXML
//    private TableColumn<Team, String> verlorenColumn;
//    @FXML
//    private TableColumn<Team, String> goalsvoorColumn;
//    @FXML
//    private TableColumn<Team, String> goalstegenColumn;
//    @FXML
//    private TableColumn<Team, String> doelsaldoColumn;
//    @FXML
//    private TableColumn<Team, String> rodekaartenColumn;
//    @FXML
//    private TableColumn<Team, String> gelekaartenColumn;
    
    private MainApp mainApp;
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
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
    private void handleExit(){
        System.exit(0);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
}
