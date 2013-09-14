package assignment1;

public class Identifier implements IdentifierInterface{
	
	private StringBuffer name;
	
	public Identifier() {
		name = new StringBuffer();
		name.append('x');
	}
	
	public Identifier(Identifier src) {
		name = new StringBuffer();
		name.append(src.getChar(0));
		for (int i = 1; i < src.getSize(); i++) {
			name.append(src.getChar(i));
		}
	}

    public void init (char c) {
    	name.delete(0, Integer.MAX_VALUE);
    	name.append(c);
    }

    public void addChar(char c) {
    	name.append(c);
    }

    public char getChar(int index) {
    	return name.charAt(index);
    }
    
    public int getSize() {
    	return name.length();
    }
    
    public boolean equals(Identifier id){
    	if (id.getSize() != this.getSize())
    		return false;
    	
		for (int i = 0; i < this.getSize(); i++) {
			if (id.getChar(i) != this.getChar(i)) {
				return false;
			}
		}
		
		return true;
	}
    
    public int hashCode() {
    	return name.hashCode();
    }
    
}
