package opgave2;

class Node<E extends Data> implements Clonable {

	E data;
	Node<E> prior,
			next;


	public Node (E d) {
		this(d, null, null);
	}


	public Node (E data, Node<E> prior, Node<E> next) {
		this.data = data == null ? null : (E) data.clone();
		this.prior = prior;
		this.next = next;
	}

	
	public Node<E> clone () {
		Node<E> prior = this.prior == null ? null : this.prior.clone();
		Node<E> next = this.next == null ? null : this.next.clone();
		
		return new Node<E>(data, prior, next);
	}
}
