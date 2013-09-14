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
			clone.addElement(new Identifier(identifiers[i])); //exception?
		}
		return clone;
	}
	
	public void init () {
		size = 0;
	}

    public void addElement(Identifier id) { //throws exception?
    	for (int i = 0; i < size; i++) {
    		if (identifiers[i].equals(id)) {
    			return;
    		}
    	}//exception
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
    	Verzameling aftrekker = v.clone();
    	while (aftrekker.getSize() > 0) {
    		Identifier id = aftrekker.someElement();
    		verschil.removeElement(id);
    		aftrekker.removeElement(id);
    	}
    	return verschil;
    }
    
    public Verzameling doorsnede(Verzameling v) {
    	Verzameling verschil = verschil(v);
    	return verschil(verschil);
    }
    
    public Verzameling vereniging(Verzameling v) throws Exception {
    	Verzameling vereniging = this.clone();
    	Verzameling opteller = v.clone();
    	while (opteller.getSize() > 0) {
    		Identifier id = opteller.someElement();
    		vereniging.addElement(id); //exception
    		opteller.removeElement(id);
    	}
    	return vereniging;
    }
    
    public Verzameling symmetrischVerschil(Verzameling v) throws Exception {
    	Verzameling verschil1 = verschil(v);
    	Verzameling verschil2 = v.verschil(this);
    	return verschil1.vereniging(verschil2); //exception
    }
    
}
