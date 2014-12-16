/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import soccer.Competitie;
import soccer.Speler;
import soccer.Team;

/**
 * FXML Controller class
 *
 * @author floris
 */
public class newteamscreenController implements Initializable {
    
    private ObservableList<Team> teamData = FXCollections.observableArrayList();
    @FXML
    private TableView<Team> teamTable;
    @FXML
    private TableColumn<Team, String> TeamColumn;
    
    private ObservableList<Speler> spelerData = FXCollections.observableArrayList();
    @FXML
    private TableView<Speler> spelerTable;
    @FXML
    private TableColumn<Speler, String> spelerColumn;
    @FXML
    private TableColumn<Speler, Integer> rugColumn;
    @FXML
    private TableColumn<Speler, String> positieColumn;
    @FXML
    private TableColumn<Speler, Integer> aanvalColumn;
    @FXML
    private TableColumn<Speler, Integer> verdedigingColumn;
    @FXML
    private TableColumn<Speler, Integer> staminaColumn;
    
    private MainApp mainApp;
    
    public newteamscreenController(){
        
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Team> teamList = Competitie.getCompetitie().getTeams();
        teamData.addAll(teamList);
        
        TeamColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        
        teamTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTeamDetails(newValue));
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        teamTable.setItems(teamData);
    }
    
    public void showTeamDetails(Team team){
        spelerData.clear();
        ArrayList<Speler> spelerList = team.getSpelers();
        
        spelerData.addAll(spelerList);
        
        spelerColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        rugColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getNummer()).asObject());
        positieColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(""+cellData.getValue().getType()));
        aanvalColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getAanvallend()).asObject());
        verdedigingColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getVerdedigend()).asObject());
        staminaColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getUithoudingsvermogen()).asObject());
        
        spelerTable.setItems(spelerData);
    }
    
    @FXML
    private void handleSelect(){
        Competitie.getCompetitie().setUserindex(
        Competitie.getCompetitie().getTeams().indexOf(teamTable.getSelectionModel().getSelectedItem()));
        
        mainApp.showMainHubScreen();
    }
}
