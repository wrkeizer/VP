/**
 *
 * @author Floris Golbach & Wisse Keizer
 *
 * @elementen
 * 	Een verzameling van Identifiers
 * @structuur
 * 	Linear
 * @domein
 * 	0 Tot 10 elementen
 *
 * @constructor
 * 	Verzameling();
 * 		<dl>
 * 		<dt><b>PRE:</b><dd> -
 * 		<dt><b>POST:</b><dd> De inhoud van het nieuwe object is een lege verzameling.
 * 		</dl>
 * 
 *
 *  Verzameling(Verzameling src);
 * 		<dl>
 * 		<dt><b>PRE:</b><dd> -
 * 		<dt><b>POST:</b><dd> De inhoud van het nieuwe object is een kopie van het src-object.
 * 		</dl>
 */
 public interface VerzamelingInterface{
	
	/** Initialiseert het IdentifierStack object tot de lege verzameling.
     * @preconditie
     *	    -
     * @postconditie
     *	    De verzameling is leeg.
     **/
    void init ();
	
	/** Voegt een Identifier aan de verzameling toe.
     * @preconditie
     *	    -
     * @postconditie
     *	    Een kopie van element is als laatste element aan de verzameling toegevoegd.
     **/
    void push (Identifier element);


    /** Verwijdert een Identifier uit de verzameling.
     * @preconditie
     *	    De verzameling is niet leeg.
     * @postconditie
     *	    Het laatste element van de verzameling-PRE is geretourneerd en verwijderd.
     **/
    Identifier pop ();


    /** Retourneert het laatste element van de verzameling.
     * @preconditie
     *	    De verzameling is niet leeg.
     * @postconditie
     *	    Een kopie van het laatste element van de verzameling-PRE is geretourneerd.
     **/
    Identifier top ();


    /** Retourneert of de verzameling leeg is.
     * @preconditie
     *	    -
     * @postconditie
     *	    true: het aantal elementen op de verzameling == 0.<br>
     *	    false: het aantal elementen op de verzameling &gt; 0.
     **/
    boolean isEmpty ();


    /** Retourneert het aantal elementen van de verzameling.
     * @preconditie
     *	    -
     * @postconditie
     *	    Het aantal elementen van de verzameling is geretourneerd.
     **/
    int size ();
}