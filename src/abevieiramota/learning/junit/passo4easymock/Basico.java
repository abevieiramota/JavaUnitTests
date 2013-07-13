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
 * Funcionamento básico do EasyMock.
 * 
 * Observações:
 * 	- mock em fase de Recording não é thread-safe
 * 	- mock em fase de Replay são thread-safe
 * 	- pode-se checar se um mock(não sei ao certo em quais estados) está sendo utilizado em apenas uma thread
 * 		através de checkIsUsedInOneThread(mock, true)
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class Basico {
	
	protected Calculadora calc;
	protected Calculadora niceCalc;
	
	@Before
	public void setUp() {
		// mocks podem ser nomeados. os nomes são utilizados nas mensagens de falha
		calc = createMock("DefaultMock", Calculadora.class);
		niceCalc = createNiceMock("NiceMock", Calculadora.class);
	}
	
	/**
	 * O mock criado, por default, não possui nenhum comportamento.
	 * Caso um método seja invocado no objeto mockado, é lançada exceção {@link AssertionError.class}.
	 */
	@Test(expected = AssertionError.class)
	public void mockSemComportamentoChamado() {
		/*
		 * Altera o estado do objeto mockado para 'Replay'.
		 * O objeto mockado possui estados, dentre eles:
		 * 	
		 * 	Recording: nesse estado o objeto irá gravar as expectativas. 
		 * 		Estado inicial.
		 * 	
		 * 	Replay: nesse estado o objeto irá reiniciar seu funcionamento. Observar que o funcionamento/expectativas
		 * 		por default não funcionam para todas as chamadas. Melhor falando: caso seja configurado uma expectativa,
		 * 		esta irá ser executada apenas para a primeira chamada. As demais irão lançar AssertionError.class.
		 * 		Ao passar o objeto mock para o estado Replay, estamos informando que queremos reiniciar seu comportamento.
		 * 		Estado inicializado com a chamada para verify().
		 * 		
		 * 
		 */
		replay(calc);
		calc.soma(1, 1);
	}

	
	/**
	 * Notar que para métodos sem retorno, não é necessário mocka-los via expect(...).andReturn(...),
	 * 	sendo suficiente chamá-los.
	 */
	@Test
	public void mockComportamentoSemExpect() {
		calc.inicializa();
		replay(calc);
	}
	
	/**
	 * Demonstra o comportamento default do EasyMock.
	 * 	Os métodos são mockados, por default, para apenas uma chamada.
	 */
	@Test(expected = AssertionError.class)
	public void mockComportamentoDefaultApenasUmaChamada() {
		// UMA chamada é mockada
		expect(calc.soma(1, 1)).andReturn(2);
		replay(calc);
		// DUAS chamadas são realizadas
		calc.soma(1,1);
		calc.soma(1,1);
	}
	
	/**
	 * Verificação se o comportamento mockado foi chamado.
	 * 	O comportamento foi mockado, mas não foi chamado. 
	 * 	O EasyMock lança uma AssertionError e informa qual comportamento não foi chamado, 
	 * 		informando também em que quantidade era esperado ser chamado e em que quantidade foi chamado.
	 */
	@Test(expected = AssertionError.class)
	public void mockVerify() {
		expect(calc.soma(1,1)).andReturn(2);
		replay(calc);
		verify(calc);
	}
	
	/**
	 * Configurando mais de um comportamento para o mesmo método.
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
