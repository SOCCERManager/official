/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.MainApp;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Random;
import soccer.Speler;
import soccer.SpelerType;
import soccer.Team;
import soccer.Wedstrijd;

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
    private TableColumn<Speler, Double> aanvallendColumn;
    @FXML
    private TableColumn<Speler, Double> verdedigendColumn;
    @FXML
    private TableColumn<Speler, Double> staminaColumn;
    @FXML
    private TableColumn<Speler, Integer> prijsColumn;
    @FXML
    private Label budgetLabel;
    @FXML
    private VBox alert1;
    @FXML
    private TextArea alert1Text;
    @FXML
    private Button koopButton;
    @FXML
    private HBox sliderHBox;
    @FXML
    private HBox alertHBox;
    @FXML
    private Slider prijsSlider;
    @FXML
    private Label prijsLabel;
    @FXML
    private TextArea koopAlert;
    
    private Team userteam = mainhubController.originalteamlist.get(Competitie.getCompetitie().getUserindex()); 
    private HashSet<Speler> tempList = new HashSet();
    static HashSet<Speler> backupList = new HashSet();
    private MainApp mainApp = new MainApp();
    static int oldmatchplayed = 0;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertHBox.setVisible(false);
        sliderHBox.setVisible(false);
        if(oldmatchplayed == Competitie.getCompetitie().getPlayedGamesofTeam(userteam)){
            System.out.println("OLD TABLE");
            tempList = backupList;
            drawTable();
            System.out.println("old match: " +oldmatchplayed + "\nnew match: " + Competitie.getCompetitie().getPlayedGamesofTeam(userteam));
        }else{
            System.out.println("NEW TABLE");
            setData();
            backupList = tempList;
            drawTable();    
            oldmatchplayed = Competitie.getCompetitie().getPlayedGamesofTeam(userteam);
            System.out.println("old match: " +oldmatchplayed + "\nnew match: " + Competitie.getCompetitie().getPlayedGamesofTeam(userteam));
        } 
        
        marketTable.setRowFactory(tv -> {
            TableRow<Speler> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                Speler rowData = row.getItem(); 
                System.out.println("Speler: " + rowData.getNaam() + "\t\tAanvallend: "+ rowData.getAanvallend() + "\tVerdedigend: " + rowData.getVerdedigend() + "\tUithouding: " + rowData.getUithoudingsvermogen() + "\tPrijs: " + rowData.getPrijs());

                koopButton.setDisable(false);

            });
            return row;
        });        
    }
    
    private void drawBudget() {
       budgetLabel.setText("Budget: " + userteam.getBudget()); 
    }
    
    private void setData() {
        Random rnd = Random.get();
        ArrayList<Team> teamList = mainhubController.originalteamlist;
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
    }
    
    private void drawTable(){
        koopButton.setDisable(true);
        ObservableList<Speler>spelerList = FXCollections.observableArrayList();
        System.out.println(tempList.size());
        spelerList.addAll(tempList);
        
        for (int i=0; i<spelerList.size(); i++){
            //System.out.println("----Spelers: " + spelerList.get(i).getNaam()); 
        }
        
        teamColumn.setCellValueFactory(cellData -> new SimpleStringProperty(
                mainhubController.originalteamlist.stream().filter(
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
        
        marketTable.setItems(spelerList);
        prijsColumn.setSortType(TableColumn.SortType.DESCENDING);
        marketTable.getSortOrder().add(prijsColumn);
        
        aanvallendColumn.getStyleClass().add("red-bar");
        staminaColumn.getStyleClass().add("yellow-bar");
        verdedigendColumn.getStyleClass().add("blue-bar");
        
        drawBudget();
    }
    
    @FXML
    private void handleKoopSpeler() {
//        Speler temp = new Speler("New", 1, SpelerType.Aanvaller, 1, 1,1,1);
//        if(marketTable.getSelectionModel().getSelectedItem()!=null){
//            temp = marketTable.getSelectionModel().getSelectedItem();
//        }
        sliderHBox.setVisible(false);
        alertHBox.setVisible(false);
        if(marketTable.getSelectionModel().getSelectedItem()!=null){
            prijsSlider.setValue(1.0);
            prijsLabel.setText("Bied prijs: " + marketTable.getFocusModel().getFocusedItem().defineMarketValue());
            sliderHBox.setVisible(true);
        }
    }
    
    @FXML
    private void handleBiedPrijs() {        
        int prijs = marketTable.getFocusModel().getFocusedItem().getPrijs();
        int offeredPrice = ((int)((prijsSlider.getValue()*marketTable.getFocusModel().getFocusedItem().getPrijs())/1000))*1000;
        
        if((Random.get().nextFloat() < Math.max(0, Math.sqrt(prijsSlider.getValue()/2)-0.1)) && userteam.getBudget()-offeredPrice>0) {
            // Gefleicteerd!
            Speler temp = marketTable.getFocusModel().getFocusedItem();
            userteam.addSpeler(temp);
            tempList.remove(temp);

            userteam.setBudget(userteam.getBudget()-offeredPrice);


            System.out.println("Removing from market table: " + temp.getNaam());

            koopAlert.setText("Gefeliciteerd! \nSpeler " + marketTable.getFocusModel().getFocusedItem().getNaam() + " is verkocht voor: €" + offeredPrice);
            marketTable.getSelectionModel().clearSelection();
            drawTable();
        } else if(!(Random.get().nextFloat() < Math.max(0, Math.sqrt(prijsSlider.getValue()/2)-0.1)) && (userteam.getBudget()-offeredPrice>0)){
            koopAlert.setText("Het bod €" + offeredPrice + " is afgewezen, waarschijnlijk is het te laag! \nDoe een andere bod.");
        } else if(!(userteam.getBudget()-offeredPrice>0)) {
            koopAlert.setText("Het budget is te klein! \nBudget: " + userteam.getBudget() + "\nUw bod: €" + offeredPrice);
        }
        sliderHBox.setVisible(false);
        alertHBox.setVisible(true);
    }
    
    @FXML
    private void handleSlidePrice() {
        prijsLabel.setText("Bied prijs: " + ((int)((prijsSlider.getValue()*marketTable.getFocusModel().getFocusedItem().getPrijs())/1000))*1000);
    }
    
    @FXML
    private void handleCloseKoopAlert() {
        alertHBox.setVisible(false);
    }
    
    @FXML
    private void handleCloseAlert1() {
        alert1.setVisible(false);
    }

    @FXML
    private void handleExit() {
       this.mainMarketPane.setVisible(false); 
    }

}
