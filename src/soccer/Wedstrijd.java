/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.util.Objects;

/**
 *
 * @author floris
 */
public class Wedstrijd {

    private Team team_a;
    private Team team_b;
    private int score_a;
    private int score_b;
    private int points_a;
    private int points_b;
    private boolean played;
    
    /**
     *
     * @param team_a
     * @param team_b
     */
    public Wedstrijd(Team team_a, Team team_b) {
        this.team_a = team_a;
        this.team_b = team_b;
        played = false;
    }

    /**
     *Returns Team a.
     * @return
     */
    public Team getTeam_a() {
        return team_a;
    }

    /**
     *
     * @param team_a
     */
    public void setTeam_a(Team team_a) {
        this.team_a = team_a;
    }

    /**
     *Returns Team b
     * @return
     */
    public Team getTeam_b() {
        return team_b;
    }

    /**
     *
     * @param team_b
     */
    public void setTeam_b(Team team_b) {
        this.team_b = team_b;
    }

    /**
     *The score of Team a in the current match.
     * @return
     */
    public int getScore_a() {
        return score_a;
    }

    /**
     *
     * @param score_a
     */
    public void setScore_a(int score_a) {
        this.score_a = score_a;
    }

    /**
     *The score of Team b in the current match.
     * @return
     */
    public int getScore_b() {
        return score_b;
    }

    /**
     *
     * @param score_b
     */
    public void setScore_b(int score_b) {
        this.score_b = score_b;
    }

    /**
     *The amount of points Team a has.
     * @return
     */
    public int getPoints_a() {
        return points_a;
    }

    /**
     *
     * @param points_a
     */
    public void setPoints_a(int points_a) {
        this.points_a = points_a;
    }

    /**
     *The amount of points Team b has.
     * @return
     */
    public int getPoints_b() {
        return points_b;
    }

    /**
     *
     * @param points_b
     */
    public void setPoints_b(int points_b) {
        this.points_b = points_b;
    }

    /**
     *
     * @return
     */
    public boolean isPlayed() {
        return played;
    }

    /**
     *
     * @param played
     */
    public void setPlayed(boolean played) {
        this.played = played;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Wedstrijd other = (Wedstrijd) obj;
        if (!Objects.equals(this.team_a, other.team_a)) {
            return false;
        }
        if (!Objects.equals(this.team_b, other.team_b)) {
            return false;
        }
        if (this.score_a != other.score_a) {
            return false;
        }
        if (this.score_b != other.score_b) {
            return false;
        }
        if (this.points_a != other.points_a) {
            return false;
        }
        if (this.points_b != other.points_b) {
            return false;
        }
        if (this.played != other.played) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wedstrijd{" + "team_a=" + team_a + ", team_b=" + team_b + ", score_a=" + score_a + ", score_b=" + score_b + ", points_a=" + points_a + ", points_b=" + points_b + ", played=" + played + '}';
    }
    
    /**
     *This function checks for the score of a Team t, if this Team t corresponds to Team a or Team b it will return the right score.
     * @param t
     * @return
     */
    public int scoreOfTeam(Team t){
        
        if(t.equals(this.getTeam_a())){
            return this.getPoints_a();
        }
        
        else if (t.equals(this.getTeam_b())){
            return this.getPoints_b();
        }
        
        return 0;
    }
    
    /**
     *
     */
    public void playGame(){
        if(!this.team_a.OpstellingIsValide()) 
            this.team_a.generateOpstelling();
        
        if(!this.team_b.OpstellingIsValide())
            this.team_b.generateOpstelling();
        
        this.team_a.playGame();
        this.team_b.playGame();
        
        this.score_a = getGoals(team_a, team_b);
        this.score_b = getGoals(team_b, team_a);
        
        if(this.score_a > this.score_b) {
            this.points_a = 3;
            this.points_b = 0;
        } else if(this.score_a < this.score_b) {
            this.points_a = 0;
            this.points_b = 3;
        } else { 
            this.points_a = 1;
            this.points_b = 1;
        }
        
    }
    
    private int getGoals(Team a, Team b) {
        return (int) Math.round(
            (double)a.getAanvallendTotaal()*(double)a.getUithoudingsTotaal()*Math.random()
            /
            (double)b.getVerdedigingsTotaal()*(double)b.getUithoudingsTotaal()
        );
    }
}
