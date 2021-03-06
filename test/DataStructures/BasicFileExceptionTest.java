/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * A test file to check whether exceptions are being thrown when invalid
 * segments are added to the file. This is bad programming (later
 Segment/TranslationFile will be changed so that no need for exception throwing).
 *
 * @author Chris
 */
public class BasicFileExceptionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TranslationFile bf = new TranslationFile();
        System.out.println(bf);

        // makes sure a properly built segment CAN be added
        SegmentBuilder sb = new SegmentBuilder(bf);
        bf.addSeg(sb.createSegment());

        // makes sure an exception is thrown when the fileID doesn't match.
        try {
            sb.setFileID(-1);
            bf.addSeg(sb.createSegmentNewID());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown! " + e);
        }

        // makes sure an exception is thrown when the fileName doesn't match
        try {
            sb = new SegmentBuilder(bf);
            sb.setFileName("something else");
            bf.addSeg(sb.createSegmentNewID());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown! " + e);
        }

        System.out.println(bf);
    }

}
