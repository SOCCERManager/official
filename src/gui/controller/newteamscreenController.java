/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.ProgressBarTableCell;
import soccer.Competitie;
import soccer.Speler;
import soccer.Team;
import soccer.bouwXML;
import static soccer.bouwXML.bouwXML;

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
    private TableColumn<Speler, Double> aanvalColumn;
    @FXML
    private TableColumn<Speler, Double> verdedigingColumn;
    @FXML
    private TableColumn<Speler, Double> staminaColumn;
    
    private MainApp mainApp;
    
    public newteamscreenController(){
        
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            for(int i = 0; i < Competitie.getCompetitie().getTeams().size(); i++){
                Competitie.getCompetitie().getTeams().get(i).generateOpstelling();
            }
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
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getAanvallend()* 0.01)).asObject());
        aanvalColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        verdedigingColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getVerdedigend()* 0.01)).asObject());
        verdedigingColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        staminaColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getUithoudingsvermogen()* 0.01)).asObject());
        staminaColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        
        spelerTable.setItems(spelerData);
        
        aanvalColumn.getStyleClass().add("red-bar");
        staminaColumn.getStyleClass().add("yellow-bar");
        verdedigingColumn.getStyleClass().add("blue-bar");
    }
    
    @FXML
    private void handleSelect() throws IOException{
        Competitie.getCompetitie().setUserindex(
        Competitie.getCompetitie().getTeams().indexOf(teamTable.getSelectionModel().getSelectedItem()));
        bouwXML.SaveGame();
        mainApp.showMainHubScreen();
    }
}
