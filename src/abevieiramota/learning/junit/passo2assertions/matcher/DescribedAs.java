package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.describedAs;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Pessoa;


/** 
 * Decora o Matcher, adicionando uma mensagem customizada, podendo ser parametrizada com %i, onde i in {0, 1, ...}.
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class DescribedAs {

	@Test(expected = AssertionError.class)
	public void testDescribedAs() {
		Pessoa pessoa = new Pessoa("Teste", "Abelardo", "Vieira");
		Pessoa pessoaDiferente = new Pessoa("Testeasas", "Abelardo", "Vieira");
		
		
		org.junit.Assert.assertThat(
				
				pessoa, 

				describedAs("Pessoa com nome: %0", is(equalTo(pessoaDiferente)), pessoa.getNome())
				
				);
	}
}
