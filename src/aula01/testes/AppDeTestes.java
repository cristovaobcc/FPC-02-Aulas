/**
 * 
 */
package aula01.testes;

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

		// Random random = new Random();	
		// elementosParaArvore = insereInteirosAleatorios(elementosParaArvore);

		Integer[] numeros = {21, 30, 31, 25, 27, 22, 8, 6, 7};	
		elementosParaArvore = insereNumerosDeArray(numeros, elementosParaArvore);	
		System.out.println(elementosParaArvore);

		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

		// Integer valor = random.nextInt(100);
		// Nodo n = new Nodo(valor, null);
		Nodo n = new Nodo(numeros[0], null);
		imprimeLinha("Valor inicial da raiz");
		System.out.println(n);
		arvoreBinaria.setRaiz(n);
		imprimeLinha("Valor inicial de árvore binária");
		System.out.println(arvoreBinaria);

		insereElementosEmArvore(elementosParaArvore, arvoreBinaria);
		System.out.println(arvoreBinaria);

		testaPercusoEmPreOrdem(arvoreBinaria);

		testaPercusoEmOrdem(arvoreBinaria);

		testaPercusoEmPosOrdem(arvoreBinaria);

		testaBuscaNumerosRepetidos();
		
		testaBuscarElementoNaArvore(arvoreBinaria);

	}
	
	private static void testaBuscarElementoNaArvore(ArvoreBinaria arvore) {
		imprimeLinha("Busca por elemento na árvore");
		Integer numA = 27;
		Integer numB = 6;
		Integer numC = 32;
		
		verificaDadoIntegerEmArvore(numA, arvore);
		verificaDadoIntegerEmArvore(numB, arvore);
		verificaDadoIntegerEmArvore(numC, arvore);
		
	}
	
	private static void verificaDadoIntegerEmArvore(Integer n, ArvoreBinaria arvore) {
		Integer encontrado = (Integer) arvore.busca(n);
		if (encontrado != null) {
			System.out.println(String.format("Foi encontrado o número %d", encontrado));
		} else {
			System.out.println(String.format("Não foi encontrado o número %d", n));
		}
		
	}

	private static void testaBuscaNumerosRepetidos() {
		
		imprimeLinha("Busca por números repetidos");
		Integer inteiros[] = {2, 5, 7, 5, 2, 1, 9, 10, 11, 13, 7}; 
		
		List<Integer> listaComRepetidosParaTeste = preencheComInteiros(inteiros);
		System.out.println("Lista de teste -> "+ listaComRepetidosParaTeste);
		List<Integer> listaDeRepetidos = buscaNumerosRepetidos(listaComRepetidosParaTeste);

		// O resultado esperado é uma lista c/ {2, 5, 7}
		System.out.println("Os números repetidos são: " + listaDeRepetidos);

	}

	private static LinkedList<Integer> preencheComInteiros(Integer[] inteiros){
		LinkedList<Integer> inteirosLL = new LinkedList<Integer>();

		for (int i = 0; i < inteiros.length; i++) {
			Integer integer = inteiros[i];
			inteirosLL.add(integer);
		}

		return inteirosLL;

	}


	private static LinkedList<Integer> buscaNumerosRepetidos(List<Integer> inteirosList){

		Nodo raiz = new Nodo(inteirosList.get(0), null);
		ArvoreBinaria arvoreDeInteiros = new ArvoreBinaria(raiz);
		int t = inteirosList.size();
		Integer inteiro = null;
		LinkedList<Integer> inteirosRepetidos = new LinkedList<Integer>();
		for (int i = 1; i < t; i++) {
			inteiro = inteirosList.get(i);
			if(arvoreDeInteiros.hasNode(inteiro)) {
				inteirosRepetidos.add(inteiro);
			} else {
				arvoreDeInteiros.insereNodo(inteiro);
			}
		}

		if (inteirosRepetidos.size() == 0) {
			return null;
		} else {
			return inteirosRepetidos;
		}
	}


	private static void testaPercusoEmPosOrdem(ArvoreBinaria arvoreBinaria) {
		List<Object> elementosPercorridosEmOrdem = arvoreBinaria.listarEmPosOrdemRecursivo();
		imprimeLinha("Árvore percorrida em pós-ordem");
		imprimeListDeNodos(elementosPercorridosEmOrdem);
	}


	private static void testaPercusoEmOrdem(ArvoreBinaria arvoreBinaria) {
		List<Object> elementosPercorridosEmOrdem = arvoreBinaria.listarEmOrdemRecursivo();
		imprimeLinha("Árvore percorrida em ordem");
		imprimeListDeNodos(elementosPercorridosEmOrdem);	
	}

	/**
	 * Percorre a arvoreBinaria em pré-ordem (percurso em profudidade).
	 * @param arvoreBinaria
	 */
	private static void testaPercusoEmPreOrdem(ArvoreBinaria arvoreBinaria) {
		List<Object> elementosPercorridosEmPreOrdem = arvoreBinaria.listarEmPreOrdemRecursivo();
		imprimeLinha("Árvore percorrida em pré-ordem");
		imprimeListDeNodos(elementosPercorridosEmPreOrdem);

	}

	private static void imprimeListDeNodos(List<Object> nodos) {

		int tamanho = nodos.size();
		Nodo nodoLido = null;
		for(int i = 0; i < tamanho ; i++) {
			nodoLido = (Nodo)nodos.get(i);
			if (i + 1 == tamanho) {
				System.out.println(nodoLido.getDados().toString() + ".");
			} else {
				System.out.printf(nodoLido.getDados().toString() + ", ");
			}
		}
	}


	/**
	 * Insere itens de elementosParaArvores em arvoreBinaria.
	 * @param elementosParaArvore
	 * @param arvoreBinaria
	 */
	private static void insereElementosEmArvore(List<Integer> elementosParaArvore, ArvoreBinaria arvoreBinaria) {
		for (Integer integer : elementosParaArvore) {
			arvoreBinaria.insereNodo(integer);
		}
	}

	/**
	 * Insere numeros em elementosParaArvore.
	 * 
	 * @param numeros
	 * @param elementosParaArvore
	 * @return
	 */
	private static List<Integer> insereNumerosDeArray(Integer[] numeros, List<Integer> elementosParaArvore) {
		for (int i = 0; i < numeros.length; i++) {
			Integer integer = numeros[i];
			elementosParaArvore.add(integer);
		}
		return elementosParaArvore;
	}


	public static List<Integer> insereInteirosAleatorios(List<Integer> list) {
		Random random = new Random();

		for (int i = 0, j = 0; i < 10; i++) {
			j = random.nextInt(100);
			list.add(j);
		}

		return list;
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
