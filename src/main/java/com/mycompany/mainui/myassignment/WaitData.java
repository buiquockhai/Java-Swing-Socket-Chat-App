package com.mycompany.mainui.myassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JTextArea;

public class WaitData extends Thread{
    
    private Socket socketOfServer = null;
    private BufferedReader is;
    private BufferedWriter os;
    private Hashtable<String,String> hashtable, hashtableTemp;
    private Enumeration next;
    private String key, line, exitString;
    private JTextArea jTextArea;
    
    public WaitData(Socket socketOfServer, JTextArea jTextArea, Hashtable<String,String> hashtable){
        this.socketOfServer =socketOfServer;
        this.jTextArea = jTextArea;
        this.hashtable = hashtable;
    }
    
    public void run(){
        Connect();
        SaveMoreData(is);
        WaitUpdate();
    }
    
    public void Connect(){
        try {
            is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
        } catch (Exception e) {
        }
    }
    
    public void WaitUpdate(){
        while(true){
            try {
                SendData(os);
                while(true){
                    Receive();
                    SendData(os);
                   
                    sleep(1000);
                }
            } catch (Exception e) {
            }
        }
    }
    
    public void Receive(){
        Thread newThread = new Thread(){
            public void run(){
                try {
                    if((exitString = is.readLine()) != null){
                        String[] text = jTextArea.getText().split("\n");
                        String delUser = exitString.substring(4, exitString.length());
                        String del = String.format("%02d", exitString.length()-4) + delUser + hashtable.get(delUser);
                        jTextArea.setText("");
                        for(int i=0;i<text.length;i++){
                            if(text[i].equals(del)) continue;
                            jTextArea.append(text[i] + "\n");
                        }
                        hashtable.remove(delUser);
                        is.close();
                        os.close();
                        socketOfServer.close();
                    }
                } catch (Exception e) {
                    System.err.println("Loi tai is.readLine");
                }
            }
        };
        newThread.start();
    }
    
    public void SendData(BufferedWriter os){
        String str = "";
        next = hashtable.keys();
        while(next.hasMoreElements()){
            key = (String)next.nextElement();
            str = str + String.format("%02d", key.length()) + key + hashtable.get(key) + ",";
        }
        try {
            System.err.println("Sending: " + str);
            os.write(str);
            os.newLine();
            os.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public void SaveMoreData(BufferedReader is){
        try {
            line = is.readLine();
            jTextArea.append(line + "\n");
            String length = line.substring(0,2);
            String userName = line.substring(2,Integer.parseInt(length)+2);
            String ipAddr = line.substring(Integer.parseInt(length)+2,line.length());
            hashtable.put(userName, ipAddr);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
}
