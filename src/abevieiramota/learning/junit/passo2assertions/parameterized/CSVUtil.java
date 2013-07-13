package abevieiramota.learning.junit.passo2assertions.parameterized;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public final class CSVUtil {
	
	private static final Charset DEFAULT_CHARSET = Charsets.UTF_8;
	private static final String DEFAULT_VALUE_SEPARATOR = ",";
	

	public static List<String[]> linhas(String fileName) throws IOException {
		return linhas(fileName, DEFAULT_VALUE_SEPARATOR);
	}
	
	
	public static List<String[]> linhas(String fileName, String valueSeparator) throws IOException {
		return linhas(fileName, valueSeparator, DEFAULT_CHARSET);
	}
	
	
	public static List<String[]> linhas(String fileName, String valueSeparator, Charset charset) throws IOException {
		
		List<String> dadosDoArquivo = Files.readLines(new File(fileName), charset);

		List<String[]> dados = new ArrayList<String[]>(dadosDoArquivo.size());
		
		for(String linhaDoArquivo: dadosDoArquivo) {
			dados.add(linhaDoArquivo.split(valueSeparator));
		}
		
		return dados;
	}

}
