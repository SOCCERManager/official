package soccer;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * Class Team
 */
public class Team {
    private ArrayList<Speler> spelers;
    private String name;
    private ArrayList<PosPlayer> opstelling;
    private Competitie competitie;
    private int budget;

    /**
     * This constructor sets the private variables spelers, name, opstelling and c.
     * @param spelers De lijst van spelers in het team (ArrayList<Spelers>)
     * @param name De naam van het team (String)
     * @param opstelling De opstelling van het team gemaakt door de positie van de spelers (ArrayList<PosPlayer>)
     * @param c De competitie waarin dit team speelt (Competitie)
     * @param budget Het budget van het team (int)
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
    /**
     * Set het budget van het team
     * @param budget nieuw budget van het team
     */
    public void setBudget(int budget){
        this.budget = budget;
    }
    
    /**
     * Geeft alle spelers in een team terug
     * @return een ArrayList van alle spelers in een team
     */
    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    /**
     * Set de lijst van spelers in het team
     * @param spelers de nieuwe lijst van spelers voor het team
     */
    public void setSpelers(ArrayList<Speler> spelers) {
        this.spelers = spelers;
    }

    /**
     * Get de competitie van het team
     * @return  de competitie van het team
     */
    public Competitie getCompetitie() {
        return competitie;
    }

    /**
     * Set de opgegeven competitie als de huidige voor het team
     * @param competitie de nieuwe competitie voor het team
     */
    public void setCompetitie(Competitie competitie) {
        this.competitie = competitie;
    }
    
    /**
     * Get de naam van het team
     * @return de naam van het team
     */
    public String getName() {
        return name;
    }

    /**
     * Set de naam van het team
     * @param name de nieuwe naam voor het team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get de huidige opstelling van het team
     * @return ArrayList<PosPlayer> waarin de opstelling staat van het team
     */
    public ArrayList<PosPlayer> getOpstelling() {
        return opstelling;
    }

    /**
     * Set een opgegeven opstelling van het team
     * @param opstelling de nieuwe osptelling voor het team
     */
    public void setOpstelling(ArrayList<PosPlayer> opstelling) {
        this.opstelling = opstelling;
    }

    /**
     * Kijkt of Teams aan elkaar gelijk zijn
     * @param obj het opgegeven team dat wordt vergeleken met het team waarbij deze methode wordt opgeroepen
     * @return true als de teams gelijk zijn en false als de teams niet gelijk zijn aan elkaar
     */
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
     * Roept getScoreOfTeam in competitie aan en vraagt hierbij het totaal aantal punten van het team
     * @return het aantal punten van een team
     */
    public int getScore(){
        return this.competitie.getScoreOfTeam(this);
    }
    
    /**
     * Start een spel (start het spel voor alle spelers om te kijken of deze wel/niet beschikbaar zijn enz.
     * zie speler.playGame();
     */
    public void playGame() {
        for(Speler s: this.spelers)
            s.playGame();
    }
    
    /**
     * Kijkt of de opstelling valide is
     * @return true als de opstelling valide is en false als de opstelling niet valide is
     */
    public boolean OpstellingIsValide() {
        return this.opstelling.size() == 11 && ((int) this.opstelling.stream().filter(v -> v.isUnavaliableToPlay()).count()) == 0;
    }
    
    /**
     * Creëert een opstelling voor een team
     */
    public void generateOpstelling() {
        
        // To many players injured, lets magialy fix some (:
        while(this.spelers.stream().filter(v -> v.isUnavaliableToPlay()).count() >= 11)
            for(Speler s:this.spelers)
                if(s.isUnavaliableToPlay()) {
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
            if(this.opstelling.size() <= 11 && !s.isUnavaliableToPlay() && !this.opstelling.contains(s))
                 this.opstelling.add(new PosPlayer(s, s.getType()));
        }
    }
    
    /**
     * Berekent de totale Aanvalsstats van een team door alle Aanvalstats van alle spelers in de opstelling
     * bij elkaar op te tellen
     * @return het totaal(int)
     */
    public int getAanvallendTotaal() {
        if(!this.OpstellingIsValide())
            this.generateOpstelling();
        
        return this.opstelling.stream().mapToInt(v -> v.getAanvallend()).sum();
    }
    
    /**
     * Berekent de totale Verdedigingsstats van een team door alle Verdedigingstats van alle spelers in de opstelling
     * bij elkaar op te tellen
     * @return het totaal (int)
     */
    public int getVerdedigingsTotaal() {
        if(!this.OpstellingIsValide())
            this.generateOpstelling();
        
        return this.opstelling.stream().mapToInt(v -> v.getVerdedigend()).sum();
    }
    
    /**
     * Berekent de totale Uithoudingsstats van een team door alle Uithoudingsstats van alle spelers in de opstelling
     * bij elkaar op te tellen
     * @return het totaal (int)
     */
    public int getUithoudingsTotaal() {
        if(!this.OpstellingIsValide())
            this.generateOpstelling();
        
        return this.opstelling.stream().mapToInt(v -> v.getUithoudingsvermogen()).sum();
    }
    
    /**
     * Telt alle stats van een team bij elkaar op (aanvallend + verdedigend + uithoudingsvermogen)
     * @return het totaal van alle stats voor een team
     */
    public int getTotalStat() {
        return this.getAanvallendTotaal() + this.getVerdedigingsTotaal() + this.getUithoudingsTotaal();
    }
    
    /**
     * Respresenteer ~ als een string
     */
    @Override
    public String toString() {
        return "Team{" + "spelers=" + spelers + ", name=" + name + ", opstelling=" + opstelling + ", budget=" + budget + '}';
    }
}
