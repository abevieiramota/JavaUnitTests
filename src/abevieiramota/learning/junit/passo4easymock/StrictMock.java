package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.checkOrder;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Calculadora;

/**
 * StrickMocks verificam também a ordem com que os métodos são chamados.
 * 
 * Pode-se habilitar ou desabilitar programaticamente a verificação de ordem de chamada,
 * 	através de chamadas a EasyMock.checkOrder(mock, boolean).
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class StrictMock extends Basico {

	/**
	 * Com mock strict, a ordem é verificada e nesse caso lança uma AssertionError
	 */
	@Test(expected = AssertionError.class)
	public void testStrictMock() {
		Calculadora calcStrict = createStrictMock(Calculadora.class);
		
		calcStrict.inicializa();
		expect(calcStrict.soma(1,1)).andReturn(2);
		
		replay(calcStrict);
		
		calcStrict.soma(1, 1);
		calcStrict.inicializa();
		
		verify(calcStrict);
	}

	/**
	 * Com mocks normais, a ordem de chamada é irrelevante.
	 */
	@Test
	public void testNormalMock() {
		calc.inicializa();
		expect(calc.soma(1,1)).andReturn(2);
		
		replay(calc);
		
		calc.soma(1, 1);
		calc.inicializa();
		
		verify(calc);
	}
	
	
}
