package assignment2;

public class Set<E extends Data> implements SetInterface<E>{
	
	private List<E> list;

	Set() {
		list = new List<E>();
	}
	
	public Set<E> clone() {
		Set<E> clone = new Set<E>();
		clone.list = list.clone();
		return clone;		
	}
	
	public void init () {
		list.init();
	}

    public void addElement(E d){
    	if(list.find(d)){
    		return;
    	}
    	list.insert(d);
    }
    
    public void removeElement(E d) {
    	if(list.find(d)) {
        	list.remove();
    	}
    }
    
    public E someElement() {
    	list.setFirst(); //doesn't matter for unstructured sets but our implementation uses ordered lists so yeah..
    	return list.retrieve();
    }
    
    public int getSize() {
    	return list.getSize();
    }

    public Set<E> difference(Set<E> v) {
    	Set<E> difference = this.clone();
    	Set<E> subtracter = v.clone();
    	while (subtracter.getSize() > 0) {
    		E d = subtracter.someElement();
    		difference.removeElement(d);
    		subtracter.removeElement(d);
    	}
    	return difference;
    }
    
    public Set<E> intersection(Set<E> v) {
    	return difference(difference(v));
    }
    
    public Set<E> union(Set<E> v){
    	Set<E> union = this.clone();    	
		Set<E> adder = v.clone();
		while (adder.getSize() > 0) {
		 	E d = adder.someElement();
		 	union.addElement(d);
		   	adder.removeElement(d);
		}
		return union;
    }
    
    public Set<E> symmetricDifference(Set<E> v){
    	return difference(v).union(v.difference(this));
    }
    
}
