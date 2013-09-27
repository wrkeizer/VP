package assignment2;

/** ADT for class N.
*
* @author 
* 	Floris Golbach & Wisse Keizer
* @elementen
* 	A string which contains a natural number.
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
*  N(String s);
* 		<dl>
* 		<dt><b>PRE:</b><dd> s Should be a natural number.
* 		<dt><b>POST:</b><dd> The content of the new N object is a String with the value of s.
* 		</dl>
**/

public interface NInterface {
	
	/** @preconditie  -
	 *	@postconditie - A deep-copy of N has been returned.
	 **/
	public N clone ();
}