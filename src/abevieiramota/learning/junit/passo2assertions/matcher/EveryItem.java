package abevieiramota.learning.junit.passo2assertions.matcher;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Match em todos os itens de um Collection.
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class EveryItem {

	@Test
	public void everyItemEhAbelardo() {
		String abelardo1 = "Abelardo Vieira Mota";
		String abelardo2 = "Abelardo Barbosa";
		
		org.junit.Assert.assertThat(
				
				Arrays.asList(abelardo1, abelardo2), 

				everyItem(
						containsString("Abelardo")
						)
				);
	}
}
