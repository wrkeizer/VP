package assignment1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	public static final int MAX_AANTAL_IDENTIFIERS_INPUT = 10;
	
	Main(){
		
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
	
	private boolean leesVerzamelingIn(Verzameling v, Scanner in) {
		if(!nextCharIs(in, '{')){
			System.out.println("Verzameling moet beginnen met een '{'.");
			return false;
		}
		in.next(); // Get rid of '{'
		removeWhitespace(in);

		while(nextCharIs(in, '}') == false) { // read in identifiers
			if (v.getSize() == MAX_AANTAL_IDENTIFIERS_INPUT) {
				System.out.println("De verzameling bevat teveel elementen.");
				return false;
			}
			if (!nextCharIsLetter(in)) {
				System.out.println("Identifier moet beginnen met een letter.");
				return false;
			}
			Identifier id = readIdentifier(in); // read in individual identifier
			if(nextCharIsNewLine(in)){
				System.out.println("De '}' ontbreekt.");
				return false;
			}
			if (!(nextCharIsSpace(in) || nextCharIs(in, '}'))) {
				System.out.println("Identifier mag alleen bestaan uit letters en cijfers.");
				return false;
			}
			v.addElement(id); // add identifier to set
			removeWhitespace(in);
		}
		
		in.next(); // Lose the '}'
		removeWhitespace(in);
		if(nextCharIsNewLine(in)) {
			return true;
		}
		
		System.out.println("Er staan tekens buiten de verzameling.");
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
	
	private void print(Verzameling v){
		Verzameling clone = v.clone();
		while(clone.getSize() > 1){
			Identifier id = clone.someElement();
			for(int i=0; i<id.getSize(); i++){
				System.out.print(id.getChar(i));
			}
			System.out.print(" ");
			clone.removeElement(id);
		}
		
		//For the last element, don't print the space at the end
		if(v.getSize() == 1){ 
			Identifier id = v.someElement();
			for(int i=0; i<id.getSize(); i++){
				System.out.print(id.getChar(i));
			}
			v.removeElement(id);
		}
	}
	
	private boolean vraagVerzameling(String s, Verzameling v) {
		Scanner in;
		
		do { //lees eerste verzameling in
			in = new Scanner(System.in);
			in.useDelimiter("");
			v.init();
			System.out.print(s);
			if (in.hasNext() == false) {
				in.close();
				return false;
			}
		} while (leesVerzamelingIn(v, in) == false);
		
		return true;
		
	}
	
	private boolean vraagInvoer(Verzameling v1, Verzameling v2) {
		return vraagVerzameling("Geef eerste verzameling: ", v1) && vraagVerzameling("Geef tweede verzameling: ", v2);
	}
	
	private void start(){
		Verzameling v1 = new Verzameling(),
					v2 = new Verzameling();
		while(vraagInvoer(v1, v2)){
			Verzameling v1Clone = v1.clone();
			v1Clone = v1Clone.verschil(v2);
			System.out.print("Verschil: {");
			print(v1.verschil(v2));
			print(v1);
			System.out.println('}');
			
			v1Clone = v1.clone();
			v1Clone = v1Clone.doorsnede(v2);
			System.out.print("Doorsnede: {");
			print(v1Clone);
			System.out.println('}');
			
			v1Clone = v1.clone();
			v1Clone = v1Clone.vereniging(v2);
			System.out.print("Vereniging: {");
			print(v1Clone);
			System.out.println('}');
			
			v1Clone = v1.clone();
			v1Clone = v1Clone.symmetrischVerschil(v2);
			System.out.print("Symmetrisch verschil: {");
			print(v1Clone);
			System.out.println('}');
		}
	}
	
	public static void main(String[] args) {
		new Main().start();
	}

}
