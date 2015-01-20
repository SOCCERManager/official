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
    private static Competitie c;

    /**
     * Constructor van Competitie opgebouwd uit (ArrayList en
     * ArrayList)
     *
     * @param wedstrijden ArrayList
     * @param teams ArrayList
     */
    public Competitie(ArrayList<Wedstrijd> wedstrijden, ArrayList<Team> teams) {
        this.wedstrijden = wedstrijden;
        this.teams = teams;
        Competitie.c = this;
    }

    /**
     * Getter van UserIndex
     *
     * @return de UserIndex
     */
    public int getUserindex() {
        return userindex;
    }

    /**
     * Setter van userIndex
     *
     * @param userindex Index van de user
     */
    public void setUserindex(int userindex) {
        this.userindex = userindex;
    }

    /**
     * Getter van een ArrayList, alle wedstrijden in een competitie
     * in een arrayList
     *
     * @return ArrayList<Wedstrijd>, een lijst van alle wedstrijden in een
     * competitie
     */
    public ArrayList<Wedstrijd> getWedstrijden() {
        return wedstrijden;
    }

    /**
     * Setter voor een ArrayList<Wedstrijd>, alle wedstrijden in een competitie
     * in een arrayList
     *
     * @param wedstrijden dit is de ArrayList die de nieuwe lijst
     * moet worden
     */
    public void setWedstrijden(ArrayList<Wedstrijd> wedstrijden) {
        this.wedstrijden = wedstrijden;
    }

    /**
     * Getter van een ArrayList terug, alle teams in een competitie
     *
     * @return de teams in een competitie
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * Setter voor een ArrayList, een arrayList van alle teams in een
     * competitie
     *
     * @param teams de arrayList van alle teams in een competitie
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    /**
     * Equals methode voor een competitie. Er wordt gekeken of twee competities
     * aan elkaar gelijk zijn.
     *
     * @param obj de competitie waarmee de this.competitie vergeleken moet
     * worden
     * @return true/false (als de twee competities aan elkaar gelijk zijn is de
     * return true, anders false)
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
     *
     * @return de String van een competitie in de vorm: Competitie{wedstrijden=
     * x} met x als wedstrijden in de competitie
     */
    @Override
    public String toString() {
        return "Competitie{" + "wedstrijden=" + wedstrijden + ", teams=" + teams + ", userindex=" + userindex + '}';
    }

    /**
     * Als een team punten heeft gekregen na een wedstrijd, wordt dat bij het
     * aanroepen van de functie toegevoegd aan het totaal van het team.
     *
     * @param t het ingevoerde team waarvan het puntentotaal berekend moet
     * worden.
     * @return het puntentotaal van het team (int)
     */
    public int getScoreOfTeam(Team t) {
        return this.wedstrijden.stream().mapToInt(v -> v.scoreOfTeam(t)).sum();
    }

    /**
     * Return the amount of wins of a team
     * @param t team
     * @return the amount of wins
     */
    public int getWinsOfTeam(Team t) {
        return (int) this.wedstrijden.stream().filter(v -> v.teamWon(t)).count();
    }
    
    /**
     * Return the amount of draws of a team
     * @param t team
     * @return the amount of draws
     */
    public int getDrawsOfTeam(Team t) {
        return (int) this.wedstrijden.stream().filter(v -> v.teamDrawed(t)).count();
    }

    /**
     * Return the amount of losses per team
     * @param t team
     * @return the amount of losses
     */
    public int getLossesOfTeam(Team t) {
        return (int) this.wedstrijden.stream().filter(v -> v.isPlayed()).filter(v -> v.teamLost(t)).count();
    }

    /**
     * Return the amount of played games per team
     * @param t team
     * @return the amount of played games
     */
    public int getPlayedGamesofTeam(Team t) {
        return (int) this.wedstrijden.stream().filter(v -> v.teamPlayed(t)).count();
    }

    /**
     * Return the amount of goals per team
     * @param t team
     * @return the amount of scored goals
     */
    public int getGoalsofTeam(Team t) {
        return (int) this.wedstrijden.stream().mapToInt(v -> v.teamGoal(t)).sum();
    }

    /**
     * Return the amount of counter goals per team
     * @param t team
     * @return the amount of conceived goals
     */
    public int getCounterGoalsofTeam(Team t) {
        return (int) this.wedstrijden.stream().mapToInt(v -> v.teamCounterGoal(t)).sum();
    }

    /**
     * Creërt alle wedstrijden voor een competite uit een ArrayList van Teams.
     */
    public void bouwWedstrijden() {
        //Collections.shuffle(teams);
        ArrayList<Team> a = new ArrayList<>();
        ArrayList<Team> b = new ArrayList<>();

        for (int i = 0; i < (teams.size() / 2); i++) {
            a.add(teams.get(i));
        }
        for (int p = (teams.size() / 2); p < teams.size(); p++) {
            b.add(teams.get(p));
        }
        
        ArrayList<Wedstrijd> reverswedstriedlist = new ArrayList<>();
        Team tmp;

        for (int x = 0; x < teams.size() - 1; x++) {
            for (int j = 0; j < a.size(); j++) {
                Wedstrijd w = new Wedstrijd(a.get(j), b.get(j), x);
                w.setPlayed(false);
                wedstrijden.add(w);
                
                Wedstrijd u = new Wedstrijd(b.get(j), a.get(j), x+teams.size());
                u.setPlayed(false);
                reverswedstriedlist.add(u);
            }

            // up each element in a
            Collections.rotate(a, -1);

            // down each element in b
            Collections.rotate(b, 1);

            // swap first and last in a
            Collections.swap(a, 0, a.size() - 1);

            // switch last in a with first in b
            tmp = b.get(0);
            b.set(0, a.get(a.size() - 1));
            a.set(a.size() - 1, tmp);
        }
        
        wedstrijden.addAll(reverswedstriedlist);
    }

    /**
     * Return the competition a team is playing in
     * @return competitie
     */
    public static Competitie getCompetitie() {
        return Competitie.c;
    }

    /**
     * Set the competition a team is playing in
     */
    public static void setCompetitie(Competitie c) {
        Competitie.c = c;
    }

    /**
     * Plays games until there are no games left to play for the player. 
     * Plays the matches in which the team of the player is not active. 
     */
    public void playGamesTilPlayerGameIsDue() {
        if(this.wedstrijden == null || this.wedstrijden.isEmpty())
            this.bouwWedstrijden();
        
        for(Wedstrijd w:this.wedstrijden) {
            System.out.println(w);
            if(w.isPlayed()) continue;
            if(w.teamPlaying(this.teams.get(this.userindex))) break;
            w.playGame();
        }
    }
    
    /**
     * Checks if there are more games left to play
     * @return boolean
     */
    public boolean gamesLeftToPlay() {
        return (this.wedstrijden.stream().filter(v -> !v.isPlayed()).count()>0);
    }
    
    /**
     * Plays the game of the player
     * @return the match played by the player
     * @throws Exception 
     */
    public Wedstrijd playPlayerGame() throws Exception {
        if(this.wedstrijden == null || this.wedstrijden.isEmpty())
            this.bouwWedstrijden();
        
        this.playGamesTilPlayerGameIsDue();
        Wedstrijd houder = null;
        
        for(Wedstrijd w: this.wedstrijden) {
            if(w.isPlayed()) continue;
            if(w.teamPlaying(this.teams.get(this.userindex))) {
                w.playGame();
                houder = w;
                break;
            }
        }
        
        this.playGamesTilPlayerGameIsDue();
        return houder;
    }
    
    /**
     * Restart competition with same players
     */
    public void resetCompetition() {
        this.wedstrijden = new ArrayList<>();
        bouwWedstrijden();
    }
}
