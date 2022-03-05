/**
 * 
 */
package aula01.testes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import aula01.arvore.ArvoreBinaria;
import aula01.arvore.Nodo;

/**
 * @author cristovao
 *
 */
public class AppDeTestes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		imprimeLinha("Lista de números inteiros aleatórios para árvore");
		
		List<Integer> elementosParaArvore = new LinkedList<Integer>();
		
		Random random = new Random();
		
		for (int i = 0, j = 0; i < 10; i++) {
			j = random.nextInt(100);
			elementosParaArvore.add(j);
		}
		
		System.out.println(elementosParaArvore);
		
		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
		
		Integer valor = random.nextInt(100);
		Nodo n = new Nodo(valor, null);
		imprimeLinha("Valor inicial da raiz");
		System.out.println(n);
		arvoreBinaria.setRaiz(n);
		imprimeLinha("Valor inicial de árvore binária");
		System.out.println(arvoreBinaria);
		
		for (Integer integer : elementosParaArvore) {
			arvoreBinaria.insereNodo(integer);
		}
		
		List<Object> elementosPercorridosEmOrdem = arvoreBinaria.listarEmOrdemRecursivo();
		
		imprimeLinha("Árvore percorrida em ordem");
		int tamanho = elementosPercorridosEmOrdem.size();
		Nodo nodoLido = null;
		for(int i = 0; i < tamanho ; i++) {
			nodoLido = (Nodo)elementosPercorridosEmOrdem.get(i);
			if (i + 1 == tamanho) {
				System.out.println(nodoLido.getDados().toString() + ".");
			} else {
				System.out.printf(nodoLido.getDados().toString() + ", ");
			}
		}
		
		
		
		

	}
	
	/**
	 * Imprime linha com 50 "-" e um texto no meio delas;
	 * @param texto String
	 */
	public static void imprimeLinha(String texto) {
		System.out.println();
		for (int i = 0; i < 50; i++) {
			System.out.printf("-");
			if (texto.length()==0 || texto == null) {
				continue;
			} else if(i == 50/2) {
				System.out.printf(" %s ", texto);
			}
		}
		System.out.println();
	}

}
