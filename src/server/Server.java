/**
 *  
 *  
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import server.Logic;

/**
 * Server.java
 *
 * Feb 28, 2019
 * 
 */
public class Server {
	
	 public static void main(String[] args) throws IOException {
	        
	        Logic gl = new Logic();
	        
	        int portNumber = 8000;
	        
	        try (
	            ServerSocket serverSocket = new ServerSocket(portNumber);
	        		
	            Socket clientSocket = serverSocket.accept();     
	        		
	            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	        		
	            BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));

	        		
	        ) {
	        	boolean g = true;
	        	while(g == true) {
	        		try {
	        			
	        		}catch(Exception e) {
	        			e.getMessage();
	        		}
	        	}
	        	
	        	
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {
	            	try {
	            		out.println(gl.squareReturn(inputLine));
	            	} catch (NumberFormatException NF){
	            		out.println(gl.stringReverse(inputLine));
	            	}
	            	
	            	
	            }
	        } catch (IOException e) {
	            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
	            System.out.println(e.getMessage());
	        }
	    }

}
