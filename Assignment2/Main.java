package assignment2;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	Scanner programScanner;
	PrintStream out;
	
	Table<Identifier, Set<N>> table;
	
	Main(){
		programScanner = new Scanner(System.in);
		programScanner.useDelimiter("");
		out = new PrintStream(System.out);
		table = new Table<Identifier, Set<N>>();
	}
	
	private char nextChar(Scanner in){ //--> Delimiter needs to be "" empty string
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
	
	private boolean nextCharIsAdditiveOperator(Scanner in) {
		return nextCharIs(in, '+') || nextCharIs(in, '-') || nextCharIs(in, '|');
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
	
	private Identifier readIdentifier(Scanner in) throws APException{
		Identifier id = new Identifier();
		removeWhitespace(in);
		if(!nextCharIsLetter(in)){
			throw new APException("Identifier should start with a letter."); //wrong invocation
		}
		id.init(nextChar(in));
		while (nextCharIsLetter(in) || nextCharIsDigit(in)) {
			id.addChar(nextChar(in));
		}
		return id;
	}
	
	private N readNaturalNumber(Scanner in) throws APException{
		N number = new N();
		
		removeWhitespace(in);
		if(!nextCharIsDigit(in)){
			throw new APException("Natural numbers should start with a digit"); //wrong invocation
		}
		
		if(nextCharIs(in, '0')){
			number.init(nextChar(in));
			if(!nextCharIsDigit(in)){
				return number;
			}
			throw new APException("Non-zero numbers must not start with '0'.");
		}
		
		number.init(nextChar(in));
		while (nextCharIsDigit(in)) {
			number.addDigit(nextChar(in));
		}
		return number;
	}
	
	private Set<N> readNumberSequence(Scanner in) throws APException{
		//Reads in a bunch of numbers.
		
		Set<N> set = new Set<N>();
		
		removeWhitespace(in);
		if(!nextCharIsDigit(in)){
			return set;
		}
		set.addElement(readNaturalNumber(in));
		removeWhitespace(in);
		while(nextCharIs(in, ',')) {
			in.next(); //read away ','
			removeWhitespace(in);
			if (!nextCharIsDigit(in)) {
				throw new APException("Problem reading number sequence: expected a ',' followed by a number.");
			}
			set.addElement(readNaturalNumber(in));
			removeWhitespace(in);
		}
		
		return set;
	}
	
	private Set<N> readSet(Scanner in) throws APException{
		//Reads a single set from the program.
		removeWhitespace(in);
		if (!nextCharIs(in, '{')){
			throw new APException("Set should start with '{'");
		}
		in.next(); //Read away '{'
		
		removeWhitespace(in);
		Set<N> set = readNumberSequence(in);
		
		removeWhitespace(in);
		if (!nextCharIs(in, '}')){
			throw new APException("Problem reading set: expected a number sequence followed by '}'");
		}
		in.next(); // Read away '}'
		
		return set;		
	}
	
	private Set<N> readComplexFactor(Scanner in) throws APException{
		//Reads a single complex factor from the program.
		removeWhitespace(in);
		if (!nextCharIs(in, '(')){
			throw new APException("Complex factor should start with '('");
		}
		in.next(); //Read away '('.
		
		removeWhitespace(in);
		Set<N> set = readExpression(in);
		
		removeWhitespace(in);
		if (!nextCharIs(in, ')')) {
			throw new APException("Problem reading complex factor: expected an expression followed by ')'");
		}
		in.next(); //Read away ')'.
		
		return set;
	}
	
	private Set<N> readFactor(Scanner in) throws APException{
		//Reads a single factor from the program.
		
		removeWhitespace(in);
		if (!in.hasNext()) {
			throw new APException("Factor should not be empty.");
		}
		
		if(nextCharIsLetter(in)){
			Identifier id = readIdentifier(in);
			Set<N> set = table.retrieve(id);
			
			if(set == null){
				throw new APException("Identifier is not associated with a set.");
			}
			return set;
		}

		if(nextCharIs(in, '(')){
			return readComplexFactor(in);
		}
		
		if(nextCharIs(in, '{')){
			return readSet(in);
		}
		
		throw new APException("Factor must be an identifier, complex factor or set.");
	}
	
	private Set<N> readTerm(Scanner in) throws APException{
		//Reads one or more factor(s), separated by a '*'.
		removeWhitespace(in);
		if (!in.hasNext()) {
			throw new APException("Term should not be empty.");
		}
		Set<N> set = readFactor(in);
		
		removeWhitespace(in);
		while(nextCharIs(in, '*')){
			in.next(); //Read away '*'.
			set = set.intersection(readFactor(in));
			removeWhitespace(in);
		}
		return set;
	}
	
	private Set<N> readExpression(Scanner in) throws APException{
		//Reads one or more term(s), separated by '+', '|' or '-' sign.
		removeWhitespace(in);
		if (!in.hasNext()) {
			throw new APException("Expression should not be empty.");
		}
		Set<N> set = readTerm(in);
		
		removeWhitespace(in);
		while(nextCharIsAdditiveOperator(in)){
			if(nextCharIs(in, '+')){
				in.next(); //Read away '+'.
				removeWhitespace(in);
				set = set.union(readTerm(in));
			}else if(nextCharIs(in, '-')){
				in.next(); //Read away '-'.
				removeWhitespace(in);
				set = set.difference(readTerm(in));
			}else if(nextCharIs(in, '|')){
				in.next(); //Read away '|'.
				removeWhitespace(in);
				set = set.symmetricDifference(readTerm(in));
			}
			removeWhitespace(in);
		}
		return set;
	}
	
	private void readAssignment(Scanner in) throws APException{
		//Reads a single assignment
		removeWhitespace(in);
		if(!nextCharIsLetter(in)) {
			throw new APException("Assignment should start with an identifier"); //wrong invocation
		}
		Identifier id = readIdentifier(in);
		
		removeWhitespace(in);
		if(nextCharIs(in, '=')){
			in.next(); //Read away '='
			removeWhitespace(in);
			Set<N> set = readExpression(in);
			if (in.hasNext()) {
				throw new APException("Problem reading assignment: expected an expression followed by <eoln>");
			}
			
			table.insert(id, set);
			
		}else{
			throw new APException("Problem reading assignment: expected an identifier followed by '='");
		}
	}
	
	private void readStatement(Scanner in) throws APException{
		//Reads a single statement
		in.useDelimiter(""); //<--This is important
		
		removeWhitespace(in); //ignore spaces
		
		//Empty in
		if(!in.hasNext()){
			throw new APException("Statement should not be empty.");
		}
		
		if(nextCharIs(in, '/')){
			//Commentary
			return;
		}
		
		if(nextCharIs(in, '?')){
			//Print-statement ('?' + expression)
			in.next(); //read away '?'
			removeWhitespace(in);
			Set<N> set = readExpression(in);
			
			removeWhitespace(in);
			if (in.hasNext()) {
				throw new APException("Problem reading print statement: expected an expression followed by <eoln>");
			}

			printSet(set);
			out.println();
			
			return;
		}
		
		if(nextCharIsLetter(in)){
			//Assignment
			readAssignment(in);
		} else {
			throw new APException("Statement must be an assignment, comment or print statement.");
		}
	}
	
	private void printNumber(N n) {
		for (int i = 0; i < n.getLength(); i++) {
			out.print(n.getDigit(i));
		}
	}
	
	private void printSet(Set<N> set) {
		Set<N> clone = set.clone();
		while (clone.getSize() > 0) {
			N n = clone.someElement();
			clone.removeElement(n);
			printNumber(n);
			out.print(" ");
		}
	}

	private void start(){
		while(programScanner.hasNext()){
			try{
				readStatement(new Scanner(programScanner.nextLine()));
			}
			catch(APException e){
				out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
}
