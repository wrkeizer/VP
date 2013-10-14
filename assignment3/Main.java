package assignment3;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	Scanner in;
	PrintStream out;
	
	Main(){
		in = new Scanner(System.in);
		in.useDelimiter("");
		out = new PrintStream(System.out);
	}
	
	private char nextChar(Scanner in){
		return in.next().charAt(0);
	}
	
	private void removeWhitespace(Scanner in) {
		while (nextCharIsSpace(in)) {
			in.next(); // Read away space
		}
	}
	
	private boolean nextCharIsSpace (Scanner in) {
		return in.hasNext(" ");
	}
	
	private boolean nextCharIsNewLine(Scanner in) {
		return nextCharIs(in, '\n') || nextCharIs(in, '\r');
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
	
	private Identifier readIdentifier(Scanner in) throws APException{
		Identifier id = new Identifier();
		if(!nextCharIsLetter(in)){
			in.nextLine();
			throw new APException("Identifier should start with a letter.");
		}
		id.init(nextChar(in));
		while (!nextCharIsSpace(in)) {
			if(nextCharIsLetter(in) || nextCharIsDigit(in)){
				id.addChar(nextChar(in));
			}else{
				in.nextLine();
				throw new APException("Identifier can only consist of letters and numbers.");
			}
		}
		return id;
	}
	
	private Identifier readNaturalNumber(Scanner in) throws APException{
		Identifier id = new Identifier();
		if(nextCharIs(in, '0')){
			in.nextLine();
			throw new APException("Number cannot start with a '0'.");
		}
		id.init(nextChar(in));
		while (nextCharIsDigit(in)) {
			id.addChar(nextChar(in));
		}
		return id;
	}
	
	void start(String[] args){
		
	}
	
	public static void main(String[] args) {
		new Main().start(args);
	}

}
