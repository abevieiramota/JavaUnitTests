package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.CalculadoraImpl;
import abevieiramota.learning.junit.CalculadoraLogadaImpl;

/**
 * Delega a execução de um método para outro objeto que implemente a mesma interface.
 * @author abelardo.mota
 *
 */
// UTILIDADE?
@RunWith(JUnit4.class)
public class DelegateCall extends Basico {
	
	@Test
	public void delegaPraCalculadoraImplementada() {
		
		expect(calc.soma(1, 1)).andDelegateTo(new CalculadoraImpl());
		
		replay(calc);
		
		assertThat(
				
				calc.soma(1,1), is(equalTo(2))
				
				);
	}

	@Test
	public void delegaPraCalculadoraLogadaImplementada() {
		
		expect(calc.soma(1, 1)).andDelegateTo(new CalculadoraLogadaImpl());
		
		replay(calc);
		
		assertThat(
				
				calc.soma(1,1), is(equalTo(2))
				
				);
	}
}
