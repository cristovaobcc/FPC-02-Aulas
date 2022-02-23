package aula01.arvore;

/**
 * Classe que representa o nó de uma árvore binária.
 * 
 * @author cristovao
 *
 */
public class Nodo {

	private Dado dados;
	private Nodo pai;
	private Nodo nodoEsq;
	private Nodo nodoDir;
	
	/**
	 * Ao instanciar um nodo deve-se passar um conteúdo que seja do tipo Dado.
	 * Caso nodo raiz seja null, o nó
	 * 
	 * @param dados @Dado
	 * @param pai @Nodo
	 * @param nodoEsq @Nodo
	 * @param nodoDir @Nodo
	 */
	public Nodo(Dado dados, Nodo pai, Nodo nodoEsq, Nodo nodoDir) {
		super();
		this.dados = dados;
		this.pai = pai;
		this.nodoEsq = nodoEsq;
		this.nodoDir = nodoDir;
	}

	public Dado getDados() {
		return dados;
	}

	public void setDados(Dado dados) {
		this.dados = dados;
	}

	public Nodo getPai() {
		return pai;
	}

	public void setPai(Nodo raiz) {
		this.pai = raiz;
	}

	public Nodo getNodoEsq() {
		return nodoEsq;
	}

	public void setNodoEsq(Nodo nodoEsq) {
		this.nodoEsq = nodoEsq;
	}

	public Nodo getNodoDir() {
		return nodoDir;
	}

	public void setNodoDir(Nodo nodoDir) {
		this.nodoDir = nodoDir;
	}
	
	public boolean isRaiz() {
		return this.pai == null ? true:false;
	}

}
