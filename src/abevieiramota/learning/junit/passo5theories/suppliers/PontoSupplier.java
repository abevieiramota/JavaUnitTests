package abevieiramota.learning.junit.passo5theories.suppliers;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import abevieiramota.learning.junit.passo5theories.Ponto;

public class PontoSupplier {
	
	private static PontoSupplier instance = new PontoSupplier();
	
	private PontoSupplier() {
	}
	
	public static PontoSupplier instance() {
		return instance;
	}
	
	public Ponto pontoSimples() {
		return new Ponto();
	}
	
	public Ponto[] pontosSimples(Integer quantidade) {
		checkNotNull(quantidade);
		checkArgument(quantidade > 0);
		Ponto[] pontos = new Ponto[quantidade];
		for(int i=0; i<quantidade; i++)
			pontos[i] = pontoSimples();
		return pontos;
	}

}
