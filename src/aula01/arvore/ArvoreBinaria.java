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
	 * Insere o dado na árvore binária. O objeto inserido deve implementar 
	 * a interface Comparable.
	 * 
	 * @param dado Object
	 */
	public void insereNodo(Object dado) {

		if(this.raiz == null) {
			this.raiz = new Nodo(dado, null);
		} else {
			this.insereNodoRecursivo(raiz, dado);
		}

	}

	/**
	 * Insere nodo com dado à esquerda ou direita do nodo n.
	 * Obedecendo a ordem natural implemetada no objeto passado como dado.
	 * @param n Nodo
	 * @param dado Object
	 */
	private void insereNodoRecursivo(Nodo n, Object dado) {
		@SuppressWarnings("unchecked")
		Comparable<Object> comparable = (Comparable<Object>) n.getDados();

		// Conteúdo do nó n vem antes de dado: inserção à direita de n.
		if (comparable.compareTo(dado) < 0 ) {
			// Verifica se tem nó direito antes de inserir.
			if (n.getNodoDir() == null) {
				// insere novo dado em nó direito
				Nodo novoNodo = new Nodo(dado, n); // Configura-se o pai do novo nó
				try {
					n.setNodoDir(novoNodo);
				} catch (NodoException e) {
					e.printStackTrace();
				}
			} else {
				this.insereNodoRecursivo(n.getNodoDir(), dado);;
			}
		} // Conteúdo do nó n vem depois de dado: inserção à esquerda de n.
		else if (comparable.compareTo(dado) > 0) {
			// Verifica se tem nó direito antes de inserir.
			if (n.getNodoEsq() == null) {
				// insere novo dado em nó esquerdo
				Nodo novoNodo = new Nodo(dado, n); // Configura-se o pai do novo nó
				try {
					n.setNodoEsq(novoNodo);
				} catch (NodoException e) {
					e.printStackTrace();
				}
			} else {
				this.insereNodoRecursivo(n.getNodoEsq(), dado);
			}
		}
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
		// Visita a raiz da subárvore que tem raiz no nodo n.
		lista.add(n);
		// Verifica se o nó atual tem filho esquerdo.
		if (n.getNodoEsq() != null) {
			this.percorreEmOrdem(n.getNodoEsq(), lista);
		} 		
		// Verifica se o nó atual não tem filho direito.
		if (n.getNodoDir() != null) {
			this.percorreEmOrdem(n.getNodoDir(), lista);
		}		
	}

	@Override
	public String toString() {
		return "ArvoreBinaria [raiz=" + raiz + "]";
	}

	
	


}
