package assignment3;

import java.util.Iterator;

/** ADT for the class BinaryTree.
 *
 * @author Floris Golbach & Wisse Keizer
 * 
 * @elementen
 *  Data of type E
 * @structuur
 *	Binary tree
 * @domein
 *	Each node in the tree has two children. 
 *	The value of left child's data is less than the parent's data, while the right's is equal or greater to the parent's.
 *
 * @constructor
 *	BinaryTree();
 *	    <dl>
 *		<dt><b>PRE-conditie</b><dd>-
 *		<dt><b>POST-conditie</b><dd>The new
 *		BinaryTree-object contains an empty tree.
 *	    </dl>
 *	<br>
 **/

public interface BinaryTreeInterface<E extends Data>{
	/**
	 * @preconditie  -
	 * @postconditie - 	The tree is initialized to be empty and has been returned.
	 **/
	BinaryTree<E> init();
	
	/**
	 * @preconditie  -
	 * @postconditie - 	A copy of d has been added to BinaryTree-PRE.
	 * 					BinaryTree-POST has been returned.
	 **/
	BinaryTree<E> insert(E d);
	
	/**
	 * @preconditie  -	
	 * @postconditie -	TRUE: BinaryTree contains a copy of d.
	 * 					FALSE: BinaryTree does not contain a copy of d.
	 **/
	boolean contains(E d);
	
	/** 
	 * @preconditie  -	
	 * @postconditie -	The in the binary search tree stored data have been run through in a 
	 * 					Monotone non-descending and have been inserted into a 
	 * 					object of type Iterator in this specific order.
	 * 					This object of type Iterator has been returned.
	 **/ 
	 Iterator<E> ascendingIterator (); 
	 
	 /** 
	 * @preconditie  -	
	 * @postconditie -	The in the binary search tree stored data have been run through in a 
	 * 					Monotone non-ascending and have been inserted into a 
	 * 					object of type Iterator in this specific order.
	 * 					This object of type Iterator has been returned.
	 **/ 
	 Iterator<E> descendingIterator ();
}
