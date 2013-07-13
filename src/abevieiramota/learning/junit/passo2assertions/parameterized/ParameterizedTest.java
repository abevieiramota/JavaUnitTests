package abevieiramota.learning.junit.passo2assertions.parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {

	@Parameters(name = "[{index}]:       {0} + {1} = {2}      ")
	public static Collection<? extends Object[]> data() {
		return Arrays.asList(new Integer[][]{
			
				{1,2,3},
				{2,2,4},
				{3,4,7}
				
		});
	}
	
	private int a;
	private int b;
	private int resultado;
	
	public ParameterizedTest(Integer a, Integer b, Integer resultado) {
		this.a = a;
		this.b = b;
		this.resultado = resultado;
	}
	
	@Test
	public void testaSoma() {
		assertThat(
				a+b, 
				is(
						equalTo(
								Integer.valueOf(resultado)
								)
						)
				);
	}
}
