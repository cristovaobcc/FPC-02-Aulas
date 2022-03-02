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
	public Nodo(Object dados, Nodo pai, Nodo nodoEsq, Nodo nodoDir) {
		super();
		this.dados = new Dado(dados);
		this.pai = pai;
		this.nodoEsq = nodoEsq;
		this.nodoDir = nodoDir;
	}
	
	/**
	 * Devolve o contéudo(dados) do Nodo.
	 * @return Object Conteúdo armazenado no nodo.
	 */
	public Object getDados() {
		return dados.getDado();
	}

	public void setDados(Object dado) {
		this.dados.setDado(dado);
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
	
	/**
	 * Informa se este Nodo n é filho esquerdo numa árvore.
	 * @param n @Nodo
	 * @return boolean Devolve true, se n for filho esquerdo. false, caso contrário.
	 */
	public boolean isNodoEsq() {
		Nodo q = this.pai;
		if (q == null)  // O nodo n aponta p/ raiz.
			return false; 
		if (q.getNodoEsq().equals(this)) 
			return true;
		return false;	
	}
	
	/**
	 * Informa se este Nodo n é filho direito numa árvore.
	 * @param n @Nodo
	 * @return boolean Devolve true, se n for filho esquerdo. false, caso contrário.
	 */
	public boolean isNodoDir() {
		Nodo q = this.pai;
		if (q == null) 
			return false;
		if (q.getNodoDir().equals(this))
			return true;
		return false;
	}
	
	/**
	 * Verifica se nodo possui irmão.
	 * @param n
	 * @return boolean Devolve true, se n possui irmao. false, caso contrário.
	 */
	public boolean temIrmao() {
		if (this.pai == null) 
			return false;
		if (this.isNodoEsq())
			return this.pai.getNodoDir() != null ? true : false;
		return this.pai.getNodoEsq() != null ? true : false;
	}
	
	/**
	 * Devolve o irmão do nodo atual, se ele existir.
	 * Caso este nodo seja um nó direito, devolve o irmão esquerdo. E vice-versa.
	 * Caso não haja irmao, devolve null.
	 * @return Nodo O nodo irmão, se existir. null, caso não exista.
	 */
	public Nodo getIrmao() {
		if (this.temIrmao()) {

			if (this.isNodoDir()) {
				return this.pai.getNodoEsq();
			} else {
				return this.pai.getNodoDir();
			}
		}
		return null;
	}
	
	//----------------------------------------------------------------------------------//
	// --------------------------- Métodos estáticos a partir daqui ------------------- //
	//----------------------------------------------------------------------------------//
	
	/**
	 * Informa se um Nodo n é filho esquerdo numa árvore.
	 * @param n @Nodo
	 * @return boolean Devolve true, se n for filho esquerdo. false, caso contrário.
	 */
	public static boolean isNodoEsq(Nodo n) {
		Nodo q = n.getPai();
		if (q == null)  // O nodo n aponta p/ raiz.
			return false; 
		if (q.getNodoEsq() == n) 
			return true;
		return false;	
	}
	
	/**
	 * Informa se um Nodo n é filho direito numa árvore.
	 * @param n @Nodo
	 * @return boolean Devolve true, se n for filho esquerdo. false, caso contrário.
	 */
	public static boolean isNodoDir(Nodo n) {
		Nodo q = n.getPai();
		if (q == null) 
			return false;
		if (q.getNodoDir() == n)
			return true;
		return false;
	}
	
	/**
	 * Verifica se o nodo n possui irmão.
	 * @param n
	 * @return boolean Devolve true, se n possui irmao. false, caso contrário.
	 */
	public static boolean temIrmao(Nodo n) {
		if (n.getPai() == null) 
			return false;
		if (isNodoEsq(n))
			return n.getPai().getNodoDir() != null ? true : false;
		return n.getPai().getNodoEsq() != null ? true : false;
	}
	
}
