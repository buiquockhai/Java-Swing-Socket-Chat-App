
package com.mycompany.mainui.myassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ServerMethodThread extends Thread{
    
    private Socket socketOfServer;
    private BufferedReader is;
    private BufferedWriter os;
    private String line, hisName;
    private Boolean checkFlag =true;
    private JTextArea txtAreaShow;
    private JLabel lbName;
    
    public ServerMethodThread(Socket socketOfServer,JTextArea txtAreaShow, JLabel lbName){
        this.socketOfServer = socketOfServer;
        this.txtAreaShow = txtAreaShow;
        this.lbName = lbName;
    }
    
    public void run(){
        RecieveServer(txtAreaShow);
    }
    
    public void ConnectServer(){
        try {
            is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
 
    public void RecieveServer(JTextArea jTextArea){
        while (true) {            
            try {
                //Get two byte for check type
                String check = String.valueOf((char)is.read());
                check = check + String.valueOf((char)is.read());
                
                if(check.equals("<?")){
                    line = is.readLine();
                    if(checkFlag){
                        hisName = line;
                        lbName.setText(hisName);
                        checkFlag = false;
                        continue;
                    }
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
                    
                    jTextArea.append(hisName + ": " + fileName+  "\n");
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
    
    public void SendServer(String str){
        str = "<?" + str;
        try {
            os.write(str);
            os.newLine();
            os.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public void SendFileServer(String str){
        str = "cd" + str;
        try {
            os.write(str);
            os.newLine();
            os.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
}
