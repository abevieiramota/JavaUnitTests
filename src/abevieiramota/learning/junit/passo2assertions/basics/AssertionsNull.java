package abevieiramota.learning.junit.passo2assertions.basics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AssertionsNull {

	@Test
	public void assertNotNull() {
		org.junit.Assert.assertNotNull("N�o � nulo.", new Object());
	}
	
	@Test
	public void assertNull() {
		org.junit.Assert.assertNull("� nulo.", null);
	}
}
