package abevieiramota.learning.junit.passo2assertions.parameterized.zohhak;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@RunWith(ZohhakRunner.class)
public class ParameterizedWithZohhak {
	
	
	@TestWith({
		"1,2,3",
		"2,3,5",
		"3,4,7"
	})
	public void testSoma(Integer a, Integer b, Integer expected) {
		Integer resultado = a + b;
		assertThat(
				resultado, 
				
				is(
						equalTo(expected)
						)
				);
	}

}
