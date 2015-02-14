/*
*	URLHandler CLASS - CSC 365 - Assignment 1
*
*	Author: Brandon Caruso
*   Handles creating Histograms from URLs.
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import java.net.*;
import java.io.IOException;
import java.net.URISyntaxException;

import java.util.Scanner;

public class URLHandler {

		public static Histogram createHistogram(URL url) throws IOException, URISyntaxException{
			
			Histogram h = new Histogram(128);
			
			Document doc = Jsoup.parse(url.openStream(),null,url.toURI().toString());
			
			String dirtyDoc = doc.text();
			//Remove Punctuation
			String cleanDoc = dirtyDoc.replaceAll("[^a-zA-Z0-9 ]", "");
			System.out.println(cleanDoc);
			// Create Histogram
			
			Scanner s = new Scanner(cleanDoc);
			
			while(s.hasNext())
				h.add(s.next());
				
			s.close();
			
			return h;
			
		}
		
}