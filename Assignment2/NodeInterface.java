package assignment2;

/** ADT for class Node.
*
* @author Floris Golbach & Wisse Keizer
*
* @elementen
* 	Objects of type E.
* @structuur
* 	Linear linked with prior and next Node object.
* @domein
* 	E extends Data.
*
* @constructor
* 	Node(E d);
* 		<dl>
* 		<dt><b>PRE:</b><dd> -
* 		<dt><b>POST:</b><dd> The content of the new Node object is a copy of data d.
* 		</dl>
*  <br>
*  Node(E d, Node<E> prior, Node<E> next);
* 		<dl>
* 		<dt><b>PRE:</b><dd> -
* 		<dt><b>POST:</b><dd> The content of the new Node object contains a copy of data d and pointers to Nodes prior and next.
* 		</dl>
**/

public interface NodeInterface<E extends Data>{
	
	/** Copies the Node object
     * @preconditie
     *	    -
     * @postconditie
     *	    A copy of the Node object is returned.
     **/
	public Node<E> clone();
}
