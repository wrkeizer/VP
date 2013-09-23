package assignment2;

/** ADT for class Node.
*
* @author Floris Golbach & Wisse Keizer
*
* @elementen
* 	Objects of type Node.
* @structuur
* 	Linked with prior and next Node object.
* @domein
* 	Data of some type.
*
* @constructor
* 	Node(E d);
* 		<dl>
* 		<dt><b>PRE:</b><dd> -
* 		<dt><b>POST:</b><dd> The content of the new Node object is a copy of some data d.
* 		</dl>
*  <br>
*  Node(E d, Node<E> prior, Node<E> next);
* 		<dl>
* 		<dt><b>PRE:</b><dd> -
* 		<dt><b>POST:</b><dd> The content of the new Node object contains copies of some data d and Nodes prior and next.
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
