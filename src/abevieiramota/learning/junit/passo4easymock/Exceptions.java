package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.expect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Exceptions extends Basico{
	
	/**
	 * Como fazer lançar exceção. Método com retorno void.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void mockThrowExcecao() {
		calc.inicializa();
		expectLastCall().andThrow(new IllegalArgumentException());
		replay(calc);
		calc.inicializa();
	}
	
	/**
	 * Como fazer lançar exceção. Método com retorno != void.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void mockThrowExcecao2() {
		expect(calc.soma(1, 1)).andThrow(new IllegalArgumentException());
		replay(calc);
		calc.soma(1, 1);
	}

}
