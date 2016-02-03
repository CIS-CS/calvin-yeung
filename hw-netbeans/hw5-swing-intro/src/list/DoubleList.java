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
public class DoubleList<T> {
	private DoubleNode<T> head, tail, current;
	private int size;
	
	public DoubleList() {
		head = null;
		tail = null;
		current = null;
		size = 0;
	}
	
	public void insertHead(T item) {
		DoubleNode<T> node = new DoubleNode<T>(item);
		
		if(!isEmpty()) {
			head.setPrevious(node);
			node.setNext(head);
			head = node;
			size++;
		}
		
		else insert(item);
	}
	
	public void insertTail(T item) {
		DoubleNode<T> node = new DoubleNode<T>(item);
		
		if(!isEmpty()) {
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
			size++;
		}
		
		else insert(item);
	}
	
	public void insert(T item) {
		DoubleNode<T> node = new DoubleNode<T>(item);
		
		if(isEmpty()) {
			head = node;
			tail = node;
			current = node;
			size++;
		}
		
		else {
			if(current.getNext() == null) {
				insertTail(item);
			}
			
			else {
				current.getNext().setPrevious(node);
				node.setNext(current.getNext());
				node.setPrevious(current);
				current.setNext(node);
				
				size++;
			}
		}
	}
	
	public void remove() {
		if(size() == 1) {
			head = null;
			tail = null;
			current = null;
			size = 0;
		}
		
		if(size() > 1) {
			if(current == head) {
				DoubleNode<T> n = head.getNext();
				head.setNext(null);
				n.setPrevious(null);
				head = n;
			}
			
			else if(current == tail) {
				DoubleNode<T> n = tail.getPrevious();
				tail.setPrevious(null);
				n.setNext(null);
				tail = n;
			}
			
			else {
				DoubleNode<T> p = current.getPrevious();
				DoubleNode<T> n = current.getNext();
				p.setNext(n);
				n.setPrevious(p);
				current.setNext(null);
				current.setPrevious(null);
				current = p;
			}
		}
		
		size--;
	}
	
	public T getCurrent() {
		return current.getItem();
	}
	
	public T gotoHead() {
		current = head;
		return current.getItem();
	}
	
	public T gotoTail() {
		current = tail;
		return current.getItem();
	}
			
	public T next() throws Exception {
		if(hasNext())
			current = current.getNext();
		else
			throw new Exception("Nothing after!");
		return current.getItem();
	}
	
	public T previous() throws Exception {
		if(hasPrevious())
			current = current.getPrevious();
		else
			throw new Exception("Nothing before!");
		return current.getItem();
	}
	
	public int size() {
		return size;
	}
	
	public boolean hasNext() {
		return current.getNext() != null;
	}
	
	public boolean hasPrevious() {
		return current.getPrevious() != null;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
}
