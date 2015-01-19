/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    @FXML
    private AnchorPane mainWinnerPane;
    @FXML
    private Label team2;
    @FXML
    private Label team1;
    @FXML
    private Label team3;
    @FXML
    private AnchorPane winnerVideoPane;
    @FXML
    private HBox videoViewer;
    @FXML
    private VBox videoVBox;
    @FXML
    private AnchorPane pregamePane;
    
    private MediaPlayer vplayer;

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
        if(Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()).OpstellingIsValide() && Competitie.getCompetitie().gamesLeftToPlay()){
            Competitie.getCompetitie().playPlayerGame();
            drawResults();
            resultPane.setVisible(true);
        }
        else {
            invalidPane.setVisible(true);
            //MOET NOG ZEGGEN DAT DE COMPETITIE VOORBIJ IS.
            //MOET NOG VRAGEN OF SPELER OPNIEUW WIL SPELEN.
        }
        //if no more games:
        if(Competitie.getCompetitie().gamesLeftToPlay() == false) {
            ArrayList<Team> teamCopy = new ArrayList<Team>(Competitie.getCompetitie().getTeams());
            Collections.sort(teamCopy, (Team t1, Team t2) -> Integer.compare(t1.getScore(), t2.getScore()));
            if(teamCopy.get(teamCopy.size()-1).equals(Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()))) {
                //Your team wins :D
                //Show video
                
                File vfile = new File("./src/media/goldencup.mp4");
                Media vmedia = new Media(vfile.toURI().toString());
                vplayer = new MediaPlayer(vmedia);
                MediaView vviewer = new MediaView(vplayer);
                vplayer.setAutoPlay(true);
                vplayer.setCycleCount(Integer.MAX_VALUE);
                vviewer.setFitHeight(winnerVideoPane.getHeight());
                winnerVideoPane.getChildren().add(vviewer);

                pregamePane.setVisible(false);
                invalidPane.setVisible(false);

                //videoVBox.setOpacity(1);
                videoVBox.setVisible(true);
 
            } else {
                //Show generic winner stage 
                team1.setText(teamCopy.get(teamCopy.size()-1).getName());
                team2.setText(teamCopy.get(teamCopy.size()-2).getName());
                team3.setText(teamCopy.get(teamCopy.size()-3).getName());
                mainWinnerPane.setVisible(true);
            }
        }
    }
    
    @FXML
    private void handleCloseVideo() {
        vplayer.stop();
        videoVBox.setVisible(false);
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
    
        @FXML
    private void handleCloseWinners(ActionEvent event) {
        mainWinnerPane.setVisible(false);
    }    
}
