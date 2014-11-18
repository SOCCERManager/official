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
    private SpelerType spelertype;

    public PosPlayer(Speler speler, SpelerType spelertype) {
        this.speler = speler;
        this.spelertype = spelertype;
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public SpelerType getSpelertype() {
        return spelertype;
    }

    public void setSpelertype(SpelerType spelertype) {
        this.spelertype = spelertype;
    }
}
