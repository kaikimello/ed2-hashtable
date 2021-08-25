/**
 * 
 */
package br.edu.ifs.ed2.dados;

import br.edu.ifs.ed2.dados.lista.ListaDupla;
import br.edu.ifs.ed2.dados.no.NoDuplo;

/**
 * Classe que implementa as operações de uma fila
 * 
 * 
 *
 */
public class Fila<G> {

	/**
	 * Lista duplamente encadeada para a implementação das operações da fila
	 */
	private ListaDupla<G> lista;

	/**
	 * Construtor que inicializa os atributos da classe
	 */
	public Fila() {

		/*
		 * Inicialização da lista
		 */
		this.setLista(new ListaDupla<G>());
	}

	/**
	 * Método para a inserção de um elemento na fila
	 * 
	 * @param conteudo Conteúdo a ser inserido na fila
	 * 
	 * @return Uma referência para a fila (encadeamento de operações)
	 */
	public Fila<G> inserir(G conteudo) {

		/*
		 * Inserção do elemento no fim da lista
		 */
		this.getLista().inserirFim(conteudo);

		return this;
	}

	/**
	 * Método para a obtenção do primeiro elemento da fila
	 * 
	 * @return Uma referência para o inicio da fila em caso de lista não vazia e
	 *         nulo caso contrário
	 */
	public G obterInicio() {

		/*
		 * Verifica se a lista está vazia
		 */
		if (this.lista.estaVazia()) {

			return null;
		}

		/*
		 * Retorna o último elemento da lista
		 */
		return this.getLista().getInicio().getConteudo();
	}

	/**
	 * Método para a remoção de um elemento da fila
	 * 
	 * @return Verdadeiro em caso de remoção bem sucedida e falso caso contrário
	 */
	public boolean remover() {

		/*
		 * Remover o elemento do inicio da lista
		 */
		return this.getLista().removerInicio();
	}

	/**
	 * Método que remove todos os elementos da fila
	 * 
	 * @return Uma referência para a fila (encadeamento de operações)
	 */
	public Fila<G> limpar() {

		/*
		 * Limpa a lista
		 */
		this.lista.limpar();

		return this;
	}

	/**
	 * Método que retorna uma representação da fila no formato texto (string)
	 */
	@Override
	public String toString() {

		NoDuplo<G> aux = this.lista.getInicio();
		StringBuilder s = new StringBuilder();

		/*
		 * Percorre toda a lista e concatena cada elemento em um string
		 */
		while (aux != null) {

			s.append(aux.getConteudo()).append(" -> ");
			aux = aux.getPosterior();
		}

		return s.append("*").toString();
	}

	/**
	 * Método que retorna uma referência para a lista encadeada
	 * 
	 * @return Referência para a lista encadeada
	 */
	private ListaDupla<G> getLista() {

		return this.lista;
	}

	/**
	 * Método que altera a lista encadeada
	 * 
	 * @param lista Lista a ser inserida
	 * 
	 * @return Uma referência para a fila (encadeamento de operações)
	 */
	private Fila<G> setLista(ListaDupla<G> lista) {

		this.lista = lista;

		return this;
	}
}
