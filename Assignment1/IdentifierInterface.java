package assignment1;

/** ADT voor de class Identifier.
 *
 * @author Floris Golbach & Wisse Keizer
 * @elementen
 *  characters van het type char
 * @structuur
 *	lineair
 * @domein
 *	alle strings met minstens één character, bestaande uit alfanumerieke characters en beginnende met een letter
 * @constructor
 *	Identifier();
 *	    <dl>
 *		<dt><b>PRE-conditie</b><dd>-
 *		<dt><b>POST-conditie</b><dd>Het nieuwe
 *		Indentifier-object bevat een StringBuffer met een dummy character.
 *	    </dl>
 *	<br>
 *	Identifier (Identifier src);
 *	    <dl>
 *		<dt><b>PRE-conditie</b><dd>-
 *		<dt><b>POST-conditie</b><dd>Het nieuwe
 *		Identifier-object bevat een kopie van de inhoud van src.
 *	    </dl>
 **/

public interface IdentifierInterface {
    
    /** Initialiseert het Identifier object tot een identifier met één character.
     * @preconditie
     *	    c is een letter a-Z.
     * @postconditie
     *	    De identifier is geinitaliseerd en bevat een StringBuffer met een kopie van character c.
     **/
    void init (char c);
    
    /** Voegt een character toe aan de identifier
     * @preconditie
     *	    c is een letter a-Z of een cijfer 0-9.
     * @postconditie
     *	    Aan de StringBuffer van het identifier-object is een kopie van character c toegevoegd.
     **/
    void addChar(char c);
    
    
    /** Retourneert de naam van het identifier-object
     * @preconditie
     *	    De identifier is geïnitialiseerd.
     * @postconditie
     *	    Een kopie van de StringBuffer van het identifier-object is geretourneerd
    **/
    StringBuffer getName();
    
    //todo?
    //void setName(StringBuffer s);
    //void addString(StringBuffer s);
    //int getSize();
    //void removeChar();
    
}
