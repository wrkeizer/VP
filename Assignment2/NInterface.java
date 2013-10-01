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
	 *	@postconditie - The content of the new N object is a dummy character '0'.
	 */
	public N init();
	
	/** @preconditie  -
	 *	@postconditie - c is added to the StringBuffer.
	 *		
	 */
	public void addChar(char c);
	
	/** @preconditie  -
	 *	@postconditie - The character at index index is returned.
	 */
	public char getChar(int index);

	/** @preconditie  -
	 *	@postconditie - The length of the StringBuffer is returned.
	 */
	public int getLength();
	
	/** @preconditie  -
	 *	@postconditie - A deep-copy of N has been returned.
	 **/
	public N clone ();

	/** @preconditie  -
	 *	@postconditie - Returns -1 if the value of n is smaller than the value of this object,
	 *					0 if they're equal,
	 *					and 1 if the value of this object is larger.
	 **/
	public int compareTo(N n);
	
	
}