package assignment2;

public class List<E extends Data> implements ListInterface{
	Node<E> first, 
			last, 
			current;
	
	List(){
		//Is this necessary?
		first = last = current = null;
	}
	
	public boolean isEmpty(){
		if(first == null){
			return true;
		}else return false;
	}
	
	public List<E> init(){
		return new List<E>();
	}
	
	public int getSize(){
		if(setFirst()){
			int counter = 0;
			
			//Because setFirst() is true, the list is not empty and therefore this loop will execute at least once.
			do{
				counter++;
			}while(getNext());
			
			return counter;
		}else return 0;
	}
	
	public List<E> insert(E d){
		
	}
	
	public E retrieve(){
		
	}
	
	public List<E> remove(){
		
	}
	
	public boolean find(E d){
	
	}
	
	public boolean setFirst(){
		if(isEmpty()){
			return false;
		}
		current = first;
		return true;
	}
	
	public boolean setLast(){
		if(isEmpty()){
			return false;
		}
		current = last;
		return true;
	}
	
	public boolean getNext(){
		if(isEmpty() || current == last){
			return false;
		}else{
			//make current point to next element
			return true;
		}
	}
	
	public boolean getPrior(){
		if(isEmpty() || current == first){
			return false;
		}else{
			//make current point to prior element
			return true;
		}
	}
	
	public List<E> clone(){
		List<E> clone = new List<E>();
		while(getNext()){
			clone.insert(current.clone().data);
		}
		return clone;
	}
}
