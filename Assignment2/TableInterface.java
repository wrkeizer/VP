package assignment2;

/**	@elementen : key-value pairs of type KeyValuePair
 *	@structuur : lineair
 *	@domein : 	The elements in the table are sorted monotonically increasing by their key attribute.
 *				All rows of elements of type KeyValuePair with unique keys are valid values for a table.
 *       		For every non-empty table the reference current is pointing to an
 *				element in the table.
 *	@constructor - Table ();
 *	<dl>
 *		<dt><b>PRE-conditie</b><dd>		-
 *		<dt><b>POST-conditie</b><dd> 	The new Table-object is the empty table.
 * </dl> 
 **/

public interface TableInterface<E extends Data> extends Clonable{
	
	/**	@preconditie - 
	 *  @postconditie - FALSE: table is not empty.
	 *  				TRUE:  table is empty.
	 **/
	boolean isEmpty ();

	/** @preconditie  - 
	 *	@postconditie - Table-POST is empty and has been returned.
	 **/
	Table init ();

	/**	@preconditie  -
	 *	@postconditie - The number of elements has been returned.
	 **/
	int getSize ();

	/** @preconditie  -
	 *	@postconditie - A copy of p is present in Table-PRE.
	 *    				current points to the newly added element.
	 *   				Table-POST has been returned.
	 **/
	Table insert (KeyValuePair p);


	/** @preconditie  - The table is not empty.
	 *	@postconditie - A copy of the value of the current element has been returned.
	 */
	E retrieve ();


	/** @preconditie  - The table is not empty.
	 * 	@postconditie - The current element of table-PRE is not present in table-POST.
	 * 	    			current-POST points to
	 *    					- if table-POST is empty
	 *   						null
	 *   					- if table-POST is not empty
	 *     						if current-PRE was the last element of table-PRE
	 *     							the last element of table-POST
	 *     						else 
	 *     							the element after current-PRE 
	 *  				table-POST has been returned.
	 **/
	List<E> remove ();


	/** @preconditie  - 
	 *	@postconditie - TRUE:  table contains a keyvalue pair with key k
	 *	     			current-POST points to the element in table with key k
	 *     				FALSE: table does not contain a keyvaluepair with key k.
	 *	     			current-POST points to
	 *	      				- if table-POST is empty
	 *                    		null
	 *	      				- if the first element in table > d:
	 *                    		the first element in table
	 *        				else
	 *	    					the last element in table with value < d
	 **/
	boolean find (String k);


	/** @preconditie  - 
	 *	@postconditie - FALSE: table is empty
	 *    				TRUE:  current points to the first element
	 *
	 **/
	boolean setFirst ();


	/**	@preconditie  - 
	 *	@postconditie - FALSE: table is empty
	 *     				TRUE:  current points to the last element
	 */
	boolean setLast ();


	/** @preconditie  - 
	 *	@postconditie - FALSE: table is empty or current points to the last element
	 *     				TRUE:  current-POST points to the next element of current-PRE
	 */
	boolean getNext ();


	/** @preconditie  - 
	 *	@postconditie - FALSE: table is empty or current points to the first element
	 *     				TRUE:  current-POST points to the prior element of current-PRE
	 */
	boolean getPrior ();

	/** @preconditie  -
	 *	@postconditie - A deep-copy of table has been returned.
	 **/
	public Table clone ();
	
}