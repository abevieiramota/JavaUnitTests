package abevieiramota.learning.junit.passo5theories;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import abevieiramota.learning.junit.passo5theories.suppliers.PontoSupplier;

@RunWith(Theories.class)
public class PontoComutatividade {
	
	@DataPoint
	public static Ponto pontoX = PontoSupplier.instance().pontoSimples();

	@DataPoint
	public static Ponto pontoY = PontoSupplier.instance().pontoSimples();
	
	@Theory
	public void comutativo(Ponto a, Ponto b) {
		assumeThat(a, is(notNullValue()));
		assumeThat(b, is(notNullValue()));
		
		a.addVizinho(b);
		
		assertThat(a.isVizinho(b), is(Boolean.TRUE));
		assertThat(b.isVizinho(a), is(Boolean.TRUE));
	}

}
