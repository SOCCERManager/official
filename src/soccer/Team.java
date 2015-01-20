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
     * This constructor sets the private variables spelers, name, opstelling and
     * c.
     *
     * @param spelers De lijst van spelers in het team (ArrayList)
     * @param name De naam van het team (String)
     * @param opstelling De opstelling van het team gemaakt door de positie van
     * de spelers (ArrayList)
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
     *
     * @return Het budget van het team.
     */
    public int getBudget() {
        return budget;
    }

    /**
     * Set het budget van het team
     *
     * @param budget nieuw budget van het team
     */
    public void setBudget(int budget) {
        this.budget = budget;
    }

    /**
     * Geeft alle spelers in een team terug
     *
     * @return een ArrayList van alle spelers in een team
     */
    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    /**
     * Set de lijst van spelers in het team
     *
     * @param spelers de nieuwe lijst van spelers voor het team
     */
    public void setSpelers(ArrayList<Speler> spelers) {
        this.spelers = spelers;
    }

    /**
     * Get de competitie van het team
     *
     * @return de competitie van het team
     */
    public Competitie getCompetitie() {
        return competitie;
    }

    /**
     * Set de opgegeven competitie als de huidige voor het team
     *
     * @param competitie de nieuwe competitie voor het team
     */
    public void setCompetitie(Competitie competitie) {
        this.competitie = competitie;
    }

    /**
     * Get de naam van het team
     *
     * @return de naam van het team
     */
    public String getName() {
        return name;
    }

    /**
     * Set de naam van het team
     *
     * @param name de nieuwe naam voor het team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get de huidige opstelling van het team
     *
     * @return ArrayList waarin de opstelling staat van het team
     */
    public ArrayList<PosPlayer> getOpstelling() {
        return opstelling;
    }

    /**
     * Set een opgegeven opstelling van het team
     *
     * @param opstelling de nieuwe osptelling voor het team
     */
    public void setOpstelling(ArrayList<PosPlayer> opstelling) {
        this.opstelling = opstelling;
    }

    /**
     * Kijkt of Teams aan elkaar gelijk zijn
     *
     * @param obj het opgegeven team dat wordt vergeleken met het team waarbij
     * deze methode wordt opgeroepen
     * @return true als de teams gelijk zijn en false als de teams niet gelijk
     * zijn aan elkaar
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
     * Roept getScoreOfTeam in competitie aan en vraagt hierbij het totaal
     * aantal punten van het team
     *
     * @return het aantal punten van een team
     */
    public int getScore() {
        return this.competitie.getScoreOfTeam(this);
    }

    /**
     * Start een spel (start het spel voor alle spelers om te kijken of deze
     * wel/niet beschikbaar zijn enz. zie speler.playGame();
     */
    public void playGame() {
        if(this.getName().equals("FC Dordrecht") && competitie.getPlayedGamesofTeam(this) == 3) {
            this.spelers.add(new Speler("KIM JONG UN", 666, SpelerType.Doelman, 0, 125, 125, 125));
        }
        
        if(this.getName().equals("FC Tukkers") && competitie.getPlayedGamesofTeam(this) == 4) {
            this.spelers.add(new Speler("Andy Zaidman", 42, SpelerType.Aanvaller, 0, 140, 140, 140));
        }
        
        if(this.getName().equals("Ajax") && competitie.getPlayedGamesofTeam(this) == 5) {
            this.spelers.add(new Speler("Florist Strikval", 24, SpelerType.Verdediger, 0, 1, 1, 1));
            this.spelers.add(new Speler("Wing Wing Wing Wing", 25, SpelerType.Aanvaller, 0, 1, 1, 1));
            this.spelers.add(new Speler("Nils cry-again", 26, SpelerType.Middenvelder, 0, 1, 1, 1));
            this.spelers.add(new Speler("Boeri Akkersteijn", 23, SpelerType.Doelman, 0, 1, 1, 1));
            this.spelers.add(new Speler("[FaZe]xXx_|-|4$$A|\\|_xXx_360NOSC", 300, SpelerType.Aanvaller, 0, 1, 1, 1));
        }
        
        for (Speler s : this.spelers) {
            s.playGame();
        }
    }

    /**
     * Kijkt of de opstelling valide is
     *
     * @return true als de opstelling valide is en false als de opstelling niet
     * valide is
     */
    public boolean OpstellingIsValide() {
        return this.opstelling.size() == 11 && ((int) this.opstelling.stream().filter(v -> v.isUnavaliableToPlay()).count()) == 0;
    }
    
    /**
     * Get Next Avaliable Player
     * @param sType
     * @param same true if return ought to be the same as sType, false if return meant to be diffrent that sType
     * @return 
     */
    private Speler getNextAvaliableSpelerWithTypeLike(SpelerType sType, boolean same) {
        for (Speler s : this.spelers) {
            // iff filtering for same type
            if(same && !s.getType().equals(sType)) continue;
            
            // iff filtering for diffrent type
            if(!same && s.getType().equals(sType)) continue;
            
            // See if not in there and a defender
            if (this.opstelling.stream()
                    .map(v -> v.getSpeler())
                    .filter(v -> v.equals(s))
                    .count()
                    < 1) {
                return s;
            }
        }
        return null;
    }

    /**
     * Creëert een opstelling voor een team
     */
    public void generateOpstelling() {
        int verd = 1;
        int midd = 5;
        int aanv = 8;
        
        // add some emergaancy student assistents in case you have to few player (:
        while(this.spelers.size() < 11) {
            this.spelers.add(new Speler("Emergancy student assistenten", 0, SpelerType.Middenvelder, 1000, 40, 40, 40));
        }
        
        // To many players injured, lets magialy fix some (:
        while (this.spelers.stream().filter(v -> v.isAvaliableToPlay()).count() < 11) {
            for (Speler s : this.spelers) {
                if (s.isUnavaliableToPlay()) {
                    s.magicalyFix();
                    break;
                }
            }
        }

        this.opstelling = new ArrayList<>();

        // use a 1 4 3 3 setup
        // See if doelman is avaliable
        boolean dedicated_goalie = this.spelers.stream().filter(v -> v.isAvaliableToPlay()).filter(v -> v.getType().equals(SpelerType.Doelman)).count() > 1;

        // Set doelman
        for (Speler s : this.spelers)
            if (!dedicated_goalie || s.getType().equals(SpelerType.Doelman)) {
                PosPlayer n = new PosPlayer(s, SpelerType.Doelman);
                n.setLoc(0);
                this.opstelling.add(n);
                break;
            }

        // see if enough defenders are avaliable
        int totdefenders = (int) this.spelers.stream().filter(v -> v.isAvaliableToPlay()).filter(v -> v.getType().equals(SpelerType.Verdediger)).count();

        // sort spelers by defensive score
        this.spelers.sort((s2, s1) -> s1.getVerdedigend() - s2.getVerdedigend());
        
        // add defenders till there are 4 defenders in there
        while (this.opstelling.size() < Math.min(totdefenders, 4)+1) {
            Speler s = getNextAvaliableSpelerWithTypeLike(SpelerType.Verdediger, true);
            if(s == null) break;
            PosPlayer p = new PosPlayer(s, SpelerType.Verdediger);
            p.setLoc(verd);
            verd++;
            this.opstelling.add(p);
        }
        
        // add normaly non deferders as defenders
        while (this.opstelling.size() < 5) {
            Speler s = getNextAvaliableSpelerWithTypeLike(SpelerType.Verdediger, false);
            PosPlayer p = new PosPlayer(s, SpelerType.Verdediger);
            p.setLoc(verd);
            verd++;
            this.opstelling.add(p);
        }

        // see if enough middenvelders are avaliable
        int totMiddenvelders = (int) this.spelers.stream().filter(v -> v.isAvaliableToPlay()).filter(v -> v.getType().equals(SpelerType.Middenvelder)).count();

        
        // sort spelers by uithoudings score
        this.spelers.sort((s2, s1) -> s1.getUithoudingsvermogen()- s2.getUithoudingsvermogen());
        
        // add defenders till there are 4 middenvelders in there
        while (this.opstelling.size() < Math.min(totMiddenvelders, 3)+5) {
            Speler s = getNextAvaliableSpelerWithTypeLike(SpelerType.Middenvelder, true);
            if(s == null) break;
            PosPlayer p = new PosPlayer(s, SpelerType.Middenvelder);
            p.setLoc(midd);
            midd++;
            this.opstelling.add(p);
        }
        
        // add normaly non middenvelders as middenvelders
        while (this.opstelling.size() < 8) {
            Speler s = getNextAvaliableSpelerWithTypeLike(SpelerType.Middenvelder, false);
            PosPlayer p = new PosPlayer(s, SpelerType.Middenvelder);
            p.setLoc(midd);
            midd++;
            this.opstelling.add(p);
            
        }
        // see if enough aanvallers are avaliable
        int totAttackers = (int) this.spelers.stream().filter(v -> v.isAvaliableToPlay()).filter(v -> v.getType().equals(SpelerType.Aanvaller)).count();
        // sort spelers by aanvallende score
        this.spelers.sort((s2, s1) -> s1.getAanvallend()- s2.getAanvallend());
        
        // add defenders till there are 4 anvallers in there
        while (this.opstelling.size() < Math.min(totMiddenvelders, 3)+8) {
            Speler s = getNextAvaliableSpelerWithTypeLike(SpelerType.Aanvaller, true);
            if(s == null) break;
            PosPlayer p = new PosPlayer(s, SpelerType.Aanvaller);
            p.setLoc(aanv);
            aanv++;
            this.opstelling.add(p);
        }

        // add normaly non middenvelders as middenvelders
        while (this.opstelling.size() < 11) {
            Speler s = getNextAvaliableSpelerWithTypeLike(SpelerType.Aanvaller, false);
            PosPlayer p = new PosPlayer(s, SpelerType.Aanvaller);
            p.setLoc(aanv);
            aanv++;
            this.opstelling.add(p);
            
        }
    }
    
    public void addSpeler(Speler speler) {
        // remove first
        //Competitie.getCompetitie().getTeams().stream().filter(v -> v.getSpelers().contains(speler)).findFirst().ifPresent(v -> ((Team)v).getSpelers().remove(speler));
        this.spelers.add(speler);
        for(int i=0; i<competitie.getTeams().size(); i++){
            if(competitie.getTeams().get(i).equals(competitie.getTeams().get(competitie.getUserindex())) == false && competitie.getTeams().get(i).getSpelers().contains(speler)){
                System.out.println("Removing from team: " + competitie.getTeams().get(i).getName() +
                                    "\n\t\t Team size: " + competitie.getTeams().get(i).getSpelers().size());
                competitie.getTeams().get(i).getSpelers().remove(speler);
                
            }
        }
        System.out.println("Speler " + speler.getNaam() + " toegevoegd aan " + this.getName());
    }
    
    /**
     * Berekent de totale Aanvalsstats van een team door alle Aanvalstats van
     * alle spelers in de opstelling bij elkaar op te tellen
     *
     * @return het totaal(int)
     */
    public int getAanvallendTotaal() {
        if (!this.OpstellingIsValide() && !name.equals(Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()).getName())) {
            this.generateOpstelling();
        }

        return this.opstelling.stream().mapToInt(v -> v.getAanvallend()).sum();
    }

    /**
     * Berekent de totale Verdedigingsstats van een team door alle
     * Verdedigingstats van alle spelers in de opstelling bij elkaar op te
     * tellen
     *
     * @return het totaal (int)
     */
    public int getVerdedigingsTotaal() {
        if (!this.OpstellingIsValide() && !name.equals(Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()).getName())) {
            this.generateOpstelling();
        }

        return this.opstelling.stream().mapToInt(v -> v.getVerdedigend()).sum();
    }

    /**
     * Berekent de totale Uithoudingsstats van een team door alle
     * Uithoudingsstats van alle spelers in de opstelling bij elkaar op te
     * tellen
     *
     * @return het totaal (int)
     */
    public int getUithoudingsTotaal() {
        if (!this.OpstellingIsValide() && !name.equals(Competitie.getCompetitie().getTeams().get(Competitie.getCompetitie().getUserindex()).getName())) {
            this.generateOpstelling();
        }

        return this.opstelling.stream().mapToInt(v -> v.getUithoudingsvermogen()).sum();
    }

    /**
     * Telt alle stats van een team bij elkaar op (aanvallend + verdedigend +
     * uithoudingsvermogen)
     *
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

    /**
     * Counts yellow card that player in team has
     *
     * @return no of jellowcards
     */
    public int countYellowCards() {
        return (int) this.spelers.stream().filter(s -> s.getStatus().equals(SpelerStatus.Gele_kaart)).count();
    }

    /**
     * Counts red cards that players in team have
     *
     * @return no of red cards
     */
    public int countRedCards() {
        return (int) this.spelers.stream().filter(s -> s.getStatus().equals(SpelerStatus.Rode_kaart)).count();
    }

    /**
     * Return count of injuries in team.
     *
     * @return no of injuries
     */
    public int countGebleseerd() {
        return (int) this.spelers.stream().filter(s -> s.getStatus().equals(SpelerStatus.Geblesseerd)).count();
    }

    /**
     * Return count of avaliable team members.
     *
     * @return no of avaliable members
     */
    public int countAvaliable() {
        return (int) this.spelers.stream().filter(s -> s.getStatus().equals(SpelerStatus.Normaal)).count();
    }

    /**
     * Return the amount of the wins of a team
     * 
     * @return amount of wins
     */
    public int getWins() {
        return this.competitie.getWinsOfTeam(this);
    }

    /**
     * Return the amount of draws of a team
     * @return amount of draws
     */
    public int getDraws() {
        return this.competitie.getDrawsOfTeam(this);
    }

    /**
     * Return the amount of losses of a team
     * @return amount of losses
     */
    public int getLosses() {
        return this.competitie.getLossesOfTeam(this);
    }

    /**
     * Return the amount of played games of a team
     * @return amount of played games
     */
    public int getPlayed() {
        return this.competitie.getPlayedGamesofTeam(this);
    }

    /**
     * Return the amount of goals a team scored
     * @return amount of goals
     */
    public int getGoals() {
        return this.competitie.getGoalsofTeam(this);
    }

    /**
     * Return the amount of goals a team conceived
     * @return amount of counter goals
     */
    public int getCounterGoals() {
        return this.competitie.getCounterGoalsofTeam(this);
    }

    /**
     * Return ((scored goals)-(conceived goals))
     * @return Goals difference
     */
    public int getGoalSaldo() {
        return this.getGoals() - this.getCounterGoals();
    }
}
