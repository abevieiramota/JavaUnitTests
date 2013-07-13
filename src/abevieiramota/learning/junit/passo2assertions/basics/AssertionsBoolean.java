package abevieiramota.learning.junit.passo2assertions.basics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AssertionsBoolean {

	@Test
	public void testTrue() {
		org.junit.Assert.assertTrue("True é verdadeiro.", Boolean.TRUE);
	}

	@Test
	public void testFalse() {
		org.junit.Assert.assertFalse("False é falso.", Boolean.FALSE);
	}
	
}
