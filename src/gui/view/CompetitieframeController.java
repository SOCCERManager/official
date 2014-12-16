/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    private TableColumn<Team, String> puntenColumn;
    @FXML    
    private TableColumn<Team, String> gespeeldColumn;
    @FXML
    private TableColumn<Team, String> gewonnenColumn;
    @FXML
    private TableColumn<Team, String> gelijkspelColumn;
    @FXML
    private TableColumn<Team, String> verlorenColumn;
    @FXML
    private TableColumn<Team, String> goalsvoorColumn;
    @FXML
    private TableColumn<Team, String> goalstegenColumn;
    @FXML
    private TableColumn<Team, String> doelsaldoColumn;
    @FXML
    private TableColumn<Team, String> rodekaartenColumn;
    @FXML
    private TableColumn<Team, String> gelekaartenColumn;
    @FXML
    private TableColumn<Team, String> blessureColumn;

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
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getScore())));        
        gespeeldColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getPlayed())));
        gewonnenColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getWins())));         
        gelijkspelColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getDraws())));         
        verlorenColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getLosses())));         
        goalsvoorColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getGoals())));         
        goalstegenColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getCounterGoals())));         
        doelsaldoColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getGoalSaldo())));         
        rodekaartenColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().countRedCards())));         
        gelekaartenColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().countYellowCards())));  
        blessureColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().countGebleseerd())));
      resultatenTable.setItems(resultatenList);  
        teamColumn.isVisible();
    }    
    
}
