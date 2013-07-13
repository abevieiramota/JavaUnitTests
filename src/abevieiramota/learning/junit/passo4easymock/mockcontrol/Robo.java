package abevieiramota.learning.junit.passo4easymock.mockcontrol;

import java.util.ArrayList;
import java.util.List;

public class Robo {
	
	private List<Comando> comandos;
	private String nome;
	
	public Robo(String nome) {
		if(nome == null) {
			throw new IllegalArgumentException();
		}
		
		this.comandos = new ArrayList<Comando>();
		this.nome = nome;
	}
	
	public void addComando(Comando comando) {
		if(comando == null) {
			throw new IllegalArgumentException();
		}
		
		comandos.add(comando);
	}
	
	public void execute() {
		for(Comando comando: comandos) {
			comando.executar(this);
		}
	}
	
	public String getNome() {
		return this.nome;
	}
}
