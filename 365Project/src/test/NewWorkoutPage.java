/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


/**
 *
 * @author cignx
 */
public class NewWorkoutPage extends javax.swing.JFrame {

    /**
     * Creates new form NewWorkoutPage
     */
    public NewWorkoutPage() {
        initComponents();
        setLocationRelativeTo(null);
        
        typeComboBox.removeAllItems();
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

        jSeparator1 = new javax.swing.JSeparator();
        label_headerNew = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        label_type = new javax.swing.JLabel();
        label_duration = new javax.swing.JLabel();
        DateTextField = new javax.swing.JTextField();
        typeComboBox = new javax.swing.JComboBox<>();
        DurationTextField = new javax.swing.JTextField();
        submit_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        IncorrectLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_headerNew.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        label_headerNew.setText("New Workout");

        label_date.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        label_date.setText("Date (yyyy-mm-dd):");

        label_type.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        label_type.setText("Type:");

        label_duration.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        label_duration.setText("Duration (minutes):");

        DateTextField.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N

        typeComboBox.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });

        DurationTextField.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N

        submit_button.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        cancel_button.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        IncorrectLabel.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        IncorrectLabel.setForeground(new java.awt.Color(255, 0, 0));
        IncorrectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IncorrectLabel.setText("   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submit_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancel_button))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_date)
                            .addComponent(label_type)
                            .addComponent(label_duration))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateTextField)
                            .addComponent(DurationTextField)
                            .addComponent(typeComboBox, 0, 350, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label_headerNew)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(IncorrectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(label_headerNew)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_date)
                    .addComponent(DateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_type)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_duration)
                    .addComponent(DurationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(IncorrectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_button)
                    .addComponent(submit_button))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // return to main page with no changes to DB
    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        this.dispose();
        
        // TODO: change this to setting global main page back to visible
        Main.main_runner.setVisible(true);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    // return to main page?
    // or go to a results page of all workouts with same 'name' value?
    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
        try{
            if(DateTextField.getText().trim().isEmpty()){
                IncorrectLabel.setText("Must Have Date");
            }else if(DurationTextField.getText().trim().isEmpty()){
                IncorrectLabel.setText("Must Have Duration");
            }else{
                try{
                    if(!Queries.insertWorkout((String)typeComboBox.getSelectedItem(), DateTextField.getText().trim(), Integer.parseInt(DurationTextField.getText().trim()))){
                        IncorrectLabel.setText("Incorrect Date");
                    }else {
                        Main.main_runner = new MainPage();
                        Main.main_runner.setVisible(true);
                        this.dispose();
                    }
                }catch(NumberFormatException e){
                    IncorrectLabel.setText("Duration must be a number");
                }
            }
        }catch (Exception e){
            IncorrectLabel.setText("Error inserting new workout");
        }
        
        // TODO: create query using only 'name' field
        // open new results page and pass query to it
        // sort results by most recent date first
        
    }//GEN-LAST:event_submit_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(NewWorkoutPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewWorkoutPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewWorkoutPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewWorkoutPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewWorkoutPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateTextField;
    private javax.swing.JTextField DurationTextField;
    private javax.swing.JLabel IncorrectLabel;
    private javax.swing.JButton cancel_button;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_duration;
    private javax.swing.JLabel label_headerNew;
    private javax.swing.JLabel label_type;
    private javax.swing.JButton submit_button;
    private javax.swing.JComboBox<String> typeComboBox;
    // End of variables declaration//GEN-END:variables
}
