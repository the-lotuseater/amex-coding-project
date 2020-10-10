package com.codingproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AppTest {	

	@Nested
	class GivenAValidOrder{
		String[] order = new String[] {"orange","apple","apple"};
		
		@Test
		void calculateTotal() throws Exception{
			Double actualResult = App.calculateTotal(order);
			Double expectedResult = 1.45D;
			assertEquals(expectedResult, actualResult);
		}
		
		@Test
		void printReceipt() throws Exception{
			App.main(order);
		}
	}

	@Nested
	class GivenAnInvalidOrder{
		String[] order = new String[] {"orange","apple","banana"};
		
		@Test
		void thenThenExpectIllegalArgumentException() throws Exception{
			assertThrows(IllegalArgumentException.class,()->App.calculateTotal(order));
		}
	}
	
}
