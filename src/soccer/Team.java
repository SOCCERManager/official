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
    private int budget;

    /**
     * This constructor sets the private variables spelers, name, opstelling and c.
     * @param spelers
     * @param name
     * @param opstelling
     * @param c
     * @param budget
     */
    public Team(ArrayList<Speler> spelers, String name, ArrayList<PosPlayer> opstelling, Competitie c, int budget) {
        this.spelers = spelers;
        this.name = name;
        this.opstelling = opstelling;
        this.competitie = c;
        this.budget = budget;
    }

    /**
     * Budget van het team
     * @return Het budget van het team.
     */
    public int getBudget(){
        return budget;
    }
    
    public void setBudget(int budget){
        this.budget = budget;
    }
    
    /**
     * Returns the arraylist which contains all the spelers in a team.
     * @return
     */
    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    /**
     *
     * @param spelers
     */
    public void setSpelers(ArrayList<Speler> spelers) {
        this.spelers = spelers;
    }

    /**
     * Returns the name of the team.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the current opstelling of the team.
     * @return
     */
    public ArrayList<PosPlayer> getOpstelling() {
        return opstelling;
    }

    /**
     *
     * @param opstelling
     */
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
        if (!Objects.equals(this.competitie, other.competitie)) {
            return false;
        }
        if (this.budget != other.budget) {
            return false;
        }
        return true;
    }

    
    /**
     * Calls the function getScoreOfTeam which returns an integer and consists out of the total amount of points gained.
     * @return
     */
    public int getScore(){
        return this.competitie.getScoreOfTeam(this);
    }
    
    /**
     * Method to be called when playing a game.
     */
    public void playGame() {
        for(Speler s: this.spelers)
            s.playGame();
    }
    
    public boolean OpstellingIsValide() {
        return this.opstelling.size() == 11 && ((int) this.opstelling.stream().filter(v -> v.isUnavaliableAvaliableToPlay()).count()) == 0;
    }
    
    public void generateOpstelling() {
        
        // To many players injured, lets magialy fix some (:
        while(this.spelers.stream().filter(v -> v.isUnavaliableAvaliableToPlay()).count() >= 11)
            for(Speler s:this.spelers)
                if(s.isUnavaliableAvaliableToPlay()) {
                    s.magicalyFix();
                    break;
                }
        
        this.opstelling = new ArrayList<>();
        
        // See if doelman is avaliable
        boolean dedicated_goalie = this.spelers.stream().filter(v -> v.isAvaliableToPlay()).filter(v -> v.getType().equals(SpelerType.Doelman)).count() > 1;
        
        // Set doelman
        for(Speler s: this.spelers)
            if(!dedicated_goalie || s.getType().equals(SpelerType.Doelman))
                this.opstelling.add(new PosPlayer(s, s.getType()));
                    
        // set other players
        for(Speler s: this.spelers) {
            if(this.opstelling.size() <= 11 && !s.isUnavaliableAvaliableToPlay() && !this.opstelling.contains(s))
                 this.opstelling.add(new PosPlayer(s, s.getType()));
        }
    }
    
    public int getAanvallendTotaal() {
        if(!this.OpstellingIsValide())
            this.generateOpstelling();
        
        return this.opstelling.stream().mapToInt(v -> v.getAanvallend()).sum();
    }
    
    public int getVerdedigingsTotaal() {
        if(!this.OpstellingIsValide())
            this.generateOpstelling();
        
        return this.opstelling.stream().mapToInt(v -> v.getVerdedigend()).sum();
    }
    public int getUithoudingsTotaal() {
        if(!this.OpstellingIsValide())
            this.generateOpstelling();
        
        return this.opstelling.stream().mapToInt(v -> v.getUithoudingsvermogen()).sum();
    }
    
    
    public int getTotalStat() {
        return this.getAanvallendTotaal() + this.getVerdedigingsTotaal() + this.getUithoudingsTotaal();
    }
}
