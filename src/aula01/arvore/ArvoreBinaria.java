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
	 * a interface Comparable, portanto a inserção obedece à ordem natural implementada
	 * na classe de objeto dado passado no parâmetro.
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
	public ArrayList<Object> listarEmPreOrdemRecursivo(){

		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(this.raiz);

		if (this.raiz.getNodoEsq() != null ) {
			this.percorreEmPreOrdem(this.raiz.getNodoEsq(), arrayList);
		} 
		if (this.raiz.getNodoDir() != null) {
			this.percorreEmPreOrdem(this.raiz.getNodoDir(), arrayList);
		}

		return arrayList;
	}


	/**
	 * Percorre em ordem a árvore e add o nodo n na lista.
	 * @param n Nodo
	 * @param lista {@link ArrayList}
	 */
	private void percorreEmPreOrdem(Nodo n, ArrayList<Object> lista) {
		// Visita a raiz da subárvore que tem raiz no nodo n.
		lista.add(n);
		// Verifica se o nó atual tem filho esquerdo.
		if (n.getNodoEsq() != null) {
			this.percorreEmPreOrdem(n.getNodoEsq(), lista);
		} 		
		// Verifica se o nó atual não tem filho direito.
		if (n.getNodoDir() != null) {
			this.percorreEmPreOrdem(n.getNodoDir(), lista);
		}		
	}


	public ArrayList<Object> listarEmOrdemRecursivo(){
		ArrayList<Object> arrayList = new ArrayList<Object>();

		if (this.raiz.getNodoEsq() != null ) {
			this.percorreEmOrdem(this.raiz.getNodoEsq(), arrayList);
		} 
		arrayList.add(this.raiz);
		if (this.raiz.getNodoDir() != null) {
			this.percorreEmOrdem(this.raiz.getNodoDir(), arrayList);
		}
		return arrayList;
	}

	private void percorreEmOrdem(Nodo n, ArrayList<Object> lista) {
		// Visita a subarvore da esquerda
		if (n.getNodoEsq() != null) {
			this.percorreEmOrdem(n.getNodoEsq(), lista);
		}
		// Visita raiz
		lista.add(n);
		// Visita subarvore da direita
		if (n.getNodoDir() != null) {
			this.percorreEmOrdem(n.getNodoDir(), lista);
		}

	}

	public ArrayList<Object> listarEmPosOrdemRecursivo(){
		ArrayList<Object> arrayList = new ArrayList<Object>();

		if (this.raiz.getNodoEsq() != null ) {
			this.percorreEmPosOrdem(this.raiz.getNodoEsq(), arrayList);
		} 
		if (this.raiz.getNodoDir() != null) {
			this.percorreEmPosOrdem(this.raiz.getNodoDir(), arrayList);
		}
		arrayList.add(this.raiz);
		return arrayList;
	}


	private void percorreEmPosOrdem(Nodo n, ArrayList<Object> lista) {
		// Visita a subarvore da esquerda
		if (n.getNodoEsq() != null) {
			this.percorreEmPosOrdem(n.getNodoEsq(), lista);
		}
		// Visita subarvore da direita
		if (n.getNodoDir() != null) {
			this.percorreEmPosOrdem(n.getNodoDir(), lista);
		}
		// Visita raiz
		lista.add(n);

	}

	/**
	 * Verifica se o objeto element passado no parâmetro, está contido na árvore.
	 * Método equals(), hashCode() deve estar implementados p/ resultado correto.
	 * O objeto element passado deve também implementar a interface {@link Comparable}.
	 * 
	 * @param element {@link Object}
	 * @return true, caso objeto esteja já inserido na árvore. false, caso contrário.
	 */
	@SuppressWarnings("rawtypes")
	public boolean hasNode(Comparable element) {
		
		return buscaEmPreOrdem(element) != null ? true : false;
	}
	
	/**
	 * Busca o elemento em pré-ordem de forma iterativa.
	 * Caso exista devolve o conteúdo do nó que contém element.
	 * Do contrário devolve null.
	 * @param element {@link Comparable}
	 * @return {@link Object}
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object buscaEmPreOrdem(Comparable element) {
		Nodo nodoAtual = this.raiz;
		Object o = null;
		while(nodoAtual != null) {
			if (nodoAtual.compareTo(element) == 0) {
				o = nodoAtual.getDados();
				return o;
			} else {
				// element vem depois de nodo
				if(nodoAtual.compareTo(element) > 0) {
					nodoAtual = nodoAtual.getNodoEsq();
				} else {
					nodoAtual = nodoAtual.getNodoDir();
				}
			}
		}
		return null;
		
	}
	
	@Override
	public String toString() {
		return "ArvoreBinaria [raiz=" + raiz + "]";
	}

	


}
