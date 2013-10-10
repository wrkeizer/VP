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
	
	private void readIdentifiers(Set set, Scanner in) throws APException{
		while(nextCharIs(in, '}') == false) { // read in identifiers
			if (!nextCharIsLetter(in)) {
				System.out.println("Identifier should start with a letter.");
				in.nextLine();//Bethlehem insert
				throw new APException("Foutmelding");
			}
			Identifier id = readIdentifier(in); // read in individual identifier
			removeWhitespace(in);
			if(nextCharIsNewLine(in)){
				System.out.println("'}' Is missing.");
				in.nextLine();//Bethlehem insert
				throw new APException("Foutmelding");
			}
			if (!(nextCharIs(in, ',') || nextCharIs(in, '}'))) {
				System.out.println("Identifier can only exist out of letters and numbers.");
				in.nextLine();//Bethlehem insert
				throw new APException("Foutmelding");
			}
			if(nextCharIs(in, ',')){
				in.next(); //Read away ','
			}
			set.addElement(id); // add identifier to set
		}
	}
	
	private Set readSet(Scanner in) throws APException{
		Set set = new Set();
		removeWhitespace(in);
		if(!nextCharIs(in, '{')){
			if (nextCharIsNewLine(in)) {
				in.nextLine();//Keizer insert
				throw new APException("Foutmelding");
			}
			System.out.println("Set should start with a '{'.");
			in.nextLine();//Bethlehem insert
			throw new APException("Foutmelding");
		}
		in.next(); // Get rid of '{'
		removeWhitespace(in);
		
		readIdentifiers(set, in);
		
		in.next(); // Lose the '}'
		removeWhitespace(in);
		if(!nextCharIsNewLine(in)) {
			System.out.println("There are characters outside of the set.");
			in.nextLine();//Bethlehem insert
			throw new APException("Foutmelding");
		}
		
		in.nextLine();//Bethlehem insert
		return set;		
	}
	
	private Set readExpression(Scanner line) throws APException{
		//Reads one or more term(s), separated by '+', '|' or '-' sign.
		removeWhitespace(in);
		Set set = readTerm(line);
		while(line.hasNext()){
			removeWhitespace(line);
			if(nextCharIsNewLine(line)){
				line.nextLine();
			}else if(nextCharIs(line, '+')){
				line.next(); //Read away '+'.
				set.union(readTerm(line));
			}else if(nextCharIs(line, '-')){
				line.next(); //Read away '-'.
				set.difference(readTerm(line));
			}else if(nextCharIs(line, '|')){
				line.next(); //Read away '|'.
				set.symmetricDifference(readTerm(line));
			}else{
				line.nextLine();
				throw new APException("Foutmelding");
				return null; //<- Is this correct?
			}
		}
		return set;
	}
	
	private void readAssignment(Scanner line) throws APException{
		//This method can only be called if the next char is a letter.
		//Reads a single assignment from the program.
		Identifier id = readIdentifier(line);	
		removeWhitespace(line);
		if(nextCharIs(line, '=')){
			line.next(); //Read away '='
			removeWhitespace(line);
			Set set = readExpression(line);
			//Add id and set to keyvaluepair and node and list and table and whatever.
		}else{
			line.nextLine();
			throw new APException("Foutmelding");
		}		
	}
	
	private void readStatement(Scanner line) throws APException{
		//Reads a single statement from the program.
		removeWhitespace(line);
		//Empty line
		if(nextCharIsNewLine(line)){
			line.nextLine();
			throw new APException("Foutmelding");
		}else if(nextCharIsLetter(line)){
			// Assignment
			readAssignment(line);
		}else if(nextCharIs(line, '/')){
			// Comment
			line.nextLine();
			return;
		}else if(nextCharIs(line, '?')){
			// Print statement
			Set set = readExpression(line);
			//Print set
		}else {
			line.nextLine();
			throw new APException("Foutmelding");
		}
	}

	private void start(){
		while(in.hasNext()){
			try{
				readStatement(new Scanner(in.nextLine()));
			}
			catch(APException e){
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
}
