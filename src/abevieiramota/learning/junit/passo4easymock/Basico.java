package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Calculadora;

/**
 * Funcionamento b�sico do EasyMock.
 * 
 * Observa��es:
 * 	- mock em fase de Recording n�o � thread-safe
 * 	- mock em fase de Replay s�o thread-safe
 * 	- pode-se checar se um mock(n�o sei ao certo em quais estados) est� sendo utilizado em apenas uma thread
 * 		atrav�s de checkIsUsedInOneThread(mock, true)
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class Basico {
	
	protected Calculadora calc;
	protected Calculadora niceCalc;
	
	@Before
	public void setUp() {
		// mocks podem ser nomeados. os nomes s�o utilizados nas mensagens de falha
		calc = createMock("DefaultMock", Calculadora.class);
		niceCalc = createNiceMock("NiceMock", Calculadora.class);
	}
	
	/**
	 * O mock criado, por default, n�o possui nenhum comportamento.
	 * Caso um m�todo seja invocado no objeto mockado, � lan�ada exce��o {@link AssertionError.class}.
	 */
	@Test(expected = AssertionError.class)
	public void mockSemComportamentoChamado() {
		/*
		 * Altera o estado do objeto mockado para 'Replay'.
		 * O objeto mockado possui estados, dentre eles:
		 * 	
		 * 	Recording: nesse estado o objeto ir� gravar as expectativas. 
		 * 		Estado inicial.
		 * 	
		 * 	Replay: nesse estado o objeto ir� reiniciar seu funcionamento. Observar que o funcionamento/expectativas
		 * 		por default n�o funcionam para todas as chamadas. Melhor falando: caso seja configurado uma expectativa,
		 * 		esta ir� ser executada apenas para a primeira chamada. As demais ir�o lan�ar AssertionError.class.
		 * 		Ao passar o objeto mock para o estado Replay, estamos informando que queremos reiniciar seu comportamento.
		 * 		Estado inicializado com a chamada para verify().
		 * 		
		 * 
		 */
		replay(calc);
		calc.soma(1, 1);
	}

	
	/**
	 * Notar que para m�todos sem retorno, n�o � necess�rio mocka-los via expect(...).andReturn(...),
	 * 	sendo suficiente cham�-los.
	 */
	@Test
	public void mockComportamentoSemExpect() {
		calc.inicializa();
		replay(calc);
	}
	
	/**
	 * Demonstra o comportamento default do EasyMock.
	 * 	Os m�todos s�o mockados, por default, para apenas uma chamada.
	 */
	@Test(expected = AssertionError.class)
	public void mockComportamentoDefaultApenasUmaChamada() {
		// UMA chamada � mockada
		expect(calc.soma(1, 1)).andReturn(2);
		replay(calc);
		// DUAS chamadas s�o realizadas
		calc.soma(1,1);
		calc.soma(1,1);
	}
	
	/**
	 * Verifica��o se o comportamento mockado foi chamado.
	 * 	O comportamento foi mockado, mas n�o foi chamado. 
	 * 	O EasyMock lan�a uma AssertionError e informa qual comportamento n�o foi chamado, 
	 * 		informando tamb�m em que quantidade era esperado ser chamado e em que quantidade foi chamado.
	 */
	@Test(expected = AssertionError.class)
	public void mockVerify() {
		expect(calc.soma(1,1)).andReturn(2);
		replay(calc);
		verify(calc);
	}
	
	/**
	 * Configurando mais de um comportamento para o mesmo m�todo.
	 */
	@Test
	public void mockVariosComportamentosMesmoMetodo() {
		
		expect(calc.soma(1,1)).andReturn(2).andReturn(3);
		
		replay(calc);
		
		assertThat(
				
				calc.soma(1,1),is(equalTo(2))
				
				);
		
		assertThat(
				
				calc.soma(1,1),is(equalTo(3))
				
				);
	}

}
