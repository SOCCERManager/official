/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.Team;
import soccer.bouwXML;

/**
 * FXML Controller class
 *
 * @author codesalad
 */
public class veranderOpstellingController implements Initializable {
    @FXML
    private AnchorPane mainOpstellingPane;
    @FXML
    private Label opstellingLabel;
    @FXML
    private TableView<PosPlayer> teamTable;
    @FXML
    private TableColumn<PosPlayer, String> filteredTeamColumn;
    @FXML
    private TableColumn<PosPlayer, String> filteredPositieColumn;
    @FXML
    private TableColumn<PosPlayer, Double> filteredAanvalColumn;
    @FXML
    private TableColumn<PosPlayer, Double> filteredStaminaColumn;
    @FXML
    private TableColumn<PosPlayer, Double> filteredVerdedigingColumn;
    @FXML
    private TableColumn<PosPlayer, String> filteredStatusColumn;
    
    @FXML
    private TableView<PosPlayer> opstellingTable;
    @FXML
    private TableColumn<PosPlayer, String> opstellingSpelersColumn;
    @FXML
    private TableColumn<PosPlayer, String> opstellingPositieColumn;
    @FXML
    private TableColumn<PosPlayer, Double> opstellingAanvalColumn;
    @FXML
    private TableColumn<PosPlayer, Double> opstellingStaminaColumn;
    @FXML
    private TableColumn<PosPlayer, Double> opstellingVerdedigingColumn;
    @FXML
    private TableColumn<PosPlayer, String> opstellingStatusColumn;
    @FXML
    private AnchorPane titlePane;
    @FXML
    private SplitPane splitPane;
    @FXML
    private VBox helpMessage;
    @FXML
    private VBox alert1;
    @FXML
    private TextArea alert1Text;
    @FXML 
    private VBox alert2;
    @FXML
    private TextArea alert2Text;
    @FXML
    private Button opstellingRemoveButton;
    @FXML
    private Button opstellingAddButton;

    
    private Team userteam = mainhubController.originalteamlist.get(Competitie.getCompetitie().getUserindex()); 
    private ArrayList<Speler> teamSpelers = userteam.getSpelers();
    private ArrayList<PosPlayer> opstelling = userteam.getOpstelling();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()).getName()+"HIER KIJK IK");
        System.out.println(mainhubController.originalteamlist.get(Competitie.getCompetitie().getUserindex()).getName()+" HIER KIJK IK NU2");
        opstellingRemoveButton.setDisable(false);
        opstellingAddButton.setDisable(true);
        drawOpstelling();
        drawTeam();
        
        
    }    
    
    public void drawTeam() {
        ObservableList<PosPlayer>filteredTeamList = FXCollections.observableArrayList();
        ArrayList<PosPlayer> allPosPlayers = new ArrayList<PosPlayer>();
        ArrayList<PosPlayer> filteredTeam = new ArrayList<PosPlayer>();
        filteredTeamList.removeAll();
        for(int i=0; i<teamSpelers.size(); i++){
            allPosPlayers.add(new PosPlayer(teamSpelers.get(i), teamSpelers.get(i).getType()));
        }
        
        for(int i=0; i<allPosPlayers.size(); i++){
            if(opstelling.contains(allPosPlayers.get(i)) == false){
                filteredTeam.add(allPosPlayers.get(i));
            }
        }
        
        filteredTeamList.addAll(filteredTeam);
        filteredTeamColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        filteredPositieColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(""+cellData.getValue().getType()));
        
        filteredAanvalColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getAanvallend() * 0.01)).asObject());
        filteredAanvalColumn.setCellFactory(
                ProgressBarTableCell.<PosPlayer> forTableColumn());
        
        filteredStaminaColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getUithoudingsvermogen()* 0.01)).asObject());
        filteredStaminaColumn.setCellFactory(
                ProgressBarTableCell.<PosPlayer> forTableColumn());
        
        filteredVerdedigingColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getVerdedigend()* 0.01)).asObject());
        filteredVerdedigingColumn.setCellFactory(
                ProgressBarTableCell.<PosPlayer> forTableColumn());
        
        filteredStatusColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(""+cellData.getValue().getStatus()));
        
        
        teamTable.setItems(filteredTeamList);
        filteredTeamColumn.setSortType(TableColumn.SortType.ASCENDING);
        teamTable.getSortOrder().add(filteredTeamColumn);
        
        filteredAanvalColumn.getStyleClass().add("red-bar");
        filteredStaminaColumn.getStyleClass().add("yellow-bar");
        filteredVerdedigingColumn.getStyleClass().add("blue-bar");
    }
    
    public void drawOpstelling() {
        ObservableList<PosPlayer>opstellingList = FXCollections.observableArrayList();
        opstellingList.removeAll();
        opstellingList.addAll(opstelling);
        System.out.println("DRAW OPSTELLING "+opstellingList.size());
        opstellingSpelersColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        opstellingPositieColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(""+cellData.getValue().getType()));
        opstellingAanvalColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getAanvallend() * 0.01)).asObject());
        opstellingAanvalColumn.setCellFactory(
                ProgressBarTableCell.<PosPlayer> forTableColumn());
        opstellingStaminaColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getUithoudingsvermogen()* 0.01)).asObject());
        opstellingStaminaColumn.setCellFactory(
                ProgressBarTableCell.<PosPlayer> forTableColumn());
        opstellingVerdedigingColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getVerdedigend()* 0.01)).asObject());
        opstellingVerdedigingColumn.setCellFactory(
                ProgressBarTableCell.<PosPlayer> forTableColumn());
        opstellingStatusColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(""+cellData.getValue().getStatus()));
        opstellingTable.setItems(opstellingList);
        opstellingSpelersColumn.setSortType(TableColumn.SortType.ASCENDING);
        opstellingTable.getSortOrder().add(opstellingSpelersColumn);
        
        opstellingAanvalColumn.getStyleClass().add("red-bar");
        opstellingStaminaColumn.getStyleClass().add("yellow-bar");
        opstellingVerdedigingColumn.getStyleClass().add("blue-bar");
    }
    
    @FXML
    private void handleRemoveFromOpstelling() {
        opstelling.remove(opstellingTable.getSelectionModel().getSelectedItem());
        if(opstelling.size()==0){
            opstellingRemoveButton.setDisable(true);
        }
        if(opstelling.size()<11){
            opstellingAddButton.setDisable(false);
        }
        drawOpstelling();
        drawTeam();
    }
    
    @FXML
    private void handleAddToOpstelling() {
        if(opstelling.size()<11){
            if(!teamTable.getSelectionModel().getSelectedItem().isUnavaliableToPlay()) {
                opstelling.add(teamTable.getSelectionModel().getSelectedItem());
            } else {
                alert2Text.setText("Speler is niet beschikbaar: " + teamTable.getSelectionModel().getSelectedItem().getStatus() + "!");
                alert2.setVisible(true);
            }
            if(opstelling.size()==11){
                opstellingAddButton.setDisable(true);
            }
        }
        opstellingRemoveButton.setDisable(false);
        drawOpstelling();
        drawTeam();
    }
    
    @FXML
    private void handleSaveOpstelling() {
        if(opstelling.size() == 11){
            userteam.setOpstelling(opstelling);
            //mainhubController.setOpstellingTable();
            mainOpstellingPane.setVisible(false);
            bouwXML.SaveGame();
        }else{
            alert1Text.setText("De opstelling bevat niet genoeg spelers! (" + Integer.toString(opstelling.size()) + "/11 spelers)");
            alert1.setVisible(true);
        }
        System.out.println("Saved new opstelling");
        for(int i=0; i<userteam.getOpstelling().size();i++){
            System.out.println(userteam.getOpstelling().get(i).getNaam());
        }
    }
    
    @FXML
    private void handleCloseHelpMessage(){
        helpMessage.setVisible(false);
    }
    
    @FXML
    private void handleCloseAlert1() {
        alert1.setVisible(false);
    }
    
    @FXML
    private void handleCloseAlert2() {
        alert2.setVisible(false);
    }

            

   

}
