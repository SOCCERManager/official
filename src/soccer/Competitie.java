/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author floris
 */
public class Competitie {

    private ArrayList<Wedstrijd> wedstrijden;
    private ArrayList<Team> teams;
    private int userindex;

    /**
     * Sets private members wedstrijden and teams.
     * @param wedstrijden
     * @param teams
     */
    public Competitie(ArrayList<Wedstrijd> wedstrijden, ArrayList<Team> teams) {
        this.wedstrijden = wedstrijden;
        this.teams = teams;
    }
    public int getUserindex() {
        return userindex;
    }

    public void setUserindex(int userindex) {
        this.userindex = userindex;
    }
    
    /**
     * Returns the complete arraylist which contains the total amount of wedstrijden played.
     * @return
     */
    public ArrayList<Wedstrijd> getWedstrijden() {
        return wedstrijden;
    }

    /**
     *
     * @param wedstrijden
     */
    public void setWedstrijden(ArrayList<Wedstrijd> wedstrijden) {
        this.wedstrijden = wedstrijden;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Competitie other = (Competitie) obj;
        if (!Objects.equals(this.wedstrijden, other.wedstrijden)) {
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        return "Competitie{" + "wedstrijden=" + wedstrijden + '}';
    }
    
    /**
     * This function checks for every wedstrijd played if Team t obtained any points. If that is the case those points will be added and 
     * finally returned.
     * @param t
     * @return
     */
    public int getScoreOfTeam(Team t){
        return this.wedstrijden.stream().mapToInt(v -> v.scoreOfTeam(t)).sum();
    }
    /**
     * Creërt alle wedstrijden voor een competite uit een ArrayList van Teams.
     * @param team  ArrayList<Team>
     */ 
    public static void bouwWedstrijden(ArrayList<Team> team){
        
        ArrayList<Team> listA = new ArrayList<>();
        ArrayList<Team> listB = new ArrayList<>();
        ArrayList<Wedstrijd> wedstrijdenlijst = new ArrayList<>();
        
        
        for (int i=0; i<(team.size()/2); i++) {
            listA.add(team.get(i));
        }
        for (int p=(team.size()/2); p<team.size(); p++) {
            listB.add(team.get(p));
        }
        for (int x = 0; x<team.size()-2; x++) {
            for (int j = 0; j<listA.size(); j++) {
                wedstrijdenlijst.add(new Wedstrijd(listA.get(j), listB.get(j)));
            }

            for (int q = 0; q<listA.size(); q++){
                listB.set(0, listA.get(1));
                for (int k = 1; k<listA.size(); k++) {
                    Collections.swap(listA, k, k+1);
                }
                for (int m = 1; m<listB.size(); m++) {
                    Collections.swap(listB, m, m-1);
                }
                listA.set(listA.size(), listB.get(listB.size()));
            }
        }
        
        
    }   
}