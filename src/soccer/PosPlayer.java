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
public class PosPlayer {
    private Speler speler;
    private SpelerType posspelertype;

    public PosPlayer(Speler speler, SpelerType spelertype) {
        this.speler = speler;
        this.posspelertype = spelertype;
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public SpelerType getPosSpelertype() {
        return posspelertype;
    }

    public void setPosSpelertype(SpelerType spelertype) {
        this.posspelertype = spelertype;
    }

    public String getNaam() {
        return speler.getNaam();
    }

    public void setNaam(String aNaam) {
        speler.setNaam(aNaam);
    }

    public int getNummer() {
        return speler.getNummer();
    }

    public void setNummer(int aNummer) {
        speler.setNummer(aNummer);
    }

    public int getAanvallend() {
        return speler.getAanvallend();
    }

    public void setAanvallend(int aAanvallend) {
        speler.setAanvallend(aAanvallend);
    }

    public int getVerdedigend() {
        return speler.getVerdedigend();
    }

    public void setVerdedigend(int aVerdeligend) {
        speler.setVerdedigend(aVerdeligend);
    }

    public int getUithoudingsvermogen() {
        if(speler.getType().equals(posspelertype)) {
            return speler.getUithoudingsvermogen();
        } else {
            return (int) (speler.getUithoudingsvermogen()*0.8);
        }
    }

    public void setUithoudingsvermogen(int aUithoudingsvermogen) {
        speler.setUithoudingsvermogen(aUithoudingsvermogen);
    }

    public SpelerType getType() {
        return speler.getType();
    }

    public void setType(SpelerType aType) {
        speler.setType(aType);
    }

    public SpelerStatus getStatus() {
        return speler.getStatus();
    }

    public void setStatus(SpelerStatus _status) {
        speler.setStatus(_status);
    }

    public int getPrijs() {
        return speler.getPrijs();
    }

    public void setPrijs(int _prijs) {
        speler.setPrijs(_prijs);
    }

    public void playedGame() {
        speler.playedGame();
    }
    
    
}
