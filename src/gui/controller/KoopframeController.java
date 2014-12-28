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
import soccer.Speler;
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
    private ObservableList<Speler>spelerList = FXCollections.observableArrayList();
    @FXML
    private TableView<Speler> marketTable;
    @FXML
    private TableColumn<Speler, String> naamColumn;
    @FXML
    private TableColumn<Team, String> teamColumn;
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
    
    private MainApp mainApp = new MainApp();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random rnd = new Random();
        ArrayList<Team> teamList = Competitie.getCompetitie().getTeams();
        HashSet tempList = new HashSet();
        //ArrayList<Speler> spelerList = new ArrayList<Speler>();
        for (int i = 0; i < rnd.nextInt(teamList.size()); i++) {
            if(teamList.get(i).equals(userteam) == false) {
                System.out.println("--Picking from team: " + teamList.get(i).getName());
                for (int j = 0; j < rnd.nextInt(teamList.get(i).getSpelers().size()); j++) {
                    tempList.add(teamList.get(i).getSpelers().get(rnd.nextInt(teamList.get(i).getSpelers().size())));
                }
            }
        }
        spelerList.addAll(tempList);
        
        for (int i=0; i<spelerList.size(); i++){
            System.out.println("----Spelers: " + spelerList.get(i).getNaam()); 
        }
        
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
       userteam.addSpeler(marketTable.getSelectionModel().getSelectedItem());
       //mainApp.showMainHubScreen();
       this.mainMarketPane.setVisible(false);
    }

}
