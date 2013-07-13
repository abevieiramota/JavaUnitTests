package abevieiramota.learning.junit.passo2assertions.basics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import abevieiramota.learning.junit.Pessoa;

@RunWith(JUnit4.class)
public class AssertionsEquals {
	
	// assertEquals 
	// tipos primitivos : ==
	// tipos complexos : equals
	
	
	/**
	 * assertEquals para tipo primitivo.
	 */
	@Test
	public void testEquals() {
		org.junit.Assert.assertEquals("Tem que ser igual...", 5L, 5L);
	}
	
	@Test
	public void testNotEquals() {
		org.junit.Assert.assertNotEquals("Não são iguais...", Pessoa.pessoaIgual1, Pessoa.pessoaDiferente);
	}
	
	/**
	 * assertEquals para tipo complexo.
	 */
	@Test
	public void testEqualsTipoComplexo() {
		org.junit.Assert.assertEquals("JUnit4 assertEquals usa o método equals.", Pessoa.pessoaIgual1, Pessoa.pessoaIgual2);
	}
	
	
	// assertSame 
	// ==
	
	@Test
	public void notSame() {
		org.junit.Assert.assertNotSame("Não são o mesmo objeto.", Pessoa.pessoaIgual1, Pessoa.pessoaIgual2);
	}
	
	@Test
	public void same() {
		org.junit.Assert.assertSame("São o mesmo objeto.", Pessoa.pessoaDiferente, Pessoa.pessoaDiferente);
	}

}
