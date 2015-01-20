package soccer; 

import java.util.Objects;

/**
 * PosPlayer is een speler decorator, bepaalt o.a. het aantal typepunten die een speler heeft afhankelijk van zijn positie.
 **/
public class PosPlayer {
    private Speler speler;
    private SpelerType posspelertype;
    final double reduceFactor = 0.8; 
    private int loc;

    /**
     * Initialiseer PosPlayer
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
     * Stel het uithoudingsvermogen van een speler in
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
     * Return het type speler.
     * @return Retourneert het type van de speler.
     */
    public SpelerType getType() {
        return speler.getType();
    }

    /**
     * Set het type speler
     * @param type 
     */
    public void setType(SpelerType type) {
        speler.setType(type);
    }

    /**
     * Status van de speler (blessure/gele/rode kaart)
     * @return de status van de speler (enum)
     */
    public SpelerStatus getStatus() {
        return speler.getStatus();
    }

    /**
     * Stel de status van een speler in (blessure/gele kaart/rode kaart)
     * @param status (blessure, gele kaart, rode kaart, normaal)
     */
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

    /**
     * Stel de prijs van de speler in
     * @param prijs de nieuwe prijs van de speler
     */
    public void setPrijs(int prijs) {
        speler.setPrijs(prijs);
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
        return true;
    }

    /**
     * Speelt een game (gekoppeld aan speler)
     */
    public void playGame() {
        speler.playGame();
    }

    /**
     * Kijkt of de speler niet beschikbaar is om te spelen
     * @return true als de speler niet beschikbaar is en false als de speler wel beschikbaar is.
     */
    public boolean isUnavaliableToPlay() {
        return speler.isUnavaliableToPlay();
    }

    /**
     * Kijkt of de speler beschikbaar is om te spelen
     * @return true als de speler beschikbaar is en false als de speler niet beschikbaar is. 
     */
    public boolean isAvaliableToPlay() {
        return speler.isAvaliableToPlay();
    }

    /**
     * Respresenteer ~ als een string
     */
    @Override
    public String toString() {
        return "PosPlayer{" + "speler=" + speler + ", posspelertype=" + posspelertype + ", reduceFactor=" + reduceFactor + '}';
    }
    /**
     * Vraagt locatie in het spel van de speler op
     * @return een int (0-10) gebaseerd op de positie in het spel van de speler. 
     */
    public int getLoc(){
        return this.loc;
    }
    
    /**
     * Set de locatie van de speler
     * @param i in (0-10) met:
     * 0=Doelman
     * 1-4=Verdediger
     * 5-7=Middenvelder
     * 8-10=Aanvaller
     */
    public void setLoc(int i){
        this.loc = i;
    }
    
    
}
