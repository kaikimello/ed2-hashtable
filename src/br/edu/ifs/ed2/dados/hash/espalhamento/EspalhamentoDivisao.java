/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.espalhamento;

/**
 * Classe que implementa a técnica de espalhamento via divisão.
 * 
 * 
 *
 */
public class EspalhamentoDivisao<G> implements EstrategiaEspalhamento<G> {

	/**
	 * 
	 */
	@Override
	public int calcularIndice(int chave, int tamanho) {

		/*
		 * Inicialização do índice
		 */
		int indice = 0;

		/*
		 * Cálculo do índice com base na técnica de divisão
		 */
		indice = chave % tamanho;

		/*
		 * Retorno do índice
		 */
		return indice;
	}
}
