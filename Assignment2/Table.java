package assignment2;

public class Table<K extends Data, V extends Clonable> implements TableInterface<K, V> {
	
	private List<KeyValuePair<K,V>> list;
	
	Table() {
		list = new List<KeyValuePair<K,V>>();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public Table<K,V> init() {
		list.init();
		return this;
	}
	
	public int getSize () {
		return list.getSize();
	}
	
	public void insert (K k, V v) {
		if (find(k)){
			list.remove();
		}
		list.insert(new KeyValuePair<K,V>(k, v));
	}
	
	private boolean find(K k) {
		if(!list.setFirst()){
			return false;
		}
		do {
			if (list.retrieve().getKey().compareTo(k) == 0) {
				return true;
			}
		} while (list.getNext());
		return false;
	}
	
	public V retrieve (K k) {
		if(!find(k)){
			return null;
		}
		return list.retrieve().getValue();
	}
	
	public void remove(K k) {
		
	}
	
	public Table<K,V> clone () {
		Table<K,V> t = new Table<K,V>();
		t.list = list.clone();
		return t;
	}
}