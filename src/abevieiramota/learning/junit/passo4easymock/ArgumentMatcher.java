package abevieiramota.learning.junit.passo4easymock;

import static org.easymock.EasyMock.aryEq;
import static org.easymock.EasyMock.cmp;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.gt;
import static org.easymock.EasyMock.isNull;
import static org.easymock.EasyMock.lt;
import static org.easymock.EasyMock.matches;
import static org.easymock.EasyMock.notNull;
import static org.easymock.EasyMock.or;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.same;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Comparator;

import org.easymock.LogicalOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Pessoa;

/**
 * Matchers para argumentos.
 * 
 * Observações:
 * 	- comparação de arrays, se quiser verificar se os itens são iguais => aryEq
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class ArgumentMatcher extends Basico {
	
	@Test(expected = AssertionError.class)
	public void comoNaoFazerComArray() {
		Integer[] valoresIgual1 = new Integer[]{1,2,3};
		Integer[] valoresIgual2 = new Integer[]{1,2,3};
		
		expect(calc.soma(valoresIgual1)).andReturn(6);
		replay(calc);
		
		assertThat(
				
				calc.soma(valoresIgual2),is(equalTo(6))
				
				);
	}
	
	@Test
	public void comoFazerComArray() {
		Integer[] valoresIgual1 = new Integer[]{1,2,3};
		Integer[] valoresIgual2 = new Integer[]{1,2,3};
		
		expect(calc.soma( /* >>>> */aryEq /* <<<< */(valoresIgual1))).andReturn(6);
		replay(calc);
		
		assertThat(
				
				calc.soma(valoresIgual2),is(equalTo(6))
				
				);
	}
	
	// Equals parametros de tipo complexo
	@Test
	public void parametroObjetoEquals() {
		Pessoa pessoaMockada = createMock(Pessoa.class);
		
		expect(pessoaMockada.testarOutraPessoa(Pessoa.pessoaIgual1)).andReturn("Teste");
		replay(pessoaMockada);
		
		assertThat(pessoaMockada.testarOutraPessoa(Pessoa.pessoaIgual2), is(equalTo("Teste")));
	}
	
	@Test
	public void parametrosObjetoEqualsExplicito() {
		Pessoa pessoaMockada = createMock(Pessoa.class);
		
		expect(pessoaMockada.testarOutraPessoa(eq(Pessoa.pessoaIgual1))).andReturn("Teste");
		replay(pessoaMockada);
		
		assertThat(pessoaMockada.testarOutraPessoa(Pessoa.pessoaIgual2), is(equalTo("Teste")));	
	}
	
	/*
	 * Any Objects
	 * 
	 * anyBoolean()
	 * anyByte()
	 * anyChar()
	 * anyDouble()
	 * anyFloat()
	 * anyInt()
	 * anyLong()
	 * anyObject()
	 * anyObject(Class clazz)
	 * anyShort()
	 * 
	 * 
	 */
	
	/**
	 * Testes passando null.
	 */
	@Test
	public void parametroObjetoNull() {
		expect(calc.soma(isNull(Integer[].class))).andReturn(999);
		
		replay(calc);
		
		assertThat(calc.soma(null), is(equalTo(999)));
	}
	
	/**
	 * Testes passando not null.
	 */
	@Test
	public void parametroObjetoNotNull() {
		expect(calc.soma(notNull(Integer[].class))).andReturn(999);
		
		replay(calc);
		
		assertThat(calc.soma(new Integer[] {1,2}), is(equalTo(999)));
	}
	
	/**
	 * Mesmo objeto.
	 */
	@Test
	public void parametroMesmoObjetoDoMock() {
		Pessoa pessoaMockada = createMock(Pessoa.class);
		expect(pessoaMockada.testarOutraPessoa(same(Pessoa.pessoaIgual1))).andReturn("Olá");
		
		replay(pessoaMockada);
		
		assertThat(pessoaMockada.testarOutraPessoa(Pessoa.pessoaIgual1), is(equalTo("Olá")));
	}

	@Test(expected = AssertionError.class)
	public void parametroEntidadeIgualMasObjetoDiferente() {
		Pessoa pessoaMockada = createMock(Pessoa.class);
		expect(pessoaMockada.testarOutraPessoa(same(Pessoa.pessoaIgual1))).andReturn("Olá");
		
		replay(pessoaMockada);
		
		assertThat(pessoaMockada.testarOutraPessoa(Pessoa.pessoaIgual2), is(equalTo("Olá")));
	}
	
	/**
	 * Comparable.
	 */
	@Test
	public void mockParametroMenorQue() {
		expect(calc.soma(lt(4), lt(4))).andReturn(10);
		expect(calc.soma(gt(4), gt(4))).andReturn(20);
		
		replay(calc);
		
		assertThat(calc.soma(1,1), is(equalTo(10)));
	}
	
	@Test
	public void mockParametroMaiorQue() {
		expect(calc.soma(lt(4), lt(4))).andReturn(10);
		expect(calc.soma(gt(4), gt(4))).andReturn(20);
		
		replay(calc);
		
		assertThat(calc.soma(5,5), is(equalTo(20)));
	}

	@Test(expected = AssertionError.class)
	public void mockParametroForaDosIntervalos() {
		expect(calc.soma(lt(4), lt(4))).andReturn(10);
		expect(calc.soma(gt(4), gt(4))).andReturn(20);
		
		replay(calc);
		
		assertThat(calc.soma(6,2), is(equalTo(20)));
	}
	
	/**
	 * Matchers lógicos
	 * 	AND, OR, NOT
	 */
	@Test
	public void mockAndParameterMatcher() {
		expect(calc.soma(or(eq(2), eq(3)), lt(4))).andReturn(10).times(2);
		
		replay(calc);
		
		assertThat(calc.soma(2,2), is(equalTo(10)));
		assertThat(calc.soma(3,2), is(equalTo(10)));
	}
	
	/**
	 * Matchers para String.
	 * 
	 * startsWith(String prefix)
	 * contains(String substring)
	 * endsWith(String suffix)
	 * matches(String regex)
	 * find(String regex)
	 */
	@Test
	public void mockStringMatcher() {
		Pessoa pessoaMockada = createMock(Pessoa.class);
		expect(pessoaMockada.falar(matches("\\d+"))).andReturn("Numero");
		
		replay(pessoaMockada);
		
		assertThat(pessoaMockada.falar("123"), is(equalTo("Numero")));
	}

	@Test(expected = AssertionError.class)
	public void mockStringMatcherNotMatchs() {
		Pessoa pessoaMockada = createMock(Pessoa.class);
		expect(pessoaMockada.falar(matches("\\d+"))).andReturn("Numero");
		
		replay(pessoaMockada);
		
		assertThat(pessoaMockada.falar("123a"), is(equalTo("Numero")));
	}
	
	/**
	 * Comparator.
	 */
	@Test
	public void mockParametroIfComparator() {
		expect(calc.soma(eq(1), cmp(10, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
			
		}, LogicalOperator.GREATER))).andReturn(10);
		
		replay(calc);
		
		assertThat(calc.soma(1, 12), is(equalTo(10)));
	}
	
	
	
}
