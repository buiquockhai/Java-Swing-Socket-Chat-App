package com.mycompany.mainui.myassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ClientData extends Thread{
    
    private Socket socketOfClient = null;
    private BufferedReader is;
    private BufferedWriter os;
    private ArrayList<JPanel> arrayPanels;
    private ArrayList<JLabel> arrayName, arrayIp;
    private JLabel lbCount;
    private String serverHost, myName, line, length, userName, ipAddr, myIp, checkString;
    public Hashtable<String,String> connection;
    public JTextArea txtAreaIp, txtAreaName;
    
    
    
    public ClientData(String serverHost, String myName, String myIp, Hashtable<String,String> connection, JTextArea txtAreaIp, JTextArea txtAreaName, ArrayList<JPanel> arrayPanels, ArrayList<JLabel> arrayName, ArrayList<JLabel> arrayIp, JLabel lbCount){
        this.serverHost = serverHost;
        this.connection = connection;
        this.myName = myName;
        this.myIp = myIp;
        this.txtAreaIp = txtAreaIp;
        this.txtAreaName = txtAreaName;
        this.arrayPanels = arrayPanels;
        this.arrayIp = arrayIp;
        this.arrayName = arrayName;
        this.lbCount = lbCount;
    }
    
    public void run(){
        Connect();
        SendInformation(String.format("%02d", myName.length()) + myName + myIp);
        NewUpdateConnection();
    }
    
    public void Connect(){
        try {
            socketOfClient = new Socket(serverHost, 9998);
            is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            System.err.println("Client Data connect success");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public void NewUpdateConnection(){
        while(true){
            try {
                line = is.readLine();
                if(line != null && !line.equals("") && !line.equals(checkString)){
                    connection.clear();
                    txtAreaIp.setText("");
                    txtAreaName.setText("");
                    checkString = line;
                    // Line contain string character like: 02ab127.0.0.2
                    // Two character is length of username
                    // The next is username
                    // Finally is IP address
                    String[] subString = line.split(",");
                    for(int i=0;i<subString.length;i++){
                        System.err.println(subString[i]);
                        length = subString[i].substring(0,2);
                        userName = subString[i].substring(2,Integer.parseInt(length)+2);
                        ipAddr = subString[i].substring(Integer.parseInt(length)+2,subString[i].length());
                        connection.put(userName, ipAddr);
                        txtAreaIp.append(ipAddr + "\n");
                        txtAreaName.append(userName + "\n");
                    }
                    lbCount.setText(String.format("%02d", connection.size()));
                    SetRecommand(connection);
                }
            } catch (IOException e) {
                System.err.println("In ClientData");
            }
        }
    }
    
    public void SendInformation(String str){
        try {
            os.write(str);
            os.newLine();
            os.flush();
            System.err.println("Send my data success");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public void Close(){
        try {
            SendInformation("Exit" + myName);
            os.close();
            is.close();
            socketOfClient.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void SetRecommand(Hashtable<String,String> hashtable){
        String key;
        int size = hashtable.size();
        Enumeration next;
        next = hashtable.keys();
        if(size > 6) {
            // Turn on panel one
            key = (String)next.nextElement();
            arrayPanels.get(0).setVisible(true);
            arrayName.get(0).setText(key);
            arrayIp.get(0).setText(hashtable.get(key));
            // Turn on panel two
            key = (String)next.nextElement();
            arrayPanels.get(1).setVisible(true);
            arrayName.get(1).setText(key);
            arrayIp.get(1).setText(hashtable.get(key));
            // Turn on panel three
            key = (String)next.nextElement();
            arrayPanels.get(2).setVisible(true);
            arrayName.get(2).setText(key);
            arrayIp.get(2).setText(hashtable.get(key));
            // Turn on panel four
            key = (String)next.nextElement();
            arrayPanels.get(3).setVisible(true);
            arrayName.get(3).setText(key);
            arrayIp.get(3).setText(hashtable.get(key));
            // Turn on panel five
            key = (String)next.nextElement();
            arrayPanels.get(4).setVisible(true);
            arrayName.get(4).setText(key);
            arrayIp.get(4).setText(hashtable.get(key));
        } else{
            arrayPanels.get(0).setVisible(false);
            arrayPanels.get(1).setVisible(false);
            arrayPanels.get(2).setVisible(false);
            arrayPanels.get(3).setVisible(false);
            arrayPanels.get(4).setVisible(false);
            if(size >= 1){
                // Turn on panel one
                key = (String)next.nextElement();
                arrayPanels.get(0).setVisible(true);
                arrayName.get(0).setText(key);
                arrayIp.get(0).setText(hashtable.get(key));
            }
            if(size >= 2) {
                // Turn on panel two
                key = (String)next.nextElement();
                arrayPanels.get(1).setVisible(true);
                arrayName.get(1).setText(key);
                arrayIp.get(1).setText(hashtable.get(key));
            }
            if(size >= 3){
                // Turn on panel three
                key = (String)next.nextElement();
                arrayPanels.get(2).setVisible(true);
                arrayName.get(2).setText(key);
                arrayIp.get(2).setText(hashtable.get(key));
            }
            if(size >= 4){
                // Turn on panel four
                key = (String)next.nextElement();
                arrayPanels.get(3).setVisible(true);
                arrayName.get(3).setText(key);
                arrayIp.get(3).setText(hashtable.get(key));
            }
            if(size >= 5){
                // Turn on panel five
                key = (String)next.nextElement();
                arrayPanels.get(4).setVisible(true);
                arrayName.get(4).setText(key);
                arrayIp.get(4).setText(hashtable.get(key));
            }
        }
    }
    
    public String CheckSearch(String checkString){
        String[] ipArray = txtAreaIp.getText().split("\n");
        String[] nameArray = txtAreaName.getText().split("\n");
        String result;
        for(int i=0;i<ipArray.length;i++){
            if(checkString.equals(ipArray[i]) || checkString.equals(nameArray[i]))
                return ipArray[i] + "," + nameArray[i];
        }
        return "0";
    }
    
}
