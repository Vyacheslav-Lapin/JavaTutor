package com.luxoft.training.java2.module7;

import org.junit.Test;

public class ClassSpyTest {

	@Test
	public void testClassSpy() {
		ClassSpy.spy("com.luxoft.training.java2.module7.ExampleClass", ClassMember.ALL.toString());
	}
}
