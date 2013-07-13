package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class CallsCount extends Basico{

	@Test
	public void configureLastCalls() {
		calc.inicializa();
		expectLastCall().times(2);
		replay(calc);
		calc.inicializa();
		calc.inicializa();
	}

	@Test
	public void configureOnceExplicitamente() {
		calc.inicializa();
		expectLastCall().once();
		replay(calc);
		calc.inicializa();
	}

	@Test
	public void configureLasCallsExpect() {
		expect(calc.soma(1,1)).andReturn(2);
		expectLastCall().times(2);
		replay(calc);
		calc.soma(1,1);
		calc.soma(1,1);
	}
	
	@Test(expected = AssertionError.class)
	public void configureLastCallExpectChamandoMaisVezes() {
		expect(calc.soma(1,1)).andReturn(2);
		expectLastCall().times(2);
		replay(calc);
		calc.soma(1,1);
		calc.soma(1,1);
		calc.soma(1,1);
		// verifico as chamadas, se foram como esperado
		/*
		 * Notar que se deve chamar verify(...) para verificar se as chamadas foram realizadas.
		 */
		verify(calc);
	}
	
	@Test()
	public void configureLastCallExpectChamandoXVezes() {
		expect(calc.soma(1,1)).andReturn(2);
		expectLastCall().anyTimes();
		replay(calc);
		calc.soma(1,1);
		calc.soma(1,1);
		calc.soma(1,1);
		// verifico as chamadas, se foram como esperado
		verify(calc);
	}

	@Test()
	public void configureLastCallExpectChamandoMaisDeUmaVez() {
		expect(calc.soma(1,1)).andReturn(2);
		expectLastCall().atLeastOnce();
		replay(calc);
		calc.soma(1,1);
		calc.soma(1,1);
		calc.soma(1,1);
		// verifico as chamadas, se foram como esperado
		verify(calc);
	}
	
	@Test(expected = AssertionError.class)
	public void configureLastCallExpectChamandoMenosVezes() {
		expect(calc.soma(1,1)).andReturn(2);
		expectLastCall().times(2);
		replay(calc);
		calc.soma(1,1);
		// verifico as chamadas, se foram como esperado
		verify(calc);
	}

	@Test()
	public void configureLastCallExpectChamandoIntervaloDeVezes() {
		expect(calc.soma(1,1)).andReturn(2);
		expectLastCall().times(1, 3);
		replay(calc);
		calc.soma(1,1);
		// verifico as chamadas, se foram como esperado
		verify(calc);
	}
}
