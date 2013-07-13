package abevieiramota.learning.junit.passo2assertions.basics;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class AssertionsException {

	/**
	 * 1
	 * - Não permite testar mensagens da exceção.
	 * - Falha se em qualquer parte do código for levantada a exceção.
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
			org.junit.Assert.fail("Deveria ter lançado index out of bound exception");
		} catch(IndexOutOfBoundsException ex) {
		}
	}
	
	/**
	 * 3 
	 *  usando Rule
	 *  TODO: completar
	 */
}
