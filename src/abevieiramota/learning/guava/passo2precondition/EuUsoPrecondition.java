package abevieiramota.learning.guava.passo2precondition;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;


public class EuUsoPrecondition implements EuTestoPrecondition {
	
	public void aquiNaoEntraNull(String naoSejaNull) {
		checkNotNull(naoSejaNull);
	}

	public void aquiNaoEntraNullComMensagem(String valor) {
		checkNotNull(valor, MENSAGEM_ERRO_NULL);
	}

	// apenas %s na mensagem template é reconhecido.
	// Observar que todos os checks possuem versões:
	// - (object)
	// - (object, mensagem)
	// - (object, mensagemTemplate, objetos...)
	public void aquiNaoEntraNullMensagemParametrizada(Object valor,	String mensagem, Object... params) {
		checkNotNull(valor, mensagem, params);
	}

	public void aquiNaoEntraStringComTamanhoMaiorQue10(String string) {
		checkNotNull(string);
		checkArgument(string.length() <= 10, EuTestoPrecondition.MENSAGEM_ERRO_STRING_GT_10);
	}


}
