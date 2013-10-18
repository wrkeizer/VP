package assignment2;

/** ADT for class Node.
*
* @author Floris Golbach & Wisse Keizer
*
* @elementen
* 	Objects of type E.
* @structuur
* 	None.
* @domein
* 	All elements of type E are valid data for a node. There may also be references to a prior and next node of the same type.
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
     *	    A deep copy of the Node object is returned.
     **/
	public Node<E> clone();
}
