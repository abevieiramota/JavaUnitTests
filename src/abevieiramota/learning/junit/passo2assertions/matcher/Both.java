package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * &&
 * 
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class Both {

	/**
	 * Um both.
	 */
	@Test
	public void bothContainsString() {
		String nome = "Abelardo Vieira Mota";
		
		org.junit.Assert.assertThat(
				
				nome, 
				both(containsString("Abelardo")).and(containsString("Vieira")));
		
	}
	
	/**
	 * Dois both.
	 */
	@Test
	public void bothAndBoth() {
		String nome = "Abelardo Vieira Mota";
		
		org.junit.Assert.assertThat(
				
				nome, both(containsString("Abelardo")).and(both(containsString("Vieira")).and(containsString("Mota")))
				
				);
	}
	
	
}
