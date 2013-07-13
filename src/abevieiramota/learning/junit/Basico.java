package abevieiramota.learning.junit;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * 
 * @author abelardo.mota
 *
 */
// indica qual Runner ir� executar os testes desta classe.
@RunWith(JUnit4.class)
public class Basico {
	
	@Test
	// se um teste n�o possui assert, passa.
	public void thisAlwaysPass() {}
	
	@Test
	// informa que este teste dever� ser ignorado. ver que a view do JUnit no Eclipse informa a quantidade de testes ignorados.
	// 	pode ser aplicado � classe, informando que todos os testes da classe anotada devem ser ignorados.
	@Ignore
	public void thisIsIgnored() {}

}
