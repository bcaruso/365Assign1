/*
*	HISTOGRAM CLASS - CSC 365 - Assignment 1
*
*	Author: Brandon Caruso
*	A hash map containing Strings and the Frequency of that String
*	
*/

public class Histogram {


	private double loadFactor = .75;
	private int numberOfEntries = 0;
	private Entry[] histogram;
	
	public Histogram(){
		histogram = new Entry[16];
	}
	
	public Histogram(int size){
		histogram = new Entry[size];
	}
	
	public Histogram(int size, float loadF ){
		histogram = new Entry[size];
		loadFactor = loadF;
	}
	
	public int getCount(String key){
		Entry contains = this.contains(key);
		
		if( contains == null ){
			// Umm... I can find any thing
			return 0;
		}else{
			// Give me your Count
			return contains.getCount();
		}
		
	}
	
	public void add(String key){
		
		// Have I seen this before?
		Entry contains = this.contains(key);
		
		if(contains == null){
			// NOPE!
			Entry e = new Entry(key);
			int eHash = e.getHashCode();
			int index = Math.abs(eHash) % histogram.length;
			Entry current = histogram[index];
			e.next = current;
			histogram[index] = e;
			numberOfEntries += 1;
		}else{
			//YEP!
			contains.incCount();
		}
		
		if(((double) numberOfEntries/histogram.length) > .75){
			// Well we knew it had to happen sometime ... TIME TO REHASH!
			rehash();
		}	
	}
	
	private void rehash(){
		System.out.println("Rehashing...");
		
		// A new Histogram
		Entry[] newArray = new Entry[histogram.length * 2];
		numberOfEntries = 0;
		// For each element in current histogram add to newHistogram
		// newHistogram.add();
		
		histogram = newArray;
	}
	
	public Entry contains(String key){
		int eHash = key.toLowerCase().hashCode();
		int index = Math.abs(eHash) % histogram.length;
		
		Entry current = histogram[index];
		
		while(current != null && !current.getKey().equals(key.toLowerCase())){
			current = current.next;
		}
		
		return current;
	}
	
	public int numberOfEntries(){
		return numberOfEntries;
	}

	/*  
	*	SOME WAY TO ITERATE THROUGH THE HISTOGRAM
	* 	DECIDED forEach
	*/
	
	
}