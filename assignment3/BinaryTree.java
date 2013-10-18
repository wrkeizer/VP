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
	
	public boolean isEmpty(){
		return data == null;
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
	
	public Iterator<E> ascendingIterator(){
		if(!leftChild.isEmpty()){
			Iterator<E> left = leftChild.descendingIterator();
			while(left.hasNext()){
				al.add(left.next());
			}
		}
		
		al.add(data);
		
		if(!rightChild.isEmpty()){
			Iterator<E> right = rightChild.descendingIterator();
			while(right.hasNext()){
				al.add(right.next());
			}
		}
		
		return al.iterator();		
	}
	
	public Iterator<E> descendingIterator(){
		if(!rightChild.isEmpty()){
			Iterator<E> right = rightChild.descendingIterator();
			while(right.hasNext()){
				al.add(right.next());
			}
		}
		
		al.add(data);
		
		if(!leftChild.isEmpty()){
			Iterator<E> left = leftChild.descendingIterator();
			while(left.hasNext()){
				al.add(left.next());
			}
		}
				
		return al.iterator();	
	}
}
