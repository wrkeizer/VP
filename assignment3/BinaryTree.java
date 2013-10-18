package assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTree<E extends Data> implements BinaryTreeInterface<E>{
		
	private ArrayList<E> al;
	private BinaryTree<E> leftChild, rightChild;
	private E data;
	
	BinaryTree(){
		init();
	}
	
	public BinaryTree<E> init(){
		al = new ArrayList<E>();
		leftChild = rightChild = null;
		return this;
	}
	
	public BinaryTree<E> insert(E d){
		if(data == null){
			data = d;
		}else if(data.compareTo(d) > 0){
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
				
		return this;
	}
	
	public BinaryTree<E> remove(E d){
		if(contains(d)){
			if(data.compareTo(d) == 0){
				data = null;
			}else if(data.compareTo(d) == -1){
				leftChild.remove(d);
			}else rightChild.remove(d);
		}
		
		return this;
		//N.B.: does not yet restructure tree after deletion!
	}
	
	public boolean contains(E d){
		if(data == null){
			return false;
		}
		if(data.compareTo(d) == 0){
			return true;
		}if(data.compareTo(d) > 0){
			if(leftChild == null){
				return false;
			}
			return leftChild.contains(d);
		}else{
			if(rightChild == null){
				return false;
			}return rightChild.contains(d);		
		}
	}
	
	public Iterator<E> ascendingIterator(){
		if(!(leftChild == null)){
			Iterator<E> left = leftChild.ascendingIterator();
			while(left.hasNext()){
				al.add(left.next());
			}
		}
		
		al.add(data);
		
		if(!(rightChild == null)){
			Iterator<E> right = rightChild.ascendingIterator();
			while(right.hasNext()){
				al.add(right.next());
			}
		}
		
		return al.iterator();		
	}
	
	public Iterator<E> descendingIterator(){
		if(!(rightChild == null)){
			Iterator<E> right = rightChild.descendingIterator();
			while(right.hasNext()){
				al.add(right.next());
			}
		}
		
		al.add(data);
		
		if(!(leftChild == null)){
			Iterator<E> left = leftChild.descendingIterator();
			while(left.hasNext()){
				al.add(left.next());
			}
		}
				
		return al.iterator();	
	}
}
