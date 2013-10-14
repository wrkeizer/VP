package assignment3;

public class BinaryTree<E extends Data> implements BinaryTreeInterface<E>{
	
	private BinaryTree<E> tree;
	
	BinaryTree(){
		init();
	}
	
	public BinaryTree<E> init(){
		tree = null;
		return this;
	}
	
	
}
