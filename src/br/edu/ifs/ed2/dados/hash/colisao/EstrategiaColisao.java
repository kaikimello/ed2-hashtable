/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import br.edu.ifs.ed2.dados.hash.Hash;

/**
 * Interface que define a operação de tratamento de colisões na tabela.
 * 
 * 
 *
 */
public interface EstrategiaColisao<G> {

	/**
	 * Método que aplica uma técnica de tratamento de colisão, a partir de um índice
	 * inicial, no intuito de obter o índice de uma célula não ocupada.
	 * 
	 * @param indiceInicial Índice inicial.
	 * 
	 * @param tabela        Tabela de espalhamento.
	 * 
	 * @return Índice obtido após a resolução da colisão, em caso de resolução bem
	 *         sucedida, ou -1, em caso de tabela cheia.
	 */
	public int obterIndice(int indiceInicial, Hash<G> tabela);

	/**
	 * Método que aplica uma técnica de tratamento de colisão, a partir de um índice
	 * inicial, no intuito de buscar um determinado conteúdo na tabela de
	 * espalhamento.
	 * 
	 * @param indiceInicial Índice inicial.
	 * 
	 * @param tabela        Tabela de espalhamento.
	 * 
	 * @param conteudo      Conteúdo a ser buscado.
	 * 
	 * @return Índice obtido após a resolução da colisão, em caso de buscar bem
	 *         sucedida, ou -1, em caso de busca mal sucedida.
	 */
	public int obterIndice(int indiceInicial, Hash<G> tabela, G conteudo);

}
