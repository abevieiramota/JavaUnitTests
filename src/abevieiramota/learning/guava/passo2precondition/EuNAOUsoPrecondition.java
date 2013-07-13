package abevieiramota.learning.guava.passo2precondition;

public class EuNAOUsoPrecondition implements EuTestoPrecondition {

	public void aquiNaoEntraNull(String valor) {
		if(valor == null) {
			throw new NullPointerException();
		}
	}

	public void aquiNaoEntraNullComMensagem(String valor) {
		if(valor == null) {
			throw new NullPointerException(MENSAGEM_ERRO_NULL);
		}
	}

	public void aquiNaoEntraNullMensagemParametrizada(Object valor,	String mensagem, Object... params) {
		if(valor == null) {
			throw new NullPointerException(String.format(mensagem, params));
		}
	}

	public void aquiNaoEntraStringComTamanhoMaiorQue10(String string) {
		if(string == null) {
			throw new NullPointerException();
		}
		if(string.length() > 10) {
			throw new IllegalArgumentException(EuTestoPrecondition.MENSAGEM_ERRO_STRING_GT_10);
		}
		
	}

}
