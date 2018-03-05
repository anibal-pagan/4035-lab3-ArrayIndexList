package arrayIndexList;

import indexList.IndexList;

public class ArrayIndexList<E> implements IndexList<E> {
	private static final int INITCAP = 1; 
	private static final int CAPTOAR = 1; 
	private static final int MAXEMPTYPOS = 2; 
	private E[] element; 
	private int size; 

	public ArrayIndexList() { 
		element = (E[]) new Object[INITCAP]; 
		size = 0; 
	} 
	

	public void add(int index, E e) throws IndexOutOfBoundsException {
		if(index<0 || index>size) throw new IndexOutOfBoundsException("Index must be between 0 and current size.");
		moveDataOnePositionTR(index, size);
		element[index] = e;
		size++;
		if(size == element.length-1) this.changeCapacity(element.length);
	}


	public void add(E e) {
		element[size] = e;
		size++;
		if(size == element.length-1) this.changeCapacity(element.length);
	}


	public E get(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>size-1) throw new IndexOutOfBoundsException("get: Invalid index = " + index);
		return element[index];
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>size || this.isEmpty()) throw new IndexOutOfBoundsException("get: Invalid index = " + index);
		E prev = element[index];
		moveDataOnePositionTL(index+1, size-1);
		element[size-1] = null;
		size--;
		if(size == element.length/4) this.changeCapacity(-element.length/2);
		return prev;
	}


	public E set(int index, E e) throws IndexOutOfBoundsException {
		if(index<0 || index>size) throw new IndexOutOfBoundsException("get: Invalid index = " + index);
		E prev = element[index];
		element[index] = e;
		return prev;
	}


	public int size() {
		return size;
	}	
	
	
	
	// private methods  -- YOU CAN NOT MODIFY ANY OF THE FOLLOWING
	// ... ANALYZE AND USE WHEN NEEDED
	
	// you should be able to decide when and how to use
	// following method.... BUT NEED TO USE THEM WHENEVER
	// NEEDED ---- THIS WILL BE TAKEN INTO CONSIDERATION WHEN GRADING
	
	private void changeCapacity(int change) { 
		int newCapacity = element.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = element[i]; 
			element[i] = null; 
		} 
		element = newElement; 
	}
	
	// useful when adding a new element with the add
	// with two parameters....
	private void moveDataOnePositionTR(int low, int sup) { 
		// pre: 0 <= low <= sup < (element.length - 1)
		for (int pos = sup; pos >= low; pos--)
			element[pos+1] = element[pos]; 
	}

	// useful when removing an element from the list...
	private void moveDataOnePositionTL(int low, int sup) { 
		// pre: 0 < low <= sup <= (element.length - 1)
		for (int pos = low; pos <= sup; pos++)
			element[pos-1] = element[pos]; 
	}


	// The following two methods are to be implemented as part of an exercise
	public Object[] toArray() {
		// TODO es in Exercise 3
		return null;
	}


	@Override
	public <T1> T1[] toArray(T1[] array) {
		// TODO as in Exercise 3
		return null;
	}


	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return 0;
	}

}
