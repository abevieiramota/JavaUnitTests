package abevieiramota.learning.junit;

/**
 * Calculadora para {@link Integer}.
 * @author abelardo.mota
 *
 */
public interface Calculadora {

	/**
	 * Calcula a soma de dois inteiros.
	 * @param a
	 * @param b
	 * @return
	 */
	Integer soma(Integer a, Integer b);
	
	void inicializa();
	
	Integer soma(Integer[] valores);
}
