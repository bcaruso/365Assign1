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

public class URLSuggester {

	
		public static void main(String[] args){
			
			Histogram[] urlHistograms;
			
			/* Initialize gui */		
			URLSuggesterGUI gui = new URLSuggesterGUI();
			
			/* Establish Event Dispatch Thread and Create GUI */
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					gui.createGUI();
				}
			});
			
		}	
		
}