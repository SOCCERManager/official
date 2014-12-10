/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static java.nio.file.StandardCopyOption.*;
import soccer.ReadFolder;


/**
 *
 * @author codesalad
 */
public class ReadFolderTest {
    public File dir;
    public Path source;
    public Path target;
    
    @Before
    public void setUp() throws IOException{
        source = Paths.get("src/saves/standaard.xml");
        target = Paths.get("test/testMap/test.xml");
        dir = new File("test/testMap");
        dir.mkdir();
        
        File f = new File(source.toString());
        CopyOption[] options = new CopyOption[] {
            StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES
        };
         Files.copy(source, target, options);
    }
    
    @After
    public void tearDown() {
        dir.delete();
    }
    @Test
    public void testReadNames_Positive_Case() throws IOException {
        System.out.println(ReadFolder.readNames("/test/testMap").get(0));
        assertEquals(ReadFolder.readNames("/test/testMap").get(0), "test");
    }
    
    @Test
    public void testReadNames_Negative_Case(){
        ReadFolder.readNames("45678");
        assertEquals(ReadFolder.getAantalSaveGames(),0);
    }
    
    @Test
    public void testGetAantalSaveGames(){
        System.out.println(ReadFolder.getAantalSaveGames());
        assertTrue(ReadFolder.getAantalSaveGames()>=0);
    }
    
    @Test
    public void testGetFileExtension_Positive_Case(){
        assertEquals(ReadFolder.getFileExtension(new File("/test/testMap/test.xml")),"xml");
    }
    
    @Test
    public void testGetFileExtension_Negative_Case(){
        File file1 = new File("123");
        assertEquals(ReadFolder.getFileExtension(file1), "");
    }
}

