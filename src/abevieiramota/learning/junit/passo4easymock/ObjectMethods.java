package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ObjectMethods extends Basico {

	/**
	 * 
	 * Os seguintes métodos de Object não podem ser mockados:
	 * 	equals
	 * 	hashCode
	 * 	toString
	 * 
	 */
	@Test(expected = IllegalStateException.class)
	public void metodosDeObjectQueNaoPodemSerMockados() {
		expect(calc.toString()).andReturn("Teste");
		
		replay(calc);
		
		assertThat(calc.toString(), is(equalTo("Teste")));
	}
}
