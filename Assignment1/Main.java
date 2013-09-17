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
	
<<<<<<< HEAD
	private boolean leesInvoerIn(Verzameling v1, Verzameling v2) {

		Scanner in;
		
		do { //lees eerste verzameling in
			in = new Scanner(System.in);
=======
	private boolean is1Correct(Verzameling v){				
		boolean valid = false;		
		while(valid == false){
			Scanner in = new Scanner(System.in);
>>>>>>> 6f9b71bf59ba93d4f5d2ac9171172635b0e3492b
			in.useDelimiter("");
			v1.init();
			System.out.print("Geef eerste verzameling: ");
			if (in.hasNext() == false) {
				in.close();
				return false;
<<<<<<< HEAD
			}
		} while (!leesVerzamelingIn(v1, in));
		
		do { //lees tweede verzameling in
			in = new Scanner(System.in);
=======
			} 
			
			if(nextCharIs(in, '{')){
				in.next(); //Get rid of '{'
				
				start:
				while(in.hasNext()){
					
					if(nextCharIs(in, '}')){
						if(v.getSize() < 11){
							valid = true;
							break;
						}else {
							System.out.println("Verzameling heeft meer dan 10 elementen");
							break;
						}
					}
					
					if(nextCharIsLetter(in)){
						Identifier id = readIdentifier(in);
						if (!(nextCharIs(in, ' ') || nextCharIs(in, '}'))) {
							if(nextCharIs(in, '\n') || nextCharIs(in, '\r')){
								System.out.println("'}' is missing");
								break start;
							}
							System.out.println("Identifier mag alleen bestaan uit letters en cijfers");
							break start;
						}
						
						/* is nu overbodig? 
						Identifier id = new Identifier();
						id.init(readChar(in));
						while(!(nextCharIs(in, ' ') || nextCharIs(in, '}'))){
							if(nextCharIs(in, '\n') || nextCharIs(in, '\r')){
								System.out.println("'}' is missing");
								break start;
							}
							if(nextCharIsLetter(in) || nextCharIsDigit(in)){
								id.addChar(readChar(in));
							}else{
								System.out.println("Identifier mag alleen bestaan uit letters en cijfers");
								break start;
							}
						}  
						*/
						
						if(nextCharIs(in, ' ')){
							in.next(); //Read away space
						}
						try{
							v.addElement(id);
						}
						catch(Exception e){
							break;
						}
					}else{
						System.out.println("Identifier moet beginnen met een letter.");
						break;
					}
					
				}
			}else System.out.println("Verzamling moet beginnen met een '{'");
		}
		//System.out.println(v.someElement().name);//Fout
	
		return true;
	}
	
	private boolean is2Correct(Verzameling v){				
		boolean valid = false;
		while(valid == false){
			Scanner in = new Scanner(System.in);
>>>>>>> 6f9b71bf59ba93d4f5d2ac9171172635b0e3492b
			in.useDelimiter("");
			v2.init();
			System.out.print("Geef tweede verzameling: ");
<<<<<<< HEAD
			if (in.hasNext() == false) {
				in.close();
				return false;
			}
		} while (!leesVerzamelingIn(v2, in));
		
=======
			
			if (in.hasNext() == false) {
				in.close();
				return false;
			} 
			
			if(nextCharIs(in, '{')){
				in.next(); //Get rid of '{'
				
				start:
				while(in.hasNext()){
					
					if(nextCharIs(in, '}')){
						if(v.getSize() < 11){
							valid = true;
							break;
						}else {
							System.out.println("Verzameling heeft meer dan 10 elementen");
							break;
						}
					}
					
					if(nextCharIsLetter(in)){
						Identifier id = readIdentifier(in);
						if (!(nextCharIs(in, ' ') || nextCharIs(in, '}'))) {
							if(nextCharIs(in, '\n') || nextCharIs(in, '\r')){
								System.out.println("'}' is missing");
								break start;
							}
							System.out.println("Identifier mag alleen bestaan uit letters en cijfers");
							break start;
						}
						
						/* is nu overbodig? 
						Identifier id = new Identifier();
						id.init(readChar(in));
						while(!(nextCharIs(in, ' ') || nextCharIs(in, '}'))){
							if(nextCharIs(in, '\n') || nextCharIs(in, '\r')){
								System.out.println("'}' is missing");
								break start;
							}
							if(nextCharIsLetter(in) || nextCharIsDigit(in)){
								id.addChar(readChar(in));
							}else{
								System.out.println("Identifier mag alleen bestaan uit letters en cijfers");
								break start;
							}
						}  
						*/
						
						if(nextCharIs(in, ' ')){
							in.next(); //Read away space
						}
						try{
							v.addElement(id);
						}
						catch(Exception e){
							break;
						}
					}else{
						System.out.println("Identifier moet beginnen met een letter.");
						break;
					}
					
				}
			}else System.out.println("Verzamling moet beginnen met een '{'");
		}
		//System.out.println(v.someElement().name);//Fout	
>>>>>>> 6f9b71bf59ba93d4f5d2ac9171172635b0e3492b
		return true;
	}
	
	private void start(){
		Verzameling v1 = new Verzameling(),
					v2 = new Verzameling();
<<<<<<< HEAD
		while(leesInvoerIn(v1, v2)){
=======
		while(readyToGo(v1, v2)){
>>>>>>> 6f9b71bf59ba93d4f5d2ac9171172635b0e3492b
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
<<<<<<< HEAD
=======
			
>>>>>>> 6f9b71bf59ba93d4f5d2ac9171172635b0e3492b
		}
	}
	
	public static void main(String[] args) {
		new Main().start();
	}

}
