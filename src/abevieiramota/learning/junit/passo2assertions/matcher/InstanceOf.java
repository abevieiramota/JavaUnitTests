package abevieiramota.learning.junit.passo2assertions.matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Pessoa;
import abevieiramota.learning.junit.PessoaDoMal;

import static org.hamcrest.CoreMatchers.instanceOf;


/**
 * Verifica se o objeto é instância de determinada classe.
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class InstanceOf {

	@Test
	public void testInstanceOf() {
		Pessoa pessoa = new PessoaDoMal("", "", "");
		
		org.junit.Assert.assertThat(pessoa, instanceOf(PessoaDoMal.class));
	}
}
