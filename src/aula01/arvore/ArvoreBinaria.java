package aula01.arvore;

import java.util.ArrayList;

public class ArvoreBinaria {
	
	private Nodo raiz;
	
	public ArvoreBinaria() { }
	
	/**
	 * Instancia uma nova árvore com o objeto raiz como 
	 * raiz da árvore.
	 * @param raiz Object
	 */
	public ArvoreBinaria(Object raiz) {
		this.raiz = new Nodo(raiz, null);
	}
	
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	/**
	 * Insere o dado na árvore binária.
	 * 
	 * @param dado Object
	 */
	public void insereNodo(Object dado) {
		// TODO: implementar a inserção em 1 das 3 ordens.
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Object> listarEmOrdemRecursivo(){
		
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(this.raiz);
		
		if (this.raiz.getNodoEsq() != null ) {
			this.percorreEmOrdem(this.raiz.getNodoEsq(), arrayList);
		} 
		
		if (this.raiz.getNodoDir() != null) {
			this.percorreEmOrdem(this.raiz.getNodoDir(), arrayList);
		}
		
		return arrayList;
	}
	
	
	/**
	 * Percorre em ordem a árvore e add o nodo n na lista.
	 * @param n Nodo
	 * @param lista {@link ArrayList}
	 */
	private void percorreEmOrdem(Nodo n, ArrayList<Object> lista) {
		// Verifica se o nó atual tem filho esquerdo.
		if (n.getNodoEsq() != null) {
			this.percorreEmOrdem(n.getNodoEsq(), lista);
		} 
		lista.add(n);	
		// Verifica se o nó atual não tem filho direito.
		if (n.getNodoDir() != null) {
			this.percorreEmOrdem(n.getNodoDir(), lista);
		}		
	}
	
	
	
}
