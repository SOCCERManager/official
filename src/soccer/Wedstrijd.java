package soccer;

import java.util.Objects;

/**
 * Class Wedstrijd
 */
public class Wedstrijd {

    private Team team_a;
    private Team team_b;
    private int score_a;
    private int score_b;
    private int points_a;
    private int points_b;
    private boolean played;
    private int speeldag;
    private java.util.Random rnd;
    
    /**
     * Constructor van Wedstrijd, bestaande uit twee teams
     * @param team_a het eerste team dat deelneemt aan een wedstrijd
     * @param team_b het tweede team dat deelneemt aan een wedstrijd
     */
    public Wedstrijd(Team team_a, Team team_b) {
        this.team_a = team_a;
        this.team_b = team_b;
        played = false;
    }
    
    /**
     * Constructor van Wedstrijd, bestaande uit twee teams
     * @param team_a het eerste team dat deelneemt aan een wedstrijd
     * @param team_b het tweede team dat deelneemt aan een wedstrijd
     * @param speeldag
     */
    public Wedstrijd(Team team_a, Team team_b, int speeldag) {
        this.team_a = team_a;
        this.team_b = team_b;
        played = false;
        this.speeldag = speeldag;
    }

    /**
     * Retouneerd de speeldag van de wedstreid
     * @return 
     */
    public int getSpeeldag() {
        return speeldag;
    }

    /**
     * Stelt de speeldag van de wedstreid in.
     * @param speeldag 
     */
    public void setSpeeldag(int speeldag) {
        this.speeldag = speeldag;
    }

    
    
    /**
     * geeft het eerste team in een wedstrijd terug
     * @return het eerste team
     */
    public Team getTeam_a() {
        return team_a;
    }

    /**
     * Veranderd het eerste team van een wedstrijd
     * @param team_a het eerste team in een wedstrijd
     */
    public void setTeam_a(Team team_a) {
        this.team_a = team_a;
    }

    /**
     * geeft het tweede team in een wedstrijd terug
     * @return het tweede team
     */
    public Team getTeam_b() {
        return team_b;
    }

    /**
     * Veranderd het tweede team van een wedstrijd
     * @param team_b het tweede team in een wedstrijd
     */
    public void setTeam_b(Team team_b) {
        this.team_b = team_b;
    }

    /**
     * Geeft de score van het eerste team in een wedstrijd
     * @return de score van het eerste team
     */
    public int getScore_a() {
        return score_a;
    }

    /**
     * Set de score van het eerste team in een wedstrijd
     * @param score_a de score van het eerste team
     */
    public void setScore_a(int score_a) {
        this.score_a = score_a;
    }

    /**
     * Geeft de score van het tweede team in een wedstrijd
     * @return de score van het tweede team
     */
    public int getScore_b() {
        return score_b;
    }

    /**
     * Set de score van het eerste team in een wedstrijd
     * @param score_b de score van het eerste team
     */
    public void setScore_b(int score_b) {
        this.score_b = score_b;
    }

    /**
     * Get het aantal punten van het eerste team in een wedstrijd
     * @return het aantal punten van het eerste team in een wedstrijd (int)
     */
    public int getPoints_a() {
        return points_a;
    }

    /**
     * Set het aantal punten van het eerste team in een wedstrijd
     * @param points_a het aantal punten van het eerste team in een wedstrijd
     */
    public void setPoints_a(int points_a) {
        this.points_a = points_a;
    }

    /**
     * Get het aantal punten van het tweede team in een wedstrijd
     * @return het aantal punten van het tweede team in een wedstrijd (int)
     */
    public int getPoints_b() {
        return points_b;
    }

    /**
     * Set het aantal punten van het tweede team in een wedstrijd
     * @param points_b het aantal punten van het tweede team in een wedstrijd
     */
    public void setPoints_b(int points_b) {
        this.points_b = points_b;
    }

    /**
     * Kijkt of een wedstrijd gespeeld is
     * @return true als de wedstrijd gespeeld is, false als dit niet het geval is
     */
    public boolean isPlayed() {
        return played;
    }

    /**
     * Set of de wedstrijd al gespeeld is
     * @param played true/false of de wedstrijd al gespeeld is ja/nee
     */
    public void setPlayed(boolean played) {
        this.played = played;
    }
    
    /**
     * De equals methode om te kijken of wedstrijden aan elkaar gelijk zijn.
     * @param obj de wedstrijd die vergeleken wordt met de wedstrijd waarbij deze methode is aangeroepen
     * @return true als de wedstrijden gelijk zijn en false als de wedstrijdne niet aan elkaar gelijk zijn. 
     */
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

    /**
     * toString voor een wedstrijd
     * @return De String representatie van een wedstrijd in de vorm van "Wedstrijd{teams, scores, aantal punten, is de wedstrijd gespeeld true of false)
     */
    @Override
    public String toString() {
        return "Wedstrijd{" + "team_a=" + team_a.getName() + ", team_b=" + team_b.getName() + ", score_a=" + score_a + ", score_b=" + score_b + ", points_a=" + points_a + ", points_b=" + points_b + ", played=" + played + '}';
    }
    
    /**
     * Kijkt of de score van een team t gelijk is aan dat van een team in de wedstrijd (team_a of team_b). 
     * Indien deze aan elkaar gelijk zijn, zal het aantal punten van dit team returnen
     * @param t een team waarvoor het bovenstaande bekeken moet worden
     * @return de score van team a of team b als deze gelijk zijn, anders return 0
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
    
    public boolean teamWon(Team t) {
        return this.played && (this.team_a.equals(t) && this.getPoints_a() == 3) || (this.team_b.equals(t) && this.getPoints_b() == 3);
    }
    public boolean teamLost(Team t) {
        return this.played && (this.team_a.equals(t) && this.getPoints_a() == 0) || (this.team_b.equals(t) && this.getPoints_b() == 0);
    }
    public boolean teamDrawed(Team t) {
        return this.played && (this.team_a.equals(t) && this.getPoints_a() == 1) || (this.team_b.equals(t) && this.getPoints_b() == 1);
    }
    public boolean teamPlayed(Team t) {
        return this.played && teamPlaying(t);
    }
    public boolean teamPlaying(Team t) {
        return this.team_a.equals(t) || this.team_b.equals(t);
    }
    public int teamGoal(Team t) {
        if(this.team_a.equals(t)) return score_a;
        if(this.team_b.equals(t)) return score_b;
        return 0;
    }
    public int teamCounterGoal(Team t) {
        if(this.team_a.equals(t)) return score_b;
        if(this.team_b.equals(t)) return score_a;
        return 0;
    }
    
    /**
     * De wedstrijd zelf, er wordt gekeken of de opstellingen valide zijn, anders worden deze gegenereert.
     * Daarna wordt er op basis van de stats van de teams een aantal goals toegekend aan een team.
     * Tot slot wordt gekeken naar de uitslag van de wedstrijd en de hoeveelheid punten die ieder team krijgt. 
     */
    public void playGame(){
        if(!this.team_a.OpstellingIsValide()) 
            this.team_a.generateOpstelling();
        
        if(!this.team_b.OpstellingIsValide())
            this.team_b.generateOpstelling();
        
        this.played = true;
        this.team_a.playGame();
        this.team_b.playGame();
        
        this.score_a = getGoals(team_a, team_b);
        this.score_b = getGoals(team_b, team_a);
        
        if(Random.get().nextBoolean()) score_a++;
        if(Random.get().nextBoolean() && score_a>0) score_a--;
        if(Random.get().nextBoolean()) score_b++;
        if(Random.get().nextBoolean() && score_b>0) score_b--;
        
        if(this.score_a > this.score_b) {
            this.points_a = 3;
            this.points_b = 0;
            if(team_a.equals(this.getTeam_a().getCompetitie().getTeams().get(this.getTeam_a().getCompetitie().getUserindex()))){
                int temp = this.getTeam_a().getCompetitie().getTeams().get(this.getTeam_a().getCompetitie().getUserindex()).getBudget() + 100000;
                this.getTeam_a().getCompetitie().getTeams().get(this.getTeam_a().getCompetitie().getUserindex()).setBudget(temp);
                
            }
        } else if(this.score_a < this.score_b) {
            this.points_a = 0;
            this.points_b = 3;
            if (team_b.equals(this.getTeam_b().getCompetitie().getTeams().get(this.getTeam_b().getCompetitie().getUserindex()))) {
                int temp = this.getTeam_b().getCompetitie().getTeams().get(this.getTeam_b().getCompetitie().getUserindex()).getBudget() + 100000;
                this.getTeam_b().getCompetitie().getTeams().get(this.getTeam_b().getCompetitie().getUserindex()).setBudget(temp);
            }
            
        } else { 
            this.points_a = 1;
            this.points_b = 1;
            if(team_a.equals(this.getTeam_a().getCompetitie().getTeams().get(this.getTeam_a().getCompetitie().getUserindex())) || team_b.equals(this.getTeam_b().getCompetitie().getTeams().get(this.getTeam_b().getCompetitie().getUserindex()))) {
                int temp = this.getTeam_a().getCompetitie().getTeams().get(this.getTeam_a().getCompetitie().getUserindex()).getBudget() + 50000;
                this.getTeam_a().getCompetitie().getTeams().get(this.getTeam_a().getCompetitie().getUserindex()).setBudget(temp);
            }
        }        
    }
    /**
     * De berekening achter het genereren van de goals
     * De aanvallende- en de uithoudingsscore van het team waarvoor het aantal goals gegenereerd moet worden wordt het product van genomen. (a)
     * Van de verdedigende- en de uithoudingsscore van het team dat "verdedigd" wordt het product genomen. (b)
     * Dan (a)/(b) = (c) en tot slot (c) vermenigvuldigd met een willekeurige waarde tussen 0 en 1. 
     */ 
    private int getGoals(Team a, Team b) {
        int t = (int) Math.round(
            (((double)a.getAanvallendTotaal()+(double)a.getUithoudingsTotaal())*Random.get().nextFloat()*2)
            /
            ((double)b.getVerdedigingsTotaal()+(double)b.getUithoudingsTotaal())
        );
        
        if(Random.get().nextFloat() < 0.5) t++;
        if(Random.get().nextFloat() < 0.3) t--;
        
        return (t>0? t: 0);
    }
}
