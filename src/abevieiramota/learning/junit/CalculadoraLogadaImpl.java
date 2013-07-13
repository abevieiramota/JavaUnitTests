package abevieiramota.learning.junit;

public class CalculadoraLogadaImpl implements Calculadora {

	public Integer soma(Integer a, Integer b) {
		if(a == null || b == null) {
			throw new IllegalArgumentException();
		}
		
		System.out.printf("Somando %d e %d", a, b);
		return a + b;
	}

	public void inicializa() {
		System.out.printf("Calculadora %s ligada", this.getClass().getSimpleName());
	}
	
	public Integer soma(Integer[] valores) {
		
		if(valores == null) {
			throw new IllegalArgumentException();
		}
		
		System.out.println("Somando "+valores);
		Integer resultado = 0;
		for(Integer valor: valores) {
			resultado += valor;
		}
		return resultado;
	}

}
