/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cignx
 */
public class ViewWorkoutsPage extends javax.swing.JFrame {

    /**
     * Creates new form ViewWorkoutsPage
     */
    public ViewWorkoutsPage() {
        initComponents();
        typeComboBox.removeAllItems();
        typeComboBox.addItem("");
        typeComboBox.addItem("Chest");
        typeComboBox.addItem("Legs");
        typeComboBox.addItem("Biceps");
        typeComboBox.addItem("Back");
        typeComboBox.addItem("Abs");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_headerView = new javax.swing.JLabel();
        label_name = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        label_type = new javax.swing.JLabel();
        label_duration = new javax.swing.JLabel();
        tf_searchName = new javax.swing.JTextField();
        tf_searchDate1 = new javax.swing.JTextField();
        typeComboBox = new javax.swing.JComboBox<>();
        tf_searchDuration1 = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        tf_searchDate2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tf_searchDuration2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        IncorrectLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_headerView.setText("Search Criteria");

        label_name.setText("Name:");

        label_date.setText("Date Range (yyyy-mm-dd):");

        label_type.setText("Workout Type:");

        label_duration.setText("Duration Range:");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });

        search_button.setText("Search");
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("-");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("-");

        IncorrectLabel.setForeground(new java.awt.Color(255, 0, 0));
        IncorrectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IncorrectLabel.setText("   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_duration)
                    .addComponent(label_type)
                    .addComponent(label_date)
                    .addComponent(label_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tf_searchName)
                        .addComponent(typeComboBox, 0, 201, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_searchDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_searchDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_searchDuration1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(tf_searchDuration2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_headerView)
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(search_button)
                        .addGap(18, 18, 18)
                        .addComponent(cancel_button)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(IncorrectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(label_headerView)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_name)
                    .addComponent(tf_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_date)
                    .addComponent(tf_searchDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tf_searchDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_type)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_duration)
                    .addComponent(tf_searchDuration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_searchDuration2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(IncorrectLabel)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_button)
                    .addComponent(cancel_button))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // perform a search of the DB with the values indicated in the fields
    //  - a blank field indicates to not search with that parameter
    //  - will lead to a results page with desired info
    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        
        // TODO: consolidate data, form query from data
        //          then pass query to result page (run query from there)
        List<Workout> workouts=null;
        WorkoutSearch w = new WorkoutSearch();
        
        try{
            if(!tf_searchDuration1.getText().trim().isEmpty()){               
                if(!tf_searchDuration2.getText().trim().isEmpty()){
                    w.byDuration(Integer.parseInt(tf_searchDuration1.getText().trim()),Integer.parseInt(tf_searchDuration2.getText().trim()));                       
                }else{
                    w.byDuration(Integer.parseInt(tf_searchDuration1.getText().trim()));   
                }

            }
            if(!tf_searchName.getText().trim().isEmpty()){
                w.byName(tf_searchName.getText().trim());
            }
            if(!tf_searchDate1.getText().trim().isEmpty()){
                if(!tf_searchDate2.getText().trim().isEmpty()){
                     w.byDate(tf_searchDate1.getText().trim(),tf_searchDate2.getText().trim());
                }else{
                    w.byDate(tf_searchDate1.getText().trim());
                }
            }
            if(typeComboBox.getSelectedIndex()!=0){
                w.byType((String)typeComboBox.getSelectedItem());
            }
            w.searchAllUsers(true);
            workouts=w.getWorkouts();
            if(workouts.size()==0){
                IncorrectLabel.setText("No Results For Search Query");
            }else{
                new ResultPage(workouts).setVisible(true);
                this.dispose();
            }             

        }catch(NumberFormatException e){
            IncorrectLabel.setText("Duration must be numbers");

        }
        
        
    }//GEN-LAST:event_search_buttonActionPerformed

    // return to main page without searching DB
    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        this.dispose();
        
        // TODO: change this to setting global main page back to visible
        Main.main_runner.setVisible(true);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(ViewWorkoutsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewWorkoutsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewWorkoutsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewWorkoutsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewWorkoutsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IncorrectLabel;
    private javax.swing.JButton cancel_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_duration;
    private javax.swing.JLabel label_headerView;
    private javax.swing.JLabel label_name;
    private javax.swing.JLabel label_type;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField tf_searchDate1;
    private javax.swing.JTextField tf_searchDate2;
    private javax.swing.JTextField tf_searchDuration1;
    private javax.swing.JTextField tf_searchDuration2;
    private javax.swing.JTextField tf_searchName;
    private javax.swing.JComboBox<String> typeComboBox;
    // End of variables declaration//GEN-END:variables
}
