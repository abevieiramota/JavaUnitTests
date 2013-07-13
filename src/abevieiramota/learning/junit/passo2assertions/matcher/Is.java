package abevieiramota.learning.junit.passo2assertions.matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;;

/**
 * Sem efeito, apenas para deixar mais legível.
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class Is {

	@Test
	public void testIs() {
		String nome = "Abelardo Vieira Mota";
		
		org.junit.Assert.assertThat(nome, is(nome));
	}
}
