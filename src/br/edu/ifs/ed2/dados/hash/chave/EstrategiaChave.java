/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.chave;

/**
 * Interface que define a operação de construção da chave de um elemento.
 * 
 * 
 *
 */
public interface EstrategiaChave<G> {

	/**
	 * Método que calcula o valor de uma chave a partir do conteúdo de um elemento.
	 * 
	 * @param conteudo Conteúdo em foco.
	 * 
	 * @return Chave calculada.
	 */
	public int gerarChave(G conteudo);

}
