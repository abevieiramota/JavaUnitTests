package abevieiramota.learning.junit.passo5theories;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashMap;
import java.util.Map;

public class Ponto implements Comparable<Ponto> {
	
	public static final Integer PESO_DEFAULT = 1;

	private Map<Ponto, Integer> vizinhos;
	
	private Integer id;
	
	private static Integer ID_BASE = 0;
	
	public Ponto() {
		vizinhos = new HashMap<Ponto, Integer>();
		id = ID_BASE++;
	}
	
	public Integer id() {
		return this.id;
	}
	
	public void addVizinho(Ponto vizinho) {
		addVizinho(vizinho, PESO_DEFAULT);
	}
	
	public void addVizinho(Ponto vizinho, Integer peso) {
		checkNotNull(vizinho);
		checkNotNull(peso);
		if(!this.isVizinho(vizinho)) {
			vizinhos.put(vizinho, peso);
			vizinho.addVizinho(this);
		}
	}
	
	public Integer numVizinhos() {
		return vizinhos.size();
	}
	
	public Integer pesoVizinhanca() {
		Integer resultado = 0;
		for(Integer i: vizinhos.values())
			resultado += i;
		return resultado;
	}
	
	public Boolean isVizinho(Ponto ponto) {
		checkNotNull(ponto);
		return vizinhos.keySet().contains(ponto);
	}

	public int compareTo(Ponto o) {
		checkNotNull(o);
		int resultado = 0;
		if(id > o.id) {
			resultado = 1;
		} else if(id < o.id) {
			resultado = -1;
		}
		return resultado;
	}
	
}
