package abevieiramota.learning.guava.passo2precondition;

public interface EuTestoPrecondition {
	
	public static String MENSAGEM_ERRO_NULL = "Não entra null aqui não!";

	public static String MENSAGEM_ERRO_NULL_TEMPLATE = "[%s][%s]";
	
	public static String MENSAGEM_ERRO_NULL_TEMPLATE_VALOR_1 = "Valor 1";
	
	public static String MENSAGEM_ERRO_NULL_TEMPLATE_VALOR_2 = "Valor 2";

	public static String MENSAGEM_ERRO_STRING_GT_10 = "Só pode String com tamanho igual a no máximo 10";

	void aquiNaoEntraNull(String valor);
	
	void aquiNaoEntraNullComMensagem(String valor);
	
	void aquiNaoEntraNullMensagemParametrizada(Object valor, String mensagem, Object... params);
	
	void aquiNaoEntraStringComTamanhoMaiorQue10(String string);
}
