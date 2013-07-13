package abevieiramota.learning.junit.passo5theories;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import org.junit.AfterClass;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import abevieiramota.learning.junit.passo5theories.suppliers.PontoSupplier;

@RunWith(Theories.class)
public class PontoAumentoDeVizinhos {
	
	private static int quantidadeExecutada = 0;
	
	@DataPoints
	public static Ponto[] pontosX() {
		return PontoSupplier.instance().pontosSimples(QUANTIDADE_DE_PONTOS_UNDER_TEST);
	}

	@DataPoints
	public static Ponto[] pontosY() {
		return PontoSupplier.instance().pontosSimples(QUANTIDADE_DE_PONTOS_UNDER_TEST);
	}

	
	@DataPoints
	public static Integer[] pesos() {
		return new Integer[] {1,2,3,4};
	}
	
	// cuidado com a explosão combinatória.
	private static final Integer QUANTIDADE_DE_PONTOS_UNDER_TEST = 10;
	
	@Theory
	public void adicionarVizinhoAumentaAQuantidade(Ponto a, Ponto b, Integer peso) {
		// pre condições
		assumeThat(a, is(notNullValue()));
		assumeThat(b, is(notNullValue()));
		assumeThat(a.isVizinho(b), not(Boolean.TRUE));
		
		// valores antigos
		Integer quantidadeAntiga = a.numVizinhos();
		Integer pesoAntigo = a.pesoVizinhanca();
		
		// método under test
		a.addVizinho(b);
		
		// valores atualizados
		Integer novaQuantidade = a.numVizinhos();
		Integer novoPeso = a.pesoVizinhanca();
				
		// asserts
		assertThat(novaQuantidade, is(equalTo(quantidadeAntiga + 1)));
		assertThat(novoPeso, is(equalTo(pesoAntigo + Ponto.PESO_DEFAULT)));
		quantidadeExecutada++;
	}
	
	@AfterClass
	public static void doAfterClass() {
		System.out.println(quantidadeExecutada);
	}

}
