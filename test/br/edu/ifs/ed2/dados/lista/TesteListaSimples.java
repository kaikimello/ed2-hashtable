/**
 * 
 */
package br.edu.ifs.ed2.dados.lista;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

/**
 * 
 *
 */
public class TesteListaSimples {

	/*
	 * Instanciação de uma lista simplesmente encadeada
	 */
	private Lista<Integer> lista = new ListaSimples<Integer>();

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		/*
		 * Efetua a limpeza da lista antes de cada um dos testes
		 */
		this.lista.limpar();
	}

	/**
	 * Test method for
	 * {@link br.edu.ifs.ed2.dados.lista.ListaSimples#inserirInicio(java.lang.Object)}.
	 */
	@Test
	public void testInserirInicio() {

		/*
		 * Teste de inserção do primeiro item
		 */
		this.lista.inserirInicio(1);
		assertEquals(this.lista.toString(), "1 -> *");

		/*
		 * Teste de inserção do segundo item
		 */
		this.lista.inserirInicio(2);
		assertEquals(this.lista.toString(), "2 -> 1 -> *");

		/*
		 * Teste de inserção do terceiro item
		 */
		this.lista.inserirInicio(3);
		assertEquals(this.lista.toString(), "3 -> 2 -> 1 -> *");
	}

	/**
	 * Test method for
	 * {@link br.edu.ifs.ed2.dados.lista.ListaSimples#inserirFim(java.lang.Object)}.
	 */
	@Test
	public void testInserirFim() {

		/*
		 * Teste de inserção do primeiro item
		 */
		this.lista.inserirFim(1);
		assertEquals(this.lista.toString(), "1 -> *");

		/*
		 * Teste de inserção do primeiro item
		 */
		this.lista.inserirFim(2);
		assertEquals(this.lista.toString(), "1 -> 2 -> *");

		/*
		 * Teste de inserção do primeiro item
		 */
		this.lista.inserirFim(3);
		assertEquals(this.lista.toString(), "1 -> 2 -> 3 -> *");
	}

	/**
	 * Test method for
	 * {@link br.edu.ifs.ed2.dados.lista.ListaSimples#removerInicio()}.
	 */
	@Test
	public void testRemoverInicio() {

		/*
		 * Teste de remoção com a lista vazia
		 */
		assertFalse(this.lista.removerInicio());
		assertEquals(this.lista.toString(), "*");

		/*
		 * Teste de remoção com a lista contendo um único elemento
		 */
		this.lista.inserirInicio(1);

		assertTrue(this.lista.removerInicio());
		assertEquals(this.lista.toString(), "*");

		/*
		 * Teste de remoção com a lista contendo mais do que um elemento
		 */
		this.lista.inserirInicio(1);
		this.lista.inserirInicio(2);

		assertTrue(this.lista.removerInicio());
		assertEquals(this.lista.toString(), "1 -> *");
	}

	/**
	 * Test method for {@link br.edu.ifs.ed2.dados.lista.ListaSimples#removerFim()}.
	 */
	@Test
	public void testRemoverFim() {

		/*
		 * Teste de remoção com a lista vazia
		 */
		assertFalse(this.lista.removerFim());
		assertEquals(this.lista.toString(), "*");

		/*
		 * Teste de remoção com a lista contendo um único elemento
		 */
		this.lista.inserirInicio(1);

		assertTrue(this.lista.removerFim());
		assertEquals(this.lista.toString(), "*");

		/*
		 * Teste de remoção com a lista contendo mais do que um elemento
		 */
		this.lista.inserirInicio(1);
		this.lista.inserirInicio(2);

		assertTrue(this.lista.removerFim());
		assertEquals(this.lista.toString(), "2 -> *");
	}

	/**
	 * Test method for
	 * {@link br.edu.ifs.ed2.dados.lista.ListaSimples#remover(java.lang.Object)}.
	 */
	@Test
	public void testRemover() {

		/*
		 * Teste de remoção com a lista vazia
		 */
		assertFalse(this.lista.remover(1));
		assertEquals(this.lista.toString(), "*");

		/*
		 * Teste de remoção com a lista contendo um único elemento
		 */
		this.lista.inserirInicio(1);

		assertTrue(this.lista.remover(1));
		assertEquals(this.lista.toString(), "*");

		/*
		 * Teste de remoção com a lista contendo mais do que um elemento
		 */
		this.lista.inserirInicio(1);
		this.lista.inserirInicio(2);
		this.lista.inserirInicio(3);

		assertTrue(this.lista.remover(2));
		assertEquals(this.lista.toString(), "3 -> 1 -> *");

		/*
		 * Teste de remoção com a lista não contendo o elemento a ser removido
		 */
		assertFalse(this.lista.remover(2));
		assertEquals(this.lista.toString(), "3 -> 1 -> *");
	}

	/**
	 * Test method for
	 * {@link br.edu.ifs.ed2.dados.lista.ListaSimples#buscar(java.lang.Object)}.
	 */
	@Test
	public void testBuscar() {

		/*
		 * Teste de busca com a lista vazia
		 */
		assertNull(this.lista.buscar(1));

		/*
		 * Teste de busca com a lista contendo um elemento
		 */
		this.lista.inserirInicio(1);

		assertEquals((int) this.lista.buscar(1).getConteudo(), 1);

		/*
		 * Teste de busca com a lista contendo mais do que um elemento
		 */
		this.lista.inserirInicio(1);
		this.lista.inserirInicio(2);
		this.lista.inserirInicio(3);

		assertEquals((int) this.lista.buscar(2).getConteudo(), 2);
		assertEquals((int) this.lista.buscar(3).getConteudo(), 3);

		/*
		 * Teste de busca com a lista não contendo o elemento a ser buscado
		 */
		assertNull(this.lista.buscar(4));
	}

	/**
	 * Test method for {@link br.edu.ifs.ed2.dados.lista.ListaSimples#estaVazia()}.
	 */
	@Test
	public void testEstaVazia() {

		/*
		 * Teste quando a lista está vazia
		 */
		assertTrue(this.lista.estaVazia());

		/*
		 * Teste quando a lista não está vazia
		 */
		this.lista.inserirInicio(1);

		assertFalse(this.lista.estaVazia());
	}

	/**
	 * Test method for {@link br.edu.ifs.ed2.dados.lista.ListaSimples#limpar()}.
	 */
	@Test
	public void testLimpar() {

		/*
		 * Teste de limpeza quando a lista já está vazia
		 */
		this.lista.limpar();

		assertTrue(this.lista.estaVazia());

		/*
		 * Teste de limpeza quando a lista não está vazia
		 */
		this.lista.inserirInicio(1);
		this.lista.limpar();

		assertTrue(this.lista.estaVazia());
	}
}
