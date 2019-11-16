
package com.mycompany.mainui.myassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.swing.JTextArea;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;

public class Client extends Thread{
    
    private JTextArea jTextArea;
    private String serverHost;
    private Socket socketOfClient = null;
    private BufferedWriter os = null;
    private BufferedReader is = null;
    private String line, hisName, myName;
    
    public Client(JTextArea jTextArea,String serverHost, String hisName, String myName){
        this.jTextArea = jTextArea;
        this.serverHost = serverHost;
        this.hisName = hisName;
        this.myName = myName;
    }
    
    public void run(){
//        Connect();
        Send(myName);
        Recieve(jTextArea);
    }
    
    public void Connect(){
        try {
        socketOfClient = new Socket(serverHost,9999);
        os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
        is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
        
        } catch (IOException e) {
            System.err.println(e);
            return;
        }
    }
    
    public void Recieve(JTextArea jTextArea){
        while (true) {            
            try {
                //Get two byte for check type
                String check = String.valueOf((char)is.read());
                check = check + String.valueOf((char)is.read());
                
                if(check.equals("<?")){
                    line = is.readLine();
                    jTextArea.append(hisName + ": " + line + "\n");
                } else{
                    //Get name
                    String getLength = String.valueOf((char)is.read());
                    getLength = getLength + String.valueOf((char)is.read());

                    int length = Integer.parseInt(getLength);
                    String fileName = "";

                    for(int i=1;i<=length;i++){
                        fileName = fileName + String.valueOf((char)is.read());
                    }
                    
                    jTextArea.append(hisName + ": " +  fileName+  "\n");
                    Path currentPath = Paths.get("");

                    Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currentPath.toAbsolutePath().toString() + "\\" + fileName),"utf-8"));

                    line = is.readLine();
                    if(line!=null){
                        writer.write(line);
                        writer.flush();
                    }
                    while((line = is.readLine()) != null){
                        writer.write("\n" + line);
                        writer.flush();
                    }
                    writer.close();
                }


            } catch (IOException e) {
                System.err.println(e);
                e.printStackTrace();
            }
        }
    }
    
    public void Send(String str){
        str = "<?" + str;
        try {
            os.write(str);
            os.newLine();
            os.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public void SendFile(String str){
        str = "cd" + str;
        try {
            os.write(str);
            os.newLine();
            os.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public void Close(){
        try {
            os.close();
            is.close();
            socketOfClient.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
