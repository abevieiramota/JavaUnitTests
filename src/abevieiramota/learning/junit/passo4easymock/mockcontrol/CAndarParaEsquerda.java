package abevieiramota.learning.junit.passo4easymock.mockcontrol;

public class CAndarParaEsquerda extends Comando {

	@Override
	void executar(Robo robo) {		
		System.out.printf("[%s] : andou para esquerda", robo.getNome());
	}

}
