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
import java.util.HashSet;
import java.util.Random;
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
import soccer.SpelerType;
import soccer.Team;

/**
 * FXML Controller class
 *
 * @author codesalad
 */
public class KoopframeController implements Initializable {
    @FXML
    private AnchorPane marketPane;
    @FXML
    private AnchorPane mainMarketPane;
    @FXML
    private Label marketLabel;
    @FXML
    private TableView<Speler> marketTable;
    @FXML
    private TableColumn<Speler, String> naamColumn;
    @FXML
    private TableColumn<Speler, String> teamColumn;
    @FXML
    private TableColumn<Speler, String> typeColumn;
    @FXML
    private TableColumn<Speler, Integer> aanvallendColumn;
    @FXML
    private TableColumn<Speler, Integer> verdedigendColumn;
    @FXML
    private TableColumn<Speler, Integer> staminaColumn;
    @FXML
    private TableColumn<Speler, Integer> prijsColumn;
    @FXML
    private Team userteam = Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()); 
    private HashSet<Speler> tempList = new HashSet();
    private MainApp mainApp = new MainApp();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Random rnd = new Random();
        ArrayList<Team> teamList = Competitie.getCompetitie().getTeams();
        for (int i = 0; i < rnd.nextInt(teamList.size()); i++) {
            int randomTeamIndex = rnd.nextInt(teamList.size());
            if(teamList.get(randomTeamIndex).equals(userteam) == false) {
                for (int j = 0; j < rnd.nextInt(teamList.get(randomTeamIndex).getSpelers().size()); j++) {
                    int randomSpelerIndex = rnd.nextInt(teamList.get(randomTeamIndex).getSpelers().size());
                    if(!teamList.get(randomTeamIndex).getOpstelling().contains(new PosPlayer(teamList.get(randomTeamIndex).getSpelers().get(randomSpelerIndex), teamList.get(randomTeamIndex).getSpelers().get(randomSpelerIndex).getType()))){
                        tempList.add(teamList.get(randomTeamIndex).getSpelers().get(randomSpelerIndex));
                    }
                }
            }
        }
        
        drawTable();        
    }
    
    private void drawTable(){
        ObservableList<Speler>spelerList = FXCollections.observableArrayList();
        spelerList.addAll(tempList);
        
        for (int i=0; i<spelerList.size(); i++){
            //System.out.println("----Spelers: " + spelerList.get(i).getNaam()); 
        }
        
        teamColumn.setCellValueFactory(cellData -> new SimpleStringProperty(
                Competitie.getCompetitie().getTeams().stream().filter(
                    v->v.getSpelers().contains(cellData.getValue())
                ).findFirst().orElse(
                        new Team(
                                new ArrayList<>(), 
                                "No Team", 
                                new ArrayList<>(), 
                                Competitie.getCompetitie(), 
                                0
                        )
                ).getName()
            ));
        
        naamColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        typeColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(""+cellData.getValue().getType()));
        aanvallendColumn.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().getAanvallend()).asObject());
        verdedigendColumn.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().getVerdedigend()).asObject());
        staminaColumn.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().getUithoudingsvermogen()).asObject());
        prijsColumn.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().defineMarketValue()).asObject());
        
        marketTable.setItems(spelerList);
        prijsColumn.setSortType(TableColumn.SortType.DESCENDING);
        marketTable.getSortOrder().add(prijsColumn);
    }
    
    @FXML
    private void handleKoopSpeler() {
//        Speler temp = new Speler("New", 1, SpelerType.Aanvaller, 1, 1,1,1);
//        if(marketTable.getSelectionModel().getSelectedItem()!=null){
//            temp = marketTable.getSelectionModel().getSelectedItem();
//        }
        if(marketTable.getSelectionModel().getSelectedItem()!=null){
            Speler temp = marketTable.getFocusModel().getFocusedItem();
            System.out.println(temp);
            userteam.addSpeler(temp);

            tempList.remove(temp);
            marketTable.getSelectionModel().clearSelection();
            System.out.println("Removing from table: " + temp.getNaam());
            //mainApp.showMainHubScreen();

            drawTable();
        }else{
            System.out.println("You've encoutered the bug dragon, the player this table thinks it's selecting is null!");
        }
    }
    
    @FXML
    private void handleExit() {
       this.mainMarketPane.setVisible(false); 
    }

}
