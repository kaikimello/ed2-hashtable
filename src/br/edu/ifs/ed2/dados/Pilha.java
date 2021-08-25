/**
 * 
 */
package br.edu.ifs.ed2.dados;

import br.edu.ifs.ed2.dados.lista.ListaDupla;
import br.edu.ifs.ed2.dados.no.NoDuplo;

/**
 * Classe que implementa as operações de uma pilha
 * 
 * 
 *
 */
public class Pilha<G> {

	/**
	 * Lista duplamente encadeada para a implementação das operações da pilha
	 */
	private ListaDupla<G> lista;

	/**
	 * Construtor que inicializa os atributos da classe
	 */
	public Pilha() {

		/*
		 * Inicialização da lista
		 */
		this.setLista(new ListaDupla<G>());
	}

	/**
	 * Método para a inserção de um elemento na pilha
	 * 
	 * @param conteudo Conteúdo a ser inserido na pilha
	 * 
	 * @return Uma referência para a pilha (encadeamento de operações)
	 */
	public Pilha<G> inserir(G conteudo) {

		/*
		 * Inserção do elemento no fim da lista
		 */
		this.getLista().inserirFim(conteudo);

		return this;
	}

	/**
	 * Método para a obtenção do elemento que está no topo da pilha
	 * 
	 * @return Uma referência para o topo da pilha em caso de pilha não vazia e nulo
	 *         caso contrário
	 */
	public G obterTopo() {

		/*
		 * Verifica se a lista está vazia
		 */
		if (this.lista.estaVazia()) {

			return null;
		}

		/*
		 * Retorna o último elemento da lista
		 */
		return this.getLista().getFim().getConteudo();
	}

	/**
	 * Método para a remoção de um elemento da pilha
	 * 
	 * @return Verdadeiro em caso de remoção bem sucedida e falso caso contrário
	 */
	public boolean remover() {

		/*
		 * Remover o elemento do fim da lista
		 */
		return this.getLista().removerFim();
	}

	/**
	 * Método que remove todos os elementos da pilha
	 * 
	 * @return Uma referência para a pilha (encadeamento de operações)
	 */
	public Pilha<G> limpar() {

		/*
		 * Limpa a lista
		 */
		this.lista.limpar();

		return this;
	}

	/**
	 * Método que retorna uma representação da pilha no formato texto (string)
	 */
	@Override
	public String toString() {

		NoDuplo<G> aux = this.lista.getFim();
		StringBuilder s = new StringBuilder();

		/*
		 * Percorre toda a lista e concatena cada elemento em um string
		 */
		while (aux != null) {

			s.append(aux.getConteudo()).append("\n");
			aux = aux.getAnterior();
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
	private Pilha<G> setLista(ListaDupla<G> lista) {

		this.lista = lista;

		return this;
	}
}
