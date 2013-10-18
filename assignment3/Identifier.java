package assignment3;

public class Identifier implements IdentifierInterface{
	
	private StringBuffer name;
	
	public Identifier() {
		name = new StringBuffer();
		name.append('x');
	}

    public void init (char c) {
    	name.delete(0, getSize());
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
    
    public Identifier clone() {

		Identifier clone = new Identifier();
		clone.init(getChar(0));
		
		for(int i = 1; i < getSize(); i++){
			clone.addChar(getChar(i));
		}
		
		return clone;
    }
    
	public int compareTo(Object o) {
		Identifier id = (Identifier) o;
		return name.toString().compareTo(id.name.toString());
	}
}
