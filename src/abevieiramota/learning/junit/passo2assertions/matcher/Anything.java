package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.anything;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Matcher que sempre retorna true.
 * @author abelardo.mota
 *
 */
// TODO: qual a utilidade?
@RunWith(JUnit4.class)
public class Anything {
	
	@Test
	public void testAnything() {
		org.junit.Assert.assertThat(null, anything());
	}
	
	@Test
	public void testAnythingString() {
		org.junit.Assert.assertThat(null, anything("Retorno true sempre porque sempre sou verdadeiro"));
	}
}
