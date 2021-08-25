/**
 * 
 */
package br.edu.ifs.ed2.dados.lista;

import br.edu.ifs.ed2.dados.no.No;

/**
 * Interface que estabelece as operações básicas de uma lista
 * 
 * 
 *
 */
public interface Lista<G> {

	/**
	 * Método para a inserção de um elemento no inicio da lista
	 * 
	 * @param conteudo Conteúdo a ser inserido na lista
	 * 
	 * @return Uma referência para a lista (encadeamento de operações)
	 */
	public Lista<G> inserirInicio(G conteudo);

	/**
	 * Método para a inserção de um elemento no fim da lista
	 * 
	 * @param conteudo Conteúdo a ser inserido na lista
	 * 
	 * @return Uma referência para a lista (encadeamento de operações)
	 */
	public Lista<G> inserirFim(G conteudo);

	/**
	 * Método para a remoção de um elemento da lista
	 * 
	 * @param conteudo Conteúdo a ser removido
	 * 
	 * @return Verdadeiro em caso de remoção bem sucedida e falso caso contrário
	 */
	public boolean remover(G conteudo);

	/**
	 * Método para a remoção de um elemento do inicio lista
	 * 
	 * @return Verdadeiro em caso de remoção bem sucedida e falso caso contrário
	 */
	public boolean removerInicio();

	/**
	 * Método para a remoção de um elemento do fim lista
	 * 
	 * @return Verdadeiro em caso de remoção bem sucedida e falso caso contrário
	 */
	public boolean removerFim();

	/**
	 * Método para a busca de um elemento da lista
	 * 
	 * @param conteudo Conteúdo a ser buscado
	 * 
	 * @return Uma referência para o conteúdo em caso de busca bem sucedida e nulo
	 *         caso contrário
	 */
	public No<G> buscar(G conteudo);

	/**
	 * Método que verifica se a lista está vazia
	 * 
	 * @return Verdadeiro em caso de lista vazia e falso caso contrário
	 */
	public boolean estaVazia();

	/**
	 * Método que remove todos os elementos da lista
	 * 
	 * @return Uma referência para a lista (encadeamento de operações)
	 */
	public Lista<G> limpar();

}
