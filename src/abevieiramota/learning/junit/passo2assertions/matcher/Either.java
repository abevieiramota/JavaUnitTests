package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.not;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Não entendo porque não funciona, mas esperava que o comportamento
 * 	fosse de passar apenas se APENAS uma condição fosse satisfeita.
 * 
 * Parece similar ao both, mas para OR.
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class Either {

	@Test
	public void testAnyOf() {
		List<String> nomes = Arrays.asList("Abelardo Vieira", "Francisco Bereu Vieira");
		
		/**
		 * Todos devem satisfazer APENAS uma condição.
		 * PARECIDO COM ANYOF.
		 */
		org.junit.Assert.assertThat(nomes, 
				everyItem(
						either(
								containsString("Abelardo")
								).or( 
										containsString("Vieira")
										)
						)
				);
	}
	
	@Test
	public void testAnyOfNot() {
		List<String> nomes = Arrays.asList("Neto Chico", "Francisco Bereu Chico");
		
		/**
		 * Todos devem satisfazer APENAS uma condição.
		 * PARECIDO COM ANYOF.
		 */
		org.junit.Assert.assertThat(nomes, 
				everyItem(
						not(
								either(
										containsString("Abelardo")
										).or( 
												containsString("Vieira")
												)
								)
						)
				);
	}
}
