package assignment1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	public static final int MAX_NUMBER_OF_IDENTIFIERS_INPUT = 10;
	
	Scanner in;
	
	Main(){
		in = new Scanner(System.in);
		in.useDelimiter("");
	}
	
	private char nextChar(Scanner in){
		return in.next().charAt(0);
	}
	
	private Identifier readIdentifier(Scanner in) {
		Identifier id = new Identifier();
		id.init(nextChar(in));
		while (nextCharIsLetter(in) || nextCharIsDigit(in)) {
			id.addChar(nextChar(in));
		}
		return id;
	}
	
	private boolean leesSetIn(Set v, Scanner in) {
		int counter = 0; 
		
		removeWhitespace(in);
		if(!nextCharIs(in, '{')){
			if (nextCharIsNewLine(in)) {
				in.nextLine();//Keizer insert
				return false;
			}
			System.out.println("Set should start with a '{'.");
			in.nextLine();//Bethlehem insert
			return false;
		}
		in.next(); // Get rid of '{'
		removeWhitespace(in);

		while(nextCharIs(in, '}') == false) { // read in identifiers
			if (!nextCharIsLetter(in)) {
				System.out.println("Identifier should start with a letter.");
				in.nextLine();//Bethlehem insert
				return false;
			}
			Identifier id = readIdentifier(in); // read in individual identifier
			if(nextCharIsNewLine(in)){
				System.out.println("'}' Is missing.");
				in.nextLine();//Bethlehem insert
				return false;
			}
			if (!(nextCharIsSpace(in) || nextCharIs(in, '}'))) {
				System.out.println("Identifier can only exist out of letters and numbers.");
				in.nextLine();//Bethlehem insert
				return false;
			}
			v.addElement(id); // add identifier to set
			counter++;
			if (counter > MAX_NUMBER_OF_IDENTIFIERS_INPUT) {
				System.out.println("The set contains too much elements.");
				in.nextLine();//Bethlehem insert
				return false;
			}			
			removeWhitespace(in);
		}
		
		in.next(); // Lose the '}'
		removeWhitespace(in);
		if(nextCharIsNewLine(in)) {
			in.nextLine();//Bethlehem insert
			return true;
		}
		
		System.out.println("There are characters outside of the set.");
		in.nextLine();//Bethlehem insert
		return false;
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
	
	private void print(Set v, String s){
		System.out.print(s + ": {");
		while(v.getSize() > 0){
			Identifier id = v.someElement();
			for(int i=0; i<id.getSize(); i++){
				System.out.print(id.getChar(i));
			}
			
			//For the last element, don't print the space at the end
			if(v.getSize() > 1){
				System.out.print(" ");
			}
			v.removeElement(id);
		}
		System.out.println('}');
	}
	
	private boolean vraagSet(String s, Set v) {		
		do { //read set
			v.init();
			System.out.print(s);
			if (in.hasNext() == false) {
				in.close();
				return false;
			}
		} while (leesSetIn(v, in) == false);
		
		return true;
		
	}
	
	private boolean vraagInvoer(Set v1, Set v2) {
		return vraagSet("Give first set: ", v1) && vraagSet("Give second set: ", v2);
	}
	
	private void start(){
		Set v1 = new Set(),
					v2 = new Set();
		while(vraagInvoer(v1, v2)){
			print(v1.difference(v2), "Difference");
			print(v1.intersection(v2), "Intersection");
			print(v1.union(v2), "Union");
			print(v1.symmetricDifference(v2), "Symmetric difference");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Main().start();
	}

}
