/**
 * 
 */
package br.edu.ifs.ed2.dados.no;

/**
 * Classe abstrata que modela as operações de um nó de uma lista encadeada
 * 
 * @author Marlos Tacio Silva
 *
 */
public abstract class No<G> {

	/**
	 * Atributo genérico para o armazenamento do conteúdo do nó
	 */
	private G conteudo;

	/**
	 * Construtor da classe
	 * 
	 * @param conteudo Conteúdo do nó
	 */
	public No(G conteudo) {

		this.setConteudo(conteudo);
	}

	/**
	 * Método que retorna o conteúdo do nó
	 * 
	 * @return Uma referência para o conteúdo do nó
	 */
	public G getConteudo() {

		return this.conteudo;
	}

	/**
	 * Método que altera o conteúdo do nó
	 * 
	 * @param conteudo Conteúdo a ser inserido
	 * 
	 * @return Uma referência para o nó (encadeamento de operações)
	 */
	protected No<G> setConteudo(G conteudo) {

		this.conteudo = conteudo;

		return this;
	}

	/**
	 * Método que retorna uma representação do nó em formato texto (string)
	 */
	@Override
	public String toString() {

		return this.getConteudo().toString();
	}
}
