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
* 	N(int i);
* 		<dl>
* 		<dt><b>PRE:</b><dd> -
* 		<dt><b>POST:</b><dd> The content of the new N object is a String with the value of i.
* 		</dl>
*  <br>
**/

public interface NInterface extends Data{
	
	/** @preconditie  -
	 *	@postconditie - The content of the new N object has been initialized to contain a dummy character and has been returned.
	 */
	public N init();
	
	/** @preconditie  -
	 *	@postconditie - c has been added to the String.
	 *		
	 */
	public void addChar(char c);
	
	/** @preconditie  -
	 *	@postconditie - The character at index index has been returned.
	 */
	public char getChar(int index);

	/** @preconditie  -
	 *	@postconditie - The length of the String has been returned.
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