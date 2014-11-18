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

    private String _naam;
    private int _nummer;
    private SpelerType _type;
    private SpelerStatus _status;
    private int _prijs;
    private int _gamesTilStatusDisapears;
    private int _aanvallend;
    private int _verdedigend;
    private int _uithoudingsvermogen;

    public Speler(String _naam, int _nummer, SpelerType _type, int _prijs, int _aanvallend, int _verdedigend, int _uithoudingsvermogen) {
        this._naam = _naam;
        this._nummer = _nummer;
        this._type = _type;
        this._prijs = _prijs;
        this._aanvallend = _aanvallend;
        this._verdedigend = _verdedigend;
        this._uithoudingsvermogen = _uithoudingsvermogen;
    }

    public String getNaam() {
        return this._naam;
    }

    public void setNaam(String aNaam) {
        this._naam = aNaam;
    }

    public int getNummer() {
        return this._nummer;
    }

    public void setNummer(int aNummer) {
        this._nummer = aNummer;
    }

    public SpelerType getType() {
        return this._type;
    }

    public void setType(SpelerType aType) {
        this._type = aType;
    }

    public int getAanvallend() {
        return this._aanvallend;
    }

    public void setAanvallend(int aAanvallend) {
        this._aanvallend = aAanvallend;
    }

    public int getVerdedigend() {
        return this._verdedigend;
    }

    public void setVerdedigend(int aVerdedigend) {
        this._verdedigend = aVerdedigend;
    }

    public int getUithoudingsvermogen() {
        return this._uithoudingsvermogen;
    }

    public void setUithoudingsvermogen(int aUithoudingsvermogen) {
        this._uithoudingsvermogen = aUithoudingsvermogen;
    }

    public SpelerStatus getStatus() {
        return _status;
    }

    public void setStatus(SpelerStatus _status) {
        this._status = _status;
    }

    public int getPrijs() {
        return _prijs;
    }

    public void setPrijs(int _prijs) {
        this._prijs = _prijs;
    }
    
    public void playedGame() {
        throw new UnsupportedOperationException();
    }
}
