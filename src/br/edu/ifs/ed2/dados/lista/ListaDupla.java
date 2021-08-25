/**
 * 
 */
package br.edu.ifs.ed2.dados.lista;

import br.edu.ifs.ed2.dados.no.NoDuplo;

/**
 * Classe que implementa as operações de uma lista com encadeamento duplo
 * 
 * 
 *
 */
public class ListaDupla<G> implements Lista<G> {

	/**
	 * Inicio da lista
	 */
	private NoDuplo<G> inicio;

	/**
	 * Fim da lista
	 */
	private NoDuplo<G> fim;

	/**
	 * 
	 */
	@Override
	public Lista<G> inserirInicio(G conteudo) {

		/*
		 * Define um novo nó a ser inserido na lista
		 */
		NoDuplo<G> novo = new NoDuplo<G>(conteudo);

		/*
		 * Se a lista está vazia então inserir o novo elemento no início e no fim da
		 * lista
		 */
		if (this.estaVazia()) {

			return this.setInicio(novo).setFim(novo);
		}

		/*
		 * Insere o novo elemento no início da lista
		 */
		novo.setPosterior(this.getInicio());

		/*
		 * Estabelece o novo elemento como início da lista
		 */
		return this.setInicio(novo);
	}

	/**
	 * 
	 */
	@Override
	public Lista<G> inserirFim(G conteudo) {

		/*
		 * Define um novo nó a ser inserido na lista
		 */
		NoDuplo<G> novo = new NoDuplo<G>(conteudo);

		/*
		 * Se a lista está vazia então inserir o novo elemento no início e no fim da
		 * lista
		 */
		if (this.estaVazia()) {

			return this.setInicio(novo).setFim(novo);
		}

		/*
		 * Insere o novo nó no fim da lista
		 */
		novo.setAnterior(this.getFim());

		/*
		 * Estabelece o novo elemento como fim da lista
		 */
		return this.setFim(novo);
	}

	/**
	 * 
	 */
	@Override
	public boolean remover(G conteudo) {

		NoDuplo<G> aux = this.buscar(conteudo);

		/*
		 * Elemento não foi encontrado
		 */
		if (aux == null) {

			return false;
		}

		/*
		 * Se o elemento a ser removido estiver no início da lista
		 */
		if (aux.equals(this.getInicio())) {

			return this.removerInicio();
		}

		/*
		 * Se o elemento a ser removido estiver no fim da lista
		 */
		if (aux.equals(this.getFim())) {

			return this.removerFim();
		}

		/*
		 * Se o elemento a ser removido estiver entre o início e o fim da lista
		 */
		aux.getAnterior().setPosterior(aux.getPosterior());

		return true;
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
		 * Verifica se a lista possui apenas um elemento
		 */
		if (this.getInicio().equals(this.getFim())) {

			this.limpar();
			return true;
		}

		/*
		 * Estabelece que o novo início da lista será o segundo elemento
		 */
		this.setInicio(this.getInicio().getPosterior());
		this.getInicio().setAnterior(null);

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
		if (this.getInicio().equals(this.getFim())) {

			this.limpar();
			return true;
		}

		/*
		 * Estabelece que o novo fim da lista será o penúltimo elemento
		 */
		this.setFim(this.getFim().getAnterior());
		this.getFim().setPosterior(null);

		return true;
	}

	/**
	 * 
	 */
	@Override
	public NoDuplo<G> buscar(G conteudo) {

		NoDuplo<G> aux = this.getInicio();

		/*
		 * Percorre toda a lista em busca do elemento
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

		return this.getInicio() == null && this.getFim() == null;
	}

	/**
	 * 
	 */
	@Override
	public Lista<G> limpar() {

		return this.setInicio(null).setFim(null);
	}

	/**
	 * Método que retorna uma referência para o início da lista
	 * 
	 * @return O primeiro elemento da lista
	 */
	public NoDuplo<G> getInicio() {

		return this.inicio;
	}

	/**
	 * Método que altera o início da lista
	 * 
	 * @param inicio Elemento que será inserido no início da lista
	 *
	 * @return Uma referência para a lista (encadeamento de operações)
	 */
	private ListaDupla<G> setInicio(NoDuplo<G> inicio) {

		this.inicio = inicio;

		return this;
	}

	/**
	 * Método que retorna uma referência para o fim da lista
	 * 
	 * @return O último elemento da lista
	 */
	public NoDuplo<G> getFim() {

		return this.fim;
	}

	/**
	 * Método que altera o fim da lista
	 * 
	 * @param fim Elemento que será inserido no fim da lista
	 *
	 * @return Uma referência para a lista (encadeamento de operações)
	 */
	private ListaDupla<G> setFim(NoDuplo<G> fim) {

		this.fim = fim;

		return this;
	}

	/**
	 * Método que retorna uma representação da lista no formato texto (string)
	 */
	@Override
	public String toString() {

		/*
		 * Se a lista estiver vazia
		 */
		if (this.estaVazia()) {

			return "*";
		}

		NoDuplo<G> aux = this.getInicio();
		StringBuilder s = new StringBuilder().append("* <-> ");

		/*
		 * Percorre toda a lista e concatena cada elemento em um string
		 */
		while (aux != null) {

			s.append(aux.getConteudo()).append(" <-> ");
			aux = aux.getPosterior();
		}

		return s.append("*").toString();
	}
}
