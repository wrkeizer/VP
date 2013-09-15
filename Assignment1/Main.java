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
	
	private boolean is1Correct(Verzameling v){				
		boolean valid = false;		
		while(valid == false){
			Scanner in = new Scanner(System.in);
			in.useDelimiter("");
			v.init();
			System.out.print("Geef eerste verzameling: ");
			
			if(nextCharIs(in, '{')){
				in.next(); //Get rid of '{'
				
				start:
				while(in.hasNext()){					
					
					
					
				}
			}else System.out.println("Verzamling moet beginnen met een '{'");
		}
		
		return true;
	}
	
	private boolean is2Correct(Verzameling v){				
		boolean valid = false;
		while(valid == false){
			Scanner in = new Scanner(System.in);
			in.useDelimiter("");
			v.init();
			System.out.print("Geef tweede verzameling: ");
			
			if(nextCharIs(in, '{')){
				valid = true;
				
			}else System.out.println("Verzamling moet beginnen met een '{'");
		}
		
		return true;
	}
	
	private boolean readyToGo(Verzameling v1, Verzameling v2){
		return is1Correct(v1) && is2Correct(v2);
	}
	
	private void start(){
		Verzameling v1 = new Verzameling(),
					v2 = new Verzameling();
		while(readyToGo(v1, v2)){
			System.out.println("done\n");
		}
	}
	
	public static void main(String[] args) {
		new Main().start();
	}

}
