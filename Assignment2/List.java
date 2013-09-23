package assignment2;

public class List<E extends Data> implements ListInterface{
	private int size;
	
	List(){
		size = 0;
	}
	
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}else return false;
	}
	
	public List<E> init(){
		return new List<E>();
	}
	
	public int size(){
		return size;
	}
	
	
}
