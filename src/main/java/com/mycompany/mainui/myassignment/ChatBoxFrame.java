package com.mycompany.mainui.myassignment;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatBoxFrame extends javax.swing.JFrame {

    public static final String serverHost = "localhost";
    public Client newClient;
    public EchoServerThread newServerThread;
    public ClientData newClientData;
    
    public ChatBoxFrame() {
        initComponents();
    }
    
    private Hashtable<String,String> hashtable = new Hashtable<String, String>();
    private Hashtable<String,String> hashTemp = new Hashtable<String, String>();
    private String ipAddr;
    private String userName;
    private String ipAddrConnectTo;
    private String ipServer;
    private int flag;
    private ArrayList<JPanel> arrayPanels = new ArrayList<JPanel>();
    private ArrayList<JLabel> arrayName = new ArrayList<JLabel>();
    private ArrayList<JLabel> arrayIp = new ArrayList<JLabel>();
    
    public ChatBoxFrame(String ipAddr, int flag, String userName, String ipServer) {
        initComponents();
        CurrentTime();
        CountTime();
        
        this.ipAddr = ipAddr;
        this.flag = flag;
        this.userName = userName;
        this.ipServer = ipServer;
        
        SetUI();
        Data();
        
//        Create new ServerThread object
        newServerThread = new EchoServerThread(ipAddr,userName);
        newServerThread.start(); // Start for threading class

    }
    
    public void SetUI(){
        
        txtAreaNoti.append("Connection to server successful!\nWelcome to FoxChatBox!\n");
        
        pnlOne.setVisible(false);
        pnlTwo.setVisible(false);
        pnlThree.setVisible(false);
        pnlFour.setVisible(false);
        pnlFive.setVisible(false);
        
        arrayPanels.add(pnlOne);
        arrayPanels.add(pnlTwo);
        arrayPanels.add(pnlThree);
        arrayPanels.add(pnlFour);
        arrayPanels.add(pnlFive);
        
        arrayName.add(lbNameOne);
        arrayName.add(lbNameTwo);
        arrayName.add(lbNameThree);
        arrayName.add(lbNameFour);
        arrayName.add(lbNameFive);
        
        arrayIp.add(lbIpOne);
        arrayIp.add(lbIpTwo);
        arrayIp.add(lbIpThree);
        arrayIp.add(lbIpFour);
        arrayIp.add(lbIpFive);
        
        lbName.setText(userName);
        lbIP.setText(ipAddr);
    }
    
    public void Data(){
        Thread newThread = new Thread(){
            public void run(){
                try {
                    newClientData = new ClientData(ipServer, userName, ipAddr , hashtable, txtAreaIp, txtAreaName, arrayPanels, arrayName, arrayIp, lbPersonCount);
                    newClientData.start();
                    
                } catch (Exception e) {
                }
                
            }
        };
        newThread.start();
    }
 
    public void CountTime() {
        Thread count = new Thread(){
            public void run(){
                try {
                    int start = 0;
                    for(;;){
                        lbCountTime.setText(String.format("%02d", start));
                        start++;
                        sleep(60000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        count.start();
    }
    
    public void CurrentTime() {
        Thread clock = new Thread(){
            public void run(){
                try{
                    for(;;){
                        Calendar cal = new GregorianCalendar();
                        int min = cal.get(Calendar.MINUTE);
                        int hrs = cal.get(Calendar.HOUR);
                        int sec = cal.get(Calendar.SECOND);
                        lbTime.setText(String.format("%02d", hrs) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec));

                        int year = cal.get(Calendar.YEAR);
                        int month = cal.get(Calendar.MONTH);
                        int day = cal.get(Calendar.DATE);
                        lbDate.setText(new DateFormatSymbols().getMonths()[month].toString() + ", " + String.format("%02d", day) + ", " + year);
                        sleep(1000);
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        pnlBackground = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbTime = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbPersonCount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbCountTime = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbLogOut = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbAboutUs = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaIp = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbIP = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaName = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaNoti = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlOne = new javax.swing.JPanel();
        lbOne = new javax.swing.JLabel();
        lbNameOne = new javax.swing.JLabel();
        lbIpOne = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pnlTwo = new javax.swing.JPanel();
        lbTwo = new javax.swing.JLabel();
        lbNameTwo = new javax.swing.JLabel();
        lbIpTwo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlThree = new javax.swing.JPanel();
        lbThree = new javax.swing.JLabel();
        lbNameThree = new javax.swing.JLabel();
        lbIpThree = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnlFour = new javax.swing.JPanel();
        lbFour = new javax.swing.JLabel();
        lbNameFour = new javax.swing.JLabel();
        lbIpFour = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlFive = new javax.swing.JPanel();
        lbFive = new javax.swing.JLabel();
        lbNameFive = new javax.swing.JLabel();
        lbIpFive = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cnnTo = new javax.swing.JTextField();
        Search = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("frChat"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlBackground.setBackground(new java.awt.Color(241, 246, 251));
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(61, 74, 107));
        jPanel1.setPreferredSize(new java.awt.Dimension(140, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTime.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTime.setText("10:31:30");
        jPanel1.add(lbTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 140, -1));

        lbDate.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbDate.setForeground(new java.awt.Color(255, 255, 255));
        lbDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDate.setText("Octorber, 15, 2019");
        lbDate.setToolTipText("");
        lbDate.setAlignmentY(0.0F);
        jPanel1.add(lbDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 480, 140, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Party size");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        lbPersonCount.setFont(new java.awt.Font("Segoe UI Light", 0, 48)); // NOI18N
        lbPersonCount.setForeground(new java.awt.Color(255, 255, 255));
        lbPersonCount.setText("22");
        jPanel1.add(lbPersonCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("people");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 50, 20));

        jPanel4.setBackground(new java.awt.Color(72, 88, 128));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Online time");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 25, -1, -1));

        lbCountTime.setFont(new java.awt.Font("Segoe UI Light", 0, 48)); // NOI18N
        lbCountTime.setForeground(new java.awt.Color(255, 255, 255));
        lbCountTime.setText("38");
        jPanel4.add(lbCountTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("minutes");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 110, 60, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 140, 150));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconSetting.png")); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Change your account");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        lbLogOut.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbLogOut.setForeground(new java.awt.Color(255, 255, 255));
        lbLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogOut.setText("Log out ");
        lbLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogOutMouseClicked(evt);
            }
        });
        jPanel1.add(lbLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 60, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("__________");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        lbAboutUs.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbAboutUs.setForeground(new java.awt.Color(255, 255, 255));
        lbAboutUs.setText("About us   |");
        lbAboutUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAboutUsMouseClicked(evt);
            }
        });
        jPanel1.add(lbAboutUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        pnlBackground.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 140, 550));

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Notifications about your connection");
        pnlBackground.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 480, 30));

        lbName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 51, 51));
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setText("khaibui123");
        pnlBackground.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 490, 20));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAreaIp.setEditable(false);
        txtAreaIp.setBackground(new java.awt.Color(241, 246, 251));
        txtAreaIp.setColumns(20);
        txtAreaIp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAreaIp.setForeground(new java.awt.Color(51, 51, 51));
        txtAreaIp.setRows(5);
        jScrollPane1.setViewportView(txtAreaIp);

        pnlBackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 120, 340));

        jLabel17.setBackground(new java.awt.Color(158, 158, 158));
        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\ip.png")); // NOI18N
        jLabel17.setText("IP Address");
        pnlBackground.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 120, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("with IP address");
        pnlBackground.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 490, 30));

        lbIP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbIP.setForeground(new java.awt.Color(51, 51, 51));
        lbIP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIP.setText("169.254.53.183");
        pnlBackground.add(lbIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 490, 20));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAreaName.setEditable(false);
        txtAreaName.setBackground(new java.awt.Color(241, 246, 251));
        txtAreaName.setColumns(20);
        txtAreaName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAreaName.setForeground(new java.awt.Color(51, 51, 51));
        txtAreaName.setRows(5);
        jScrollPane2.setViewportView(txtAreaName);

        pnlBackground.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 160, 340));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\user.png")); // NOI18N
        jLabel10.setText("Username");
        pnlBackground.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 160, -1));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtAreaNoti.setEditable(false);
        txtAreaNoti.setBackground(new java.awt.Color(241, 246, 251));
        txtAreaNoti.setColumns(20);
        txtAreaNoti.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtAreaNoti.setForeground(new java.awt.Color(51, 51, 51));
        txtAreaNoti.setLineWrap(true);
        txtAreaNoti.setRows(5);
        txtAreaNoti.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtAreaNoti);

        pnlBackground.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 160, 340));

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\noti.png")); // NOI18N
        pnlBackground.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\iconFoxBig.png")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        pnlOne.setBackground(new java.awt.Color(241, 246, 251));
        pnlOne.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbOneMouseClicked(evt);
            }
        });
        pnlOne.add(lbOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 50));

        lbNameOne.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNameOne.setForeground(new java.awt.Color(51, 51, 51));
        lbNameOne.setText("Johny");
        pnlOne.add(lbNameOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 4, 90, 20));

        lbIpOne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbIpOne.setForeground(new java.awt.Color(51, 51, 51));
        lbIpOne.setText("127.0.0.1");
        pnlOne.add(lbIpOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 90, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\next2.png")); // NOI18N
        pnlOne.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, 50));

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\avatar.png")); // NOI18N
        pnlOne.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(pnlOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 220, 50));

        pnlTwo.setBackground(new java.awt.Color(255, 255, 255));
        pnlTwo.setPreferredSize(new java.awt.Dimension(220, 50));
        pnlTwo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTwoMouseClicked(evt);
            }
        });
        pnlTwo.add(lbTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 50));

        lbNameTwo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNameTwo.setForeground(new java.awt.Color(51, 51, 51));
        lbNameTwo.setText("Mariana");
        pnlTwo.add(lbNameTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 30));

        lbIpTwo.setForeground(new java.awt.Color(51, 51, 51));
        lbIpTwo.setText("127.0.0.2");
        pnlTwo.add(lbIpTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 24, 100, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\next2.png")); // NOI18N
        pnlTwo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 2, -1, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\avatar.png")); // NOI18N
        pnlTwo.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jPanel2.add(pnlTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 220, 50));

        pnlThree.setBackground(new java.awt.Color(241, 246, 251));
        pnlThree.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbThree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbThreeMouseClicked(evt);
            }
        });
        pnlThree.add(lbThree, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 50));

        lbNameThree.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNameThree.setForeground(new java.awt.Color(51, 51, 51));
        lbNameThree.setText("Chris Evan");
        pnlThree.add(lbNameThree, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 4, 100, 20));

        lbIpThree.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbIpThree.setForeground(new java.awt.Color(51, 51, 51));
        lbIpThree.setText("127.0.0.3");
        pnlThree.add(lbIpThree, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 26, 100, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\next2.png")); // NOI18N
        pnlThree.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\avatar.png")); // NOI18N
        pnlThree.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jPanel2.add(pnlThree, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 220, 50));

        pnlFour.setBackground(new java.awt.Color(255, 255, 255));
        pnlFour.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbFour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFourMouseClicked(evt);
            }
        });
        pnlFour.add(lbFour, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 50));

        lbNameFour.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNameFour.setForeground(new java.awt.Color(51, 51, 51));
        lbNameFour.setText("Liam Hemswoth");
        pnlFour.add(lbNameFour, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 4, 110, 20));

        lbIpFour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbIpFour.setForeground(new java.awt.Color(51, 51, 51));
        lbIpFour.setText("127.0.0.4");
        pnlFour.add(lbIpFour, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 14, 110, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\next2.png")); // NOI18N
        pnlFour.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\avatar.png")); // NOI18N
        pnlFour.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jPanel2.add(pnlFour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 220, 50));

        pnlFive.setBackground(new java.awt.Color(241, 246, 251));
        pnlFive.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbFive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFiveMouseClicked(evt);
            }
        });
        pnlFive.add(lbFive, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 50));

        lbNameFive.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNameFive.setForeground(new java.awt.Color(51, 51, 51));
        lbNameFive.setText("Michale Jackson");
        pnlFive.add(lbNameFive, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 120, 30));

        lbIpFive.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbIpFive.setForeground(new java.awt.Color(51, 51, 51));
        lbIpFive.setText("127.0.0.5");
        pnlFive.add(lbIpFive, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 14, 110, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\next2.png")); // NOI18N
        pnlFive.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\avatar.png")); // NOI18N
        pnlFive.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jPanel2.add(pnlFive, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 220, 50));

        cnnTo.setBackground(new java.awt.Color(241, 246, 251));
        cnnTo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cnnTo.setToolTipText("");
        cnnTo.setBorder(null);
        cnnTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnnToActionPerformed(evt);
            }
        });
        cnnTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cnnToKeyPressed(evt);
            }
        });
        jPanel2.add(cnnTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, 30));

        Search.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\MainUI\\src\\main\\java\\Image\\search.png")); // NOI18N
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });
        jPanel2.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 50, -1));

        pnlBackground.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbAboutUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAboutUsMouseClicked
        // TODO add your handling code here:
        new AboutFrame().setVisible(true);
    }//GEN-LAST:event_lbAboutUsMouseClicked

    private void lbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseClicked
        // TODO add your handling code here:
        newClient.Close();
    }//GEN-LAST:event_lbLogOutMouseClicked

    private void cnnToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnnToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnnToActionPerformed

    private void lbOneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOneMouseClicked
        // TODO add your handling code here:
        ChatMiniBox newChat = new ChatMiniBox(0,lbIpOne.getText().trim(),lbNameOne.getText().trim(),userName);
        txtAreaNoti.append("Connection to " + lbNameOne.getText().trim() + " successful.\n");
        txtAreaNoti.append("Join your conversation.\n");
        newChat.setVisible(true);
    }//GEN-LAST:event_lbOneMouseClicked

    private void lbTwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTwoMouseClicked
        // TODO add your handling code here:
        ChatMiniBox newChat = new ChatMiniBox(0,lbIpTwo.getText().trim(),lbNameTwo.getText().trim(),userName);
        txtAreaNoti.append("Connection to " + lbNameTwo.getText().trim() + " successful.\n");
        txtAreaNoti.append("Join your conversation.\n");
        newChat.setVisible(true);
    }//GEN-LAST:event_lbTwoMouseClicked

    private void lbThreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThreeMouseClicked
        // TODO add your handling code here:
        ChatMiniBox newChat = new ChatMiniBox(0,lbIpThree.getText().trim(),lbNameThree.getText().trim(),userName);
        txtAreaNoti.append("Connection to " + lbNameThree.getText().trim() + " successful.\n");
        txtAreaNoti.append("Join your conversation.\n");
        newChat.setVisible(true);
    }//GEN-LAST:event_lbThreeMouseClicked

    private void lbFourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFourMouseClicked
        // TODO add your handling code here:
        ChatMiniBox newChat = new ChatMiniBox(0,lbIpFour.getText().trim(),lbNameFour.getText().trim(),userName);
        txtAreaNoti.append("Connection to " + lbNameFour.getText().trim() + " successful.\n");
        txtAreaNoti.append("Join your conversation.\n");
        newChat.setVisible(true);
    }//GEN-LAST:event_lbFourMouseClicked

    private void lbFiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFiveMouseClicked
        // TODO add your handling code here:
        ChatMiniBox newChat = new ChatMiniBox(0,lbIpFive.getText().trim(),lbNameFive.getText().trim(),userName);
        txtAreaNoti.append("Connection to " + lbNameFive.getText().trim() + " successful.\n");
        txtAreaNoti.append("Join your conversation.\n");
        newChat.setVisible(true);
    }//GEN-LAST:event_lbFiveMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.err.println("Close");
        newClientData.Close();
    }//GEN-LAST:event_formWindowClosing

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        // TODO add your handling code here:
        String checkString = newClientData.CheckSearch(cnnTo.getText().trim());
        if(!checkString.equals("0")){
            String[] arrayStrings = checkString.split(",");
            ChatMiniBox newChat = new ChatMiniBox(0,arrayStrings[0],arrayStrings[1],userName);
            txtAreaNoti.append("Connection to " + arrayStrings[1] + " successful.\n");
            txtAreaNoti.append("Join your conversation.\n");
            cnnTo.setText("");
            newChat.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(this, "Your friend not online.","Warning",JOptionPane.WARNING_MESSAGE);
            txtAreaNoti.append("Connection is failed.\n");
            txtAreaNoti.append("Please try again in other time.\n");
        }
    }//GEN-LAST:event_SearchMouseClicked

    private void cnnToKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnnToKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String checkString = newClientData.CheckSearch(cnnTo.getText().trim());
            if(!checkString.equals("0")){
                String[] arrayStrings = checkString.split(",");
                ChatMiniBox newChat = new ChatMiniBox(0,arrayStrings[0],arrayStrings[1],userName);
                txtAreaNoti.append("Connection to " + arrayStrings[1] + " successful.\n");
                txtAreaNoti.append("Join your conversation.\n");
                cnnTo.setText("");
                newChat.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(this, "Your friend not online.","Warning",JOptionPane.WARNING_MESSAGE);
                txtAreaNoti.append("Connection is failed.\n");
                txtAreaNoti.append("Please try again in other time.\n");
            }
        }
    }//GEN-LAST:event_cnnToKeyPressed

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
            java.util.logging.Logger.getLogger(ChatBoxFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatBoxFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatBoxFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatBoxFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatBoxFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Search;
    private javax.swing.JTextField cnnTo;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAboutUs;
    private javax.swing.JLabel lbCountTime;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbFive;
    private javax.swing.JLabel lbFour;
    private javax.swing.JLabel lbIP;
    private javax.swing.JLabel lbIpFive;
    private javax.swing.JLabel lbIpFour;
    private javax.swing.JLabel lbIpOne;
    private javax.swing.JLabel lbIpThree;
    private javax.swing.JLabel lbIpTwo;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNameFive;
    private javax.swing.JLabel lbNameFour;
    private javax.swing.JLabel lbNameOne;
    private javax.swing.JLabel lbNameThree;
    private javax.swing.JLabel lbNameTwo;
    private javax.swing.JLabel lbOne;
    private javax.swing.JLabel lbPersonCount;
    private javax.swing.JLabel lbThree;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbTwo;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlFive;
    private javax.swing.JPanel pnlFour;
    private javax.swing.JPanel pnlOne;
    private javax.swing.JPanel pnlThree;
    private javax.swing.JPanel pnlTwo;
    private javax.swing.JTextArea txtAreaIp;
    private javax.swing.JTextArea txtAreaName;
    private javax.swing.JTextArea txtAreaNoti;
    // End of variables declaration//GEN-END:variables
}
