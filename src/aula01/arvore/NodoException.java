/**
 * 
 */
package aula01.arvore;

/**
 * Classe que representa as exceções que podem ser lançadas pela classe Nodo.
 * @author cristovao
 *
 */
public class NodoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public NodoException(String msg) {
		super(msg);
	}
}
