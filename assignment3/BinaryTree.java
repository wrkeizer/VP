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
			data = (E)d.clone();
		}else if(data.compareTo(d) > 0){
			if(leftChild == null){
				leftChild = new BinaryTree<E>();
			}				
			leftChild.insert((E)d.clone());
		}else {
			if(rightChild == null){
				rightChild = new BinaryTree<E>();
			}
			rightChild.insert((E)d.clone());
		}
				
		return this;
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
	
	public ArrayList<E> ascendingArray(){
		if(!(leftChild == null)){
			for(int i = 0; i < leftChild.ascendingArray().size(); i++){
				al.add(leftChild.ascendingArray().get(i));
			}
		}
		
		al.add(data);

		if(!(rightChild == null)){
			for(int i = 0; i < rightChild.ascendingArray().size(); i++){
				al.add(rightChild.ascendingArray().get(i));
			}
		}
		return al;
	}
	
	public ArrayList<E> descendingArray(){
		if(!(rightChild == null)){
			for(int i = 0; i < rightChild.ascendingArray().size(); i++){
				al.add(rightChild.ascendingArray().get(i));
			}
		}
		
		al.add(data);
		
		if(!(leftChild == null)){
			for(int i = 0; i < leftChild.ascendingArray().size(); i++){
				al.add(leftChild.ascendingArray().get(i));
			}
		}
		return al;
	}
	
	public Iterator<E> ascendingIterator(){
		return ascendingArray().iterator();		
	}
	
	public Iterator<E> descendingIterator(){
		return descendingArray().iterator();	
	}
}
