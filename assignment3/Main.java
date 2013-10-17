package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.regex.Pattern;
import java.util.Scanner;

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
	
	private Identifier readWord(Scanner in){
		Identifier id = new Identifier();
		id.init(nextChar(in));
		while (!nextCharIsSeparator(in)) {
			id.addChar(nextChar(in));
		}
		return id;
	}
	
	private boolean isOption(String firstArg, String secondArg, String option) throws APException{
		if(firstArg.equals(secondArg) && firstArg.equals(option)){
			throw new APException("Option " + option + " has been called multiple times");			
		}
		
		if(firstArg.equals(option)){
			return true;
		}else if(secondArg.equals(option)){
			return true;
		}
		
		return false;		
	}
	
	private int determineStart(boolean lowerCase, boolean descending){
		if(!lowerCase && !descending){
			return 0;
		}else if(lowerCase ^ descending){
			return 1;
		}else return 2;
	}
	
	private BinaryTree<Identifier> readLine(BinaryTree<Identifier> tree, String line, boolean lowerCase, boolean descending){
		Scanner lineScanner = new Scanner(line);
		while(lineScanner.hasNext()){
			removeSeparators(lineScanner);
			
			if(nextCharIsLetter(lineScanner)){
				tree.add(readWord(lineScanner));
			}else {
				readWord(lineScanner); //Read away non-identifier.
			}			
		}
		return tree;
	}
	
	private BinaryTree<Identifier> readFile(String file, boolean lowerCase, boolean descending) throws APException{
		BinaryTree<Identifier> tree = new BinaryTree<Identifier>();		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String currentLine;

		while ((currentLine = br.readLine()) != null) {
			tree = readLine(tree, currentLine, lowerCase, descending);
		}
		return tree;
	}
	
	private void start(String[] args){
		boolean lowerCase, descending = false;
		try{
			lowerCase = isOption(args[0], args[1], "-i");
			descending = isOption(args[0], args[1], "-d");
		}
		catch(APException e){
			out.println(e.getMessage());
			System.exit(0); // This program should quit in case of an error right?
		}
		
		int startOfFiles = determineStart(lowerCase, descending);
		
		BinaryTree<Identifier>[] files = new BinaryTree<Identifier>[args.length-startOfFiles];
		for(int i = startOfFiles; i < args.length; i++){
			try{
				files[i] = readFile(args[i], lowerCase, descending);
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
