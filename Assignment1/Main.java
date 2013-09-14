package assignment1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	Main(){
		
	}
	
	private char nextChar(Scanner in){
		return in.next().charAt(0);
	}
	
	private boolean nextCharIsDigit (Scanner in) {
		return in.hasNext("[0-9]");
	} 
	
	private boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}
	
	private boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c+""));
	}
	
	
	private boolean isCorrect(Verzameling v){				
		boolean valid = false;
		while(valid == false){
			Scanner in = new Scanner(System.in);
			in.useDelimiter("");
			v.init();
			System.out.print("Geef verzameling: ");
			
			if(nextCharIs(in, '{')){
				
				in.next(); //To get rid of said '{'
				
				while(in.hasNext()){
					
					if(nextCharIs(in, '}')){
						if(v.getSize() <= 10){
							valid = true;
						}else{
							System.out.println("Verzameling bevat meer dan 10 elementen");
							break;	
						}
					}
					
					while(!nextCharIs(in, ' ')){		
						
						if(nextCharIsLetter(in)){						
							Identifier id = new Identifier();
							id.init(nextChar(in));						
							
							if(nextCharIsLetter(in) || nextCharIsDigit(in)){
								id.addChar(nextChar(in));
							}else{
								System.out.println("Verkeerd karakter. Alleen letters en cijfers toegestaan.");
								break;
							}						
						
						in.next(); //To get rid of the space						
						v.addElement(id);
						}else {
							System.out.println("Identifier moet beginnen met een letter");
							break;
						}						
					}						
				}				
			}else System.out.println("Verzameling moet beginnen met een'{'");
		}
		return true;
	}
	
	private boolean readyToGo(Verzameling v1, Verzameling v2){
		return isCorrect(v1) && isCorrect(v2);
	}
	
	private void start(){
		Verzameling v1 = new Verzameling(),
					v2 = new Verzameling();
		while(readyToGo(v1, v2)){
			//do operations
		}
	}
	
	public static void main(String[] args) {
		new Main().start();
	}

}
