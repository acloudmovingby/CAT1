/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris
 */
public class BasicFileTest {

    public BasicFileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of newSeg method, of class TranslationFile.
     */
    @Test
    public void testEquals() {
        
        // NOT GREAT TESTS (Because I only test when they're equal, not when they're not)
        
        System.out.println("Equals");
        TranslationFile f1 = new TranslationFile();
        TranslationFile f2 = new TranslationFile(f1.getFileID(), f1.getFileName());
        assertEquals(f1, f2);

        // added a seg to f1, so they should no longer be equals
        Segment newSeg = TestObjectBuilder.getTestSeg();
        f1.getActiveSegs().add(newSeg);
        assertEquals(f1.equals(f2), false);

        // added the same seg to f2. Now the should be equal
        f2.getActiveSegs().add(newSeg);
        assertEquals(f1, f2);

        // Now added a seg to removedSegs in f1. Not equal
        Segment removedSeg = TestObjectBuilder.getTestSeg();
        f1.getHiddenSegs().add(removedSeg);
        assertEquals(f1.equals(f2), false);

        // Now added the same seg to f2's removed segs. Equal
        f2.getHiddenSegs().add(removedSeg);
        assertEquals(f1, f2);
    }

    /**
     * Tests that constructing a TranslationFile based on another TranslationFile actually
 makes two entirely distinct objects (no pointers to the other).
     */
    @Test
    public void testCopyFile() {
        // NOT FINISHED
        TranslationFile testFile = TestObjectBuilder.getTestFile();
        TranslationFile testFileCopy = new TranslationFile(testFile);

    }

    @Test
    public void testGetAllSegs() {
        TranslationFile testFile = TestObjectBuilder.getTestFile();
        assertEquals(5, testFile.getAllSegs().size());

        SegmentBuilder sb = new SegmentBuilder(testFile);
        testFile.getHiddenSegs().add(sb.createSegment());
        assertEquals(6, testFile.getAllSegs().size());

        testFile.getActiveSegs().add(sb.createSegmentNewID());
        assertEquals(7, testFile.getAllSegs().size());
    }

}
