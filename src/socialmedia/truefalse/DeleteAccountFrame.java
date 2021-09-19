/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmedia.truefalse;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DeleteAccountFrame extends javax.swing.JFrame {

    /**
     * Creates new form DeleteAccountFrame
     */
    public DeleteAccountFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Are You Sure About Deleting Your Account ?");

        jButton1.setText("Yes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "DELETE FROM user WHERE username=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, LogInFrame.UN);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "The Account Has Been Deleted !");
            LogInFrame lf = new LogInFrame();
            lf.show();
            this.hide();

            connect.close();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "DELETE FROM post WHERE username=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, LogInFrame.UN);
            ps.executeUpdate();

            connect.close();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "DELETE FROM follow WHERE username1=? OR username2=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, LogInFrame.UN);
            ps.setString(2, LogInFrame.UN);
            ps.executeUpdate();

            connect.close();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "DELETE FROM follow WHERE username1=? OR username2=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, LogInFrame.UN);
            ps.setString(2, LogInFrame.UN);
            ps.executeUpdate();

            connect.close();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "DELETE FROM privatemessage WHERE username1=? OR username2=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, LogInFrame.UN);
            ps.setString(2, LogInFrame.UN);
            ps.executeUpdate();
            
            connect.close();
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteAccountFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
