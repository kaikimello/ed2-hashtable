/**
 * 
 */
package br.edu.ifs.ed2.dados.no;

/**
 * Classe que implementas as operações de um nó com encadeamento duplo
 * 
 * @author Marlos Tacio Silva
 *
 */
public class NoDuplo<G> extends No<G> {

	/**
	 * Atributo que armazena uma referência para o nó posterior
	 */
	private NoDuplo<G> posterior;

	/**
	 * Atributo que armazena uma referência para o nó anterior
	 */
	private NoDuplo<G> anterior;

	/**
	 * Construtor da classe
	 * 
	 * @param conteudo Conteúdo do nó
	 */
	public NoDuplo(G conteudo) {

		super(conteudo);
	}

	/**
	 * Método que retorna uma referência para o próximo nó
	 * 
	 * @return Uma referência para o próximo nó, caso exista, ou nulo, caso
	 *         contrário
	 */
	public NoDuplo<G> getPosterior() {

		return posterior;
	}

	/**
	 * Método que altera a referência para o nó posterior. Essa operação efetua a
	 * ligação entre as referências posterior e anterior dos nós envolvidos.
	 * 
	 * @param posterior O nó a ser inserido
	 * 
	 * @return Uma referência para o próprio nó (encadeamento de operações)
	 */
	public NoDuplo<G> setPosterior(NoDuplo<G> posterior) {

		if (this.posterior == posterior) {

			return this;
		}

		this.posterior = posterior;

		if (posterior != null) {

			posterior.setAnterior(this);
		}

		return this;
	}

	/**
	 * Método que retorna uma referência para o nó anterior
	 * 
	 * @return Uma referência para o nó anterior, caso exista, ou nulo, caso
	 *         contrário
	 */
	public NoDuplo<G> getAnterior() {

		return anterior;
	}

	/**
	 * Método que altera a referência para o nó anterior. Essa operação efetua a
	 * ligação entre as referências posterior e anterior dos nós envolvidos.
	 * 
	 * @param anterior O nó a ser inserido
	 * 
	 * @return Uma referência para o próprio nó (encadeamento de operações)
	 */
	public NoDuplo<G> setAnterior(NoDuplo<G> anterior) {

		if (this.anterior == anterior) {

			return this;
		}

		this.anterior = anterior;

		if (anterior != null) {

			anterior.setPosterior(this);
		}

		return this;
	}
}
