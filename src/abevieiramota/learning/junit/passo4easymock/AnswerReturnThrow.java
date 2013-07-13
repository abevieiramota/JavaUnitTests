package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.getCurrentArguments;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import org.easymock.IAnswer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Answer é uma forma de ter acesso aos parâmetros passados e prover uma resposta
 * 	dinâmica.
 * 
 * Observar que os argumentos retornados por {@code EasyMock#getCurrentArguments()} 
 * 	vêm na ordem em que são passados para o método, de forma que alterações na ordem dos parâmetros
 * 	ou em seus significados devem ser propagadas para os testes que se utilizem deste recurso.
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class AnswerReturnThrow extends Basico {
	
	@Test
	public void mockAnswerReturn() {
		
		expect(calc.soma(1, 1)).andAnswer(new IAnswer<Integer>() {
			
			public Integer answer() throws Throwable {
				Object[] currentArguments = getCurrentArguments();
				Integer a = (Integer) currentArguments[0];
				Integer b = (Integer) currentArguments[1];
				return a + b;
			}
		});
		
		replay(calc);
		
		org.junit.Assert.assertThat(
				
				calc.soma(1, 1),is(equalTo(2))
				
				);
	}

}
