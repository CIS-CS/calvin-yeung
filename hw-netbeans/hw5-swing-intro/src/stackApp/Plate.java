package stackApp;

public class Plate<E> {
	private Plate<E> under;
	private E item;
	
	public Plate(E item) {
		setItem(item);
		setUnder(null);
	}
	
	public E getItem() {
		return item;
	}
	
	public Plate<E> getUnder() {
		return under;
	}
	
	public void setItem(E item) {
		this.item = item;
	}
	
	public void setUnder(Plate<E> under) {
		this.under = under;
	}
}