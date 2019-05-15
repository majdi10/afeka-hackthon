package yalla;
/**  TCP Server
 * Code is taken from Computer Networking: A Top-Down Approach Featuring 
 * the Internet, second edition, copyright 1996-2002 J.F Kurose and K.W. Ross, 
 * All Rights Reserved.
 **/

import java.io.*; 
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane; 

class TCPServer { 
    
    public static void main(String argv[]) throws Exception 
    { 
	String clientSentence; 
	String capitalizedSentence; 
	
	Connection connectionRecieved = connectToServer();
	
	ServerSocket welcomeSocket = new ServerSocket(6789); 
	
	while(true) { 
	    
            Socket connectionSocket = welcomeSocket.accept(); 
	    
	    BufferedReader inFromClient = 
		new BufferedReader(new
		    InputStreamReader(connectionSocket.getInputStream())); 
	    
	    DataOutputStream  outToClient = 
		new DataOutputStream(connectionSocket.getOutputStream()); 
	    
	    //read the SQL statement from client
	    clientSentence = inFromClient.readLine(); 
	    
	    System.out.println(clientSentence);
	    
	    boolean check = insertIntoDB(clientSentence, connectionRecieved);
	    
	    if(check)
	    	System.out.println("nice");
	    else{
	    	System.out.println("basa");
	    }
	    
	    connectionRecieved.close();
        } 
    } 
    
    public static Connection connectToServer() {
    	Connection con=null;
    	try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/testing?useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","12345abcd");  
		}catch(Exception e){ System.out.println(e);} 
    	
    	return con;
    }
    
    public static boolean insertIntoDB(String s, Connection con) {
    	Connection connection = null;
		try {
			Statement statment = con.createStatement();
			
				int numOfAffectedRows = statment.executeUpdate(s);
				System.out.println("numOfAffectedRows=" + numOfAffectedRows);
				return true;
		} catch (SQLException e)            {e.printStackTrace();
		} 
		return false;
    }
} 
