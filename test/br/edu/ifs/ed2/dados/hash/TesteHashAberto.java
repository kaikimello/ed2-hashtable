/**
 * 
 */
package br.edu.ifs.ed2.dados.hash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.edu.ifs.ed2.dados.hash.chave.ChaveNumerica;
import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.colisao.ColisaoLinear;
import br.edu.ifs.ed2.dados.hash.colisao.EstrategiaColisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EspalhamentoDivisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * 
 *
 */
public class TesteHashAberto {

	/*
	 * Tamanho da tabela hash.
	 */
	private int tamanho = 8;

	/*
	 * Estratégia de geração de chaves numéricas.
	 */
	private EstrategiaChave<Integer> chave = new ChaveNumerica();

	/*
	 * Estratégia de tratamento de colisões.
	 */
	private EstrategiaColisao<Integer> colisao = new ColisaoLinear<Integer>();

	/*
	 * Estratégia de espalhamento dos elementos na tabela hash.
	 */
	private EstrategiaEspalhamento<Integer> espalhamento = new EspalhamentoDivisao<Integer>();

	/*
	 * Tabela Hash com endereçamento encadeado.
	 */
	private Hash<Integer> hash = new HashAberto<Integer>(tamanho, chave, espalhamento, colisao);

	/**
	 * Testar método para
	 * {@link br.edu.ifs.ed2.dados.hash.Hash#inserir(java.lang.Object)}.
	 */
	@Test
	public void testInserir() {

		/*
		 * Inserção de um conjunto de números que deve preencher toda a tabela.
		 */
		assertTrue(hash.inserir(0));
		assertTrue(hash.inserir(8));
		assertTrue(hash.inserir(16));
		assertTrue(hash.inserir(24));
		assertTrue(hash.inserir(32));
		assertTrue(hash.inserir(40));
		assertTrue(hash.inserir(48));
		assertTrue(hash.inserir(56));

		/*
		 * Inserção de um elemento com a tabela cheia.
		 */
		assertFalse(hash.inserir(64));
	}

	/**
	 * Testar método para
	 * {@link br.edu.ifs.ed2.dados.hash.Hash#buscar(java.lang.Object)}.
	 */
	@Test
	public void testBuscar() {

		/*
		 * Inserção de elementos no primeiro índice da tabela.
		 */
		hash.inserir(0);
		hash.inserir(8);

		/*
		 * Inserção de elementos no segundo índice da tabela.
		 */
		hash.inserir(1);
		hash.inserir(9);

		/*
		 * Inserção de elementos no último índice da tabela.
		 */
		hash.inserir(7);
		hash.inserir(15);

		/*
		 * Busca dos índices dos elementos 0 e 8 na tabela.
		 */
		assertEquals(hash.buscar(0), 0);
		assertEquals(hash.buscar(8), 1);

		/*
		 * Busca dos índices dos elementos 1 e 9 na tabela.
		 */
		assertEquals(hash.buscar(1), 2);
		assertEquals(hash.buscar(9), 3);

		/*
		 * Busca dos índices dos elementos 7 e 15 na tabela.
		 */
		assertEquals(hash.buscar(7), 7);
		assertEquals(hash.buscar(15), 4);

		/*
		 * Busca do índice do elemento 2 que não deve ser encontrado na tabela.
		 */
		assertEquals(hash.buscar(2), -1);

	}

	/**
	 * Testar método para
	 * {@link br.edu.ifs.ed2.dados.hash.Hash#remover(java.lang.Object)}.
	 */
	@Test
	public void testRemover() {

		/*
		 * Inserção de elementos no primeiro índice da tabela.
		 */
		hash.inserir(0);
		hash.inserir(8);
		hash.inserir(16);
		hash.inserir(24);
		hash.inserir(32);

		/*
		 * Remoção de elementos 16.
		 */
		assertTrue(hash.remover(16));
		assertEquals(hash.buscar(16), -1);

		/*
		 * Remoção de elementos 8.
		 */
		assertTrue(hash.remover(8));
		assertEquals(hash.buscar(8), -1);

		/*
		 * Remoção de elementos 24.
		 */
		assertTrue(hash.remover(24));
		assertEquals(hash.buscar(24), -1);

		/*
		 * Remoção de elementos 0.
		 */
		assertTrue(hash.remover(0));
		assertEquals(hash.buscar(0), -1);

		/*
		 * Remoção de elementos 32.
		 */
		assertTrue(hash.remover(32));
		assertEquals(hash.buscar(32), -1);
	}
}
