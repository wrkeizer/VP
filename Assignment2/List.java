package assignment2;

public class List<E extends Data> implements ListInterface<E> {
	Node<E> first, 
			last, 
			current;
	
	List(){
		first = last = current = null;
	}
	
	public boolean isEmpty(){
		if(first == null){
			return true;
		}else return false;
	}
	
	public List<E> init(){
		first = last = current = null;
		return this;
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
		return current.data;
	}
	
	public List<E> remove(){
		
	}
	
	public boolean find(E d) {
		if(isEmpty()){
			return false;
		}
		
		if(setFirst()){
			do{				
				if(d.compareTo(current.data) == 0){
					return true;
				}
				
				if(d.compareTo(current.data) == 1){
					//Make current point to the last element < d or first element if first < d.
					if(!(current == first)){
						current = current.prior;
					}
					return false;
				}
			}while(getNext());
			//If the method gets to this point, current < d and current should already be pointing to last.
			return false;
		}else return false;
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
			current = current.next;
			return true;
		}
	}
	
	public boolean getPrior(){
		if(isEmpty() || current == first){
			return false;
		}else{
			current = current.prior;
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
