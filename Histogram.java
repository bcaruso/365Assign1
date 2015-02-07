/*
*	HISTOGRAM CLASS - CSC 365 - Assignment 1
*
*	Author: Brandon Caruso
*	A hash map containing Strings and the Frequency of that String
*	
*/

public class Histogram {


	private float loadFactor = .75;
	private int numberOfEntries = 0;
	private Entry[] histogram;
	
	public Histogram(int size){
		histogram = new Entry[size];
	}
	
	public Histogram(int size, float loadF ){
		histogram = new Entry[size];
		loadFactor = loadF;
	}
	
	public int getCount(String key){
			return 0;
	}
	
	public void add(String key){
	
	}
	
	private void rehash(){
		
	}
	
	public Entry contains(String key){
			return null;
	}

	/*  
	*	SOME WAY TO ITERATE THROUGH THE HISTOGRAM
	* 	TODO: DECIDED BETWEEN A forEach OR Iterator
	*/
	
	
}