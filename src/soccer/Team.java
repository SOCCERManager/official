/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package soccer;

import java.util.ArrayList;

/**
 *
 * @author Youri
 */
public class Team {
    private ArrayList<Speler> spelers;
    private String name;
    private ArrayList<PosPlayer> opstelling;

    public Team(ArrayList<Speler> spelers, String name, ArrayList<PosPlayer> opstelling) {
        this.spelers = spelers;
        this.name = name;
        this.opstelling = opstelling;
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
}