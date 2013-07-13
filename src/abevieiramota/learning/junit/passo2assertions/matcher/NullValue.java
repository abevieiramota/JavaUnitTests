package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Verifica se o valor é null;
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class NullValue {

	@Test
	public void testNullValue() {
		
		org.junit.Assert.assertThat(
				
				null,is(nullValue())
				
				);
	}
}
