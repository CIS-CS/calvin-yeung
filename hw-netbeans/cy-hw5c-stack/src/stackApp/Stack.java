package stackApp;

public class Stack<E> {
	private Plate<E> top;
	private int size;
	
	public Stack() {
		top = null;
		size = 0;
	}
	
	public void push(E item) {
		Plate<E> p = new Plate(item);
		p.setUnder(top);
		top = p;
		
		size++;
	}
	
	public E pop() {
		E item = null;
		
		if(top != null) {
			Plate<E> u = top.getUnder();
			item = top.getItem();
			top.setUnder(null);
			top = u;
			
			size--;
		}
		
		return item;
	}
	
	public E peek() {
		if(top != null)
			return top.getUnder().getItem();
		else
			return null;
	}
	
	public int size() {
		return size;
	}
}