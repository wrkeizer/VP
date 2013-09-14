package assignment1;

public class Verzameling implements VerzamelingInterface{
	
	private static final int MAX_AANTAL_ELEMENTEN = 20;
	
	private Identifier[] identifiers;
	private int size;

	public Verzameling() {
		identifiers = new Identifier[MAX_AANTAL_ELEMENTEN];
		size = 0;
	}
	
	public Verzameling(Verzameling src) {
		//
	}
	
	public void init () {
		size = 0;
	}

    public void addElement(Identifier id) {
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
    
    public int size() {
    	return size;
    }

    public Verzameling verschil(Verzameling v) {
    	
    }
    
    public Verzameling doorsnede(Verzameling v) {
    	
    }
    
    public Verzameling vereniging(Verzameling v) throws Exception {
    	
    }
    
    public Verzameling symmetrischVerschil(Verzameling v) throws Exception {
    	
    }
    
}
