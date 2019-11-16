
package com.mycompany.mainui.myassignment;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatMiniBox extends javax.swing.JFrame {

    private Socket socketOfServer;
    private ServerMethodThread newServerMethodThread;
    private Client newClient;
    private String ipAddr,userName,myName;
    private int flag;
    private boolean isFirst = true;
    
    public ChatMiniBox() {
        initComponents();
    }
    
    public ChatMiniBox(int flag, String ipAddr, String userName, String myName) {
        initComponents();
        this.flag = flag;
        this.ipAddr = ipAddr;
        this.userName = userName;
        this.myName = myName;
        newClient = new Client(txtAreaShow, ipAddr,userName,myName);
        newClient.Connect();
        newClient.start();
        
        fileChooser.setVisible(false);
        lbName.setText(userName);
    }
    
    public ChatMiniBox(int flag, Socket socketOfServer, String userName) {
        initComponents();
        this.flag = flag;
        this.socketOfServer = socketOfServer;
        this.userName = userName;
        newServerMethodThread = new ServerMethodThread(socketOfServer,txtAreaShow,lbName);
        newServerMethodThread.ConnectServer();
        newServerMethodThread.start();
        
        //Set UI 
        fileChooser.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaShow = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        txtAreaInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbSendMsg = new javax.swing.JLabel();
        lbSendFile = new javax.swing.JLabel();
        lbSendIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(241, 246, 251));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        txtAreaShow.setEditable(false);
        txtAreaShow.setBackground(new java.awt.Color(241, 246, 251));
        txtAreaShow.setColumns(20);
        txtAreaShow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAreaShow.setLineWrap(true);
        txtAreaShow.setRows(5);
        txtAreaShow.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAreaShow);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 61, 360, 330));

        jPanel1.setBackground(new java.awt.Color(241, 246, 251));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAreaInput.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtAreaInput.setBorder(null);
        txtAreaInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAreaInputKeyPressed(evt);
            }
        });
        jPanel1.add(txtAreaInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 290, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your conversation with");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        lbName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setText("khaibui123");
        jPanel1.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, -1));

        lbSendMsg.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconSend4.png")); // NOI18N
        lbSendMsg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSendMsgMouseClicked(evt);
            }
        });
        jPanel1.add(lbSendMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        lbSendFile.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconSend3.png")); // NOI18N
        lbSendFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSendFileMouseClicked(evt);
            }
        });
        jPanel1.add(lbSendFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        lbSendIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconSend2.png")); // NOI18N
        jPanel1.add(lbSendIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbSendMsgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSendMsgMouseClicked
        // TODO add your handling code here:
        String str = txtAreaInput.getText().trim();
        if(flag==0){
            newClient.Send(str);
        } else{
            newServerMethodThread.SendServer(str);
        }
        txtAreaShow.append("Me: " + str + "\n");
        txtAreaInput.setText("");
    }//GEN-LAST:event_lbSendMsgMouseClicked

    private void lbSendFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSendFileMouseClicked
        // TODO add your handling code here:
        fileChooser.setVisible(true);
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        String fileName = file.getName();
        txtAreaShow.append("Me: " + fileName + "\n");
        FileReader fileReader;
        try {
            fileReader = new FileReader(file.getAbsolutePath());
            if(flag==0){
                    int ch = fileReader.read();
                    String sendText = String.format("%02d", fileName.length()) + fileName;
                    while (ch!=-1) {
                            sendText = sendText + String.valueOf((char)ch);
                            ch = fileReader.read();
                        }
                    newClient.SendFile(sendText);

                } else{
                    int ch = fileReader.read();
                    String sendText = String.format("%02d", fileName.length()) + fileName;
                    while (ch!=-1) {
                            sendText = sendText + String.valueOf((char)ch);
                            ch = fileReader.read();
                        }
                    newServerMethodThread.SendFileServer(sendText);
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChatBoxFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChatBoxFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbSendFileMouseClicked

    private void txtAreaInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaInputKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String str = txtAreaInput.getText().trim();
            if(flag==0){
                newClient.Send(str);
            } else{
                newServerMethodThread.SendServer(str);
            }
            txtAreaShow.append("Me: " + str + "\n");
            txtAreaInput.setText("");
        }
    }//GEN-LAST:event_txtAreaInputKeyPressed

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
            java.util.logging.Logger.getLogger(ChatMiniBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatMiniBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatMiniBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatMiniBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatMiniBox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbSendFile;
    private javax.swing.JLabel lbSendIcon;
    private javax.swing.JLabel lbSendMsg;
    private javax.swing.JTextField txtAreaInput;
    private javax.swing.JTextArea txtAreaShow;
    // End of variables declaration//GEN-END:variables
}
