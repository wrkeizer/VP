package assignment2;

/** ADT for the class Set.
 *
 * @author Floris Golbach & Wisse Keizer
 *
 * @elementen
 * 	Objects of type Identifier.
 * @structuur
 * 	Geen
 * @domein
 * 	0-20 Non-identical Identifiers.
 *
 * @constructor
 * 	Set();
 * 		<dl>
 * 		<dt><b>PRE:</b><dd> -
 * 		<dt><b>POST:</b><dd> The content of the new object is an empty set.
 * 		</dl>
 *  <br>
 *  Set(Set src);
 * 		<dl>
 * 		<dt><b>PRE:</b><dd> -The newly constructed Set-object contains a copy of the contents of src.
 * 		</dl>
 **/
 public interface SetInterface{
	 
	 /**Clones the Set-object.
	  * @preconditie
	  * 	-
	  * @postconditie
	  * 	A copy of the Set-object has been returned.	 
	  **/
	 Set clone();
	 
	/** Initializes the Set-object to be an empty set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The set is empty.
     **/
    void init ();
	
	/** Adds an Identifier to the set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The set contains an Identifier with the same content as id.
     * @exception
     * 	    If the set contains more than 20 elements.
     **/
    void addElement(Identifier id) throws ArrayIndexOutOfBoundsException;


    /** Deletes an Identifier from the set.
     * @preconditie
     *	    -
     * @postconditie
     *	    There is no element in the set with the same content as id.
     **/
    void removeElement(Identifier id);


    /** Returns an element from the set.
     * @preconditie
     *	    The set is not empty.
     * @postconditie
     *	    A copy of one of the elements from the set has been returned.
     **/
    Identifier someElement();


    /** Returns the number of elements in the set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The number of elements in the set has been returned.
     **/
    int getSize();
    
    
    /** Returns a new Set containing the difference of the own and given set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The new Set contains a copy of all Identifiers present in the own set, but not in v.
     **/     
    Set difference(Set v);
    
    
    /** Returns a new Set containing the intersection of the own and given set.
     * @preconditie
     *	    -
     * @postconditie
     * 		The new Set contains a copy of all Identifiers present in both the own set as in v.
     **/     
    Set intersection(Set v);
    
    
    /** Returns a new Set containing the union of the own and given set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The new Set contains a copy of all Identifiers present in either the own set or in v.
     **/
    Set union(Set v);
    
    
    /** Returns a new Set containing the symmetric difference of the own and given set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The new Set contains a copy of all Identifiers present in either the own set or in v, but not both.
     **/    
    Set symmetricDifference(Set v);
}
