package passwdserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NewRequest {
    private ServerSocket srvSock;
    private Socket clientSock;
    private InputStream inputStream;
    private BufferedReader reader;
    private PrintWriter writer;
    
    public  NewRequest(int Port) {
        
        try{
            this.srvSock = new ServerSocket(Port);
            this.clientSock = srvSock.accept();
        } catch (Exception e) {
            System.out.println("ERROR CREATING SOCKETS:\t" + e);
        }
        
        try{
            reader = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
        } catch(Exception e) {
            System.out.println("ERROR CREATING BUFFERED READER:\t" + e);
        }
        
        try{
            writer = new PrintWriter(clientSock.getOutputStream(), true);
        } catch(Exception e) {
            System.out.println("ERROR CREATING PRINT WRITER:\t" + e);
        }
        
        
        String readLine;
        try{
            while ((readLine = reader.readLine()) != null) {
                
                if(!clientSock.isConnected()){
                    clientSock.close();
                }
                
                //add crazy complicated encrypted password checker
            }
        } catch(Exception e) {
            System.out.println("ERROR WHILE READING FROM CLIENT:\t" + e);
        }
        
    }
}
