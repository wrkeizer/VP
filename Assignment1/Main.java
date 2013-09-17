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

		while (nextCharIsSpace(in)) {
			in.next(); // remove (optional) whitespace
		}

		while(nextCharIs(in, '}') == false) { // read in identifiers
			if (v.getSize() == MAX_AANTAL_IDENTIFIERS_INPUT) {
				System.out.println("Verzameling heeft teveel elementen.");
				return false;
			}
			if (!nextCharIsLetter(in)) {
				System.out.println("Identifier moet beginnen met een letter.");
				return false;
			}
			Identifier id = readIdentifier(in); // read in individual identifier
			if(nextCharIs(in, '\n') || nextCharIs(in, '\r')){
				System.out.println("De '}' ontbreekt.");
				return false;
			}
			if (!(nextCharIs(in, ' ') || nextCharIs(in, '}'))) {
				System.out.println("Identifier mag alleen bestaan uit letters en cijfers.");
				return false;
			}
			v.addElement(id); // add identifier to set
			while (nextCharIsSpace(in)) {
				in.next(); // Read away space
			}
		}
		in.next(); // Lose the '}'
		return true;
	}
	
	private boolean nextCharIsSpace (Scanner in) {
		return in.hasNext(" ");
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
		while(v.getSize() > 1){
			Identifier id = v.someElement();
			for(int i=0; i<id.getSize(); i++){
				System.out.print(id.getChar(i));
			}
			System.out.print(" ");
			v.removeElement(id);
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
	
	private boolean leesInvoerIn(Verzameling v1, Verzameling v2) {

		Scanner in;
		
		do { //lees eerste verzameling in
			in = new Scanner(System.in);
			in.useDelimiter("");
			v1.init();
			System.out.print("Geef eerste verzameling: ");
			if (in.hasNext() == false) {
				in.close();
				return false;
			}
		} while (!leesVerzamelingIn(v1, in));
		
		do { //lees tweede verzameling in
			in = new Scanner(System.in);
			in.useDelimiter("");
			v2.init();
			System.out.print("Geef tweede verzameling: ");
			if (in.hasNext() == false) {
				in.close();
				return false;
			}
		} while (!leesVerzamelingIn(v2, in));
		
		return true;
	}
	
	private void start(){
		Verzameling v1 = new Verzameling(),
					v2 = new Verzameling();
		while(leesInvoerIn(v1, v2)){
			Verzameling v1Clone = v1.clone();
			v1Clone = v1Clone.verschil(v2);
			System.out.print("Verschil: {");
			print(v1Clone);
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
