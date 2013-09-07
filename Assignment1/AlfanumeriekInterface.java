/**
 * 
 * @author Floris Golbach &amp; Wisse Keizer
 * 
 * @elementen 
 * 	Eén character
 * @structuur	
 * 	0-Dimensionaal
 * @domein
 * 	(Hoofd)letters en cijfers
 *
 * @constructor
 * 	Alfanumeriek(char c);
 * 		<dl>
 * 		<dt><b>PRE:</b><dd> Het character is alfanumeriek.
 * 		<dt><b>POST:</b><dd> De inhoud van het nieuwe object is een alfanumeriek character.
 * 		</dl>
 * 
 *  Alfanumeriek(Alfanumeriek src);
 * 		<dl>
 * 		<dt><b>PRE:</b><dd> -
 * 		<dt><b>POST:</b><dd> De inhoud van het nieuwe object is een kopie van het src-object.
 * 		</dl>
 */
public interface AlfanumeriekInterface {
    /** Retourneert het character.
     * @preconditie
     *	    -
     * @postconditie
     *	    Het character is geretourneerd.
     **/
	char value();
	
	/** Retourneert of het character een letter of getal is.
     * @preconditie
     *	    -
     * @postconditie
     *	    true: het character is een letter.<br>
     *	    false: het character is een getal.
     **/
    boolean isLetter ();
	
}