package assignment1;

public class Identifier implements IdentifierInterface{

    boolean equals(Identifier id){
    	if (id.getSize() == this.getSize()){
    		for (int i = 0; i < this.getSize(); i++) {
    			if (id.getChar(i) != this.getChar(i)) {
    				return false;
    			}
    		}
    		return true;
    	}
    	return false;
    }
}
