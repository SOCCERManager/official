import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        
        File f = new File("C:\\testing.txt");
        
    }
    
    @After
    public void tearDown() {
        c1 = null;
    }
    
    @Test
    public void bouwXMLTest() throws IOException {
        bouwXML.bouwXML(c1, f);
    }
    
    @Test
    public void getStreamTest() {
       
    }
}
