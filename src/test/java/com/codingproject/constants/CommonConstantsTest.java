package com.codingproject.constants;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.codingproject.constants.CommonConstants;


class CommonConstantsTest {

	@Test
	void test() throws Exception{
		assertEquals("APPLE",CommonConstants.APPLE);

		assertEquals("ORANGE",CommonConstants.ORANGE);

		assertEquals(0.60D,CommonConstants.APPLE_COST);

		assertEquals(0.25D,CommonConstants.ORANGE_COST);
	}

}
