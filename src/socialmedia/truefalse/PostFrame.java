/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmedia.truefalse;

import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PostFrame extends javax.swing.JFrame {

    /**
     * Creates new form PostFrame
     */
    static String Pusername;
    static String Ppost;
    static String Pdate;

    public PostFrame(String Uname, String post, String date) {
        initComponents();

        Pusername = Uname;
        Ppost = post;
        Pdate = date;
        lbl_date.setText(date);
        txt_text.setText(post);
        Integer commentNumber = 0;
        Integer likeNumber = 0;

        // Display Comment and Comment Number
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "SELECT username1,comment FROM comment WHERE username2=? AND post=? AND date=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Pusername);
            ps.setString(2, Ppost);
            ps.setString(3, Pdate);
            ResultSet rs = ps.executeQuery();

            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }

            while (rs.next()) {
                commentNumber++;
                lbl_comment.setText(commentNumber.toString());
                ((DefaultTableModel) table.getModel()).addRow(new Object[]{rs.getString("username1"), rs.getString("comment")});
            }

            connect.close();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

        // Like Number
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "SELECT * FROM likepost WHERE username2=? AND post=? AND date=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Pusername);
            ps.setString(2, Ppost);
            ps.setString(3, Pdate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                likeNumber++;
                lbl_likes.setText(likeNumber.toString());
            }

            connect.close();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

        // Display Image
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "SELECT * FROM post WHERE username=? AND txt=? AND date=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, Pusername);
            ps.setString(2, Ppost);
            ps.setString(3, Pdate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                InputStream getImage = rs.getBinaryStream("pic");
                BufferedImage im = ImageIO.read(getImage);
                Image scaleImage = im.getScaledInstance(lbl_pic.getWidth(), lbl_pic.getHeight(), 0);
                ImageIcon icon = new ImageIcon(scaleImage);
                lbl_pic.setIcon(icon);

            }

            connect.close();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

        // Check Like
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "SELECT * FROM likepost WHERE username1=? AND username2=? AND post=? AND date=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, LogInFrame.UN);
            ps.setString(2, Pusername);
            ps.setString(3, Ppost);
            ps.setString(4, Pdate);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                btn_like.setSelected(true);
            } else {
                btn_like.setSelected(false);
            }

            connect.close();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_text = new javax.swing.JTextPane();
        lbl_pic = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_likes = new javax.swing.JLabel();
        txt_comment = new javax.swing.JTextField();
        btn_send = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_comment = new javax.swing.JLabel();
        btn_like = new javax.swing.JToggleButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setTitle("Posts");

        txt_text.setEnabled(false);
        jScrollPane2.setViewportView(txt_text);

        lbl_pic.setPreferredSize(new java.awt.Dimension(458, 208));

        lbl_date.setText("jLabel2");

        jLabel3.setText("Likes");

        lbl_likes.setText("0");

        btn_send.setText("Send");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Text"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setText("Comments     :");

        lbl_comment.setText("0");

        btn_like.setText("Like");
        btn_like.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_likeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_send))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_like)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(lbl_likes))
                            .addComponent(txt_comment)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_date)
                        .addGap(512, 512, 512))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbl_comment)
                .addGap(479, 479, 479))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_date)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_pic, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_likes)
                    .addComponent(btn_like))
                .addGap(18, 18, 18)
                .addComponent(btn_send, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_comment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
            String sql = "INSERT INTO comment(username1,username2,post,date,comment) VALUES(?,?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, LogInFrame.UN);
            ps.setString(2, Pusername);
            ps.setString(3, Ppost);
            ps.setString(4, Pdate);
            ps.setString(5, txt_comment.getText());
            ps.executeUpdate();

            PostFrame pf = new PostFrame(Pusername, Ppost, Pdate);
            pf.show();
            this.hide();
            
            connect.close();
            ps.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_sendActionPerformed

    private void btn_likeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_likeActionPerformed
        // TODO add your handling code here:
        if (btn_like.isSelected()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
                String sql = "INSERT INTO likepost VALUES(?,?,?,?)";
                PreparedStatement ps = connect.prepareStatement(sql);
                ps.setString(1, LogInFrame.UN);
                ps.setString(2, Pusername);
                ps.setString(3, Ppost);
                ps.setString(4, Pdate);
                ps.executeUpdate();

                PostFrame pf = new PostFrame(Pusername, Ppost, Pdate);
                pf.show();
                this.hide();
                
                connect.close();
                ps.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia?user=root");
                String sql = "Delete FROM likepost WHERE username1=? AND username2=? AND post=? AND date=?";
                PreparedStatement ps = connect.prepareStatement(sql);
                ps.setString(1, LogInFrame.UN);
                ps.setString(2, Pusername);
                ps.setString(3, Ppost);
                ps.setString(4, Pdate);
                ps.executeUpdate();

                PostFrame pf = new PostFrame(Pusername, Ppost, Pdate);
                pf.show();
                this.hide();

                connect.close();
                ps.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_likeActionPerformed

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
            java.util.logging.Logger.getLogger(PostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostFrame(Pusername, Ppost, Pdate).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_like;
    private javax.swing.JButton btn_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_comment;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_likes;
    private javax.swing.JLabel lbl_pic;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_comment;
    private javax.swing.JTextPane txt_text;
    // End of variables declaration//GEN-END:variables
}
