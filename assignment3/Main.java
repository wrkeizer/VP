package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import assignment2.N;

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
		while(in.hasNext() && nextCharIsSeparator(in)){
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
		return !(nextCharIsLetter(in) || nextCharIsDigit(in)) && in.hasNext();
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
		lineScanner.useDelimiter("");
		
		removeSeparators(lineScanner);
		while(lineScanner.hasNext()){
			
			if(nextCharIsLetter(lineScanner)){
				tree.insert(readWord(lineScanner));
			}else {
				readWord(lineScanner); //Read away non-identifier.
			}			
			removeSeparators(lineScanner);
		}
	}
	
	private void readFile(String file, boolean lowerCase) throws APException{		
		BufferedReader br = null;
		String currentLine;
		try{
			br = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e){
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
				System.out.println(e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		
		printTree(!descending);
		
	}
	
	void printTree(boolean descending) {
		Iterator<Identifier> it;		
		if(!descending){
			it = tree.descendingIterator();
		}else it = tree.ascendingIterator();
		
		while(it.hasNext()) {
			Identifier id = it.next();
			int counter = 1;
			while(it.hasNext() && id.compareTo(it.next()) == 0) {
				counter++;
			}
			if (counter % 2 == 1) {
				printIdentifier(it.next());
				System.out.println();
			}
		}
	}
	

	private void printIdentifier(Identifier id) {
		for (int i = 0; i < id.getSize(); i++) {
			out.print(id.getChar(i));
		}
	}
	
	public static void main(String[] args) {
		new Main().start(args);
	}
}
