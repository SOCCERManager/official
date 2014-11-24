/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.util.ArrayList;
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
}