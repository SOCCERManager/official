/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
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
    private TableView<PosPlayer> opstellingTable;
    @FXML
    private TableColumn<PosPlayer, String> opstellingSpelersColumn;
    @FXML
    private TableColumn<PosPlayer, String> opstellingPositieColumn;
    @FXML
    private AnchorPane titlePane;
    @FXML
    private SplitPane splitPane;
    
    private Team userteam = Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()); 
    private ArrayList<Speler> teamSpelers = userteam.getSpelers();
    private ArrayList<PosPlayer> opstelling = userteam.getOpstelling();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        teamTable.setItems(filteredTeamList);
        filteredTeamColumn.setSortType(TableColumn.SortType.ASCENDING);
        teamTable.getSortOrder().add(filteredTeamColumn);
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
        opstellingTable.setItems(opstellingList);
        opstellingSpelersColumn.setSortType(TableColumn.SortType.ASCENDING);
        opstellingTable.getSortOrder().add(opstellingSpelersColumn);
    }
    
    @FXML
    private void handleRemoveFromOpstelling() {
        opstelling.remove(opstellingTable.getSelectionModel().getSelectedItem());
        for(int i=0; i<opstelling.size();i++){
            System.out.println(opstelling.get(i).getNaam());
        }
        drawOpstelling();
        drawTeam();
    }
    
    @FXML
    private void handleAddToOpstelling() {
        if(opstelling.size()<11){
            opstelling.add(teamTable.getSelectionModel().getSelectedItem());
        }
        drawOpstelling();
        drawTeam();
    }
    
    @FXML
    private void handleSaveOpstelling() {
        if(opstelling.size() == 11){
            userteam.setOpstelling(opstelling);
        }
        System.out.println("Saved new opstelling");
        for(int i=0; i<userteam.getOpstelling().size();i++){
            System.out.println(userteam.getOpstelling().get(i).getNaam());
        }
        mainOpstellingPane.setVisible(false);
    }
}
