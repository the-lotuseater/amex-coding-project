package com.codingproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AppTest {	

	@Nested
	class GivenAValidOrder{
		String[] order = new String[] {"orange","apple"};
		
		@Test
		void calculateTotal() throws Exception{
			Double actualResult = App.calculateTotal(order);
			Double expectedResult = .85D;
			assertEquals(expectedResult, actualResult);
		}
		
		@Test
		void printReceipt() throws Exception{
			App.main(order);
		}
		
		@Nested
		class ApplyOffers{
			
			@Test
			void OnePlusOneFreeApple() throws Exception{
				String[] offerApplicableOrder = new String[] {"apple","apple","orange","apple","apple"};
				Double expectedResult = 1.45D;
				Double actualResult = App.calculateTotal(offerApplicableOrder);
				assertEquals(expectedResult, actualResult);
			}
			
			@Test
			void ThreeOrangesForPriceOfTwo() throws Exception{
				String[] offerApplicableOrder = new String[] {"apple","orange","orange","orange","orange"};
				Double expectedResult = 1.35D;
				Double actualResult = App.calculateTotal(offerApplicableOrder);
				assertEquals(expectedResult, actualResult);
			}
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
