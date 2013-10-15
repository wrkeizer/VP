package assignment2;

public class N implements NInterface{
	
	private StringBuffer s;
	
	N() {
		s = new StringBuffer();
		init('0');
	}
	
	public N init(char c){
		s.delete(0, s.length());
		s.append(c);
		return this;
	}
	
	public void addDigit(char c){
		s.append(c);
	}
	
	public char getDigit(int index){
		return s.charAt(index);
	}
	
	public int getLength(){
		return s.length();
	}
	
	public N clone(){
		N clone = new N();
		clone.init(getDigit(0));
		
		for(int i = 1; i < getLength(); i++){
			clone.addDigit(getDigit(i));
		}
		
		return clone;
	}
	
	public int compareTo(Object o){
		N n = (N) o;
		
		if(getLength() < n.getLength()){
			return -1;
		}

		if(getLength() > n.getLength()){
			return 1;
		}
		
		for(int i = 0; i < getLength(); i++){
			if(getDigit(i) < n.getDigit(i)){
				return -1;
			}
			if(getDigit(i) > n.getDigit(i)){
				return 1;
			}
		}
		return 0;
				
	}	
}