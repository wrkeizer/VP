package assignment1;

/** ADT voor de class Verzameling.
 *
 * @author Floris Golbach & Wisse Keizer
 *
 * @elementen
 * 	objecten van het type Identifier
 * @structuur
 * 	Geen
 * @domein
 * 	0 Tot 20 identifiers
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
 * 		<dt><b>POST:</b><dd> Het nieuw gemaakte Verzameling-object bevat een kopie van de inhoud van src.
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
     *	    -
     * @postconditie
     *	    In de verzameling zit een identifier met dezelfde inhoud als id.
     * @exception
     * 		als de nieuwe verzameling meer dan 20 elementen bevat.
     **/
    void addElement(Identifier id) throws Exception;


    /** Verwijdert een Identifier uit de verzameling.
     * @preconditie
     *	    -
     * @postconditie
     *	    In de verzameling zit geen element met dezelfde inhoud als id.
     **/
    void removeElement(Identifier id);


    /** Retourneert een element van de verzameling.
     * @preconditie
     *	    De verzameling is niet leeg.
     * @postconditie
     *	    Een kopie van een van de elementen van de verzameling is geretourneerd.
     **/
    Identifier someElement();


    /** Retourneert het aantal elementen van de verzameling.
     * @preconditie
     *	    -
     * @postconditie
     *	    Het aantal elementen van de verzameling is geretourneerd.
     **/
    int getSize();
    
    
    /** Retourneert een nieuwe Verzameling met daarin het verschil van de eigen en de meegegeven verzameling.
     * @preconditie
     *	    -
     * @postconditie
     *	    De nieuwe Verzameling bevat een kopie van alle Identifiers die wel in de eigen verzameling, maar niet in v zitten.
     **/     
    Verzameling verschil(Verzameling v);
    
    
    /** Retourneert een nieuwe Verzameling met daarin de doorsnede van de eigen en de meegegeven verzameling.
     * @preconditie
     *	    -
     * @postconditie
     * 		De nieuwe Verzameling bevat een kopie van alle Identifiers die zowel in de eigen verzameling als in v zitten.
     **/     
    Verzameling doorsnede(Verzameling v);
    
    
    /** Retourneert een nieuwe Verzameling met daarin het vereniging van de eigen en de meegegeven verzameling.
     * @preconditie
     *	    -
     * @postconditie
     *	    De nieuwe Verzameling bevat een kopie van alle Identifiers die in de eigen verzameling of in v zitten.
     * @exception
     * 		Als de vereniging meer dan 20 elemten bevat.
     **/
    Verzameling vereniging(Verzameling v) throws Exception;
    
    
    /** Retourneert een nieuwe Verzameling met daarin het symmetrisch verschil van de eigen en de meegegeven verzameling.
     * @preconditie
     *	    -
     * @postconditie
     *	    De nieuwe Verzameling bevat een kopie van alle Identifiers die in de eigen verzameling of in v ziten, maar niet in allebei.
     * @exception
     * 		Als het symmetrisch verschil meer dan 20 elemten bevat.
     **/    
    Verzameling symmetrischVerschil(Verzameling v) throws Exception;
}