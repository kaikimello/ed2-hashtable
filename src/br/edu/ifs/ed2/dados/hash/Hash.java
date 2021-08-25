/**
 * 
 */
package br.edu.ifs.ed2.dados.hash;

import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.colisao.EstrategiaColisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * Classe abstrata que estabelece as operações de uma tabela de espalhamento.
 * 
 * 
 *
 */
public abstract class Hash<G> {

	/**
	 * Tamanho da tabela de espalhamento.
	 */
	private int tamanho;

	/**
	 * Estratégia para a construção das chaves de cada conteúdo.
	 */
	private EstrategiaChave<G> chave;

	/**
	 * Estratégia para o tratamento de colisões.
	 */
	private EstrategiaColisao<G> colisao;

	/**
	 * Estratégia para o cálculo da função de espalhamento.
	 */
	private EstrategiaEspalhamento<G> espalhamento;

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
	public Hash(int tamanho, EstrategiaChave<G> chave, EstrategiaEspalhamento<G> espalhamento, EstrategiaColisao<G> colisao) {

		/*
		 * Estabelecimento do tamanho da tabela.
		 */
		this.setTamanho(tamanho);

		/*
		 * Estabelecimento das estratégias de construção da chave, função de
		 * espalhamento e tratamento de colisões.
		 */
		this.setChave(chave);
		this.setColisao(colisao);
		this.setEspalhamento(espalhamento);
	}

	/**
	 * Método para a inserção de um elemento na tabela de espalhamento. Tal método
	 * diz respeito a fase final do processo de inserção de elementos de uma tabela
	 * de espalhamento. Essa fase deve ser implementada nas classes concretas, haja
	 * vista que depende da estrutura de endereçamento da tabela de espalhamento
	 * (e.g., endereçamento aberto, endereçamento encadeado).
	 * 
	 * @param indice   Endereço em que o conteúdo será inserido.
	 * 
	 * @param conteudo Conteúdo a ser inserido na tabela.
	 * 
	 * @return Verdadeiro, em caso de inserção bem sucedida, ou Falso, em caso de
	 *         inserção mal sucedida.
	 */
	protected abstract boolean finalizarInsercao(int indice, G conteudo);

	/**
	 * Método para a remoção de um elemento na tabela de espalhamento. Tal método
	 * diz respeito a fase final do processo de remoção de elementos de uma tabela
	 * de espalhamento. Essa fase deve ser implementada nas classes concretas, haja
	 * vista que depende da estrutura de endereçamento da tabela de espalhamento
	 * (e.g., endereçamento aberto, endereçamento encadeado).
	 * 
	 * @param indice   Endereço do conteúdo a ser removido.
	 * 
	 * @param conteudo Conteúdo a ser removido na tabela.
	 * 
	 * @return Verdadeiro, em caso de remoção bem sucedida, ou Falso, em caso de
	 *         remoção mal sucedida.
	 */
	protected abstract boolean finalizarRemocao(int indice, G conteudo);

	/**
	 * Método para a inserção de um elemento na tabela de espalhamento.
	 * 
	 * @param conteudo Conteúdo a ser inserido na tabela.
	 * 
	 * @return Verdadeiro, em caso de inserção bem sucedida, ou Falso, em caso de
	 *         inserção mal sucedida.
	 */
	public boolean inserir(G conteudo) {

		/*
		 * Construção da chave a partir do conteúdo a ser inserido.
		 */
		int chave = this.getChave().gerarChave(conteudo);

		/*
		 * Cálculo do índice inicial em que o conteúdo será inserido.
		 */
		int indice = this.getEspalhamento().calcularIndice(chave, this.getTamanho());

		/*
		 * Cálculo do índice final com base em eventuais colisões.
		 */
		int indiceFinal = this.getColisao().obterIndice(indice, this);

		/*
		 * Inserção do elemento na tabela de espalhamento.
		 */
		return this.finalizarInsercao(indiceFinal, conteudo);

	}

	/**
	 * Método para a busca de um elemento na tabela de espalhamento.
	 * 
	 * @param conteudo Conteúdo a ser buscado na tabela.
	 * 
	 * @return Índice da tabela em que o conteúdo está inserido, em caso de busca
	 *         bem sucedida, ou -1, em caso de busca mal sucedida.
	 */
	public int buscar(G conteudo) {

		/*
		 * Construção da chave a partir do conteúdo a ser buscado.
		 */
		int chave = this.getChave().gerarChave(conteudo);

		/*
		 * Cálculo do índice inicial do conteúdo a ser buscado.
		 */
		int indice = this.getEspalhamento().calcularIndice(chave, this.getTamanho());

		/*
		 * Obtenção do índice final com base em eventuais colisões.
		 */
		return this.getColisao().obterIndice(indice, this, conteudo);
	}

	/**
	 * Método para a remoção de um elemento na tabela de espalhamento.
	 * 
	 * @param conteudo Conteúdo a ser removido da tabela.
	 * 
	 * @return Verdadeiro, em caso de remoção bem sucedida, ou Falso, em caso de
	 *         remoção mal sucedida.
	 */
	public boolean remover(G conteudo) {

		/*
		 * Obtenção do índice do conteúdo.
		 */
		int indice = this.buscar(conteudo);

		/*
		 * Remoção do elemento na tabela de espalhamento.
		 */
		return this.finalizarRemocao(indice, conteudo);
	}

	/**
	 * Método que retorna o tamanho da tabela.
	 * 
	 * @return Tamanho da tabela.
	 */
	public int getTamanho() {

		return this.tamanho;
	}

	/**
	 * Método que altera o tamanho da tabela.
	 * 
	 * @param tamanho Novo valor para o tamanho da tabela.
	 */
	protected void setTamanho(int tamanho) {

		this.tamanho = tamanho;
	}

	/**
	 * Método que retorna a estratégia de construção de chaves.
	 * 
	 * @return Estratégia de construção de chaves.
	 */
	public EstrategiaChave<G> getChave() {

		return this.chave;
	}

	/**
	 * Método que altera a estratégia de construção de chaves.
	 * 
	 * @param chave Nova estratégia de construção de chaves.
	 */
	protected void setChave(EstrategiaChave<G> chave) {

		this.chave = chave;
	}

	/**
	 * Método que retorna a estratégia de tratamento de colisões.
	 * 
	 * @return Estratégia de tratamento de colisões.
	 */
	public EstrategiaColisao<G> getColisao() {

		return this.colisao;
	}

	/**
	 * Método que altera a estratégia de tratamento de colisões.
	 * 
	 * @param colisao Nova estratégia de tratamento de colisões.
	 */
	protected void setColisao(EstrategiaColisao<G> colisao) {

		this.colisao = colisao;
	}

	/**
	 * Método que retorna a estratégia de espalhamento dos elementos na tabela.
	 * 
	 * @return Estratégia de espalhamento dos elementos.
	 */
	public EstrategiaEspalhamento<G> getEspalhamento() {

		return this.espalhamento;
	}

	/**
	 * Método que altera a estratégia de espalhamento dos elementos na tabela.
	 * 
	 * @param espalhamento Nova estratégia de espalhamento dos elementos.
	 */
	protected void setEspalhamento(EstrategiaEspalhamento<G> espalhamento) {

		this.espalhamento = espalhamento;
	}
}
