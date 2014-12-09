import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.*;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerType;
import soccer.Team;
import soccer.Wedstrijd;

public class TeamTest {
    
    private Team t1;
    
    @Before
    public void setUp() {
        Speler s1 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Doelman);
        Speler s2 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Verdediger);
        Speler s3 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Verdediger);
        Speler s4 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Doelman);
        Speler s5 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        Speler s6 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        Speler s7 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Doelman);
        Speler s8 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Verdediger);
        Speler s9 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Verdediger);
        Speler s10 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Doelman);
        Speler s11 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Verdediger);
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie eredivisie = new Competitie(wedstrijden, t10);
        spelerlijst.add(s1);
        spelerlijst.add(s2);
        spelerlijst.add(s3);
        spelerlijst.add(s4);
        spelerlijst.add(s5);
        spelerlijst.add(s6);
        spelerlijst.add(s7);
        spelerlijst.add(s8);
        spelerlijst.add(s9);
        spelerlijst.add(s10);
        spelerlijst.add(s11);
        posities.add(p1);
        posities.add(p2);
        posities.add(p3);
        posities.add(p4);
        posities.add(p5);
        posities.add(p6);
        posities.add(p7);
        posities.add(p8);
        posities.add(p9);
        posities.add(p10);
        posities.add(p11);
        t1 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
    }
    
    @After
    public void tearDown() {
        t1 = null;
    }
    
    @Test
    public void constuctorTest() {
        assertNotNull(t1);
    }
    @Test
    public void equalsGelijkeTeamsTest() {
        Speler s1 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Doelman);
        Speler s2 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Verdediger);
        Speler s3 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Verdediger);
        Speler s4 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Doelman);
        Speler s5 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        Speler s6 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        Speler s7 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Doelman);
        Speler s8 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Verdediger);
        Speler s9 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Verdediger);
        Speler s10 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Doelman);
        Speler s11 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Verdediger);
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie eredivisie = new Competitie(wedstrijden, t10);
        spelerlijst.add(s1);
        spelerlijst.add(s2);
        spelerlijst.add(s3);
        spelerlijst.add(s4);
        spelerlijst.add(s5);
        spelerlijst.add(s6);
        spelerlijst.add(s7);
        spelerlijst.add(s8);
        spelerlijst.add(s9);
        spelerlijst.add(s10);
        spelerlijst.add(s11);
        posities.add(p1);
        posities.add(p2);
        posities.add(p3);
        posities.add(p4);
        posities.add(p5);
        posities.add(p6);
        posities.add(p7);
        posities.add(p8);
        posities.add(p9);
        posities.add(p10);
        posities.add(p11);
        Team t2 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
        assertTrue(t1.equals(t2));
    }

    @Test
    public void equalsOngelijkeTeamsTest() {
      
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        Speler s3 = new Speler("KLAAS", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Middenvelder);
        Speler s4 = new Speler("PIETER", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Aanvaller);
        ArrayList<Speler> spelerlijst2 = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities2 = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden2 = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie PremierLeague = new Competitie(wedstrijden, t10);
        spelerlijst.add(s3);
        spelerlijst.add(s4);
        posities.add(p3);
        posities.add(p4);
        Team t2 = new Team(spelerlijst2, "SC VOETBAL", posities2, PremierLeague, 500000);

        assertEquals(false, t1.equals(t2));
    }
    @Test
    public void getBudgetTest() {
        assertEquals(500000, t1.getBudget());
    }
    @Test
    public void setBudgetTest() {
        t1.setBudget(2);
        assertEquals(2, t1.getBudget());
    }
    @Test
    public void getNameTest(){
        assertEquals("Fc club", t1.getName());
    }
    @Test
    public void setNameTest() {
        t1.setName("voetbal");
        assertEquals("voetbal", t1.getName());
    }
    @Test
    public void getOpstellingTest() {
        Speler s1 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Doelman);
        Speler s2 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Verdediger);
        Speler s3 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Verdediger);
        Speler s4 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Doelman);
        Speler s5 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        Speler s6 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        Speler s7 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Doelman);
        Speler s8 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Verdediger);
        Speler s9 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Verdediger);
        Speler s10 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Doelman);
        Speler s11 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Verdediger);
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        spelerlijst.add(s1);
        spelerlijst.add(s2);
        spelerlijst.add(s3);
        spelerlijst.add(s4);
        spelerlijst.add(s5);
        spelerlijst.add(s6);
        spelerlijst.add(s7);
        spelerlijst.add(s8);
        spelerlijst.add(s9);
        spelerlijst.add(s10);
        spelerlijst.add(s11);
        posities.add(p1);
        posities.add(p2);
        posities.add(p3);
        posities.add(p4);
        posities.add(p5);
        posities.add(p6);
        posities.add(p7);
        posities.add(p8);
        posities.add(p9);
        posities.add(p10);
        posities.add(p11);
        assertEquals(posities, t1.getOpstelling());
    }
    @Test
    public void setOpstellingTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
        Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
        ArrayList<PosPlayer> opstelling = new ArrayList<PosPlayer>();
        opstelling.add(p2);
        opstelling.add(p1);
        t1.setOpstelling(opstelling);
        assertEquals(opstelling, t1.getOpstelling());
    }
    @Test
    public void getSpelersTest() {
        Speler s1 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        Speler s2 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        Speler s3 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        Speler s4 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        Speler s5 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        Speler s6 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        Speler s7 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        Speler s8 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        Speler s9 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        Speler s10 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        Speler s11 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie eredivisie = new Competitie(wedstrijden, t10);
        spelerlijst.add(s1);
        spelerlijst.add(s2);
        spelerlijst.add(s3);
        spelerlijst.add(s4);
        spelerlijst.add(s5);
        spelerlijst.add(s6);
        spelerlijst.add(s7);
        spelerlijst.add(s8);
        spelerlijst.add(s9);
        spelerlijst.add(s10);
        spelerlijst.add(s11);
        assertEquals(spelerlijst, t1.getSpelers());
    }
    @Test
    public void setSpelersTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
        ArrayList<Speler> spelers = new ArrayList<Speler>();
        spelers.add(s2);
        spelers.add(s1);
        t1.setSpelers(spelers);
        assertEquals(spelers, t1.getSpelers());
    }

    @Test
    public void getCompetitieTest() {
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie eredivisie = new Competitie(wedstrijden, t10);
        assertEquals(eredivisie, t1.getCompetitie());
    }
    
    @Test
    public void setCompetitieTest() {
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t8 = new ArrayList<Team>();
        Competitie comp = new Competitie(wedstrijden, t8);
        t1.setCompetitie(comp);
        assertEquals(comp, t1.getCompetitie());
    }
    
    @Test
    public void getTotalStatTest() {
        assertEquals(660, t1.getTotalStat());
    }
    
    @Test
    public void getAanvallendTotaalTest() {
        assertEquals(110, t1.getAanvallendTotaal());
    }
    
    @Test
    public void getVerdedigendTotaalTest() {
        assertEquals(220, t1.getVerdedigingsTotaal());
    }
    
    @Test
    public void getUitHoudingsTotaalTest() {
        assertEquals(330, t1.getUithoudingsTotaal());
    }
    
    @Test
    public void equalsGeenTeamTest() {
        String test = "hallo";
        assertEquals(false, t1.equals(test));
    }
    
    @Test
    public void equalsNullTest() {
        String test = null;
        assertEquals(false, t1.equals(test));
    }
    
    @Test
    public void equalsOngelijkeNaamTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
        Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie eredivisie = new Competitie(wedstrijden, t10);
        spelerlijst.add(s1);
        spelerlijst.add(s2);
        posities.add(p1);
        posities.add(p2);
        Team t2 = new Team(spelerlijst, "TeamNaam", posities, eredivisie, 500000);
        assertEquals(false, t1.equals(t2));
    }
    
    @Test
    public void equalsOngelijkeOpstellingTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
        Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<PosPlayer> posities2 = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie eredivisie = new Competitie(wedstrijden, t10);
        spelerlijst.add(s1);
        spelerlijst.add(s2);
        posities.add(p1);
        posities.add(p2);
        posities2.add(p2);
        posities2.add(p1);
        Team t2 = new Team(spelerlijst, "Fc club", posities2, eredivisie, 500000);
        assertEquals(false, t1.equals(t2));
    }
    
    @Test
    public void equalsOngelijkeCompetitieTest() {
        Speler s3 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Middenvelder);
        Speler s4 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Aanvaller);
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie eredivisie = new Competitie(wedstrijden, t10);
        spelerlijst.add(s3);
        spelerlijst.add(s4);
        posities.add(p3);
        posities.add(p4);
        Team t3 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
        
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
        Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
        ArrayList<Team> teamlijst = new ArrayList<Team>();
        Competitie Henk = new Competitie(wedstrijden, teamlijst);
        spelerlijst.add(s1);
        spelerlijst.add(s2);
        posities.add(p1);
        posities.add(p2);
        teamlijst.add(t3);
        Team t2= new Team(spelerlijst, "Fc club", posities, Henk, 500000);
        assertEquals(false, t1.equals(t2));
    }
    
    @Test
    public void equalsOngelijkBudgetTest() {
        Speler s1 = new Speler("Bert", 1, SpelerType.Aanvaller, 10000, 81, 98, 22);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Middenvelder);
        Speler s2 = new Speler("Anton", 3, SpelerType.Verdediger, 15000, 65, 20, 84);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Aanvaller);
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie eredivisie = new Competitie(wedstrijden, t10);
        spelerlijst.add(s1);
        spelerlijst.add(s2);
        posities.add(p1);
        posities.add(p2);
        Team t2 = new Team(spelerlijst, "Fc club", posities, eredivisie, 3);
        assertEquals(false, t1.equals(t2));
    }
}



