package soccer;

import java.util.Objects;

/**
 * Class speler
 */
public class Speler {
    private String naam;
    private int nummer;
    private SpelerType type;
    private SpelerStatus status;
    private int prijs;
    private int gamesTilStatusDisapears;
    private int aanvallend;
    private int verdedigend;
    private int uithoudingsvermogen;

    /**
     * Initialiseer Speler. 
     * @param naam naam van de speler.
     * @param nummer het nummer van de speler.
     * @param type het type speler (aanvaller, verdediger, middenvelder, doelman). Is een enum.
     * @param prijs de prijs van de speler bij verkoop/aankoop.
     * @param aanvallend punten die een speler heeft voor zijn aanval (0-100).
     * @param verdedigend punten die een speler heeft voor zijn verdediging (0-100).
     * @param uithoudingsvermogen  punten die een speler heeft voor zijn uithoudingsvermogen (0-100).
     */
    public Speler(String naam, int nummer, SpelerType type, int prijs, int aanvallend, int verdedigend, int uithoudingsvermogen) {
        this.naam = naam;
        this.nummer = nummer;
        this.type = type;
        this.prijs = prijs;
        this.aanvallend = aanvallend;
        this.verdedigend = verdedigend;
        this.uithoudingsvermogen = uithoudingsvermogen;
    }

    /**
     * @return Retourneert de naam van de speler als String.
     */
    public String getNaam() {
        return this.naam;
    }

    /**
     * Stel de naam van een speler in.
     * @param naam De naam van de speler die ingesteld moet worden.
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }
    /**
     * Nummer van de speler.
     * @return Retourneert het nummer van de speler als String.
     */
    public int getNummer() {
        return this.nummer;
    }

    /**
     * Stel het nummer van de speler in.
     * @param nummer Het nummer van de speler die ingesteld moet worden.
     */
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    /**
     * Type van de speler.
     * @return Retourneert de enum type van de speler (aanvaller, middenvelder, verdediger, doelman).
     */
    public SpelerType getType() {
        return this.type;
    }

    /**
     * Stel het type van de speler in.
     * @param type het type die ingesteld moet worden.
     */
    public void setType(SpelerType type) {
        this.type = type;
    }

    /**
     * Aanvalspunten van de speler.
     * @return Retourneert de aanvalspunten van de speler (int).
     */
    public int getAanvallend() {
        return this.aanvallend;
    }

    /**
     * Stel de aanvalspunten van de speler in.
     * @param aanvallend De punten die ingesteld moeten worden.
     */
    public void setAanvallend(int aanvallend) {
        this.aanvallend = aanvallend;
    }

    /**
     * Verdedigingspunten van de speler.
     * @return Retourneert de verdedigingspunten van de speler (int)
     */
    public int getVerdedigend() {
        return this.verdedigend;
    }

    /**
     * Stel de verdedigingspunten van de speler in.
     * @param verdedigend de punten die ingesteld moeten worden.
     */
    public void setVerdedigend(int verdedigend) {
        this.verdedigend = verdedigend;
    }

    /**
     * Uithoudingsvermogen van de speler.
     * @return Retourneert de punten voor het uithoudingsvermogen van de speler.
     */
    public int getUithoudingsvermogen() {
        return this.uithoudingsvermogen;
    }
    
    /**
     * Stel het uithoudingsvermogen van de speler in.
     * @param uithoudingsvermogen de punten voor het uithoudingsvermogen van de speler.
     */
    public void setUithoudingsvermogen(int uithoudingsvermogen) {
        this.uithoudingsvermogen = uithoudingsvermogen;
    }

    /**
     * Status van de speler (gele/rode kaart, blessure).
     * @return Retourneert de status van de speler (gele/rode kaart, blessure).
     */
    public SpelerStatus getStatus() {
        return status;
    }

    /**
     * Stel de status van de speler in.
     * @param status De status die ingesteld moet worden (enum)
     */
    public void setStatus(SpelerStatus status) {
        this.status = status;
    }

    /**
     * Prijs van de speler.
     * @return Retourneert de prijs van de speler.
     */
    public int getPrijs() {
        return prijs;
    }

    /**
     * Stel de prijs van de speler in.
     * @param prijs De prijs die ingesteld moet worden (int).
     */
    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }
    
    /**
     * Past de status aan van de speler na iedere wedstrijd.
     */
    public void playGame() {
        if(this.gamesTilStatusDisapears > 0) {
            this.gamesTilStatusDisapears--;
            if(this.gamesTilStatusDisapears == 0) this.status = SpelerStatus.Normaal;
            
        } else {
            //1 op 100 kans dat de speler geblesseerd raakt na een wedstrijd
            if(this.randomWithRange(0, 100) == 0) {
                this.status = SpelerStatus.Gebleseerd;
                this.gamesTilStatusDisapears = this.randomWithRange(2, 5);
            
            //1 op 100 kans dat de speler een gele kaart krijgt na een wedstrijd
            } else if(this.randomWithRange(0, 100) == 0) {
                this.status = SpelerStatus.Gele_kaart;
                this.gamesTilStatusDisapears = 1;
            //1 op 100 kans dat de speler een rode kaart krijgt na een wedstrijd    
            } else if(this.randomWithRange(0, 100) == 0) {
                this.status = SpelerStatus.Roode_kaart;
                this.gamesTilStatusDisapears = 2;
            }
        }
    }
    
    /**
     * Kiest een random geheel getal uit een range van twee ingevoerde getallen
     * @param min minimale waarde
     * @param max maximale waarde 
     * @return een random getal binnen de opgegeven range
     */
    private int randomWithRange(int min, int max) {
       return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    
    /**
     * Vergelijkt een andere instantie van PosPlayer
     * @param obj Object PosPlayer
     * @return Retourneert True als andere PosPlayer overeenkomt met this en anders retourneert false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Speler other = (Speler) obj;
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        if (this.nummer != other.nummer) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.prijs != other.prijs) {
            return false;
        }
        if (this.gamesTilStatusDisapears != other.gamesTilStatusDisapears) {
            return false;
        }
        if (this.aanvallend != other.aanvallend) {
            return false;
        }
        if (this.verdedigend != other.verdedigend) {
            return false;
        }
        if (this.uithoudingsvermogen != other.uithoudingsvermogen) {
            return false;
        }
        return true;
    }
     /**
     * Kijkt of de speler niet beschikbaar is om te spelen
     * @return true als de speler niet beschikbaar is en false als de speler wel beschikbaar is.
     */
    public boolean isUnavaliableToPlay() {
        return this.gamesTilStatusDisapears != 0;
    }
    
    /**
     * Kijkt of de speler beschikbaar is om te spelen
     * @return true als de speler beschikbaar is en false als de speler niet beschikbaar is. 
     */
    public boolean isAvaliableToPlay() {
        return !this.isUnavaliableToPlay();
    }
    /**
     * Als een team minder dan 11 spelers beschikbaar heeft (dus geen volledig elftal kan opstellen)
     * wordt er een willekeurig een speler van dit team weer beschikbaar
     */
    public void magicalyFix() {
        this.gamesTilStatusDisapears =0;
        this.status = SpelerStatus.Normaal;
    }

    /**
     * Respresenteer ~ als een string
     */
    @Override
    public String toString() {
        return "Speler{" + "naam=" + naam + ", nummer=" + nummer + ", type=" + type + ", status=" + status + ", prijs=" + prijs + ", gamesTilStatusDisapears=" + gamesTilStatusDisapears + ", aanvallend=" + aanvallend + ", verdedigend=" + verdedigend + ", uithoudingsvermogen=" + uithoudingsvermogen + '}';
    }
    
    public int getGamesTilStatusDisapears() {
        return this.gamesTilStatusDisapears;
    }
    
    public void setGamesTilStatusDisapears(int games) {
        this.gamesTilStatusDisapears = games;
    }
}
