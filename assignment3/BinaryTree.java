package assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTree<E extends Data> extends ArrayList<E> implements BinaryTreeInterface<E>, Iterator<E>{
	
	private static final long serialVersionUID = 1L;	
	private BinaryTree<E> tree;
	
	BinaryTree(){
		init();
	}
	
	public BinaryTree<E> init(){
		tree = null;
		return this;
	}
	
	
}
