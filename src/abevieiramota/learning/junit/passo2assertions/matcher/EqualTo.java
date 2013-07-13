package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Pessoa;

/**
 * equals
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class EqualTo {
	
	@Test
	public void equalToTest() {
		List<Pessoa> pessoasIguais = Arrays.asList(Pessoa.pessoaIgual1, Pessoa.pessoaIgual2);
		
		org.junit.Assert.assertThat(
				
				pessoasIguais, 

				everyItem(
						is(
								equalTo(Pessoa.pessoaIgual1)
								)
						)
				);
	}

}
