package abevieiramota.learning.junit.passo2assertions.matcher.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.containsString;

/**
 * Verifica se contém a string.
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class ContainsString {
	
	@Test
	public void testContainsString() {
		String nome = "Abelardo Vieira Mota";
		
		org.junit.Assert.assertThat(
				
				nome,containsString("Vieira")
				
				);
	}

}
