package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class Not {
	
	@Test
	public void testNotContainsString() {
		String nome = "Abelardo Vieira Mota";
		
		org.junit.Assert.assertThat(
				
				nome, 

				not(
						containsString("Bereu")
						)
				);
	}
	
	
	@Test
	public void testNotNotNotContainsString() {
		String nome = "Abelardo Vieira Mota";
		
		org.junit.Assert.assertThat(
				
				nome, 
				
				not(
						not(
								not(
										containsString("Bereu")
										)
								)
						)
				);
	}

}
