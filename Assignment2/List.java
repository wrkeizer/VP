package assignment2;

public class List<E extends Data> implements ListInterface<E> {
	Node<E> first, 
			last, 
			current;
	
	List(){
		first = last = current = null;
	}
	
	public boolean isEmpty(){
		return first == null;
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
		if (setFirst() == false) { // Insert in empty list
			first = last = current = new Node<E>(d);
		} else {
			while(d.compareTo(current.data) < 1) {
				if (getNext() == false) { // Insert at end of list
					last = current = new Node<E>(d, last, null);
					current.prior.next = current;
					return this;
				}
			}
			// Insert before current
			current = new Node<E>(d, current.prior, current);
			current.prior.next = current;
			current.next.prior = current;
		}
		return this;
	}
	
	public E retrieve(){
		return current.data;
	}
	
	public List<E> remove(){
		
		if (first == last) {
			first = last = current = null;
			return this;
		}
		
		if (current == last) {
			current.prior.next = null;
			last = current = current.prior;
			return this;
		}
		
		if (current == first) {
			current.next.prior = null;
			first = current = current.next;
			return this;
		}
		
		current.next.prior = current.prior;
		current = current.prior.next = current.next;
		return this;
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
		current = first;
		return current != null;
	}
	
	public boolean setLast(){
		current = last;
		return current != null;
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
		
		if(setFirst()){
			while(getNext()){
				clone.insert(current.clone().data);
			}
		}
		return clone;
	}
}
