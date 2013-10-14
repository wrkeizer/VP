package assignment2;

/** ADT for the class Identifier.
 *
 * @author Floris Golbach & Wisse Keizer
 * 
 * @elementen
 *  Characters of type char.
 * @structuur
 *	Lineair
 * @domein
 *	All series of alfanumeric characters containig at least one character and starting with a letter.
 *
 * @constructor
 *	Identifier();
 *	    <dl>
 *		<dt><b>PRE-conditie</b><dd>-
 *		<dt><b>POST-conditie</b><dd>The new
 *		Indentifier-object contains a dummy character.
 *	    </dl>
 *	<br>
 *	Identifier (Identifier src);
 *	    <dl>
 *		<dt><b>PRE-conditie</b><dd>-
 *		<dt><b>POST-conditie</b><dd>The new
 *		Identifier-object contains a copy of the contents of src.
 *	    </dl>
 **/

public interface IdentifierInterface {
    
    /** Initializes the Identifier-object to an identifier with one character.
     * @preconditie
     *	    c Is a letter a-Z.
     * @postconditie
     *	    The identifier has been initialized with a character c.
     **/
    void init (char c);
    
    /** Adds a character to the identifier.
     * @preconditie
     *	    c Is a letter a-Z or a number 0-9.
     * @postconditie
     *	    Character c has been added to the identifier.
     **/
    void addChar(char c);
        
    /** Returns a specific character of the identifier.
     * @preconditie
     *	    index is less than the identifier's length but not less than 0. 
     * @postconditie
     *	    The character at the specified index has been returned.
    **/
    char getChar(int index);

    /** Returns the identifier's length.
     * @preconditie
     *	    - 
     * @postconditie
     *	    The identifier's length has been returned.
    **/
    int getSize();

    /** Returns whether the identifiers are equal to eachother.
     * @preconditie
     *	    - 
     * @postconditie
     *	    Returns false if the identifiers are not equal to eachother.
     *		Returns true if the identifiers are equal to eachother.
    **/
    boolean equals(Identifier id);
    
}
