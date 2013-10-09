package assignment2;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	Scanner in;
	
	Main(){
		in = new Scanner(System.in);
		in.useDelimiter("");
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
	
	private Identifier readIdentifier(Scanner in) {
		Identifier id = new Identifier();
		id.init(nextChar(in));
		while (nextCharIsLetter(in) || nextCharIsDigit(in)) {
			id.addChar(nextChar(in));
		}
		return id;
	}
	
	private void readIdentifiers(Set set, Scanner in) {
		while(nextCharIs(in, '}') == false) { // read in identifiers
			if (!nextCharIsLetter(in)) {
				System.out.println("Identifier should start with a letter.");
				in.nextLine();//Bethlehem insert
				//Foutmelding
			}
			Identifier id = readIdentifier(in); // read in individual identifier
			removeWhitespace(in);
			if(nextCharIsNewLine(in)){
				System.out.println("'}' Is missing.");
				in.nextLine();//Bethlehem insert
				//Foutmelding
			}
			if (!(nextCharIs(in, ',') || nextCharIs(in, '}'))) {
				System.out.println("Identifier can only exist out of letters and numbers.");
				in.nextLine();//Bethlehem insert
				//Foutmelding
			}
			if(nextCharIs(in, ',')){
				in.next(); //Read away ','
			}
			set.addElement(id); // add identifier to set
		}
	}
	
	private Set readSet(Scanner in) {
		Set set = new Set();
		removeWhitespace(in);
		if(!nextCharIs(in, '{')){
			if (nextCharIsNewLine(in)) {
				in.nextLine();//Keizer insert
				//Foutmelding
			}
			System.out.println("Set should start with a '{'.");
			in.nextLine();//Bethlehem insert
			//Foutmelding
		}
		in.next(); // Get rid of '{'
		removeWhitespace(in);
		
		readIdentifiers(set, in);
		
		in.next(); // Lose the '}'
		removeWhitespace(in);
		if(!nextCharIsNewLine(in)) {
			System.out.println("There are characters outside of the set.");
			in.nextLine();//Bethlehem insert
			//Foutmelding
		}
		
		in.nextLine();//Bethlehem insert
		return set;		
	}
	
	private void readExpression(){
		removeWhitespace(in);
		if (!nextCharIsLetter(in)) {
			System.out.println("Identifier should start with a letter.");
			in.nextLine();//Bethlehem insert
			//Foutmelding
		}
		Identifier id = readIdentifier(in); // read in individual identifier
		removeWhitespace(in);
		
		if(!nextCharIs(in, '=')){
			in.nextLine();
			//Foutmelding
		}
		
		removeWhitespace(in);
		//Whatever comes after the '=' sign should result in a set.
	}
	
	private void readLine(Scanner line){
		//Reads a single line from the program.
		//Empty line
		if(nextCharIsNewLine(line)){
			line.nextLine();
			//Foutmelding
		}
		// '/' Comment 
		if(nextCharIs(line, '/')){
			line.nextLine();
			return;
		}
		// '?' Print statement -> Identifier or expression
		if(nextCharIs(line, '?')){
			removeWhitespace(line);
			if (!nextCharIsLetter(line)) {
				System.out.println("Identifier should start with a letter.");
				line.nextLine();//Bethlehem insert
				//Foutmelding
			}
			//If single Identifier: Print value with key Identifier
			//If expression: Print result of expression
		}
		
		// Expression -> multiple possibilities.
		readExpression();
		return;
	}

	private void start(){
		while(in.hasNext()){
			readLine(new Scanner(in.nextLine()));
		}
	}
	
	public static void main(String[] args) {
		new Main().start();
	}

}
