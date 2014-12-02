package soccer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Class Competitie
 */
public class Competitie {

    private ArrayList<Wedstrijd> wedstrijden;
    private ArrayList<Team> teams;
    private int userindex;
    /**
     * Constructor van Competitie opgebouwd uit (ArrayList<Wedstrijd> en ArrayList<Team>)
     * @param wedstrijden ArrayList<Wedstrijd>
     * @param teams ArrayList<Team>
     */
    public Competitie(ArrayList<Wedstrijd> wedstrijden, ArrayList<Team> teams) {
        this.wedstrijden = wedstrijden;
        this.teams = teams;
    }
    /**
     * Getter van UserIndex
     * @return de UserIndex
     */
    public int getUserindex() {
        return userindex;
    }

    /**
     * Setter van userIndex
     * @param userindex
     */
    public void setUserindex(int userindex) {
        this.userindex = userindex;
    }
    
    /**
     * Getter van een ArrayList<Wedstrijd>, alle wedstrijden in een competitie in een arrayList
     * @return ArrayList<Wedstrijd>, een lijst van alle wedstrijden in een competitie
     */
    public ArrayList<Wedstrijd> getWedstrijden() {
        return wedstrijden;
    }

    /**
     * Setter voor een ArrayList<Wedstrijd>, alle wedstrijden in een competitie in een arrayList
     * @param wedstrijden dit is de ArrayList<Wedstrijden die de nieuwe lijst moet worden
     */
    public void setWedstrijden(ArrayList<Wedstrijd> wedstrijden) {
        this.wedstrijden = wedstrijden;
    }

    /**
     * Getter van een ArrayList<Team> terug, alle teams in een competitie
     * @return de teams in een competitie
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * Setter voor een ArrayList<Team>, een arrayList van alle teams in een competitie
     * @param teams de arrayList van alle teams in een competitie
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    /**
     * Equals methode voor een competitie.
     * Er wordt gekeken of twee competities aan elkaar gelijk zijn.
     * @param obj de competitie waarmee de this.competitie vergeleken moet worden
     * @return true/false (als de twee competities aan elkaar gelijk zijn is de return true, anders false)
     */
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

    /**
     * toString methode voor een competitie
     * @return de String van een competitie in de vorm: Competitie{wedstrijden= x} met x als wedstrijden in de competitie
     */
    @Override
    public String toString() {
        return "Competitie{" + "wedstrijden=" + wedstrijden + '}';
    }
    
    /**
     * Als een team punten heeft gekregen na een wedstrijd, wordt dat bij het aanroepen van de functie toegevoegd aan
     * het totaal van het team. 
     * @param t het ingevoerde team waarvan het puntentotaal berekend moet worden. 
     * @return het puntentotaal van het team (int)
     */
    public int getScoreOfTeam(Team t){
        return this.wedstrijden.stream().mapToInt(v -> v.scoreOfTeam(t)).sum();
    }
    /**
     * Creërt alle wedstrijden voor een competite uit een ArrayList van Teams.
     * @param team De lijst van teams waarvoor de wedstrijden moeten worden opgeschreven. 
     */ 
    public void bouwWedstrijden(){
        
        ArrayList<Team> listA = new ArrayList<>();
        ArrayList<Team> listB = new ArrayList<>();
        
        
        for (int i=0; i<(teams.size()/2); i++) {
            listA.add(teams.get(i));
        }
        for (int p=(teams.size()/2); p<teams.size(); p++) {
            listB.add(teams.get(p));
        }
        for (int x = 0; x<teams.size()-2; x++) {
            for (int j = 0; j<listA.size(); j++) {
                wedstrijden.add(new Wedstrijd(listA.get(j), listB.get(j)));
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