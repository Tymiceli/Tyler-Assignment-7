package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10]; // array of 10 item objects
	int size = 0; // size of the list

	@Override
	public boolean add(T item) { // add method takes in a T (type) and item
		
		return add(size, item);
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws IndexOutOfBoundsException { // takes in a type (array type) and an integer
																
		if (index > size) // if the integer you inputed as the index is greater
			throw new IndexOutOfBoundsException(
					"The index, " + index + ", is out of the bounds of the array with size " + size);

		return (T) items[index];
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for an array of size " + size);
		}
		
		if (size == items.length) {
			items = Arrays.copyOf(items, items.length * 2);
		}
		
		for (int i = size; i > index; i--) {
			items[i] = items[i-1];
		}
		
		items[index] = item;
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		
		if (index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		
		Object removedItem = items[index];
		
		for (int i = index; i < size-1; i++) {
			items[i] = items[i+1];
		}
		items[size-1] = null;
		
		size--;
		
		return (T) removedItem;
	}

}
