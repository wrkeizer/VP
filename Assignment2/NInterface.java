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
	 *	@postconditie - //Dummy '0'
	 */
	public N init();
	
	/** @preconditie  -
	 *	@postconditie -
	 */
	public void addChar(char c);
	
	/** @preconditie  -
	 *	@postconditie - 
	 */
	public char getChar(int index);

	/** @preconditie  -
	 *	@postconditie - 
	 */
	public int getLength();
	
	/** @preconditie  -
	 *	@postconditie - A deep-copy of N has been returned.
	 **/
	public N clone ();

	/** @preconditie  -
	 *	@postconditie - 
	 **/
	public int compareTo(N n);
	
	
}