package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomArrayListTest {
	// Test-Driven Development Methodology
	// Step 1 - Write a failing test
	// Step 2 - Write the business logic to make the test pass
	// Step 3 - Refactor your code
	// Step 4 - repeat

	// Three A's
	// Arrange, Act, Assert

	// Arrange
	private CustomList<Object> sut; // sut = system under test
										// (the variable in which you are acting on)

	@BeforeEach
	void before_each_test() {
		sut = new CustomArrayList<>();
	}

	@Test
	void should_return_size() {
		// act
		sut.add(1000);
		sut.add(0, 1001);
		//assert
		assertEquals(2, sut.getSize());
	}

	@Test
	void should_add_item_at_index() {

		sut.add(1000);
		sut.add(2000);
		
		assertTrue(sut.add(1, "item"));

	}

	@Test
	void should_add_item_at_beginning_of_list() {

		assertTrue(sut.add(-5));
	}
	
	@Test
	void should_add_1000_items() {
		for (int i = 0; i < 1000; i++) {
			sut.add(i);
		}
		assertEquals(1000, sut.getSize());
	}

	@Test
	void should_remove_item_at_index() {
		
		sut.add("begin");
		sut.add("middle");
		sut.add("end");
		
		
		assertEquals("end", sut.remove(2));	
	}
	
	@Test 
	void should_decrement_size_when_removing_items() {
		
		for (int i = 0; i < 10; i++) {
			sut.add(i);
		}
		assertEquals(10, sut.getSize());
		
		sut.remove(5);
		
		assertEquals(9, sut.getSize());
		
		
	}

	@Test
	void should_throw_exception_when_out_of_bounds() {
		sut.add(1);
//		sut.add(2);
		assertThrows(IndexOutOfBoundsException.class, () -> sut.get(1), "Throws ArrayIndexOutOfBoundsException");
	}
	
	@Test
	void should_throw_exception_when_removing_out_of_bounds() {
		
		assertThrows(IndexOutOfBoundsException.class, ()-> sut.remove(3), "Throws ArrayIndexOutOfBoundsException");
	}
	
	@Test
 	void should_throw_exception_when_adding_out_of_bounds () {
 		assertThrows(IndexOutOfBoundsException.class, ()-> sut.add(3, 3), "Throws ArrayIndexOutOfBoundsException");
	}
}