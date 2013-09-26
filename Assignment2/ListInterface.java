package assignment2;

/**	@elementen : objects of type E
 *	@structuur : lineair
 *	@domein : 	The elements in the list are sorted monotonically increasing. 
 *				All rows of elements of type E are valid values for a list.
 *       		For every non-empty list the reference current is pointing to an 
 *				element in the list.
 *	@constructor - List ();
 *	<dl>
 *		<dt><b>PRE-conditie</b><dd>		-
 *		<dt><b>POST-conditie</b><dd> 	The new List-object is the empty list.
 * </dl> 
 **/

public interface ListInterface<E extends Data> extends Clonable{

	/**	@preconditie - 
	 *  @postconditie - FALSE: list is not empty.
	 *  				TRUE:  list is empty.
	 **/
	boolean isEmpty ();

	/** @preconditie  - 
	 *	@postconditie - list-POST is empty and has been returned.
	 **/
	List<E> init ();

	/**	@preconditie  -
	 *	@postconditie - The number of elements has been returned.
	 **/
	int getSize ();

	/** @preconditie  -
	 *	@postconditie - A copy of d has been added to List-PRE.
	 *    				current points to the newly added element.
	 *   				list-POST has been returned.
	 **/
	List<E> insert (E d);


	/** @preconditie  - The list is not empty.
	 *	@postconditie - A copy of the value of the current element has been returned.
	 */
	E retrieve ();


	/** @preconditie  - The list is not empty.
	 * 	@postconditie - The current element of list-PRE is not present in list-POST.
	 * 	    			current-POST points to
	 *    					- if list-POST is empty
	 *   						null
	 *   					- if list-POST is not empty
	 *     						if current-PRE was the last element of list-PRE
	 *     							the last element of list-POST
	 *     						else 
	 *     							the element after current-PRE 
	 *  				list-POST has been returned.
	 **/
	List<E> remove ();


	/** @preconditie  - 
	 *	@postconditie - TRUE:  list contains a copy of d.
	 *	     			current-POST points to the first element in list that
	 *	     			contains a copy of d.
	 *     				FALSE: list does not contain a copy of d.
	 *	     			current-POST points to
	 *	      				- if list-POST is empty
	 *                    		null
	 *	      				- if the first element in list > d:
	 *                    		the first elmenent in list
	 *        				else
	 *	    					the last element in list with value < d
	 **/
	boolean find (E d);


	/** @preconditie  - 
	 *	@postconditie - FALSE: list is empty
	 *    				TRUE:  current points to the first element
	 *
	 **/
	boolean setFirst ();


	/**	@preconditie  - 
	 *	@postconditie - FALSE: list is empty
	 *     				TRUE:  current points to the last element
	 */
	boolean setLast ();


	/** @preconditie  - 
	 *	@postconditie - FALSE: list is empty or current points to the last element
	 *     				TRUE:  current-POST points to the next element of current-PRE
	 */
	boolean getNext ();


	/** @preconditie  - 
	 *	@postconditie - FALSE: list is empty of current points to the first element
	 *     				TRUE:  current-POST points to the prior element of current-PRE
	 */
	boolean getPrior ();

	/** @preconditie  -
	 *	@postconditie - A deep-copy of list has been returned.
	 **/
	public List<E> clone ();


}
