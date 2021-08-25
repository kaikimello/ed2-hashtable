/**
 * 
 */
package br.edu.ifs.ed2.dados.hash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.edu.ifs.ed2.dados.hash.chave.ChaveNumerica;
import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.colisao.ColisaoEncadeada;
import br.edu.ifs.ed2.dados.hash.colisao.EstrategiaColisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EspalhamentoDivisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * @author Marlos Tacio Silva
 *
 */
public class TesteHashEncadeado {

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
	private EstrategiaColisao<Integer> colisao = new ColisaoEncadeada<Integer>();

	/*
	 * Estratégia de espalhamento dos elementos na tabela hash.
	 */
	private EstrategiaEspalhamento<Integer> espalhamento = new EspalhamentoDivisao<Integer>();

	/*
	 * Tabela Hash com endereçamento encadeado.
	 */
	private Hash<Integer> hash = new HashEncadeado<Integer>(tamanho, chave, espalhamento, colisao);

	/**
	 * Testar método para
	 * {@link br.edu.ifs.ed2.dados.hash.Hash#inserir(java.lang.Object)}.
	 */
	@Test
	public void testInserir() {

		/*
		 * Aplicação da operação de inserção num conjunto de números menores do que o
		 * tamanho da tabela hash.
		 */
		assertTrue(hash.inserir(0));
		assertTrue(hash.inserir(1));
		assertTrue(hash.inserir(2));
		assertTrue(hash.inserir(3));
		assertTrue(hash.inserir(4));
		assertTrue(hash.inserir(5));
		assertTrue(hash.inserir(6));
		assertTrue(hash.inserir(7));

		/*
		 * Aplicação da operação de inserção num conjunto de números maiores do que o
		 * tamanho da tabela hash.
		 */
		assertTrue(hash.inserir(8));
		assertTrue(hash.inserir(9));
		assertTrue(hash.inserir(10));
		assertTrue(hash.inserir(11));
		assertTrue(hash.inserir(12));
		assertTrue(hash.inserir(13));
		assertTrue(hash.inserir(14));
		assertTrue(hash.inserir(15));
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
		 * Busca dos índices dos elementos 0 e 8 na tabela.
		 */
		assertEquals(hash.buscar(0), 0);
		assertEquals(hash.buscar(8), 0);

		/*
		 * Busca dos índices dos elementos 1 e 9 na tabela.
		 */
		assertEquals(hash.buscar(1), 1);
		assertEquals(hash.buscar(9), 1);

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

		/*
		 * Inserção de elementos no segundo índice da tabela.
		 */
		hash.inserir(1);
		hash.inserir(9);

		/*
		 * Remoção de elementos no primeiro e no segundo índice da tabela.
		 */
		assertTrue(hash.remover(0));
		assertTrue(hash.remover(9));

		/*
		 * Busca dos elementos removidos que não devem ser encontrados na tabela.
		 */
		assertEquals(hash.buscar(0), -1);
		assertEquals(hash.buscar(9), -1);
	}
}
