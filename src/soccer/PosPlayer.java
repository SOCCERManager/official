/*
 *PosPlayer is een 
 */

package soccer; 

import java.util.Objects;

/**
 * PosPlayer is een speler decorator, bepaalt o.a. het aantal typepunten die een speler heeft afhankelijk van zijn positie.
 * @author Youri
 **/
public class PosPlayer {
    private Speler speler;
    private SpelerType posspelertype;
    final double reduceFactor = 0.8; 

    /**
     * Initiliseer PosPlayer
     * @param speler Een object van klasse van Speler.
     * @param spelertype Het type speler.
     */
    public PosPlayer(Speler speler, SpelerType spelertype) {
        this.speler = speler;
        this.posspelertype = spelertype;
    }

    /**
     * De speler.
     * @return Retourneert object Speler van de klasse Speler.
     */
    public Speler getSpeler() {
        return speler;
    }

    /**
     * Stel de speler in.
     * @param speler De speler die ingesteld moet worden.
     */
    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    /**
     * Het type speler.
     * @return Retourneert het type speler (enum).
     */
    public SpelerType getPosSpelertype() {
        return posspelertype;
    }

    /**
     * Stel in het type speler.
     * @param spelertype Het type speler.
     */
    public void setPosSpelertype(SpelerType spelertype) {
        this.posspelertype = spelertype;
    }

    /**
     * De naam van de speler.
     * @return Retourneert de naam van de speler.
     */
    public String getNaam() {
        return speler.getNaam();
    }

    /**
     * Stel de naam in van de speler.
     * @param naam De naam die ingesteld moet worden.
     */
    public void setNaam(String naam) {
        speler.setNaam(naam);
    }

    /**
     * Het nummer van de speler.
     * @return Retourneert het nummer van de speler.
     */
    public int getNummer() {
        return speler.getNummer();
    }

    /**
     * 
     * @param nummer Het nummer dat moet worden ingesteld.
     */
    public void setNummer(int nummer) {
        speler.setNummer(nummer);
    }

    /**
     * De aanvalspunten van de speler.
     * @return Retourneert de aanvalspunten van de speler.
     */
    public int getAanvallend() {
        return speler.getAanvallend();
    }

    /**
     * Stel de aanvalspunten in van de speler.
     * @param aanvallend de aanvalspunten die ingesteld moet worden.
     */
    public void setAanvallend(int aanvallend) {
        speler.setAanvallend(aanvallend);
    }

   /**
    * Verdedigingspunten van de speler.
    * @return Retourneert de verdedigingspunten van de speler.
    */
    public int getVerdedigend() {
        return speler.getVerdedigend();
    }

    /**
     * Stel de verdedigingspunten van de speler in.
     * @param verdedigend de verdedigingspunten van de speler.
     */
    public void setVerdedigend(int verdedigend) {
        speler.setVerdedigend(verdedigend);
    }

    /**
     * Het uithoudingsvermogen van de speler.
     * @return Retourneert het uithoudingsvermogen van de speler.
     */
    public int getUithoudingsvermogen() {
        if(speler.getType().equals(posspelertype)) {
            return speler.getUithoudingsvermogen();
        } else {
            return (int) (speler.getUithoudingsvermogen()*reduceFactor);
        }
    }

    /**
     * 
     * @param uithoudingsvermogen Het uithoudingsvermogen van de speler.
     */
    public void setUithoudingsvermogen(int uithoudingsvermogen) {
        speler.setUithoudingsvermogen(uithoudingsvermogen);
    }
    
    /**
     * Berekent en retourneert de aanvallende score die een speler heeft.
     * @return Retourneert een lagere score als de speler niet in zijn standaard positie staat (factor is reduceFactor).
     */
    public double getOffence() {
        if(this.posspelertype != speler.getType()){
            return this.reduceFactor*speler.getAanvallend();
        }else{
            return speler.getAanvallend();
        }
    }
    
    /**
     * Berekent en retourneert de verdedigende score die een speler heeft.
     * @return Retourneert een lagere score als de speler niet in zijn standaard positie staat (factor is reduceFactor).
     */
    public double getDefense() {
        if(this.posspelertype != speler.getType()){
            return this.reduceFactor*speler.getVerdedigend();
        }else{
            return speler.getVerdedigend();
        }
    }

    /**
     * Het type speler.
     * @return Retourneert het type van de speler.
     */
    public SpelerType getType() {
        return speler.getType();
    }

    public void setType(SpelerType type) {
        speler.setType(type);
    }

    /**
     * Status van de speler (blessure/gele/rode kaart)
     * @return 
     */
    public SpelerStatus getStatus() {
        return speler.getStatus();
    }

    public void setStatus(SpelerStatus status) {
        speler.setStatus(status);
    }

    /**
     * De prijs van de speler
     * @return Retourneert de prijs van de speler.
     */
    public int getPrijs() {
        return speler.getPrijs();
    }

    public void setPrijs(int prijs) {
        speler.setPrijs(prijs);
    }

    /**
     * Past de status aan van de speler na iedere wedstrijd.
     */
    public void playedGame() {
        speler.playedGame();
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
        final PosPlayer other = (PosPlayer) obj;
        if (!Objects.equals(this.speler, other.speler)) {
            return false;
        }
        if (this.posspelertype != other.posspelertype) {
            return false;
        }
        if (Double.doubleToLongBits(this.reduceFactor) != Double.doubleToLongBits(other.reduceFactor)) {
            return false;
        }
        return true;
    }
    
    
}
