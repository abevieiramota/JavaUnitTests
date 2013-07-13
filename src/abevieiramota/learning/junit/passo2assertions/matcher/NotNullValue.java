package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NotNullValue {

	@Test
	public void testNotNullValue() {
		
		org.junit.Assert.assertThat(
				
				new Object(),is(notNullValue())
				
				);
	}
}
