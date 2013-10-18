package assignment2;

public class KeyValuePair<K extends Data, V extends Clonable> implements Data {
	
	private K k;
	private V v;
	
	KeyValuePair(K k, V v) {
		this.k = k;
		this.v = v;
	}
	
	public K getKey(){
		return k;
	}
	
	public V getValue(){
		return v;
	}
	
	public int compareTo (Object o) {
		KeyValuePair<K,V> kvp = (KeyValuePair<K,V>) o;
		return k.compareTo(kvp.getKey());
	}
	
	public KeyValuePair<K,V> clone(){ 
		return new KeyValuePair<K,V>((K) k.clone(), (V) v.clone());		
	}
}