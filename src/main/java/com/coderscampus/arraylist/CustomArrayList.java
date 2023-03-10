package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10]; // array of 10 item objects
	int size = 0; // size of the list

	@Override
	public boolean add(T item) { // add method takes in a T (type) and item
		if (size == items.length) { // if the size of the list equals the length of the array then
			int newArrSize = (items.length) * 2;
			items = Arrays.copyOf(items, newArrSize);
		} // just with a doubled size
		
		items[size] = item; // item array at new size = item at that index of size
		size++; // increase the size of the array after each add
		
		for (Object obj : items) {
			if (obj != null) {
				items = Arrays.copyOf(items, size); 
			}
		}
		
		return true; // returns true if item was added
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws IndexOutOfBoundsException { // takes in a type (array type) and an integer
																// (items.get(10))
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
		
		add(item);
		
		Object[] tempArr = new Object[items.length];
		
		for (int i = 0; i < index; i++) {
			tempArr[i] = items[i];
		}

		tempArr[index] = item;
		
		for (int i = index + 1; i >= items.length; i++) {
			tempArr[i] = items[i - 1];			
		}

		items = Arrays.copyOf(tempArr, tempArr.length);
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		
		if (index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		
		Object removedItem = null;
		Object[] tempArray = new Object[items.length - 1];
		int tempArrIndex = 0;
		
		for (int i = 0; i < items.length; i++) {
			if (i == index) {
				removedItem = items[i];
				continue;
			}
			tempArray[tempArrIndex++] = items[i];
		}

		items = Arrays.copyOf(tempArray, tempArray.length);
		size--;
		
		return (T) removedItem;
	}

}
