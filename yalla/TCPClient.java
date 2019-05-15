package yalla;
/**  TCP Client
 * Code is taken from Computer Networking: A Top-Down Approach Featuring 
 * the Internet, second edition, copyright 1996-2002 J.F Kurose and K.W. Ross, 
 * All Rights Reserved.
 **/

import java.io.*; 
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane; 
class TCPClient { 

	public static void main(String argv[]) throws Exception 
	{ 
		String sentence; 
		String modifiedSentence; 

		BufferedReader inFromUser = 
				new BufferedReader(new InputStreamReader(System.in)); 

		Socket clientSocket = new Socket("localhost", 6789); 

		DataOutputStream outToServer = 
				new DataOutputStream(clientSocket.getOutputStream()); 


		BufferedReader inFromServer = 
				new BufferedReader(new
						InputStreamReader(clientSocket.getInputStream())); 

		sentence = getSQLQuery();

		outToServer.writeBytes(sentence + '\n'); 

		clientSocket.close(); 

	} 
	
	public static String getSQLQuery() {
		String s = "";
	
		String tribeName = JOptionPane
				.showInputDialog("Enter new lecturer's name:");
		if (tribeName.length() > 0) {
			return "INSERT INTO `testing`.`lecturer` (`LID`,`username`) VALUES ('12312' ,'"
					+ tribeName + "')";
		}
		return null;
	}

}