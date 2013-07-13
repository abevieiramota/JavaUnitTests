package abevieiramota.learning.junit.passo2assertions.matcher.string;

import static org.hamcrest.CoreMatchers.endsWith;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class EndsWith {
	
	@Test
	public void testEndsWith() {
		String nome = "Abelardo Vieira Mota";
		
		org.junit.Assert.assertThat(
				
				nome,endsWith("Mota")
				
				);
	}

}
