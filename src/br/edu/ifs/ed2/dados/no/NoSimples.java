/**
 * 
 */
package br.edu.ifs.ed2.dados.no;

/**
 * Classe que implementas as operações de um nó com encadeamento simples
 * 
 * @author Marlos Tacio Silva
 *
 */
public class NoSimples<G> extends No<G> {

	/**
	 * Atributo que armazena uma referência para o nó posterior
	 */
	private NoSimples<G> posterior;

	/**
	 * Construtor da classe
	 * 
	 * @param conteudo Conteúdo do nó
	 */
	public NoSimples(G conteudo) {

		super(conteudo);
	}

	/**
	 * Método que retorna uma referência para o próximo nó
	 * 
	 * @return Uma referência para o próximo nó, caso exista, ou nulo, caso
	 *         contrário
	 */
	public NoSimples<G> getPosterior() {

		return posterior;
	}

	/**
	 * Método que altera a referência para o nó posterior
	 * 
	 * @param posterior O nó a ser inserido
	 * 
	 * @return Uma referência para o próprio nó (encadeamento de operações)
	 */
	public NoSimples<G> setPosterior(NoSimples<G> posterior) {

		this.posterior = posterior;

		return this;
	}
}
