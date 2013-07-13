package abevieiramota.learning.junit.passo2assertions.parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@Ignore
@RunWith(Parameterized.class)
public class ParameterizedTestJDBC {
	
	private static final String JDBC_DRIVER_NAME = "org.postgresql.Driver";
	private static final String MENSAGEM = "[{index}]:       {0} + {1} = {2}      ";
	private static final String QUERY = "SELECT * FROM \"Dados\"";
	private static final String JDBC_CONNECTION_URL = "jdbc:postgresql://localhost/postgres";

	@Parameters(name = MENSAGEM)
	public static Collection<? extends Object[]> data() throws IOException, ClassNotFoundException, SQLException {
		return JDBCUtil.linhas(QUERY, JDBC_CONNECTION_URL, JDBC_DRIVER_NAME);		
	}
	
	private int a;
	private int b;
	private int resultado;
	
	public ParameterizedTestJDBC(String a, String b, String resultado) {
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
