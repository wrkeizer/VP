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
		//setup Scanner
		Scanner in = new Scanner(System.in);
		in.useDelimiter("");
		
		
		/*
		Checklist:			
		
		Read until '}'
			-Read first character
			-Keep reading until space character: ' '
			-Add those characters to Identifier while reading
			-Add Identifier to v
			-Do same thing with next 'word'
		
		Possible errors:
			-'{' is missing; done
			-First character is wrong
			-Another character is wrong
			-'}' is missing
		
		Make sure every error has an appropriate error message
		
		How does an EOF character work?
			 
		*/		
		
		
		while(/*v != geldig*/){
			v.init();
			System.out.print("Geef verzameling: ");
			
			if(nextCharIs(in, '{')){
				
				
				
			}else System.out.println("Verzameling moet beginnen met een'{'");
		}
		
		in.close();
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
