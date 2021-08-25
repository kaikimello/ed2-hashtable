/**
 * 
 */
package br.edu.ifs.ed2.dados.hash;

import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.colisao.EstrategiaColisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;
import br.edu.ifs.ed2.dados.lista.Lista;

/**
 * 
 * 
 *
 */
public class HashEncadeado<G> extends Hash<G> {

	/**
	 * Vetor que armazena os elementos da tabela.
	 */
	private Lista<G> tabela[];

	/**
	 * Construtor da classe.
	 * 
	 * @param tamanho      Tamanho da tabela de espalhamento.
	 * 
	 * @param chave        Estratégia para a construção de chaves.
	 * 
	 * @param espalhamento Estratégia para a função de espalhamento.
	 * 
	 * @param colisao      Estratégia para o tratamento de colisões.
	 */
	@SuppressWarnings("unchecked")
	public HashEncadeado(int tamanho, EstrategiaChave<G> chave, EstrategiaEspalhamento<G> espalhamento,
			EstrategiaColisao<G> colisao) {

		/*
		 * Invocação do construtor da super classe.
		 */
		super(tamanho, chave, espalhamento, colisao);

		/*
		 * Inicialização da tabela de espalhamento.
		 */
		this.setTabela((Lista<G>[]) new Lista<?>[tamanho]);
	}

	/**
	 * 
	 */
	@Override
	protected boolean finalizarInsercao(int indice, G conteudo) {

		/*
		 * Verificação e, consequente, indicação de inserção mal sucedida.
		 */
		if (indice < 0) {

		}

		/*
		 * Verificação e, consequente, inicialização da lista, caso seja nula.
		 */
		if (this.getTabela()[indice] == null) {

		}

		/*
		 * Inserção do elemento na lista.
		 */

		/*
		 * Indicação de inserção bem sucedida.
		 */
		return true;
	}

	/**
	 * 
	 */
	@Override
	protected boolean finalizarRemocao(int indice, G conteudo) {

		/*
		 * Verificação e, consequente, indicação de remoção mal sucedida.
		 */
		if (indice < 0) {

		}

		/*
		 * Remoção do elemento e alteração do estado para removido.
		 */

		/*
		 * Indicação de remoção bem sucedida.
		 */
		return true;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {

		/*
		 * Inicialização de uma estrutura para construção da string.
		 */
		StringBuilder s = new StringBuilder();

		/*
		 * Varredura das células da tabela de espalhamento.
		 */
		for (int i = 0; i < this.getTamanho(); ++i) {

			/*
			 * Verificação e, consequente, representação de célula vazia.
			 */
			if (this.getTabela()[i] == null) {

				s.append("-").append("\n");
				continue;
			}

			/*
			 * Representação de célula ocupada.
			 */
			s.append(this.getTabela()[i]).append("\n");
		}

		/*
		 * Retorno da string que representa a tabela.
		 */
		return s.toString();
	}

	/**
	 * @return the tabela
	 */
	public Lista<G>[] getTabela() {

		return this.tabela;
	}

	/**
	 * @param tabela the tabela to set
	 */
	public void setTabela(Lista<G> tabela[]) {

		this.tabela = tabela;
	}
}