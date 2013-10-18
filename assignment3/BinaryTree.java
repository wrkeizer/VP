package assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTree<E extends Data> implements BinaryTreeInterface<E>{
		
	private BinaryTree<E> leftChild, rightChild;
	E data;
	
	BinaryTree(){
		init();
	}
	
	public BinaryTree<E> init(){
		leftChild = rightChild = null;
		return this;
	}
	
	public BinaryTree<E> insert(E d){
		if(contains(d)){
			if(data == null){
				data = d;
			}else if(data.compareTo(d) == -1){
				if(leftChild == null){
					leftChild = new BinaryTree<E>();
				}				
				leftChild.insert(d);
			}else {
				if(rightChild == null){
					rightChild = new BinaryTree<E>();
				}
				rightChild.insert(d);
			}
		}else data = d;
		
		return this;
	}
	
	public BinaryTree<E> remove(E d){
		if(contains(d)){
			if(data == null){
				data = d;
			}else if(data.compareTo(d) == -1){
				leftChild.remove(d);
			}else rightChild.remove(d);
		}
		
		return this;
		//N.B.: does not yet restructure tree after deletion!
	}
	
	public boolean contains(E d){
		return data == d || leftChild.contains(d) || rightChild.contains(d);
	}
	
	public Iterator ascendingIterator(){
		
	}
	
	public Iterator descendingIterator(){
		
	}
}
