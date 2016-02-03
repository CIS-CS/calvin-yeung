/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author Zephyr
 */
public class DoubleNode<T> {
	private T item;
	private DoubleNode<T> previous, next;
	
	public DoubleNode(T item) {
		this.item = item;
		this.previous = null;
		this.next = null;
	}
	
	public DoubleNode<T> getPrevious() {
		return previous;
	}
	
	public DoubleNode<T> getNext() {
		return next;
	}
	
	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}
	
	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}
	
	public T getItem() {
		return item;
	}
	
	public void setItem(T item) {
		this.item = item;
	}
}
