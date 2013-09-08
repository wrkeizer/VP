/** ADT voor de class Identifier.
 *
 * @author Floris Golbach & Wisse Keizer
 * @elementen
 *	alfanumerieke characters van het type Alfanumeriek
 * @structuur
 *	lineair
 * @domein
 *	alle strings met minstens één character, bestaande uit alfanumerieke characters en beginnende met een letter
 * @constructor
 *	Identifier(Alfanumeriek[] characters);
 *	    <dl>
 *		<dt><b>PRE-conditie</b><dd>characters bevat minstens één element en het eerste element in characters is een aphabet-letter
 *		<dt><b>POST-conditie</b><dd>De inhoud van het nieuwe
 *		Indentifier-object is een string die precies de elementen van characters in dezelfde volgorde bevat.
 *	    </dl>
 *	<br>
 *	Identifier (Identifier src);
 *	    <dl>
 *		<dt><b>PRE-conditie</b><dd>-
 *		<dt><b>POST-conditie</b><dd>De inhoud van het nieuwe
 *		Identifier-object is een kopie van src.
 *	    </dl>
 **/
public interface GetalStackInterface {
    
    
    /** Initialiseert het Identifier object tot een lege identifier.
     * @preconditie
     *	    -
     * @postconditie
     *	    De stack is leeg.
     **/
    void init ();
    
}
