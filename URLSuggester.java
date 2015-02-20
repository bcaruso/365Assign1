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
	
	
		public static void main(String[] args) throws IOException, URISyntaxException{
			
			urlHistograms = new ArrayList<Histogram>();
			
			// Get Reference URL Files
			File initURLs = new File(args[0]);
			// Parse and create Histogram for each URL in File
			
			Scanner s = new Scanner(initURLs);
			while(s.hasNext()){
				URL url = new URL(s.nextLine());
				System.out.println(url.toString());
				urlHistograms.add(URLHandler.createHistogram(url));
				//urlHistograms.get(urlHistograms.size()-1).printOut();
			}
			
			s.close();
			
			/* 
			
			// FOR TERMINAL TESTING 
		
			Scanner input = new Scanner(System.in);
			String url = input.nextLine();
			while( !url.equals("q")){
				System.out.println(HistogramSimilarity.findMostSimilar(url, urlHistograms).getURL().toString());
				url = input.nextLine();
			}
			
			*/
			
			// Initialize gui	
			URLSuggesterGUI gui = new URLSuggesterGUI();
			
			// Establish Event Dispatch Thread and Create GUI
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					gui.createGUI();
				}
			});
			
		}
		
}