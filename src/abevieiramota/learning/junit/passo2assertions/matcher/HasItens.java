package abevieiramota.learning.junit.passo2assertions.matcher;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Pessoa;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.hasItem;

/**
 * Subconjunto
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class HasItens {

	/**
	 * Testa se a primeira lista possui todos os itens da segunda lista.
	 */
	@Test
	public void testaSeTemItens() {
		List<Integer> itens = Arrays.asList(1,2,3,4,5);
		
		org.junit.Assert.assertThat(
				
				itens, 
				
				hasItems(1,2,3)
				
				);
	}
	
	
	/**
	 * Testa se possui um item.
	 */
	@Test
	public void testaSeTemItem() {
		List<Integer> itens = Arrays.asList(1,2,3,4,5);
		
		org.junit.Assert.assertThat(
				
				itens, 
				
				hasItem(1)
				
				);
	}
	
	/**
	 * Testa se possui um item, de tipo complexo.
	 * Obs: hasItens usa comparação via equals.
	 */
	@Test
	public void testaSeTemItemComplexo() {
		List<Pessoa> pessoasIguais = Arrays.asList(Pessoa.pessoaIgual1);
		
		org.junit.Assert.assertThat(
				
				pessoasIguais, 
				
				hasItem(Pessoa.pessoaIgual2)
				
				);
	}
}
