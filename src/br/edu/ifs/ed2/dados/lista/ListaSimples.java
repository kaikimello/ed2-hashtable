/**
 * 
 */
package br.edu.ifs.ed2.dados.lista;

import br.edu.ifs.ed2.dados.no.NoSimples;

/**
 * Classe que implementa as operações de uma lista com encadeamento simples
 * 
 * 
 *
 */
public class ListaSimples<G> implements Lista<G> {

	/**
	 * Início da lista
	 */
	private NoSimples<G> inicio;

	/**
	 * 
	 */
	@Override
	public Lista<G> inserirInicio(G conteudo) {

		/*
		 * Define um novo nó a ser inserido na lista
		 */
		NoSimples<G> novo = new NoSimples<G>(conteudo);

		/*
		 * Insere o novo nó no início da lista
		 */
		novo.setPosterior(this.getInicio());

		return this.setInicio(novo);
	}

	/**
	 * 
	 */
	@Override
	public Lista<G> inserirFim(G conteudo) {

		/*
		 * Se a lista estiver vazia então inserir no início
		 */
		if (this.estaVazia()) {

			return this.inserirInicio(conteudo);
		}

		/*
		 * Percorre toda a lista em busca do último elemento
		 */
		NoSimples<G> fim = this.getInicio();
		while (fim.getPosterior() != null) {

			fim = fim.getPosterior();
		}

		/*
		 * Insere um novo nó no fim da lista
		 */
		fim.setPosterior(new NoSimples<G>(conteudo));

		return this;
	}

	/**
	 * 
	 */
	@Override
	public boolean removerInicio() {

		/*
		 * Verifica se a lista está vazia
		 */
		if (this.estaVazia()) {

			return false;
		}

		/*
		 * Estabelece que o novo início da lista será o segundo elemento
		 */
		this.setInicio(this.getInicio().getPosterior());

		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean removerFim() {

		/*
		 * Verifica se a lista está vazia
		 */
		if (this.estaVazia()) {

			return false;
		}

		/*
		 * Verifica se a lista possui apenas um elemento
		 */
		if (this.getInicio().getPosterior() == null) {

			return this.removerInicio();
		}

		NoSimples<G> aux = this.getInicio();

		/*
		 * Percorre o restante da lista em busca do último elemento
		 */
		while (aux.getPosterior().getPosterior() != null) {

			aux = aux.getPosterior();
		}

		/*
		 * Estabelece que o novo fim da lista é o penúltimo elemento
		 */
		aux.setPosterior(null);

		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean remover(G conteudo) {

		/*
		 * Verifica se a lista está vazia
		 */
		if (this.estaVazia()) {

			return false;
		}

		/*
		 * Se o elemento a ser removido estiver no início da lista
		 */
		if (this.getInicio().getConteudo().equals(conteudo)) {

			return this.removerInicio();
		}

		NoSimples<G> aux = this.getInicio();

		/*
		 * Percorre o restante da lista em busca do elemento
		 */
		while (aux.getPosterior() != null) {

			if (aux.getPosterior().getConteudo().equals(conteudo)) {

				aux.setPosterior(aux.getPosterior().getPosterior());

				return true;
			}

			aux = aux.getPosterior();
		}

		return false;
	}

	/**
	 * 
	 */
	@Override
	public NoSimples<G> buscar(G conteudo) {

		NoSimples<G> aux = this.getInicio();

		/*
		 * Percorre toda a lista em busca do elemento da busca
		 */
		while (aux != null) {

			if (aux.getConteudo().equals(conteudo)) {

				return aux;
			}

			aux = aux.getPosterior();
		}

		/*
		 * Se o elemento não for encontrado
		 */
		return null;
	}

	/**
	 * 
	 */
	@Override
	public boolean estaVazia() {

		return this.getInicio() == null;
	}

	/**
	 * 
	 */
	@Override
	public Lista<G> limpar() {

		return this.setInicio(null);
	}

	/**
	 * Método que retorna uma referência para o início da lista
	 * 
	 * @return O primeiro elemento da lista
	 */
	public NoSimples<G> getInicio() {

		return this.inicio;
	}

	/**
	 * Método que altera o início da lista
	 * 
	 * @param inicio Elemento que será inserido no início da lista
	 *
	 * @return Uma referência para a lista (encadeamento de operações)
	 */
	private ListaSimples<G> setInicio(NoSimples<G> inicio) {

		this.inicio = inicio;

		return this;
	}

	/**
	 * Método que retorna uma representação da lista no formato texto (string)
	 */
	@Override
	public String toString() {

		NoSimples<G> aux = this.getInicio();
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
}
