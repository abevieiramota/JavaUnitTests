package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.gt;
import static org.easymock.EasyMock.lt;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Diferente do comportamento do mock normal(criado por createMock), o niceMock
 * 	tem por default o comportamento de retornar valores default.
 * 	Isto é, as chamadas a métodos que não tenha sido configurados no estado Recording
 * 		retornam valores default.
 * @author abelardo.mota
 *
 */
// UTILIDADE?
@RunWith(JUnit4.class)
public class NiceMock extends Basico {

	@Test
	public void niceMockIsNice() {
		assertThat(
				
				niceCalc.soma(1,1), is(equalTo(null))
				
				);
	}
	
	/**
	 * A primeira chamada utiliza o comportamento configurado no estado de Recording.
	 * Já a segunda chamada utiliza o comportamento default.
	 */
	@Test
	public void niceMockIsNice2() {
		expect(niceCalc.soma(lt(1), gt(20))).andReturn(30);
		
		replay(niceCalc);
		
		assertThat(niceCalc.soma(0, 40), is(equalTo(30)));
		assertThat(niceCalc.soma(0, 40), is(equalTo(null)));
	}
}
