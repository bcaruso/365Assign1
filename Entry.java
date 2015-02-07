/*
*	ENTRY CLASS - CSC 365 - Assignment 1
*
*	Author: Brandon Caruso
*	Key: a string lowercase ( i.e. "the" )
*	Value: a count
*/

public class Entry {
	
	private int hash;
	private String key;	// KEY
	private int count;	// VALUE
	private Entry next;


	public Entry (String k) {
		key = k.lowerCase();
		count = 0;
		next = null;
		hash = key.hashCode();	
	}

	public int getHashCode(){
		// Returns Hash Code for this specific Key
		return hash;
	}
	
	public int getCount(){
		// Returns number of occurrences of this specific Key
		return count;
	}
	
	public String getKey(){
		// Returns key
		return key;
	}
	
	public Entry next(){
		// Returns next entry
		return next;
	}
}
