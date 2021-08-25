/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.chave;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 *
 */
public class TesteChaveTextual {

	/*
	 * Instanciação de uma estratégia de geração de chave
	 */
	private EstrategiaChave<String> chave = new ChaveTextual();

	/**
	 * Testar método para
	 * {@link br.edu.ifs.ed2.dados.hash.chave.ChaveTextual#gerarChave(java.lang.String)}.
	 */
	@Test
	public void testGerarChave() {

		/*
		 * Aplicação da função de geração da chave em um texto vazio.
		 */
		assertEquals(chave.gerarChave(""), 0);

		/*
		 * Aplicação da função de geração da chave em uma letra (maiúscula e minúscula).
		 */
		assertEquals(chave.gerarChave("a"), 97);
		assertEquals(chave.gerarChave("A"), 97);

		/*
		 * Aplicação da função de geração da chave em combinação e duas letras
		 * (maiúscula e minúscula).
		 */
		assertEquals(chave.gerarChave("ab"), 3105);
		assertEquals(chave.gerarChave("AB"), 3105);
		assertEquals(chave.gerarChave("aB"), 3105);
		assertEquals(chave.gerarChave("Ab"), 3105);

		/*
		 * Aplicação da função de geração da chave em uma palavra (maiúscula e
		 * minúscula).
		 */
		assertEquals(chave.gerarChave("uva"), 116192);
		assertEquals(chave.gerarChave("UVA"), 116192);

	}
}
