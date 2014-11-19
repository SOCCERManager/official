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
 * @author Youri
 */
public class Team {
    private ArrayList<Speler> spelers;
    private String name;
    private ArrayList<PosPlayer> opstelling;
    private Competitie competitie;

    public Team(ArrayList<Speler> spelers, String name, ArrayList<PosPlayer> opstelling, Competitie c) {
        this.spelers = spelers;
        this.name = name;
        this.opstelling = opstelling;
        this.competitie = c;
    }

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(ArrayList<Speler> spelers) {
        this.spelers = spelers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PosPlayer> getOpstelling() {
        return opstelling;
    }

    public void setOpstelling(ArrayList<PosPlayer> opstelling) {
        this.opstelling = opstelling;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        if (!Objects.equals(this.spelers, other.spelers)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.opstelling, other.opstelling)) {
            return false;
        }
        return true;
    }
    
    public int getScore(){
        return this.competitie.getScoreOfTeam(this);
    }
    
}
