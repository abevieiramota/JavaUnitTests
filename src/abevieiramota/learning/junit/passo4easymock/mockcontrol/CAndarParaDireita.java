package abevieiramota.learning.junit.passo4easymock.mockcontrol;


public class CAndarParaDireita extends Comando {

	@Override
	void executar(Robo robo) {
		System.out.printf("[%s] : andou para direita", robo.getNome());
	}

}
