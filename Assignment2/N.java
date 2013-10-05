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
	
	public void addChar(char c){
		s.append(c);
	}
	
	public char getChar(int index){
		return s.charAt(index);
	}
	
	public int getLength(){
		return s.length();
	}
	
	public N clone(){
		N copy = new N();
		
		for(int i = 0; i < getLength(); i++){
			copy.addChar(getChar(i));
		}
		
		return copy;
	}
	
	public int compareTo(N n){
		if(getLength() < n.getLength()){
			return -1;
		}else if(getLength() > n.getLength()){
			return 1;
		}else{
			
			for(int i = 0; i < getLength(); i++){
				if(getChar(i) < n.getChar(i)){
					return -1;
				}else if(getChar(i) > n.getChar(i)){
					return 1;
				}
			}
			return 0;
		}		
	}	
	public int compareTo(Object o){
		N n = (N) o;
		return compareTo(n);		
	}	
}