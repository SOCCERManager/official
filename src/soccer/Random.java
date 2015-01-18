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
public class Random extends java.util.Random{
    /**
     * THe instance of the class itself
     */
    private static Random r;

    /**
     * Constructor Private for simplicity reasons.
     */
    private Random() {
        super();
    }
    
    /**
     * The one public way to get the Random object
     * @return 
     */
    public static Random get() {
        if(Random.r == null) {
            Random.r = new Random();
        }
        return Random.r;
    }
}
