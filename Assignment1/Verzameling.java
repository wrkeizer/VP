package assignment1;

public class Verzameling implements VerzamelingInterface{
	
	public static final int MAX_AANTAL_ELEMENTEN = 20;
	
	private Identifier[] identifiers;
	private int size;

	public Verzameling() {
		identifiers = new Identifier[MAX_AANTAL_ELEMENTEN];
		size = 0;
	}
	
	public Verzameling(Verzameling src) {
		identifiers = new Identifier[MAX_AANTAL_ELEMENTEN];
		Verzameling clone = src.clone();
		for (int size = 0; clone.getSize() > 0; size++) {
			identifiers[size] = new Identifier(clone.someElement());
			clone.removeElement(identifiers[size]);
		}
		assert (size == src.getSize());
	}
	
	public Verzameling clone() {
		Verzameling clone = new Verzameling();
		for (int i = 0; i < size; i++) {
			clone.addElement(new Identifier(identifiers[i]));
		}
		return clone;
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
    
    public int getSize() {
    	return size;
    }

    public Verzameling verschil(Verzameling v) {
    	Verzameling verschil = this.clone();
    	Verzameling clone = v.clone();
    	while (clone.getSize() > 0) {
    		Identifier id = clone.someElement();
    		verschil.removeElement(id);
    		clone.removeElement(id);
    	}
    	return verschil;
    }
    
    public Verzameling doorsnede(Verzameling v) {
    	
    }
    
    public Verzameling vereniging(Verzameling v) throws Exception {
    	
    }
    
    public Verzameling symmetrischVerschil(Verzameling v) throws Exception {
    	
    }
    
}
