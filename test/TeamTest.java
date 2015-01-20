import java.time.Clock;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.*;
import soccer.Competitie;
import soccer.PosPlayer;
import soccer.Speler;
import soccer.SpelerStatus;
import soccer.SpelerType;
import soccer.Team;
import soccer.Wedstrijd;

public class TeamTest {
    
    private Team t1;
    private Competitie eredivisie;
    
    @Before
    public void setUp() {
        Speler s1 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Doelman);
        Speler s2 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Verdediger);
        Speler s3 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Verdediger);
        Speler s4 = new Speler("Davey", 4, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Doelman);
        Speler s5 = new Speler("Eric", 5, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        Speler s6 = new Speler("Floris (Mentaal beperkt)", 6, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Doelman);
        Speler s8 = new Speler("Hektor", 8, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Verdediger);
        Speler s9 = new Speler("Issambal", 9, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Verdediger);
        Speler s10 = new Speler("Jannet", 10, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Doelman);
        Speler s11 = new Speler("Kabouter plop", 11, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Verdediger);
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
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
        t1.getCompetitie().getTeams().add(t1);
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
        Speler s4 = new Speler("Davey", 4, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Doelman);
        Speler s5 = new Speler("Eric", 5, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        Speler s6 = new Speler("Floris (Mentaal beperkt)", 6, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Doelman);
        Speler s8 = new Speler("Hektor", 8, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Verdediger);
        Speler s9 = new Speler("Issambal", 9, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Verdediger);
        Speler s10 = new Speler("Jannet", 10, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Doelman);
        Speler s11 = new Speler("Kabouter plop", 11, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Verdediger);
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
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
        Speler s4 = new Speler("Davey", 4, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Doelman);
        Speler s5 = new Speler("Eric", 5, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        Speler s6 = new Speler("Floris (Mentaal beperkt)", 6, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Doelman);
        Speler s8 = new Speler("Hektor", 8, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Verdediger);
        Speler s9 = new Speler("Issambal", 9, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Verdediger);
        Speler s10 = new Speler("Jannet", 10, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Doelman);
        Speler s11 = new Speler("Kabouter plop", 11, SpelerType.Verdediger, 15000, 10, 20, 30);
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
        Speler s4 = new Speler("Davey", 4, SpelerType.Doelman, 10000, 10, 20, 30);
        Speler s5 = new Speler("Eric", 5, SpelerType.Verdediger, 15000, 10, 20, 30);
        Speler s6 = new Speler("Floris (Mentaal beperkt)", 6, SpelerType.Verdediger, 20000, 10, 20, 30);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Doelman, 10000, 10, 20, 30);
        Speler s8 = new Speler("Hektor", 8, SpelerType.Verdediger, 15000, 10, 20, 30);
        Speler s9 = new Speler("Issambal", 9, SpelerType.Verdediger, 20000, 10, 20, 30);
        Speler s10 = new Speler("Jannet", 10, SpelerType.Doelman, 10000, 10, 20, 30);
        Speler s11 = new Speler("Kabouter plop", 11, SpelerType.Verdediger, 15000, 10, 20, 30);
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
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
        assertEquals(550, t1.getTotalStat());
    }
    
    @Test
    public void getAanvallendTotaalTest() {
        assertEquals(0, t1.getAanvallendTotaal());
    }
    
    @Test
    public void getVerdedigendTotaalTest() {
        assertEquals(440, t1.getVerdedigingsTotaal());
    }
    
    @Test
    public void getUitHoudingsTotaalTest() {
        assertEquals(110, t1.getUithoudingsTotaal());
    }
    
    @Test
    public void equalsGeenTeamTest() {
        String test = "hallo";
        assertEquals(false, t1.equals(test));
    }
    
    @Test
    public void equalsNullTest() {
        assertEquals(false, t1.equals(null));
    }
    
    @Test
    public void equalsOngelijkeNaamTest() {
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
        Team t2 = new Team(spelerlijst, "Test", posities, eredivisie, 500000);
        assertEquals(false, t1.equals(t2));
    }
    
    @Test
    public void equalsOngelijkeSpelerLijstTest() {
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
        ArrayList<Speler> spelerlijst2 = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        Competitie eredivisie = new Competitie(wedstrijden, t10);
        spelerlijst2.add(s1);
        spelerlijst2.add(s2);
        spelerlijst2.add(s3);
        spelerlijst2.add(s4);
        spelerlijst2.add(s5);
        spelerlijst2.add(s6);
        spelerlijst2.add(s7);
        spelerlijst2.add(s8);
        spelerlijst2.add(s9);
        spelerlijst2.add(s10);
        
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
        Team t2= new Team(spelerlijst2, "Fc club", posities, eredivisie, 500000);
        assertEquals(false, t1.equals(t2));
    }
    
    @Test
    public void equalsOngelijkBudgetTest() {
        Speler s1 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Doelman);
        Speler s2 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Verdediger);
        Speler s3 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Verdediger);
        Speler s4 = new Speler("Davey", 4, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Doelman);
        Speler s5 = new Speler("Eric", 5, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        Speler s6 = new Speler("Floris (Mentaal beperkt)", 6, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Doelman);
        Speler s8 = new Speler("Hektor", 8, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Verdediger);
        Speler s9 = new Speler("Issambal", 9, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Verdediger);
        Speler s10 = new Speler("Jannet", 10, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Doelman);
        Speler s11 = new Speler("Kabouter plop", 11, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Verdediger);
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
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
        Team t2 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500);
        assertEquals(false, t1.equals(t2));
    }
    
    @Test
    public void getAanvallendTotaalGenerateOpstellingTest() {
        Speler s97 = new Speler("Piet", 97, SpelerType.Verdediger, 888, 20, 55, 88);
        Speler s98 = new Speler("Johan", 98, SpelerType.Doelman, 999, 100, 88, 22);
        Speler s99 = new Speler("Fred", 99, SpelerType.Aanvaller, 555, 67, 44 ,55);
        
        t1.getSpelers().get(0).setGamesTilStatusDisapears(10);
        t1.getSpelers().get(1).setGamesTilStatusDisapears(10);
        t1.getSpelers().add(s97);
        t1.getSpelers().add(s98);
        t1.getSpelers().add(s99);
        assertEquals(167, t1.getAanvallendTotaal());   
    }
    
    @Test
    public void opstellingIsValideTest() {
        assertEquals(true, t1.OpstellingIsValide());
    }
    
    @Test
    public void equalsOngelijkeCompetitie() {
        Speler s1 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Doelman);
        Speler s2 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Verdediger);
        Speler s3 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Verdediger);
        Speler s4 = new Speler("Davey", 4, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Doelman);
        Speler s5 = new Speler("Eric", 5, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        Speler s6 = new Speler("Floris (Mentaal beperkt)", 6, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Doelman);
        Speler s8 = new Speler("Hektor", 8, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Verdediger);
        Speler s9 = new Speler("Issambal", 9, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Verdediger);
        Speler s10 = new Speler("Jannet", 10, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Doelman);
        Speler s11 = new Speler("Kabouter plop", 11, SpelerType.Verdediger, 15000, 10, 20, 30);
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
        Team t2 = new Team(spelerlijst, "Fc club", posities, null, 500000);
        assertFalse(t1.equals(t2));
    }
    
    @Test
    public void countYellowCardsTest() {
        t1.getSpelers().get(1).setStatus(SpelerStatus.Gele_kaart);
        t1.getSpelers().get(5).setStatus(SpelerStatus.Gele_kaart);
        t1.getSpelers().get(9).setStatus(SpelerStatus.Rode_kaart);
        t1.getSpelers().get(6).setStatus(SpelerStatus.Geblesseerd);
        assertEquals(2, t1.countYellowCards());
    }
    
    @Test
    public void countRedCardsTest() {
        t1.getSpelers().get(1).setStatus(SpelerStatus.Rode_kaart);
        t1.getSpelers().get(5).setStatus(SpelerStatus.Gele_kaart);
        t1.getSpelers().get(9).setStatus(SpelerStatus.Rode_kaart);
        t1.getSpelers().get(6).setStatus(SpelerStatus.Geblesseerd);
        assertEquals(2, t1.countRedCards());
    }
    
    @Test
    public void countgeBlesseerdTest() {
        t1.getSpelers().get(1).setStatus(SpelerStatus.Gele_kaart);
        t1.getSpelers().get(5).setStatus(SpelerStatus.Gele_kaart);
        t1.getSpelers().get(9).setStatus(SpelerStatus.Rode_kaart);
        t1.getSpelers().get(6).setStatus(SpelerStatus.Geblesseerd);
        assertEquals(1, t1.countGebleseerd());
    }
    
    @Test
    public void countAvailableTest() {
        t1.getSpelers().get(1).setStatus(SpelerStatus.Gele_kaart);
        t1.getSpelers().get(5).setStatus(SpelerStatus.Gele_kaart);
        t1.getSpelers().get(9).setStatus(SpelerStatus.Rode_kaart);
        t1.getSpelers().get(6).setStatus(SpelerStatus.Geblesseerd);
        assertEquals(7, t1.countAvaliable());
    }
    
    @Test
    public void equalsOngelijkeOpstellingTest() {
        Speler s1 = new Speler("Anton", 1, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p1 = new PosPlayer(s1, SpelerType.Doelman);
        Speler s2 = new Speler("Bert", 2, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p2 = new PosPlayer(s2, SpelerType.Verdediger);
        Speler s3 = new Speler("Chris", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p3 = new PosPlayer(s3, SpelerType.Verdediger);
        Speler s4 = new Speler("Davey", 4, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p4 = new PosPlayer(s4, SpelerType.Doelman);
        Speler s5 = new Speler("Eric", 5, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p5 = new PosPlayer(s5, SpelerType.Verdediger);
        Speler s6 = new Speler("Floris (Mentaal beperkt)", 6, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p6 = new PosPlayer(s6, SpelerType.Verdediger);
        Speler s7 = new Speler("Gerard", 7, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p7 = new PosPlayer(s7, SpelerType.Doelman);
        Speler s8 = new Speler("Hektor", 8, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p8 = new PosPlayer(s8, SpelerType.Verdediger);
        Speler s9 = new Speler("Issambal", 9, SpelerType.Verdediger, 20000, 10, 20, 30);
        PosPlayer p9 = new PosPlayer(s9, SpelerType.Verdediger);
        Speler s10 = new Speler("Jannet", 10, SpelerType.Doelman, 10000, 10, 20, 30);
        PosPlayer p10 = new PosPlayer(s10, SpelerType.Doelman);
        Speler s11 = new Speler("Kabouter plop", 11, SpelerType.Verdediger, 15000, 10, 20, 30);
        PosPlayer p11 = new PosPlayer(s11, SpelerType.Verdediger);
        ArrayList<Team> t10 = new ArrayList<Team>(); 
        ArrayList<Speler> spelerlijst = new ArrayList<Speler>();
        ArrayList<PosPlayer> posities = new ArrayList<PosPlayer>();
        ArrayList<Wedstrijd> wedstrijden = new ArrayList<Wedstrijd>();
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
        posities.add(p11);
        posities.add(p2);
        posities.add(p8);
        posities.add(p4);
        posities.add(p5);
        posities.add(p6);
        posities.add(p10);
        posities.add(p1);
        posities.add(p3);
        posities.add(p9);
        posities.add(p7);
        Team t2 = new Team(spelerlijst, "Fc club", posities, eredivisie, 500000);
        assertEquals(false, t1.equals(t2));
    }
    
    @Test
    public void getScoreTest() {
        ArrayList<Wedstrijd> wedstrlijst = new ArrayList<Wedstrijd>();
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
        Wedstrijd w1 = new Wedstrijd(t1, t2);
        w1.setPoints_a(3);
        w1.setPoints_b(0);
        wedstrijden.add(w1);
        eredivisie.setWedstrijden(wedstrijden);
        t1.setCompetitie(eredivisie);
        assertEquals(3, t1.getScore());
    }
    
    @Test
    public void addSpelerTest() {
        Speler newSpeler = new Speler("Jeroen de Nieuw", 3, SpelerType.Verdediger, 20000, 10, 20, 30);
        t1.addSpeler(newSpeler);
        assertEquals(t1.getSpelers().size(), 12);
    }
    
    @Test
    public void getDraws0Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(3);
        w10.setPoints_b(0);
        w10.setScore_a(3);
        w10.setScore_b(0);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(0, t2.getDraws());
    }
    
    @Test
    public void getDraws1Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(1);
        w10.setPoints_b(1);
        w10.setScore_a(1);
        w10.setScore_b(1);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(1, t2.getDraws());
    }
    
    @Test
    public void getWins0Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        t2.setBudget(200);
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(1);
        w10.setPoints_b(1);
        w10.setScore_a(1);
        w10.setScore_b(1);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(0, t2.getWins());
    }
    
    @Test
    public void getWins1Test() {
        Team t2 = t1;
        t2.setBudget(205);
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(0);
        w10.setPoints_b(3);
        w10.setScore_a(0);
        w10.setScore_b(3);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(1, t2.getWins());
    }
    
    @Test
    public void getLosses0Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(1);
        w10.setPoints_b(1);
        w10.setScore_a(1);
        w10.setScore_b(1);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(0, t2.getLosses());
    }
    
    @Test
    public void getLosses1Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(0);
        w10.setPoints_b(3);
        w10.setScore_a(0);
        w10.setScore_b(3);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(1, t1.getLosses());
    }
    
    @Test
    public void getPlayed0Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(0);
        w10.setPoints_b(3);
        w10.setScore_a(0);
        w10.setScore_b(3);
        w10.setPlayed(false);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(0, t2.getPlayed());
    }
    
    @Test
    public void getPlayed1Test(){
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(0);
        w10.setPoints_b(3);
        w10.setScore_a(0);
        w10.setScore_b(3);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(1, t2.getPlayed());
    }
    
    @Test
    public void getGoals0Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(1);
        w10.setPoints_b(1);
        w10.setScore_a(3);
        w10.setScore_b(0);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(3, t1.getGoals());
    }
    
    @Test
    public void getGoals1Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(3);
        w10.setPoints_b(0);
        w10.setScore_a(3);
        w10.setScore_b(0);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(3, t1.getGoals());
    }
    
    
    @Test
    public void getCounterGoals0Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(0);
        w10.setPoints_b(3);
        w10.setScore_a(0);
        w10.setScore_b(3);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(3, t1.getCounterGoals());
    }
    
    @Test
    public void getGoalSaldo0Test() {
        Team t2 = t1;
        t2.setName("Hallo");
        Wedstrijd w10 = new Wedstrijd(t1, t2);
        w10.setPoints_a(0);
        w10.setPoints_b(3);
        w10.setScore_a(0);
        w10.setScore_b(3);
        w10.setPlayed(true);
        ArrayList<Wedstrijd> wedlijst = new ArrayList<>();
        wedlijst.add(w10);
        System.out.println(wedlijst);
        t1.getCompetitie().setWedstrijden(wedlijst);
        t2.getCompetitie().setWedstrijden(wedlijst);
        assertEquals(-3, t1.getGoalSaldo());
    }
    
    @Test
    public void generateOpstellingGeenKeeperTest() {
        for (int i = 0; i < t1.getSpelers().size(); i++) {
            t1.getSpelers().get(i).setType(SpelerType.Verdediger);
        }
        t1.generateOpstelling();
    }
    
    @Test
    public void getUithTotaalGenOpstellingTest() {
        t1.getOpstelling().get(3).getSpeler().setGamesTilStatusDisapears(9001);
        t1.getOpstelling().get(4).getSpeler().setGamesTilStatusDisapears(9001);
        t1.getOpstelling().get(5).getSpeler().setGamesTilStatusDisapears(9001);
        assertTrue(98==t1.getUithoudingsTotaal());
    }
    
    @Test
    public void getVerdTotaalGenOpstellingTest() {
        t1.getOpstelling().get(3).getSpeler().setGamesTilStatusDisapears(9001);
        t1.getOpstelling().get(4).getSpeler().setGamesTilStatusDisapears(9001);
        t1.getOpstelling().get(5).getSpeler().setGamesTilStatusDisapears(9001);
        System.out.println(t1.getVerdedigingsTotaal());
        assertTrue(440==t1.getVerdedigingsTotaal());
    }
    
    @Test
    public void addSpelerOutputTest() {
        ArrayList<Wedstrijd> wlijst = new ArrayList<Wedstrijd>();
        ArrayList<Team> tlijst = new ArrayList<>();
        Team t2 = new Team(new ArrayList<Speler>(), "Team2", new ArrayList<PosPlayer>(), eredivisie, 300);
        Speler s1 = new Speler("Henk", 3, SpelerType.Doelman, 9, 45, 45, 45);
        t1.getSpelers().add(s1);
        Wedstrijd w1 = new Wedstrijd(t1, t2);
        wlijst.add(w1);
        tlijst.add(t1);
        tlijst.add(t2);
        Competitie c1 = new Competitie(wlijst, tlijst);
        c1.setUserindex(1);
        t2.setCompetitie(c1);
        t2.getCompetitie().getTeams().add(t1);
        t2.getCompetitie().getTeams().add(t2);
        System.out.println("T1SpelerVoor: " + t1.getSpelers().size());
        System.out.println("T2SpelerVoor: " + t2.getSpelers().size());
        t2.addSpeler(s1);
        System.out.println("T1SpelerNa: " + t1.getSpelers().size());
        System.out.println("T2SpelerNa: " + t2.getSpelers().size());
        assertTrue(t1.getSpelers().size() == 11);
        assertTrue(t2.getSpelers().size() == 1);
    }
    
    @Test
    public void playGameKYUTest() {
        t1.setName("FC Dordrecht");
        Wedstrijd w1 = new Wedstrijd(t1, t1);
        Wedstrijd w2 = new Wedstrijd(t1, t1);
        Wedstrijd w3 = new Wedstrijd(t1, t1);
        Wedstrijd w4 = new Wedstrijd(t1, t1);
        ArrayList<Wedstrijd> wlijst = new ArrayList<>();
        wlijst.add(w1);
        wlijst.add(w2);
        wlijst.add(w3);
        wlijst.add(w4);
        t1.getCompetitie().setWedstrijden(wlijst);
        t1.getCompetitie().getWedstrijden().get(0).setPlayed(true);
        t1.getCompetitie().getWedstrijden().get(1).setPlayed(true);
        t1.getCompetitie().getWedstrijden().get(2).setPlayed(true);
        t1.playGame();
        assertEquals("KIM JONG UN", t1.getSpelers().get(11).getNaam());
    }
    
    @Test
    public void playGameAZTest() {
        t1.setName("FC Tukkers");
        Wedstrijd w1 = new Wedstrijd(t1, t1);
        Wedstrijd w2 = new Wedstrijd(t1, t1);
        Wedstrijd w3 = new Wedstrijd(t1, t1);
        Wedstrijd w4 = new Wedstrijd(t1, t1);
        Wedstrijd w5 = new Wedstrijd(t1, t1);
        ArrayList<Wedstrijd> wlijst = new ArrayList<>();
        wlijst.add(w1);
        wlijst.add(w2);
        wlijst.add(w3);
        wlijst.add(w4);
        wlijst.add(w5);
        t1.getCompetitie().setWedstrijden(wlijst);
        t1.getCompetitie().getWedstrijden().get(0).setPlayed(true);
        t1.getCompetitie().getWedstrijden().get(1).setPlayed(true);
        t1.getCompetitie().getWedstrijden().get(2).setPlayed(true);
        t1.getCompetitie().getWedstrijden().get(3).setPlayed(true);
        t1.playGame();
        assertEquals(t1.getSpelers().get(11).getNaam(), "Andy Zaidman");
    }
    
    @Test
    public void playGameTeamMemberTest() {
        t1.setName("Ajax");
        Wedstrijd w1 = new Wedstrijd(t1, t1);
        Wedstrijd w2 = new Wedstrijd(t1, t1);
        Wedstrijd w3 = new Wedstrijd(t1, t1);
        Wedstrijd w4 = new Wedstrijd(t1, t1);
        Wedstrijd w5 = new Wedstrijd(t1, t1);
        Wedstrijd w6 = new Wedstrijd(t1, t1);
        ArrayList<Wedstrijd> wlijst = new ArrayList<>();
        wlijst.add(w1);
        wlijst.add(w2);
        wlijst.add(w3);
        wlijst.add(w4);
        wlijst.add(w5);
        wlijst.add(w6);
        t1.getCompetitie().setWedstrijden(wlijst);
        t1.getCompetitie().getWedstrijden().get(0).setPlayed(true);
        t1.getCompetitie().getWedstrijden().get(1).setPlayed(true);
        t1.getCompetitie().getWedstrijden().get(2).setPlayed(true);
        t1.getCompetitie().getWedstrijden().get(3).setPlayed(true);
        t1.getCompetitie().getWedstrijden().get(4).setPlayed(true);
        t1.playGame();
        assertTrue(t1.getSpelers().size() == 16);
        assertEquals(t1.getSpelers().get(11).getNaam(), "Florist Strikval");
        assertEquals(t1.getSpelers().get(12).getNaam(), "Wing Wing Wing Wing");
        assertEquals(t1.getSpelers().get(13).getNaam(), "Nils cry-again");
        assertEquals(t1.getSpelers().get(14).getNaam(), "Boeri Akkersteijn");
        assertEquals(t1.getSpelers().get(15).getNaam(), "[FaZe]xXx_|-|4$$A|\\|_xXx_360NOSC");
    }
    @Test
    public void generateOpstellingOnvoldVerdedigersTest() {
        t1.setSpelers(new ArrayList<>());
        t1.getSpelers().add(new Speler("Henk", 1, SpelerType.Doelman, 5, 41, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 2, SpelerType.Middenvelder, 5, 42, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 3, SpelerType.Verdediger, 5, 30, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 4, SpelerType.Verdediger, 5, 60, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 5, SpelerType.Verdediger, 5, 46, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 6, SpelerType.Middenvelder, 5, 10, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 7, SpelerType.Middenvelder, 5, 90, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 8, SpelerType.Aanvaller, 5, 50, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 9, SpelerType.Middenvelder, 5, 98, 15, 45));
        t1.getSpelers().add(new Speler("Henk", 10, SpelerType.Aanvaller, 5, 50, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 11, SpelerType.Aanvaller, 5, 50, 40, 40));
        t1.generateOpstelling();
        assertEquals("Henk", t1.getSpelers().get(10).getNaam());
    }
    
    @Test
    public void generateOpstellingMagicFixAPlayerTest() {
        t1.setSpelers(new ArrayList<>());
        t1.getSpelers().add(new Speler("Henk", 1, SpelerType.Doelman, 5, 41, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 2, SpelerType.Doelman, 5, 42, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 3, SpelerType.Doelman, 5, 30, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 4, SpelerType.Doelman, 5, 60, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 5, SpelerType.Doelman, 5, 46, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 6, SpelerType.Doelman, 5, 10, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 7, SpelerType.Doelman, 5, 90, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 8, SpelerType.Doelman, 5, 50, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 9, SpelerType.Doelman, 5, 98, 15, 45));
        t1.getSpelers().add(new Speler("Henk", 10, SpelerType.Doelman, 5, 50, 40, 40));
        t1.getSpelers().add(new Speler("Henk", 11, SpelerType.Doelman, 5, 50, 40, 40));
        t1.getSpelers().get(2).setGamesTilStatusDisapears(4);
        t1.getSpelers().get(8).setGamesTilStatusDisapears(1);
        t1.getSpelers().get(9).setGamesTilStatusDisapears(5);
        t1.generateOpstelling();
        for(int i =0; i<t1.getSpelers().size(); i++) {
            assertTrue(t1.getSpelers().get(i).getGamesTilStatusDisapears() == 0);
        }
    }
}
