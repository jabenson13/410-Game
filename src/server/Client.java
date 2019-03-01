/**
 *  
 *  
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * CLient.java
 *
 * Feb 28, 2019
 * 
 */
public class Client {
	
	public static void main(String[] args) throws IOException {
        
		System.out.println(Inet4Address.getLocalHost().getHostAddress());  

        String hostName = "127.0.0.1";
        int portNumber = 8000;

        try (
            Socket echoSocket = new Socket(hostName, portNumber);
        		
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        		
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        		
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        } 
    }

}
