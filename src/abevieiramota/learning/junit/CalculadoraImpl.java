package abevieiramota.learning.junit;

public class CalculadoraImpl implements Calculadora {

	public Integer soma(Integer a, Integer b) {
		if(a == null || b == null) {
			throw new IllegalArgumentException();
		}
		
		return a+b;
	}

	public void inicializa() {
		System.out.printf("Calculadora %s ligada", this.getClass().getSimpleName());
	}

	public Integer soma(Integer[] valores) {
		
		if(valores == null) {
			throw new IllegalArgumentException();
		}
		
		Integer resultado = 0;
		for(Integer valor: valores) {
			resultado += valor;
		}
		return resultado;
	}

}
