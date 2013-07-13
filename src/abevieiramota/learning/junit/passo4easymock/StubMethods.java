package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.easymock.IAnswer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Diferente do expect, métodos stubs possuem comportamento fixo.
 * 	Ou seja, configurado um stub para um método, ele irá responder da forma configurada para qualquer chamada.
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class StubMethods extends Basico {

	/**
	 * O comportamento é observado em qualquer quantidade de execuções que satisfaçam 
	 * 	os matchers dos parâmetros.
	 */
	@Test
	public void testeComStub() {
		expect(calc.soma(anyInt(), anyInt())).andStubReturn(10);
		
		replay(calc);
		
		for(int i = 0; i < 10; i++) {
			assertThat(calc.soma(i, i), is(equalTo(10)));
		}
	}
	
	/**
	 * Mesmo para answer.
	 */
	@Test
	public void mockAnswerReturn() {
		
		expect(calc.soma(anyInt(), anyInt())).andStubAnswer(new IAnswer<Integer>() {
			public Integer answer() throws Throwable {
				return 10;
			}
		});
		
		replay(calc);
		
		for(int i=0; i < 10; i++) {
			org.junit.Assert.assertThat(calc.soma(i, i),is(equalTo(10)));
		}
	}
}
