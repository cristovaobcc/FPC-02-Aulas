package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Classe com métodos estáticos para manipulação de arquivos texto no formato .txt.
 * @author cristovao
 *
 */
public final class IOTools {
	
	// Impede de se instanciar IOTools.
	private IOTools() {}
	
	/**
	 * Lê as linhas de arquivo (no formato abaixo) no caminho passado no par�metro e devolve 
	 * uma lista com objetos Map<String, String> de valores lidos em cada linha. 
	 * A primeira linha de arquivo deve conter os nomes das chaves.
	 * As linhas seguintes devem contem as informa��es pertinentes a cada chave.
	 * O delimitador das linhas devem ser iguais.
	 * 
	 * Em rela��o ao formato do arquivo a ser usado, deve-se seguir a seguinte estrutura:
	 * linha1: campoChave1[delimitador]campoChave2[delimitador]...
	 * linha2: valorNDeChave1;valorKDeChave2;...
	 * linha3: valorPDeChave1;valorQDeChave2;...
	 * 
	 * N�o use espa�o ou tabula��o como delimitador.
	 *   
	 * @param caminho String Caminho do arquivo
	 * @param delimitador String Delimitador de campos
	 * @return List<> Lista das linhas com Maps de cada campo
	 */
	public static List<Map<String,String>> carregarDeArquivo(String caminho, String delimitador) {
		
		List<Map<String,String>> dadosLidos = new LinkedList<Map<String,String>>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			
			String line = br.readLine();
			String campos[] = line.split(delimitador);
			for (int i = 0; i < campos.length; i++) {
				campos[i] = campos[i].strip();
			}
			int numCampos = campos.length;
			Map<String, String> mapDeLinha = null;
			String camposDeLinha[] = null;
			line = br.readLine();
			
			while(line != null) {
				mapDeLinha = new HashMap<String, String>();				
				camposDeLinha = line.split(delimitador.toString());
				for(int i = 0; i < numCampos; i++) {				
					mapDeLinha.put(campos[i], camposDeLinha[i].strip());
				}
				dadosLidos.add(mapDeLinha);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		return dadosLidos;
	}

}
