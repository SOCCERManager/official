/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.layout.AnchorPane;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.Team;
import soccer.Wedstrijd;

/**
 * FXML Controller class
 *
 * @author codesalad
 */
public class PreGameController implements Initializable {
    
    private ObservableList<PosPlayer> userData = FXCollections.observableArrayList();
    private ObservableList<PosPlayer> enemyData = FXCollections.observableArrayList();
    private ObservableList<Wedstrijd> wedstrijdData = FXCollections.observableArrayList();
    
    @FXML
    private TableView<PosPlayer> userTeamTable;
    @FXML
    private TableColumn<PosPlayer, String> userSpelerColumn;
    @FXML
    private TableColumn<PosPlayer, String> userPositieColumn;
    @FXML
    private TableColumn<PosPlayer, Double> userScoreColumn;
    
    @FXML
    private TableView<PosPlayer> enemyTeamTable;
    @FXML
    private TableColumn<PosPlayer, String> enemySpelerColumn;
    @FXML
    private TableColumn<PosPlayer, String> enemyPositieColumn;
    @FXML
    private TableColumn<PosPlayer, Double> enemyScoreColumn;
    
    @FXML
    private TableView<Wedstrijd> resultTable;
    @FXML
    private TableColumn<Wedstrijd, String> userTeamColumn;
    @FXML
    private TableColumn<Wedstrijd, Integer> userScoregColumn;
    @FXML
    private TableColumn<Wedstrijd, Integer> userPointColumn;
    
    @FXML
    private TableColumn<Wedstrijd, String> enemyTeamColumn;
    @FXML
    private TableColumn<Wedstrijd, Integer> enemyScoregColumn;
    @FXML
    private TableColumn<Wedstrijd, Integer> enemyPointColumn;
    
    @FXML
    private Label userTeamLabel;
    @FXML
    private Label enemyTeamLabel;

    private Wedstrijd wed;
    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane compareTeamsPane;
    @FXML
    private AnchorPane resultPane;
    @FXML
    private AnchorPane invalidPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Wedstrijd w: Competitie.getCompetitie().getWedstrijden()){
            if(!w.isPlayed()){
                userData.addAll(w.getTeam_a().getOpstelling());
                enemyData.addAll(w.getTeam_b().getOpstelling());
                userTeamLabel.setText(w.getTeam_a().getName());
                enemyTeamLabel.setText(w.getTeam_b().getName());
                wedstrijdData.addAll(w);
                wed = w;
                break;
            }
        }
        
        userSpelerColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        userPositieColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(""+cellData.getValue().getPosSpelertype()));
        userScoreColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty((cellData.getValue().getAanvallend() + cellData.getValue().getDefense() + cellData.getValue().getUithoudingsvermogen()) / 300).asObject());
        userScoreColumn.setCellFactory(
                ProgressBarTableCell.<PosPlayer> forTableColumn());
        
        enemySpelerColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        enemyPositieColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(""+cellData.getValue().getPosSpelertype()));
        enemyScoreColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty((cellData.getValue().getAanvallend() + cellData.getValue().getDefense() + cellData.getValue().getUithoudingsvermogen()) / 300).asObject());
        enemyScoreColumn.setCellFactory(
                ProgressBarTableCell.<PosPlayer> forTableColumn());
        
        
        
        userTeamTable.setItems(userData);
        enemyTeamTable.setItems(enemyData);
    }    
    
    public void showCompareTeams() {
        compareTeamsPane.setVisible(true);
    }
    
    public void closeCompareTeams() {
        compareTeamsPane.setVisible(false);
    }
    
    public void closeResults() {
        resultPane.setVisible(false);
    }
    
    @FXML
    private void handlePlay() throws Exception{
        if(Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()).OpstellingIsValide()){
            System.out.println("HAHAHAHAHAHAHAHAH");
            Competitie.getCompetitie().playPlayerGame();
            drawResults();
            resultPane.setVisible(true);
        }
        else
            invalidPane.setVisible(true);
        
    }
    
    private void drawResults(){
        userTeamColumn.setText(wed.getTeam_a().getName());
        enemyTeamColumn.setText(wed.getTeam_b().getName());
        
        userScoregColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getScore_a()).asObject());
        userPointColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getPoints_a()).asObject());
        enemyScoregColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getScore_b()).asObject());
        enemyPointColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getPoints_b()).asObject());
        resultTable.setItems(wedstrijdData);
    }
}
