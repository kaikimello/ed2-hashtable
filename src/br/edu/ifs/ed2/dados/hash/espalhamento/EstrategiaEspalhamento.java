/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.espalhamento;

/**
 * Interface que define a operação de espalhamento dos elementos na tabela.
 * 
 *
 *
 */
public interface EstrategiaEspalhamento<G> {

	/**
	 * Método para calcular o índice de um elemento a partir de sua chave.
	 * 
	 * @param chave   Chave do elemento a ser inserido.
	 * 
	 * @param tamanho Tamanho da tabela de espalhamento.
	 * 
	 * @return Índice em que o elemento será inserido.
	 */
	public int calcularIndice(int chave, int tamanho);

}
