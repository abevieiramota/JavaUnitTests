package abevieiramota.learning.junit.passo2assertions.parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestFile {

	private static final String MASSA_DE_DADOS_CSV_FILE_NAME = "massaDeDados.csv";
	private static final String MENSAGEM = "[{index}]:       {0} + {1} = {2}      ";

	@Parameters(name = MENSAGEM)
	public static Collection<? extends Object[]> data() throws IOException {
		return CSVUtil.linhas(MASSA_DE_DADOS_CSV_FILE_NAME);		
	}
	
	private int a;
	private int b;
	private int resultado;
	
	public ParameterizedTestFile(String a, String b, String resultado) {
		this.a = Integer.valueOf(a);
		this.b = Integer.valueOf(b);
		this.resultado = Integer.valueOf(resultado);
	}
	
	@Test
	public void testaSoma() {
		assertThat(
				
				a+b, 
				
				is(
						equalTo(
								Integer.valueOf(resultado)
								)
						)
				);
	}
}
