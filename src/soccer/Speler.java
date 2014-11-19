/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

/**
 *
 * @author Youri
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
     * 
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
    public void playedGame() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Vergelijkt een andere instantie van PosPlayer
     * @param obj Object PosPlayer
     * @return Retourneert True als andere PosPlayer overeenkomt met this en anders retourneert false.
     */
    public boolean equals(Object obj){
        if(obj instanceof Speler)
        {
            Speler s = (Speler)obj;
            return (this.naam.equals(s.naam) &&
                    this.nummer == s.nummer &&
                    this.type.equals(s.type) &&
                    this.status.equals(s.status) &&
                    this.prijs == s.prijs &&
                    this.gamesTilStatusDisapears == s.gamesTilStatusDisapears &&
                    this.aanvallend == s.aanvallend &&
                    this.verdedigend == s.verdedigend &&
                    this.uithoudingsvermogen == s.uithoudingsvermogen);
        }
        return false;
    }
    
}
