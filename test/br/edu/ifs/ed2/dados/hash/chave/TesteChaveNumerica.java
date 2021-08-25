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
public class TesteChaveNumerica {

	/*
	 * Instanciação de uma estratégia de geração de chave.
	 */
	private EstrategiaChave<Integer> chave = new ChaveNumerica();

	/**
	 * Testar método para
	 * {@link br.edu.ifs.ed2.dados.hash.chave.ChaveNumerica#gerarChave(java.lang.Integer)}.
	 */
	@Test
	public void testGerarChave() {

		/*
		 * Aplicação da função de geração da chave em números negativos.
		 */
		assertEquals(chave.gerarChave(-3), 3);
		assertEquals(chave.gerarChave(-2), 2);
		assertEquals(chave.gerarChave(-1), 1);
		
		/*
		 * Aplicação da função de geração da chave no número zero.
		 */
		assertEquals(chave.gerarChave(0), 0);

		/*
		 * Aplicação da função de geração da chave em números positivos.
		 */
		assertEquals(chave.gerarChave(1), 1);
		assertEquals(chave.gerarChave(2), 2);
		assertEquals(chave.gerarChave(3), 3);
	}
}
