package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.not;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Pessoa;

/**
 * ||
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class AnyOf {

	@Test
	public void testAnyOf() {
		List<Pessoa> pessoasDiferentes = Arrays.asList(Pessoa.pessoaIgual1, Pessoa.pessoaIgual2, Pessoa.pessoaDiferente);

		/**
		 * Todos devem satisfazer AO MENOS uma condição.
		 * PARECIDO COM EITHER.
		 */
		org.junit.Assert.assertThat(pessoasDiferentes, 
				everyItem(
						anyOf(
								equalTo(Pessoa.pessoaIgual1), 
								equalTo(Pessoa.pessoaDiferente)
								)
						)
				);
	}
	
	
	@Test
	public void testAnyOfNot() {
		List<String> nomes = Arrays.asList("Pereira Prariro", "Francisco Bereu Chico");
		
		/**
		 * Todos devem satisfazer a nenhuma condição.
		 */
		org.junit.Assert.assertThat(nomes, 
				everyItem(
						not(
								anyOf(
										containsString("Abelardo"),
										containsString("Vieira")
										)
								)
						)
				);
	}
}
