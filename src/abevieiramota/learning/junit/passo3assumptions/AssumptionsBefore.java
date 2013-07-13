package abevieiramota.learning.junit.passo3assumptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Caso assumptions no before não sejam satisfeita, os testes são ignorados.
 * 	Por um bug no plugin do junit(ao menos na versão que estou utilizando, 4.8.2), os testes que possuam assume
 * 	não passando são indicados em 'Runs' e não contabilizados como 'Skipped'.
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class AssumptionsBefore {
	
	@Before
	public void setUp() {
		org.junit.Assume.assumeThat(Boolean.TRUE, is(equalTo(Boolean.FALSE)));
	}
	
	@Test
	public void testAssumption() {
		
	}
	
	@Test
	public void testAssumption2() {
		
	}

}
