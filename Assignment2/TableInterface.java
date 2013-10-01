package assignment2;

/**	@elementen : key-value pairs
 *	@structuur : none
 *	@domein : 	 All sets of key-value pairs with unique keys are valid values for a table.
 *	@constructor - Table ();
 *	<dl>
 *		<dt><b>PRE-conditie</b><dd>		-
 *		<dt><b>POST-conditie</b><dd> 	The new Table-object is the empty table.
 * </dl> 
 **/

public interface TableInterface<K extends Data, V extends Clonable> extends Clonable{
	
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
	 *	@postconditie - A key-value pair with key k and value v exists in Table-POST.
	 *					If a key-value pair with key k existed in Table-PRE, it has been overwritten.
	 **/
	void insert (K k, V v);


	/** @preconditie  - The table is not empty.
	 *	@postconditie - A copy of the value corresponding to key k has been returned.
	 */
	V retrieve (K k);

	/** @preconditie  -
	 *	@postconditie - A deep-copy of table has been returned.
	 **/
	public Table clone ();
	
}