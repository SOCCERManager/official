/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.Team;

/**
 * FXML Controller class
 *
 * @author codesalad
 */
public class VerkoopframeController implements Initializable {
    @FXML
    private AnchorPane mainVerkoopPane;
    @FXML
    private AnchorPane verkoopPane;
    @FXML
    private Label verkoopLabel;
    @FXML
    private Button verkoopButton;
    @FXML
    private Button exitSellButton;
    @FXML
    private Label budgetLabel;
    @FXML
    private TableView<Speler> sellTable;
    @FXML
    private TableColumn<Speler, Integer> rugnummer;
    @FXML
    private TableColumn<Speler, String> naamColumn;
    @FXML
    private TableColumn<Speler, String> teamColumn;
    @FXML
    private TableColumn<Speler, String> typeColumn;
    @FXML
    private TableColumn<Speler, Double> aanvallendColumn;
    @FXML
    private TableColumn<Speler, Double> verdedigendColumn;
    @FXML
    private TableColumn<Speler, Double> staminaColumn;
    @FXML
    private TableColumn<Speler, Integer> prijsColumn;
    @FXML
    private VBox alert1;
    @FXML
    private TextArea alert1Text;
    private Team userteam = Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()); 
    private ArrayList<Speler> toSell = new ArrayList();
    private ArrayList<Team> teamOffers = new ArrayList();
    static ArrayList<Speler> backupSpelerList = new ArrayList();
    static ArrayList<Team> backupTeamList = new ArrayList();
    static int oldmatchplayed = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(oldmatchplayed == Competitie.getCompetitie().getPlayedGamesofTeam(userteam)){
            toSell = backupSpelerList;
            teamOffers = backupTeamList;
            drawTable();
        }else{
            setData();
            backupSpelerList = toSell;
            backupTeamList = teamOffers;
            drawTable();    
            oldmatchplayed = Competitie.getCompetitie().getPlayedGamesofTeam(userteam);
        } 
    }   
    
    private void drawBudget() {
       budgetLabel.setText("Budget: " + userteam.getBudget()); 
    }
    
    private void setData(){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(userteam.getSpelers().size());
        for ( int i = 0; i<randomNumber; i++){
        int randomSpeler = rnd.nextInt(userteam.getSpelers().size());
        int randomTeam = rnd.nextInt(Competitie.getCompetitie().getTeams().size());            
            if (toSell.contains(userteam.getSpelers().get(randomSpeler)) == false && userteam.getOpstelling().contains(userteam.getSpelers().get(randomSpeler)) == false) {
                toSell.add(userteam.getSpelers().get(randomSpeler));
                teamOffers.add(Competitie.getCompetitie().getTeams().get(randomTeam));
            }
        }
        System.out.println("Spelersize: " + toSell.size());
        System.out.println("Teamsize: " + teamOffers.size());
        
    }
    
    private void drawTable(){
        ObservableList<Speler> spelerList = FXCollections.observableArrayList();
        spelerList.addAll(toSell);
        rugnummer.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().getNummer()).asObject());
        naamColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(cellData.getValue().getNaam()));
        teamColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(teamOffers.get(spelerList.indexOf(cellData.getValue())).getName()));        
        typeColumn.setCellValueFactory(
            cellData -> new SimpleStringProperty(""+cellData.getValue().getType()));
        aanvallendColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getAanvallend()* 0.01)).asObject());
        aanvallendColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        verdedigendColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getVerdedigend()* 0.01)).asObject());
        verdedigendColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        staminaColumn.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(new Double(cellData.getValue().getUithoudingsvermogen()* 0.01)).asObject());
        staminaColumn.setCellFactory(
                ProgressBarTableCell.<Speler> forTableColumn());
        prijsColumn.setCellValueFactory(
            cellData -> new SimpleIntegerProperty(cellData.getValue().defineMarketValue()).asObject());
        
        sellTable.setItems(spelerList);
        prijsColumn.setSortType(TableColumn.SortType.DESCENDING);
        sellTable.getSortOrder().add(prijsColumn);
        
        aanvallendColumn.getStyleClass().add("red-bar");
        staminaColumn.getStyleClass().add("yellow-bar");
        verdedigendColumn.getStyleClass().add("blue-bar");
        
        drawBudget();
    }

    @FXML
    private void handleVerkoopSpeler(ActionEvent event) {
        if(sellTable.getSelectionModel().getSelectedItem()!=null){
            Speler temp = sellTable.getFocusModel().getFocusedItem();
            System.out.println(temp);
            System.out.println(userteam.getSpelers().size());
            userteam.getSpelers().remove(temp);
            System.out.println(userteam.getSpelers().size());
            teamOffers.get(toSell.indexOf(temp)).addSpeler(temp);

            
            toSell.remove(temp);

            userteam.setBudget(userteam.getBudget()+temp.defineMarketValue());

            sellTable.getSelectionModel().clearSelection();

            drawTable();
        }else{
            System.out.println("You've encoutered the bug dragon, the player this table thinks it's selecting is null!");
        }        
    }

    @FXML
    private void handleExit(ActionEvent event) {
        this.mainVerkoopPane.setVisible(false);
    }

    @FXML
    private void handleCloseAlert1(ActionEvent event) {
        
    }
    
}
