package assignment2;

/** ADT for class N.
*
* @author 
* 	Floris Golbach & Wisse Keizer
* @elementen
* 	A natural number.
* @structuur
* 	None.
* @domein
* 	All natural numbers.
*
* @constructor
* 
* 	N();
* 		<dl>
* 		<dt><b>PRE:</b><dd> -
* 		<dt><b>POST:</b><dd> The new N object is initialized to contain a placeholder value
* 		</dl>
*  <br>
* 
**/

public interface NInterface extends Data{
	
	/** @preconditie  - c is valid.
	 *	@postconditie - The N object is initialized to contain a placeholder value and has been returned.
	 */
	public N init(char c);
	
	/** @preconditie  - c is valid.
	 *	@postconditie - c has been added.
	 *		
	 */
	public void addChar(char c);
	
	/** @preconditie  -
	 *	@postconditie - The character at index index has been returned.
	 */
	public char getChar(int index);

	/** @preconditie  -
	 *	@postconditie - The numbers of characters has been returned.
	 */
	public int getLength();
	
	/** @preconditie  -
	 *	@postconditie - A deep-copy of N has been returned.
	 **/
	public N clone ();

	/** @preconditie  -
	 *	@postconditie - -1 Has been returned if the value of this object is smaller than the value of n,
	 *					0 if they're equal,
	 *					and 1 if the value of this object is larger.
	 **/
	public int compareTo(N n);
	
	
}