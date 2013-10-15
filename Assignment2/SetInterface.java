package assignment2;

/** ADT for the class Set.
 *
 * @author Floris Golbach & Wisse Keizer
 *
 * @elementen
 * 	Objects of type E
 * @structuur
 * 	Geen
 * @domein
 * 	All combinations of objects of type E are valid values for a Set
 *
 * @constructor
 * 	Set();
 * 		<dl>
 * 		<dt><b>PRE:</b><dd> -
 * 		<dt><b>POST:</b><dd> The content of the new object is an empty set.
 * 		</dl>
 *  <br>
 **/
 public interface SetInterface<E extends Data> extends Clonable{
	 
	/** Initializes the Set-object to be an empty set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The set is empty.
     **/
    void init ();
	
	/** Adds an element to the set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The set contains an element equal to d.
     **/
    void addElement(E d);


    /** Deletes an element from the set.
     * @preconditie
     *	    -
     * @postconditie
     *	    There is no element in the set equal to d.
     **/
    void removeElement(E d);


    /** Returns an element from the set.
     * @preconditie
     *	    The set is not empty.
     * @postconditie
     *	    A copy of one of the elements from the set has been returned.
     **/
    E someElement();


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
     *	    The new Set contains a copy of all elements present in the own set, but not in v.
     **/     
    Set<E> difference(Set<E> v);
    
    
    /** Returns a new Set containing the intersection of the own and given set.
     * @preconditie
     *	    -
     * @postconditie
     * 		The new Set contains a copy of all elements present in both the own set as in v.
     **/     
    Set<E> intersection(Set<E> v);
    
    
    /** Returns a new Set containing the union of the own and given set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The new Set contains a copy of all elements present in either the own set or in v.
     **/
    Set<E> union(Set<E> v);
    
    
    /** Returns a new Set containing the symmetric difference of the own and given set.
     * @preconditie
     *	    -
     * @postconditie
     *	    The new Set contains a copy of all elements present in either the own set or in v, but not both.
     **/    
    Set<E> symmetricDifference(Set<E> v);
}
