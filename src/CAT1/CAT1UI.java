/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAT1;

import comparator.TMFile;
import comparator.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Chris
 */
public class CAT1UI extends javax.swing.JFrame {

    TMFile file;
    TMFile corpus;
    int minMatchLength;

    /**
     * Creates new form CAT1UI
     */
    public CAT1UI() {
        file = new TMFile(
                "ขขข\nการเมือง\nคคคค\nลังเลตลอด",
                "gor\nfaoher\naerae\nfalerh");
        corpus = new TMFile(
                "ฟหกดกดก\nการเมืองA\nกกกกกกกก\nการเมืองB\nการเมืองC\nไำไพไพ\nไำพำไำะไำะ\nลังเลตลอด",
                "c1\nc2\nc3\nc4\nc5\nc6\nc7\nc8");
        minMatchLength = 4;
        initComponents();
        ListSelectionModel selectionModel = fileViewer.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(
                        fileViewer.getValueAt(fileViewer.getSelectedRow(), fileViewer.getSelectedColumn()));
                
                String th = (String) fileViewer.getValueAt(fileViewer.getSelectedRow(), 1);
                
                TMFile fileMatches = getMatches(th);
                
                displayMatches(fileMatches);
                
            }
        });
        
        TMFile testFile = new TMFile();
        System.out.println(testFile);
        
        Object[][] oa = new Object[][] {new Object[] {0, "this", "that"}};
        testFile.addTM(oa);
        System.out.println(testFile);
        
        oa[0] = new Object[] { 1, "blah", "blue"};
        testFile.addTM(oa);
        System.out.println(testFile);
        
        oa[0] = new Object[] { 2, "third", "eye"};
        testFile.addTM(oa);
        System.out.println(testFile);
        
       

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        fileViewer = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tmLookup = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lengthField = new javax.swing.JTextField();
        setLengthButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileViewer.setModel(new javax.swing.table.DefaultTableModel(
            file.getTMArray(),
            new String [] {
                "id", "Thai", "English"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fileViewer.getTableHeader().setReorderingAllowed(false);
        fileViewer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fileViewerFocusGained(evt);
            }
        });
        fileViewer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileViewerMouseClicked(evt);
            }
        });
        fileViewer.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fileViewerPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(fileViewer);

        tmLookup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Thai", "English"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tmLookup.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tmLookup);
        if (tmLookup.getColumnModel().getColumnCount() > 0) {
            tmLookup.getColumnModel().getColumn(0).setPreferredWidth(25);
            tmLookup.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lengthField.setText("4");
        lengthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lengthFieldActionPerformed(evt);
            }
        });

        setLengthButton.setText("Set");
        setLengthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setLengthButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(setLengthButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lengthField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(setLengthButton)
                            .addComponent(lengthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fileViewerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fileViewerFocusGained
        // TDO add your handling code here:
    }//GEN-LAST:event_fileViewerFocusGained

    private void fileViewerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileViewerMouseClicked
        /*
        Comparator3 c = new Comparator3(file.thai, corpus.thai, 5);
        Matches matches = c.getMatches();
        ArrayList<MatchEntry3> list = matches.matchList;
        
        TMFile matchesToDisplay = new TMFile(corpus.getSegmentArray(list.get(0).getIntArray()));
        /*for (MatchEntry3 m : list) {
            Object[][] segmentArray = corpus.getSegmentArray(m.getIntArray());
            matchesToDisplay.addTM(segmentArray);
        }
        
        
        for (Object[] o : matchesToDisplay.TMs) {
            System.out.println(Arrays.toString(o));
        }
        
        
        tmLookup.setModel(new javax.swing.table.DefaultTableModel(
            matchesToDisplay.getTMArray(),
            new String [] {
                "id", "Thai", "English"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
         */
    }//GEN-LAST:event_fileViewerMouseClicked

    private void fileViewerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fileViewerPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fileViewerPropertyChange

    private void setLengthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setLengthButtonActionPerformed
        String foo = lengthField.getText();
        minMatchLength = Integer.parseInt(foo);
    }//GEN-LAST:event_setLengthButtonActionPerformed

    private void lengthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lengthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lengthFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CAT1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CAT1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CAT1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CAT1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CAT1UI().setVisible(true);
            }
        });
    }
    
    public TMFile getMatches(String th) {
        Comparator c = new Comparator(th, corpus.getThai(), 4);
        ArrayList<MatchEntry3> list = c.getMatches().getMatchList();
        MatchEntry2 aba = new MatchEntry2("this", 3);
       
        
        TMFile matchesToDisplay = new TMFile();
        System.out.println("Matches are : " + list.toString());
        for (MatchEntry3 m : list) {
            Object[][] segmentArray = corpus.getSegmentArray(m.getIntArray());
            matchesToDisplay.addTM(segmentArray);
            System.out.println("\n\t*/*/*/* matchesToDisplay : " + matchesToDisplay + "\n");
        }
        return matchesToDisplay;
    }
    
    public void displayMatches(TMFile t) {
        tmLookup.setModel(new javax.swing.table.DefaultTableModel(
            t.getTMArray(),
            new String [] {
                "id", "Thai", "English"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable fileViewer;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lengthField;
    private javax.swing.JButton setLengthButton;
    private javax.swing.JTable tmLookup;
    // End of variables declaration//GEN-END:variables
}
