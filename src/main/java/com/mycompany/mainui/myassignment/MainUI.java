package com.mycompany.mainui.myassignment;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class MainUI extends javax.swing.JFrame {

    private static final String IPv4_REGEX ="^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                                            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	private static final Pattern IPv4_PATTERN = Pattern.compile(IPv4_REGEX);
    
    public MainUI() {
        initComponents();
        SetUI();
    }
    
    public void SetUI(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            myIP.setText(String.valueOf(address));
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        LayoutPanel1 = new javax.swing.JPanel();
        mainIcon = new javax.swing.JLabel();
        mainTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        myIP = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbMore = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbName = new javax.swing.JTextField();
        lbServer = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\loginButton.png")); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        setResizable(false);

        LayoutPanel1.setBackground(new java.awt.Color(255, 255, 255));
        LayoutPanel1.setForeground(new java.awt.Color(255, 255, 255));
        LayoutPanel1.setPreferredSize(new java.awt.Dimension(350, 568));
        LayoutPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconFox.png")); // NOI18N
        LayoutPanel1.add(mainIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 137, -1, -1));

        mainTitle.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\title1.png")); // NOI18N
        LayoutPanel1.add(mainTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 218, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon1.png")); // NOI18N
        LayoutPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 35, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon2.png")); // NOI18N
        LayoutPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon5.png")); // NOI18N
        LayoutPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 47, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon6.png")); // NOI18N
        LayoutPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 87, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon7.png")); // NOI18N
        LayoutPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 118, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon8.png")); // NOI18N
        LayoutPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 0, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon9.png")); // NOI18N
        LayoutPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 0, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon10.png")); // NOI18N
        LayoutPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 87, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon11.png")); // NOI18N
        LayoutPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 11, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon12.png")); // NOI18N
        LayoutPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 90, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon13.png")); // NOI18N
        LayoutPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 35, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon14.png")); // NOI18N
        LayoutPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 47, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon15.png")); // NOI18N
        LayoutPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon16.png")); // NOI18N
        LayoutPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 44, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon17.png")); // NOI18N
        LayoutPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon18.png")); // NOI18N
        LayoutPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 52, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconTemp\\icon17.png")); // NOI18N
        LayoutPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 87, -1, -1));

        myIP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myIP.setForeground(new java.awt.Color(51, 51, 51));
        myIP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        LayoutPanel1.add(myIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 180, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Your IP");
        LayoutPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Username");
        LayoutPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Add new account user?");
        LayoutPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, -1));

        lbMore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMore.setForeground(new java.awt.Color(61, 74, 107));
        lbMore.setText("More");
        lbMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMoreMouseClicked(evt);
            }
        });
        LayoutPanel1.add(lbMore, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));
        LayoutPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 559, -1, -1));

        lbName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 51, 51));
        lbName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        LayoutPanel1.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 180, -1));

        lbServer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbServer.setForeground(new java.awt.Color(51, 51, 51));
        lbServer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        LayoutPanel1.add(lbServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 180, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Server IP");
        LayoutPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\join.png")); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        LayoutPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LayoutPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LayoutPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMoreMouseClicked
        // TODO add your handling code here:
        new MainUI().setVisible(true);
    }//GEN-LAST:event_lbMoreMouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        String myIp = myIP.getText().trim();
        String server = lbServer.getText().trim();
        String name = lbName.getText().trim();
        if(!IPv4_PATTERN.matcher(myIp).matches() || !IPv4_PATTERN.matcher(server).matches()){
            JOptionPane.showMessageDialog(this, "Your IP not valid.","Warning",JOptionPane.WARNING_MESSAGE);
        } else if(name.equals("")){
            JOptionPane.showMessageDialog(this, "Fill your username.","Warning",JOptionPane.WARNING_MESSAGE);
        } else{
            new ChatBoxFrame(myIP.getText().trim(), 0, lbName.getText().trim(),lbServer.getText().trim()).setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jLabel23MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LayoutPanel1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbMore;
    private javax.swing.JTextField lbName;
    private javax.swing.JTextField lbServer;
    private javax.swing.JLabel mainIcon;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JTextField myIP;
    // End of variables declaration//GEN-END:variables
}
