package abevieiramota.learning.junit.passo2assertions.basics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Pessoa;

@RunWith(JUnit4.class)
public class AssertionsArrays {
	
	/**
	 * Testa se dois arrays são iguais.
	 */
	@Test
	public void testeDeArray() {
		byte[] expected = "teste".getBytes();
		byte[] actual = "teste".getBytes();
		org.junit.Assert.assertArrayEquals("Tem que ser igual...", expected, actual);		
	}
	
	/**
	 * Array de tipos complexos.
	 */
	@Test
	public void testeDeArrayTiposComplexos() {
		Pessoa[] pessoas1 = new Pessoa[] {Pessoa.pessoaIgual1, Pessoa.pessoaIgual1};
		
		Pessoa[] pessoas2 = new Pessoa[] {Pessoa.pessoaIgual2, Pessoa.pessoaIgual2};
		
		org.junit.Assert.assertArrayEquals(pessoas1, pessoas2);
	}
	

}
