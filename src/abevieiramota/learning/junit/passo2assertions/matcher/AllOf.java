package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.not;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * &&
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class AllOf {
	
	/**
	 * AND de matchers.
	 */
	@Test
	public void allOfAbelardoHasVieira() {
		String abelardo1 = "Abelardo Vieira Mota";
		String abelardo2 = "Abelardo Vieira Barbosa";
		String bereu = "Bereu bereludo Abelardo Vieira";
		
		List<String> nomes = Arrays.asList(abelardo1, abelardo2, bereu);
		
		/**
		 * Todos devem satisfazer todas condições em allOf.
		 */
		org.junit.Assert.assertThat(
				
				nomes, 
				
				everyItem(
						allOf(
								containsString("Abelardo"), 
								containsString("Vieira")
								)
						)
				);
	}

	/**
	 * Não é verdade que todos passam.
	 */
	@Test
	public void notAllOfAbelardoHasVieira() {
		String abelardo1 = "Abelardo Vieira Mota";
		String abelardo2 = "Abelardo Vieira Barbosa";
		String bereu = "Bereu bereludo Abelardo Vieir";
		
		List<String> nomes = Arrays.asList(abelardo1, abelardo2, bereu);
		
		/** 
		 * Pelo menos um item não deve satisfazer todas as condições.
		 */
		org.junit.Assert.assertThat(
				
				nomes, 
				
				not(
						everyItem(
								allOf(
										containsString("Abelardo"), 
										containsString("Vieira")
										)
								)
						)
				);
	}

}
