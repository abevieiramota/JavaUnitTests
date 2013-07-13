package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.isA;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Pessoa;
import abevieiramota.learning.junit.PessoaDoMal;

/**
 * Pelo que vi das discussões no github https://github.com/hamcrest/JavaHamcrest/issues/27 
 * 	o pessoal esqueceu de corrigir isso.
 * O corretor seria na assinatura <? super T> ser <? extends T>, de forma a permitir a verificação
 * 	de que um objeto de uma classe X é instância de uma subclasse sua.
 * 
 * O exemplo de teste ficaria:
 * 	Pessoa pessoa = new PessoaDoMal("Capiroto", "10", "Olá");
 * 
 * 	org.junit.Assert.assertThat(pessoa, isA(Pessoa.class));
 * @author abelardo.mota
 *
 */
@Ignore
@RunWith(JUnit4.class)
public class IsA {
	
	@Test
	public void testIsAPessoa() {
		PessoaDoMal pessoa = new PessoaDoMal("Capiroto", "10", "Olá");
		
		org.junit.Assert.assertThat(
				
				pessoa, 

				isA(Pessoa.class)
				);
	}

}
