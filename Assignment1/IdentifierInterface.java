package assignment1;

/** ADT voor de class Ifentidier.
 *
 * @author Floris Golbach & Wisse Keizer
 * @elementen
 *  characters van het type char
 * @structuur
 *	lineair
 * @domein
 *	alle reeksen van alfanumerieke characters met minstens één character en beginnende met een letter
 * @constructor
 *	Identifier();
 *	    <dl>
 *		<dt><b>PRE-conditie</b><dd>-
 *		<dt><b>POST-conditie</b><dd>Het nieuwe
 *		Indentifier-object bevat een dummy character.
 *	    </dl>
 *	<br>
 *	Identifier (Identifier src);
 *	    <dl>
 *		<dt><b>PRE-conditie</b><dd>-
 *		<dt><b>POST-conditie</b><dd>Het nieuw gemaakte
 *		Identifier-object bevat een kopie van de inhoud van src.
 *	    </dl>
 **/

public interface IdentifierInterface {
    
    /** Initialiseert het Identifier object tot een identifier met één character.
     * @preconditie
     *	    c is een letter a-Z.
     * @postconditie
     *	    De identifier is geinitaliseerd en bevat character c.
     **/
    void init (char c);
    
    /** Voegt een character toe aan de identifier
     * @preconditie
     *	    c is een letter a-Z of een cijfer 0-9.
     * @postconditie
     *	    character c is toegevoegd aan de identifier.
     **/
    void addChar(char c);
        
    /** Retourneert een specifiek character van de identifier
     * @preconditie
     *	    index is kleiner dan de lengte van de identifier en niet kleiner dan 0. 
     * @postconditie
     *	    Het character op de gespecificeerde index van de identifier is geretourneerd.
    **/
    char getChar(int index);

    /** Retourneert de lengte van de identifier
     * @preconditie
     *	    - 
     * @postconditie
     *	    De lengte van de identifier is geretourneerd.
    **/
    int getSize();

    /** Retourneert of de identifiers aan elkaar gelijk zijn.
     * @preconditie
     *	    - 
     * @postconditie
     *	    Retourneert false als de identifiers niet aan elkaar gelijk zijn. 
     *		Retourneert true als de identifiers aan elkaar gelijk zijn.
    **/
    boolean equals(Identifier id);
    
}
