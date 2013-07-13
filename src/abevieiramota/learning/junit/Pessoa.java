package abevieiramota.learning.junit;


/**
 * Classe para teste de equals.
 * Possui 3 campos, mas apenas dois são utilizados no equals.
 * @author abelardo.mota
 *
 */
public class Pessoa {
	
	public static Pessoa pessoaIgual1;
	public static Pessoa pessoaIgual2;
	public static Pessoa pessoaDiferente;
	
	static {
		pessoaIgual1 = new Pessoa("Abelardo", "23", "oi");
		pessoaIgual2 = new Pessoa("Abelardo", "23", "Muito Oi.");
		pessoaDiferente = new Pessoa("Odraleba", "62", "Olá.");
	}
	
	private String nome;
	
	private String idade;
	
	private String teste;

	public Pessoa(String nome, String idade, String teste) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.teste = teste;
	}
	
	public String testarOutraPessoa(Pessoa outraPessoa){
		if(outraPessoa == null) {
			throw new IllegalArgumentException();
		}
		
		return String.format("Oi %s : %s", teste, outraPessoa.teste);
	}
	
	public String falar(String frase) {
		if(frase == null) {
			throw new IllegalArgumentException();
		}
		
		return String.format("%s : %s", nome, frase);
	}
	
	
	@Override
	public boolean equals(Object o) {
		boolean resultado = false;
		if(o instanceof Pessoa) {
			Pessoa pessoa = (Pessoa) o;
			boolean nomeIgual = false;
			boolean idadeIgual = false;
			if(getNome() != null) {
				nomeIgual = getNome().equals(pessoa.getNome());
			} else {
				nomeIgual = pessoa.getNome() == null;
			}
			if(idade != null) {
				idadeIgual = idade.equals(pessoa.idade);
			} else {
				idadeIgual = pessoa.idade == null;
			}
			resultado = nomeIgual && idadeIgual;
		}
		return resultado;
	}


	public String getNome() {
		return nome;
	}

}
