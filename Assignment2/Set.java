package assignment2;

public class Set implements SetInterface{
	
	public static final int MAX_NUMBER_OF_ELEMENTS = 20;
	
	private Identifier[] identifiers;
	private int size;

	public Set() {
		identifiers = new Identifier[MAX_NUMBER_OF_ELEMENTS];
		size = 0;
	}
	
	public Set(Set src) {
		identifiers = new Identifier[MAX_NUMBER_OF_ELEMENTS];
		Set clone = src.clone();
		for (int size = 0; clone.getSize() > 0; size++) {
			identifiers[size] = new Identifier(clone.someElement());
			clone.removeElement(identifiers[size]);
		}
		assert (size == src.getSize());
	}
	
	public Set clone() {
		Set clone = new Set();
		
		for (int i = 0; i < size; i++) {
			try{
				clone.addElement(new Identifier(identifiers[i]));
		 	}
		 	catch(ArrayIndexOutOfBoundsException e){
	    		System.out.println("The set contains more than " + MAX_NUMBER_OF_ELEMENTS + " elements.\nIt wasn't possible to create a clone-object.");
	    	}
		}			
		return clone;		
	}
	
	public void init () {
		size = 0;
	}

    public void addElement(Identifier id) throws ArrayIndexOutOfBoundsException{
	    for (int i = 0; i < size; i++) {
	    	if (identifiers[i].equals(id)) {
	    		return;
	    	}
	    }
	    identifiers[size] = id;
	    size += 1;
    }
    
    public void removeElement(Identifier id) {
    	for (int i = 0; i < size; i++) {
    		if (identifiers[i].equals(id)) {
    			if (i+1 == size) {
    				identifiers[i] = null;
    				size -= 1;
    			}
    			identifiers[i] = identifiers [i+1];
    			identifiers[i+1] = id; //prevents the need for a flag
    		}
    	}
    }
    
    public Identifier someElement() {
    	return identifiers[size - 1];
    }
    
    public int getSize() {
    	return size;
    }

    public Set difference(Set v) {
    	Set difference = this.clone();
    	Set subtracter = v.clone();
    	while (subtracter.getSize() > 0) {
    		Identifier id = subtracter.someElement();
    		difference.removeElement(id);
    		subtracter.removeElement(id);
    	}
    	return difference;
    }
    
    public Set intersection(Set v) {
    	Set difference = difference(v);
    	return difference(difference);
    }
    
    public Set union(Set v){
    	Set union = this.clone();    	
		Set adder = v.clone();
		while (adder.getSize() > 0) {
		 	Identifier id = adder.someElement();
		 	try{
		 		union.addElement(id);
		 	}
		 	catch(ArrayIndexOutOfBoundsException e){
	    		System.out.println("The set contains more than " + MAX_NUMBER_OF_ELEMENTS + " elements.\nThe given object will be returned");
	    	}
		   	adder.removeElement(id);
		}
		return union;
    }
    
    public Set symmetricDifference(Set v){
    	Set difference1 = difference(v);
    	Set difference2 = v.difference(this);
    	return difference1.union(difference2);
    }
    
}
