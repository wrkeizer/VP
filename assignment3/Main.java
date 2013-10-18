package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
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
	
	private void readFile(String file, boolean lowerCase){		
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
		
		int i = 0;
		while(args[i].equals("-i") || args[i].equals("-d")){
			if(args[i].equals("-i")){
				lowerCase = true;
			}else if(args[i].equals("-d")){
				descending = true;
			}
			i++;
		}
		
		for(int j = i; j < args.length; j++){
			readFile(args[i], lowerCase);
		}
		
		printTree(descending);		
	}
	
	void printTree(boolean descending) {
		Iterator<Identifier> iterator;		
		if(descending){
			iterator = tree.descendingIterator();
		}else iterator = tree.ascendingIterator();
		
		while(iterator.hasNext()){
			printIdentifier(iterator.next());
			System.out.println();
		}
		
//		while(iterator.hasNext()) {
//			Identifier id = iterator.next();
//			iterator.remove();
//			int counter = 1;
//			while(iterator.hasNext() && id.compareTo(iterator.next()) == 0) {
//				counter++;
//			}
//			if (counter % 2 == 1) {
//				printIdentifier(id);
//				System.out.println();
//			}
//		}
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
