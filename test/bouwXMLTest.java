import gui.controller.loadscreenController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerType;
import soccer.Team;
import soccer.Wedstrijd;
import soccer.bouwXML;

public class bouwXMLTest {

    private Competitie c1;
    private File f;
    
    @Before
    public void setUp() throws IOException {
        Speler s1 = new Speler("A", 14, SpelerType.Aanvaller, 10, 10,10,10);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Aanvaller);
        ArrayList<Speler> sp1 = new ArrayList<Speler>();
        ArrayList<PosPlayer> pp = new ArrayList<PosPlayer>();
        pp.add(p1);
        sp1.add(s1);
        
        Team t1 = new Team(sp1, "Team", pp, null, 50000);
        Team t2 = new Team(sp1, "Team", pp, null, 50000);
        Team t3 = new Team(sp1, "Team", pp, null, 50000);
        Team t4 = new Team(sp1, "Team", pp, null, 50000);
        ArrayList<Team> ta = new ArrayList<Team>();
        ta.add(t1);
        ta.add(t2);
        ta.add(t3);
        ta.add(t4);
        
        Wedstrijd w1 = new Wedstrijd(t1,t2);
        w1.setPlayed(true);
        ArrayList<Wedstrijd> w = new ArrayList<Wedstrijd>();
        w.add(w1);
        
        c1 = new Competitie(w,ta);
        
        f = new File("testing.txt");
        if(!f.exists())
            f.createNewFile();
    }
    
    @After
    public void tearDown() {
        c1 = null;
    }
    
    @Test
    public void bouwXMLTest() throws IOException {
        bouwXML.bouwXML(c1, f);
        Scanner infile = new Scanner(f);
        String te = "";
        while(infile.hasNext())
            te += infile.nextLine()+"\n";
        assertEquals(te, "<?xml version=\"1.0\" ?><Competitie><wedstrijden><Wedstrijd><team__a><spelers><Speler><naam>A</naam><nummer>14</nummer><type>Aanvaller</type><prijs>10</prijs><gamesTilStatusDisapears>0</gamesTilStatusDisapears><aanvallend>10</aanvallend><verdedigend>10</verdedigend><uithoudingsvermogen>10</uithoudingsvermogen></Speler></spelers><name>Team</name><opstelling><OpgesteldeSpeler><speler reference=\"../../../spelers/Speler\"></speler><posspelertype>Aanvaller</posspelertype><reduceFactor>0.8</reduceFactor><loc>0</loc></OpgesteldeSpeler></opstelling><budget>50000</budget></team__a><team__b><spelers reference=\"../../team__a/spelers\"></spelers><name>Team</name><opstelling reference=\"../../team__a/opstelling\"></opstelling><budget>50000</budget></team__b><score__a>0</score__a><score__b>0</score__b><points__a>0</points__a><points__b>0</points__b><played>true</played><speeldag>0</speeldag></Wedstrijd></wedstrijden><teams><Team reference=\"../../wedstrijden/Wedstrijd/team__a\"></Team><Team reference=\"../../wedstrijden/Wedstrijd/team__b\"></Team><Team><spelers reference=\"../../../wedstrijden/Wedstrijd/team__a/spelers\"></spelers><name>Team</name><opstelling reference=\"../../../wedstrijden/Wedstrijd/team__a/opstelling\"></opstelling><budget>50000</budget></Team><Team><spelers reference=\"../../../wedstrijden/Wedstrijd/team__a/spelers\"></spelers><name>Team</name><opstelling reference=\"../../../wedstrijden/Wedstrijd/team__a/opstelling\"></opstelling><budget>50000</budget></Team></teams><userindex>0</userindex></Competitie>\n");
        System.out.println(te);
    }
    
    @Test
    public void leesXMLTest() throws FileNotFoundException {
        Competitie l = bouwXML.leesXML(f);
        assertEquals(l, c1);
    }
    
    @Test
    public void saveGame() throws FileNotFoundException, IOException {
        loadscreenController.savegame = "bouwXMLTestSaveGameToBeRemoved";
        File ff = new File("src/saves/"+loadscreenController.savegame+".xml");
        Competitie.setCompetitie(c1);
        try {bouwXML.SaveGame();} catch(Exception e){ System.out.println(e.getStackTrace()); }
        
        Competitie l = bouwXML.leesXML(ff);
        assertEquals(l, c1);
        
        ff.delete();
    }
    
    @Test(expected=AssertionError.class)
    public void saveGameException() throws FileNotFoundException, IOException  { 
        loadscreenController.savegame = "../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../../";
        File ff = new File("src/saves/"+loadscreenController.savegame+".xml");
        Competitie.setCompetitie(null);
        try {bouwXML.SaveGame();} catch(Exception e){ System.out.println(e.getStackTrace()); }
        
        Competitie l = bouwXML.leesXML(ff);
        assertEquals(l, c1);
        
        ff.delete();
    }
    
    @Test
    public void init() {
        bouwXML b = new bouwXML();
        assertEquals(b, b);
    }
}
