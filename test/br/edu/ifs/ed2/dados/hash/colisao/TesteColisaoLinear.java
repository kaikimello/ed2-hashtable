/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.ifs.ed2.dados.hash.Hash;
import br.edu.ifs.ed2.dados.hash.HashAberto;
import br.edu.ifs.ed2.dados.hash.chave.ChaveNumerica;
import br.edu.ifs.ed2.dados.hash.chave.EstrategiaChave;
import br.edu.ifs.ed2.dados.hash.espalhamento.EspalhamentoDivisao;
import br.edu.ifs.ed2.dados.hash.espalhamento.EstrategiaEspalhamento;

/**
 * 
 *
 */
public class TesteColisaoLinear {

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
	 * Tabela Hash com endereçamento aberto.
	 */
	private Hash<Integer> hash = new HashAberto<Integer>(tamanho, chave, espalhamento, colisao);

	/**
	 * Testar método para
	 * {@link br.edu.ifs.ed2.dados.hash.colisao.ColisaoLinear#obterIndice(int, br.edu.ifs.ed2.dados.hash.Hash)}.
	 */
	@Test
	public void testObterIndiceIntHashOfG() {

		/*
		 * Inserção de elementos no início da tabela.
		 */
		hash.inserir(1);
		hash.inserir(2);
		hash.inserir(3);

		/*
		 * Inserção de elementos no fim da tabela.
		 */
		hash.inserir(5);
		hash.inserir(6);
		hash.inserir(7);

		/*
		 * Resolução de colisão com células livres.
		 */
		assertEquals(colisao.obterIndice(0, hash), 0);
		assertEquals(colisao.obterIndice(4, hash), 4);

		/*
		 * Resolução de colisão com células ocupadas.
		 */
		assertEquals(colisao.obterIndice(1, hash), 4);
		assertEquals(colisao.obterIndice(2, hash), 4);
		assertEquals(colisao.obterIndice(3, hash), 4);

		/*
		 * Resolução de colisão com células ocupadas.
		 */
		assertEquals(colisao.obterIndice(5, hash), 0);
		assertEquals(colisao.obterIndice(6, hash), 0);
		assertEquals(colisao.obterIndice(7, hash), 0);
	}

	/**
	 * Testar método para
	 * {@link br.edu.ifs.ed2.dados.hash.colisao.ColisaoLinear#obterIndice(int, br.edu.ifs.ed2.dados.hash.Hash, java.lang.Object)}.
	 */
	@Test
	public void testObterIndiceIntHashOfGG() {

		/*
		 * Inserção de elementos na tabela.
		 */
		hash.inserir(0);
		hash.inserir(8);
		hash.inserir(16);
		hash.inserir(24);
		hash.inserir(32);
		hash.inserir(40);
		hash.inserir(48);
		hash.inserir(56);
		hash.inserir(64);

		/*
		 * Verificação dos elementos na tabela de espalhamento.
		 */
		assertEquals(colisao.obterIndice(0, hash, 0), 0);
		assertEquals(colisao.obterIndice(0, hash, 8), 1);
		assertEquals(colisao.obterIndice(0, hash, 16), 2);
		assertEquals(colisao.obterIndice(0, hash, 24), 3);
		assertEquals(colisao.obterIndice(0, hash, 32), 4);
		assertEquals(colisao.obterIndice(0, hash, 40), 5);
		assertEquals(colisao.obterIndice(0, hash, 48), 6);
		assertEquals(colisao.obterIndice(0, hash, 56), 7);
		assertEquals(colisao.obterIndice(0, hash, 64), -1);
	}

}
