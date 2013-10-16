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
	
	private void removeSeparators(Scanner in){
		while(nextCharIsSeparator(in)){
			in.next(); // Read away separator
		}
	}
	
	private boolean nextCharIsDigit (Scanner in) {
		return in.hasNext("[0-9]");
	} 
	
	private boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}
	
	private boolean nextCharIsSeparator(Scanner in){
		return !(nextCharIsLetter(in) || nextCharIsDigit(in));
	}
	
	private Identifier readIdentifier(Scanner in){
		Identifier id = new Identifier();
		id.init(nextChar(in));
		while (!nextCharIsSeparator(in)) {
			id.addChar(nextChar(in));
		}
		return id;
	}
	
	private Identifier readNaturalNumber(Scanner in){
		Identifier id = new Identifier();
		id.init(nextChar(in));
		while (nextCharIsDigit(in)) {
			id.addChar(nextChar(in));
		}
		return id;
	}
	
	BinaryTree<E> readFile(String file) throws APException{
		BinaryTree<E> identifiers = new BinaryTree<E>();
		while(in.hasNext()){
			removeSeparators(in);
			
			if(nextCharIsLetter(in)){
				identifiers.add(readIdentifier(in));
			}else {
				readNaturalNumber(in);
				if(!nextCharIsSeparator(in)){
					throw new APException("Number should be followed by a separator.");
				}
			}			
		}
		return identifiers;
	}
	
	void start(String[] args){
		BinaryTree<E>[] files = new BinaryTree<E>[args.length];
		for(int i = 0; i < args.length; i++){
			try{
				files[i] = readFile(args[i]);
			}
			catch(APException e){
				out.println(e.getMessage());
				System.exit(0); // This program should quit in case of an error right?
//				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().start(args);
	}

}
