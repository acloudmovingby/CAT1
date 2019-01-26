/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import javafx.collections.ObservableList;

/**
 *
 * @author Chris
 */
public class MainFile extends BasicFile {
    
    public MainFile(BasicFile file) {
        super(file);
        /*
        // Actual segs displayed to the user while translating this file.
    private ObservableList<Segment> activeSegs;
    // Any segs that had been removed. They still might appear in match queries if they had been commited
    private ArrayList<Segment> removedSegs;
    private String fileName;
    private final int fileID;
        */
    }
    
    /**
     * Splits a segment into two pieces. The second segment begins with the character at
     * the specified index. So if this method was given "unhappy" and 2, the two
     * new TUs would be "un" and "happy".
     *
     * @param seg
     * @param splitIndex
     */
    public void splitSeg(Segment seg, int splitIndex) {
        // if the seg is null or is not in the list of active segs, return
        // if the split index is out of bounds, return
        if (seg == null 
                || splitIndex <= 0 
                || splitIndex >= seg.getThai().length()) {
            return;
        }
        
        // This makes sure that the selected seg is actually in the active segs list.
        // we use == to make sure it's the exact same object (the .equals method for Segments compares the value of the fields, not identity of the object)
        // if two segs have same field values (including id) but are not the same object, this method (splitSeg) will not work correctly
        boolean isInActiveSegs = false;
        for (Segment s : getActiveSegs()) {
            if (s==seg) {
                isInActiveSegs = true;
            }
        }
        if (!isInActiveSegs) {
            return;
        }
            
        
        String firstThai = seg.getThai().substring(0, splitIndex);
        String secondThai = seg.getThai().substring(splitIndex);

        // retrieves index of old TU
        int index = getActiveSegs().indexOf(seg);

        // creates first new TU and inserts
        Segment newTU1 = new Segment(getFileID());
        newTU1.setThai(firstThai);
        newTU1.setEnglish(seg.getEnglish());
        newTU1.setCommitted(false);
        getActiveSegs().add(index, newTU1);

        // creates second new TU and inserts
        Segment newTU2 = new Segment(getFileID());
        newTU2.setThai(secondThai);
        newTU2.setEnglish("");
        newTU2.setCommitted(false);
        getActiveSegs().add(index + 1, newTU2);
        
        /*
        ObservableList<Segment> activeSegs1 = getActiveSegs();
        this.removeSegs(index, index+1, activeSegs1);
        Segment[] segsToAdd = new Segment[] {newTU1, newTU2};
        this.addSegments(activeSegs1, Arrays.asList(segsToAdd), index);
        */

        //removes old TU
        removeSeg(seg);

        // DATABASE
        realignRanks();
    }
    
    
    
}
