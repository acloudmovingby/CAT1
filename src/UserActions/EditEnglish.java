/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserActions;

import DataStructures.Segment;
import DataStructures.SegmentBuilder;
import State.State;

/**
 * User edits English text of a segment.
 * @author Chris
 */
public class EditEnglish implements Action {
    
    private final Segment seg; 
    private final String newEnglishText;
    
    EditEnglish(Segment seg, String newEnglishText) {
        this.seg = seg;
        this.newEnglishText = newEnglishText;
    }

    @Override
    public void execute(State state) {
        
        SegmentBuilder sb = new SegmentBuilder(seg);
        sb.setEnglish(newEnglishText);
        sb.setCommitted(false); // because it has new English, it is now made uncommitted
        Segment newSeg = sb.createSegmentNewID();
        
        state.replaceSeg(seg, newSeg);
    }
    
}
