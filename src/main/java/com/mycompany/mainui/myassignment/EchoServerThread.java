
package com.mycompany.mainui.myassignment;
import java.io.*;
import java.net.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.swing.JTextArea;

class EchoServerThread extends Thread{
    
    private String ipAddr,userName;
    private ServerSocket listener = null;
    private Socket socketOfServer = null;
    
    public EchoServerThread(String ipAddr, String userName){
        this.ipAddr = ipAddr;
        this.userName = userName;
    }
    
    public void run(){
        SetServer(ipAddr);
    }
    
    public void SetServer(String ipString){
        try {
            InetAddress addr = InetAddress.getByName(ipString);
            listener = new ServerSocket(9999, 50, addr);
            while (true) {                
                socketOfServer = listener.accept();
                Thread newThread = new Thread(){
                    public void run(){
                        ChatMiniBox newServer = new ChatMiniBox(1, socketOfServer,userName);
                        newServer.setVisible(true);
                    }
                };
                newThread.start();
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}