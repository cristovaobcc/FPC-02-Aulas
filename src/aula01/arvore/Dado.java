/**
 * 
 */
package aula01.arvore;

/**
 * Classe que representa os dados de um nodo de árvore binária.
 * O objeto inserido nessa classe deve implementar os métodos equals, hashCode
 * e a interface Comparable.
 * @author cristovao
 *
 */
public class Dado {

	private Object dado;

	public Dado(Object dado) {
		super();
		this.dado = dado;
	}

	public Object getDado() {
		return dado;
	}

	public void setDado(Object dado) {
		this.dado = dado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dado == null) ? 0 : dado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dado other = (Dado) obj;
		if (dado == null) {
			if (other.dado != null)
				return false;
		} else if (!dado.equals(other.dado))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.dado.toString();
	}
	
	public static void main(String[] args) {
		// Relembrando se há chamada de equals de uma classe q
		// implementa o equals. Deu certo. Há chamada de equals
		// da subclasse de Object, Integer no exemplo abaixo.
		// Se o dado passado implementar o equals seu método será
		// chamado no equals da classe Dado.
		
		Dado dado1 = new Dado(Integer.valueOf(4));
		Dado dado2 = new Dado(Integer.valueOf(5));
		Dado dado3 = new Dado(Integer.valueOf(4));
		Integer num4 = Integer.valueOf(4);
		System.out.println(num4.equals(dado1.dado) ? "true" : "false");
		if(dado1.equals(dado3)) {
			System.out.println(dado1.toString());
		} else {
			System.out.println("Chamou o equals da superclasse.");
		}
		if (dado2.equals(dado3)) {
			System.out.println("Não é p/ entrar aqui");
		}
		System.out.println("Hello world.");
	}
	
}
