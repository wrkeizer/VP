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
	
	/** @preconditie  - c is a number 1-9.
	 *	@postconditie - The N object is initialized to contain an initial digit c.
	 */
	public N init(char c);
	
	/** @preconditie  - c is a digit 0-9.
	 *	@postconditie - c has been added at the end of the number.
	 *		
	 */
	public void addDigit(char c);
	
	/** @preconditie  - 0 < index < getLength()
	 *	@postconditie - The character at index index has been returned.
	 */
	public char getDigit(int index);
	
	/** @preconditie  - 
	 *	@postconditie - The numbers of characters has been returned.
	 */
	public int getLength();
	
}