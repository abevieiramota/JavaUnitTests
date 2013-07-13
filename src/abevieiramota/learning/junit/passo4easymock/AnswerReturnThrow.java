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
 * Answer � uma forma de ter acesso aos par�metros passados e prover uma resposta
 * 	din�mica.
 * 
 * Observar que os argumentos retornados por {@code EasyMock#getCurrentArguments()} 
 * 	v�m na ordem em que s�o passados para o m�todo, de forma que altera��es na ordem dos par�metros
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
