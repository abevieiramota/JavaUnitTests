package abevieiramota.learning.junit.passo2assertions.basics;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class AssertionsException {

	/**
	 * 1
	 * - N�o permite testar mensagens da exce��o.
	 * - Falha se em qualquer parte do c�digo for levantada a exce��o.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testWithExceptionExpected() {
		Arrays.asList().get(0);
		Arrays.asList().get(0);
	}
	
	/**
	 * 2
	 */
	@Test
	public void testWithExceptionExpected2() {
		try {
			Arrays.asList().get(0);
			org.junit.Assert.fail("Deveria ter lan�ado index out of bound exception");
		} catch(IndexOutOfBoundsException ex) {
		}
	}
	
	/**
	 * 3 
	 *  usando Rule
	 *  TODO: completar
	 */
}
