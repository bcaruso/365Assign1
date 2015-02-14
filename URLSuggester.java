/*
*	URLSuggester CLASS - CSC 365 - Assignment 1
*
*	Author: Brandon Caruso
*	Main Class which will handle:
*		- GUI Setup		
*		- Histogram Setup
*		- URL Suggesting
*/

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.*;
import java.net.*;

public class URLSuggester {

		public static ArrayList<Histogram> urlHistograms;
		public static Histogram queryHistogram;
	
	
		public static void main(String[] args) throws IOException, URISyntaxException{
			
			urlHistograms = new ArrayList<Histogram>();
			
			// Get initURLs File 
			File initURLs = new File(args[0]);
			// Parse and create Histogram for each URL in File
			
			Scanner s = new Scanner(initURLs);
			while(s.hasNext()){
				URL url = new URL(s.nextLine());
				System.out.println(url.toString());
				urlHistograms.add(URLHandler.createHistogram(url));
				System.out.println(urlHistograms.size());
			}
			
			s.close();
			
			/*
			// Initialize gui		
			URLSuggesterGUI gui = new URLSuggesterGUI();
			
			// Establish Event Dispatch Thread and Create GUI
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					gui.createGUI();
				}
			});
			*/
			
		}	
		
}