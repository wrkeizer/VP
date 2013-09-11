package assignment1;

/** ADT voor de class Verzameling.
 *
 * @author Floris Golbach & Wisse Keizer
 *
 * @elementen
 * 	Een verzameling objecten van het type Identifier
 * @structuur
 * 	Geen
 * @domein
 * 	0 Tot 20 elementen
 *
 * @constructor
 * 	Verzameling();
 * 		<dl>
 * 		<dt><b>PRE:</b><dd> -
 * 		<dt><b>POST:</b><dd> De inhoud van het nieuwe object is een lege verzameling.
 * 		</dl>
 *  <br>
 *  Verzameling(Verzameling src);
 * 		<dl>
 * 		<dt><b>PRE:</b><dd> -
 * 		<dt><b>POST:</b><dd> Het nieuwe Verzameling-object bevat een kopie van de inhoud van src.
 * 		</dl>
 **/
 public interface VerzamelingInterface{
	
	/** Initialiseert het Verzameling object tot de lege verzameling.
     * @preconditie
     *	    -
     * @postconditie
     *	    De verzameling is leeg.
     **/
    void init ();
	
	/** Voegt een Identifier aan de verzameling toe.
     * @preconditie
     *	    Geen element in de verzameling is gelijk aan id.
     * @postconditie
     *	    Aan de verzameling is een kopie van id toegevoegd.
     **/
    void addElement(Identifier id);


    /** Verwijdert een Identifier uit de verzameling.
     * @preconditie
     *	    De verzameling is niet leeg en er is een element in de verzameling gelijk aan id.
     * @postconditie
     *	    Uit de verzameling is het element dat gelijk is aan id verwijderd.
     **/
    void removeElement(Identifier id);


    /** Retourneert het laatste element van de verzameling.
     * @preconditie
     *	    De verzameling is niet leeg.
     * @postconditie
     *	    Een kopie van het laatste element van de verzameling-PRE is geretourneerd.
     **/
    Identifier top ();


    /** Retourneert het aantal elementen van de verzameling.
     * @preconditie
     *	    -
     * @postconditie
     *	    Het aantal elementen van de verzameling is geretourneerd.
     **/
    int size ();
    
    
    /** Retourneert een nieuwe Verzameling met daarin het verschil van de meegegeven Verzamelingen.
     * @preconditie
     *	    -
     * @postconditie
     *	    De nieuwe Verzameling bevat een kopie van alle Identifiers die wel in a maar niet in b zitten.
     **/     
    Verzameling verschil(Verzameling a, Verzameling b);
    
    
    /** Retourneert een nieuwe Verzameling met daarin de doorsnede van de meegegeven Verzamelingen.
     * @preconditie
     *	    -
     * @postconditie
     *	    De nieuwe Verzameling bevat een kopie van alle Identifiers die in a of b zitten.
     **/     
    Verzameling doorsnede(Verzameling a, Verzameling b);
    
    
    /** Retourneert een nieuwe Verzameling met daarin het verschil van de meegegeven Verzamelingen.
     * @preconditie
     *	    -
     * @postconditie
     *	    De nieuwe Verzameling bevat een kopie van alle Identifiers die zowel in a als b zitten.
     **/
    Verzameling vereniging(Verzameling a, Verzameling b);
    
    
    /** Retourneert een nieuwe Verzameling met daarin het verschil van de meegegeven Verzamelingen.
     * @preconditie
     *	    -
     * @postconditie
     *	    De nieuwe Verzameling bevat een kopie van alle Identifiers die wel in een van beide Verzamelingen zitten, maar niet in allebei.
     **/     
    Verzameling symnetrischVerschil(Verzameling a, Verzameling b);
}