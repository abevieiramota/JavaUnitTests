package abevieiramota.learning.guava.passo1null;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.google.common.base.Optional;


/**
 * https://code.google.com/p/guava-libraries/wiki/UsingAndAvoidingNullExplained
 * 
 * Recomenda-se a evitar o uso de null, por poder causar ambiguidades.
 * 
 * Útil quando utiliza-se valores que podem ou não estar presentes.
 * 
 * > pensar melhor <
 * @author abelardo.mota
 *
 */
@RunWith(JUnit4.class)
public class GuavaNull {
	
	@Test
	public void usoDeOptional() {
		Integer valor = 5;
		
		Optional<Integer> optInt = Optional.of(valor);
		
		assertThat(optInt.isPresent(), is(equalTo(Boolean.TRUE)));
		assertThat(optInt.get(), is(equalTo(valor)));
	}
	
	/**
	 * Optional.of lança NullPointerException, caso o valor informado seja null.
	 */
	@Test(expected = NullPointerException.class)
	public void usoDeOptionalComNull() {
		Optional.of(null);
	}
	
	/**
	 * Optional.fromNullable cria um Optional com o of, caso != null, ou um Optional absent,
	 * 	isto é, sem valor.
	 */
	// caso .get seja chamado em um Optional absent, lança-se uma IllegalStateException
	@Test(expected = IllegalStateException.class)
	public void usoDeOptionalAbsentGet() {
		Integer valor = null;
		
		Optional<Integer> optInt = Optional.fromNullable(valor);
		
		assertThat(optInt.isPresent(), is(equalTo(Boolean.FALSE)));
		assertThat(optInt.get(), is(equalTo(valor)));
	}
	
	/**
	 * Caso deva ser retornado o valor, mesmo que possa ser null, deve-se usar 
	 * 	.orNull()
	 */
	@Test
	public void usoDeOptionalAbsentOrNull() {
		Integer valor = null;
		
		Optional<Integer> optInt = Optional.fromNullable(valor);
		
		assertThat(optInt.isPresent(), is(equalTo(Boolean.FALSE)));
		assertThat(optInt.orNull(), is(equalTo(valor)));
	}

	/**
	 * Pode-se criar um Optional absent com
	 * 	.absent()
	 */
	// 	UTILIDADE?
	@Test
	public void usoDeOptionalAbsentCriandoAbsent() {
		Optional<Integer> optInt = Optional.absent();
		
		assertThat(optInt.isPresent(), is(equalTo(Boolean.FALSE)));
		assertThat(optInt.orNull(), is(equalTo(null)));
	}
	
	/**
	 * Legal!
	 * 
	 * Retorno de valor default!!!!!!
	 */
	@Test
	public void usoDeOptionalValorDefault() {
		Integer valorDefault = 33;
		Optional<Integer> optInt = Optional.absent();
		
		assertThat(optInt.isPresent(), is(equalTo(Boolean.FALSE)));
		assertThat(optInt.or(valorDefault), is(equalTo(valorDefault)));
	}

}
