package assignment2;

public class KeyValuePair<K extends Data, V extends Clonable> implements Data {
	
	K k;
	V v;
	
	//Identifier
	//Set?
	
	KeyValuePair(K k, V v) {
		
	}
	
	public int compareTo (Object o) {
		return -2;
	}
	
	public KeyValuePair<K,V> clone(){ 
		return this;
	}
}