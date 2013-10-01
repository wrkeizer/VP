package assignment2;

public class Table<K extends Data, V extends Clonable> implements TableInterface<K, V> {
	
	List<K> list;
	
	Table() {
		list = new List<K>();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public Table init() {
		
	}
	
	public int getSize () {
		return list.getSize();
	}
	
	public void insert (K k, V v) {
		
	}
	
	public V retrieve (K k) {
		
	}
	
	public Table clone () {
		
	}
}