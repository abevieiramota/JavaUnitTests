package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.createMockBuilder;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * PartialMock permite mockar apenas alguns métodos, mantendo o comportamento programado
 * 	dos demais.
 * @author abelardo.mota
 *
 */
// UTILIDADE?
@RunWith(JUnit4.class)
public class PartialMock {

	private class Falador {
		public String falaOi() {
			return "Oi!";
		}
		
		public String falaOiTudoBem() {
			return String.format("%s %s", falaOi(), "Tudo bem?");
		}
	}
	
	private Falador falador;
	
	@Before
	public void setUp() {
		falador = createMockBuilder(Falador.class).addMockedMethod("falaOi").createMock();
	}
	
	/**
	 * Mocko um método utilizado por outro.
	 * 	O comportamento do primeiro é configurado, o do último mantem-se
	 */
	@Test
	public void partialMockExemplo() {
		expect(falador.falaOi()).andReturn("OOOOI");
		
		replay(falador);
		
		assertThat(falador.falaOiTudoBem(), is(equalTo("OOOOI Tudo bem?")));
	}
	
}
