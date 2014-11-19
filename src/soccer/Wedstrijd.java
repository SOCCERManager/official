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
    
    public Wedstrijd(Team team_a, Team team_b) {
        this.team_a = team_a;
        this.team_b = team_b;
        played = false;
    }

    public Team getTeam_a() {
        return team_a;
    }

    public void setTeam_a(Team team_a) {
        this.team_a = team_a;
    }

    public Team getTeam_b() {
        return team_b;
    }

    public void setTeam_b(Team team_b) {
        this.team_b = team_b;
    }

    public int getScore_a() {
        return score_a;
    }

    public void setScore_a(int score_a) {
        this.score_a = score_a;
    }

    public int getScore_b() {
        return score_b;
    }

    public void setScore_b(int score_b) {
        this.score_b = score_b;
    }

    public int getPoints_a() {
        return points_a;
    }

    public void setPoints_a(int points_a) {
        this.points_a = points_a;
    }

    public int getPoints_b() {
        return points_b;
    }

    public void setPoints_b(int points_b) {
        this.points_b = points_b;
    }

    public boolean isPlayed() {
        return played;
    }

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
    
    public int scoreOfTeam(Team t){
        
        if(t.equals(getTeam_a()))
            return getPoints_a();
        
        else if (t.equals(getTeam_b()))
            return getPoints_b();
        
        return 0;
    }
    
    public void playGame(){
        
    }
}
