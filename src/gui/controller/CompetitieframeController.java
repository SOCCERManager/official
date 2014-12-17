/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import soccer.Competitie;
import soccer.Team;

/**
 * FXML Controller class
 *
 * @author codesalad
 */
public class CompetitieframeController implements Initializable {
    @FXML
    private ObservableList<Team> resultatenList = FXCollections.observableArrayList();
    @FXML
    private TableView<Team> resultatenTable;
    @FXML
    private TableColumn<Team, String> teamColumn;
    @FXML
    private TableColumn<Team, Integer> puntenColumn;
    @FXML    
    private TableColumn<Team, Integer> gespeeldColumn;
    @FXML
    private TableColumn<Team, Integer> gewonnenColumn;
    @FXML
    private TableColumn<Team, Integer> gelijkspelColumn;
    @FXML
    private TableColumn<Team, Integer> verlorenColumn;
    @FXML
    private TableColumn<Team, Integer> goalsvoorColumn;
    @FXML
    private TableColumn<Team, Integer> goalstegenColumn;
    @FXML
    private TableColumn<Team, Integer> doelsaldoColumn;
    @FXML
    private TableColumn<Team, Integer> rodekaartenColumn;
    @FXML
    private TableColumn<Team, Integer> gelekaartenColumn;
    @FXML
    private TableColumn<Team, Integer> blessureColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Team> teamList = Competitie.getCompetitie().getTeams();
        resultatenList.addAll(teamList);
        System.out.println(resultatenList);
        teamColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        puntenColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getScore()).asObject());        
        gespeeldColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getPlayed()).asObject());
        gewonnenColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getWins()).asObject());         
        gelijkspelColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getDraws()).asObject());         
        verlorenColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getLosses()).asObject());         
        goalsvoorColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getGoals()).asObject());         
        goalstegenColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getCounterGoals()).asObject());         
        doelsaldoColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getGoalSaldo()).asObject());         
        rodekaartenColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().countRedCards()).asObject());         
        gelekaartenColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().countYellowCards()).asObject());  
        blessureColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().countGebleseerd()).asObject());
      resultatenTable.setItems(resultatenList);  
        teamColumn.isVisible();
    }    
    
}
