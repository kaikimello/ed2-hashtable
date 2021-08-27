/**
 * 
 */
package br.edu.ifs.ed2.dados.hash;

import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.colisao.EstrategiaColisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * Classe que estabelece as operações de uma tabela de espalhamento com
 * endereçamento aberto.
 * 
 * 
 *
 */
public class HashAberto<G> extends Hash<G> {

	/**
	 * Vetor que armazena os elementos da tabela.
	 */
	private G tabela[];

	/**
	 * Vetor auxiliar que armazena os estados de cada célula da tabela de
	 * espalhamento: null - Livre; O - Ocupado; R - Removido.
	 */
	private String estado[];

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
	public HashAberto(int tamanho, EstrategiaChave<G> chave, EstrategiaEspalhamento<G> espalhamento, EstrategiaColisao<G> colisao) {

		/*
		 * Invocação do construtor da super classe.
		 */
		super(tamanho, chave, espalhamento, colisao);

		/*
		 * Inicialização dos vetores de estado e conteúdo da tabela de espalhamento.
		 */
		this.setEstado(new String[tamanho]);
		this.setTabela((G[]) new Object[tamanho]);
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
			return false;
		}

		/*
		 * Inserção do elemento e alteração do estado para ocupado.
		 */
		this.getEstado()[indice] = "O";
		this.getTabela()[indice] = conteudo;

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
			return false;
		}

		/*
		 * Remoção do elemento e alteração do estado para removido.
		 */
		this.getEstado()[indice] = "R";
		this.getTabela()[indice] = null;

		/*
		 * Indicação de remoção bem sucedida.
		 */
		return true;
	}

	/**
	 * Método que retorna um vetor com os conteúdos da tabela de espalhamento.
	 * 
	 * @return Conteúdo da tabela de espalhamento.
	 */
	public G[] getTabela() {

		return this.tabela;
	}

	/**
	 * Método que altera o vetor de elementos da tabela de espalhamento.
	 * 
	 * @param tabela Novo vetor de elementos da tabela.
	 */
	private void setTabela(G tabela[]) {

		this.tabela = tabela;
	}

	/**
	 * Método que retorna um vetor com os estados das células da tabela de
	 * espalhamento: : null - Livre; O - Ocupado; R - Removido.
	 * 
	 * @return Conteúdo da tabela de espalhamento.
	 */
	public String[] getEstado() {

		return this.estado;
	}

	/**
	 * Método que altera o vetor de estados da tabela de espalhamento.
	 * 
	 * @param //tabela Novo vetor de estados da tabela.
	 */
	private void setEstado(String estado[]) {

		this.estado = estado;
	}

	/**
	 * Método que retorna uma representação da tabela no formato texto (string).
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
			 * Verificação e, consequente, representação de célula removida.
			 */
			if (this.getTabela()[i].equals("R")) {

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
}