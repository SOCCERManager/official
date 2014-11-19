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

    public Competitie(ArrayList<Wedstrijd> wedstrijden, ArrayList<Team> teams) {
        this.wedstrijden = wedstrijden;
        this.teams = teams;
    }

    public ArrayList<Wedstrijd> getWedstrijden() {
        return wedstrijden;
    }

    public void setWedstrijden(ArrayList<Wedstrijd> wedstrijden) {
        this.wedstrijden = wedstrijden;
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
    
    public int getScoreOfTeam(Team t){
        return this.wedstrijden.stream().mapToInt(v -> v.scoreOfTeam(t)).sum();
    }
}