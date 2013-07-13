package abevieiramota.learning.guava.passo2precondition;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TesteDePreconditions {
	
	private String mensagemDoTemplatePreenchida = String.format(EuTestoPrecondition.MENSAGEM_ERRO_NULL_TEMPLATE, EuTestoPrecondition.MENSAGEM_ERRO_NULL_TEMPLATE_VALOR_1, EuTestoPrecondition.MENSAGEM_ERRO_NULL_TEMPLATE_VALOR_2);
	
	// assertNotNull
	@Test(expected = NullPointerException.class)
	public void notNullPrecondition() {
		new EuUsoPrecondition().aquiNaoEntraNull(null);
	}

	@Test(expected = NullPointerException.class)
	public void notNullNormal() {
		new EuNAOUsoPrecondition().aquiNaoEntraNull(null);
	}
		// com mensagem
	@Test
	public void notNullPreconditionComMensagem() {
		try {
			new EuUsoPrecondition().aquiNaoEntraNullComMensagem(null);
			fail();
		} catch(NullPointerException ex) {
			assertThat(ex.getMessage(), is(equalTo(EuTestoPrecondition.MENSAGEM_ERRO_NULL)));
		}
	}

	@Test
	public void notNullNormalComMensagem() {
		try {
			new EuNAOUsoPrecondition().aquiNaoEntraNullComMensagem(null);
			fail();
		} catch(NullPointerException ex) {
			assertThat(ex.getMessage(), is(equalTo(EuTestoPrecondition.MENSAGEM_ERRO_NULL)));
		}
	}	
	
		// com mensagem parametrizada
	@Test
	public void notNullPreconditionComMensagemParametrizada() {
		try {
			new EuUsoPrecondition().aquiNaoEntraNullMensagemParametrizada(null, "[%s][%s]", "Valor 1", "Valor 2");
			fail();
		} catch(NullPointerException ex) {
			assertThat(ex.getMessage(), is(equalTo(mensagemDoTemplatePreenchida)));
		}
	}

	@Test
	public void notNullNormalComMensagemParametrizada() {
		try {
			new EuNAOUsoPrecondition().aquiNaoEntraNullMensagemParametrizada(null, "[%s][%s]", "Valor 1", "Valor 2");
			fail();
		} catch(NullPointerException ex) {
			assertThat(ex.getMessage(), is(equalTo(mensagemDoTemplatePreenchida)));
		}
	}
	
	// check de condições nos parâmetros
	@Test
	public void notGT10Precondition() {
		try {
			new EuUsoPrecondition().aquiNaoEntraStringComTamanhoMaiorQue10("string string string string");
		} catch(IllegalArgumentException ex) {
			assertThat(ex.getMessage(), is(equalTo(EuTestoPrecondition.MENSAGEM_ERRO_STRING_GT_10)));
		}
	}

	@Test
	public void notGT10Normal() {
		try {
			new EuNAOUsoPrecondition().aquiNaoEntraStringComTamanhoMaiorQue10("string string string string");
		} catch(IllegalArgumentException ex) {
			assertThat(ex.getMessage(), is(equalTo(EuTestoPrecondition.MENSAGEM_ERRO_STRING_GT_10)));
		}
	}

}
