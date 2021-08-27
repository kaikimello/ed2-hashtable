/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import br.edu.ifs.ed2.dados.hash.Hash;
import br.edu.ifs.ed2.dados.hash.HashEncadeado;

/**
 * Classe que implementa a operação de tratamento de colisões na tabela.
 * 
 * 
 *
 */
public class ColisaoEncadeada<G> implements EstrategiaColisao<G> {

	/**
	 * 
	 */
	@Override
	public int obterIndice(int indiceInicial, Hash<G> tabela) {

		/*
		 * Inicialização do novo índice.
		 */
		int novoIndice = 0;

		/*
		 * Resolução da colisão e, consequentemente, cálculo do novo valor do índice.
		 */
		novoIndice = indiceInicial % tabela.getTamanho();

		/*
		 * Retorno do novo índice.
		 */
		return novoIndice;
	}

	@Override
	public int obterIndice(int indiceInicial, Hash<G> tabela, G conteudo) {

		/*
		 * Coerção da tabela para um hash encadeado.
		 */
		HashEncadeado<G> hash = (HashEncadeado<G>) tabela;

		/*
		 * Verificação da condição da célula da tabela referente ao índice inicial.
		 */
		if (hash.getTabela()[indiceInicial] == null) {
			return -1;

		}

		/*
		 * Verificação da lista alocada na célula da tabela referente ao índice inicial.
		 */
		if (hash.getTabela()[indiceInicial].buscar(conteudo) == null) {
			return -1;

		}

		/*
		 * Retorno do índice em que o conteúdo está alocado.
		 */
		return indiceInicial;
	}

}
