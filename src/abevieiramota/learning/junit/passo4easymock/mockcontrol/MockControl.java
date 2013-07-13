package abevieiramota.learning.junit.passo4easymock.mockcontrol;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createStrictControl;

import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MockControl {
	
	private Comando comando1;
	private Comando comando2;
	
	private Robo robo;
	
	private IMocksControl crtl = createStrictControl();
	
	@Before
	public void setUp() {
		robo = new Robo("Jack Reacher");
		comando1 = crtl.createMock(Comando.class);
		comando2 = crtl.createMock(Comando.class);
	}
	
	@Test
	public void testaOrdemDeChamadaDeComandos() {
		comando1.executar(anyObject(Robo.class));
		comando2.executar(anyObject(Robo.class));
		
		crtl.replay(); // não precisa especificar os mocks, o replay aplica-se a todos os mocks criados com o IMockControl
		
		robo.addComando(comando1);
		robo.addComando(comando2);
		
		robo.execute();
		
		crtl.verify();
		
	}

	@Test(expected = AssertionError.class)
	public void testaOrdemDeChamadaDeComandosErrada() {
		
		comando2.executar(anyObject(Robo.class));
		
		comando1.executar(anyObject(Robo.class));
		
		crtl.replay(); // não precisa especificar os mocks, o replay aplica-se a todos os mocks criados com o IMockControl
		
		robo.addComando(comando1);
		robo.addComando(comando2);
		
		robo.execute();

		// verifica se foram chamados na ordem esperada(a em que foi realizada as chamadas no estado Recording)
		crtl.verify();
		
	}
	

}
