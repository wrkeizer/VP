package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
	
	BinaryTree<Identifier> tree;
	PrintStream out;
	
	Main(){
		tree = new BinaryTree<Identifier>();
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
	
	private void readLine(String line, boolean lowerCase){
		Scanner lineScanner = new Scanner(line);
		while(lineScanner.hasNext()){
			removeSeparators(lineScanner);
			
			if(nextCharIsLetter(lineScanner)){
				tree.insert(readWord(lineScanner));
			}else {
				readWord(lineScanner); //Read away non-identifier.
			}			
		}
	}
	
	private void readFile(String file, boolean lowerCase) throws APException{		
		BufferedReader br = null;
		String currentLine;
		try{
			br = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}

		try{
			while ((currentLine = br.readLine()) != null) {
				readLine(currentLine, lowerCase);
			}
			br.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	private void start(String[] args){
		boolean lowerCase = false, descending = false;
		
		
		/*
		 * TODO: Wisse kom eens van je luie reet
		 */
		try{
			lowerCase = isOption(args[0], args[1], "-i");
			descending = isOption(args[0], args[1], "-d");
		}
		catch(APException e){
			out.println(e.getMessage());
			System.exit(0); 
		}
		
		int startOfFiles = determineStart(lowerCase, descending);
		for(int i = startOfFiles; i < args.length; i++){
			try{
				readFile(args[i], lowerCase);
			}
			catch(APException e){
				out.println(e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		
		Iterator<Identifier> it;		
		if(descending){
			it = tree.descendingIterator();
		}else it = tree.ascendingIterator();
		
		//Check for oneven & print
	}
	
	public static void main(String[] args) {
		new Main().start(args);
	}
}
