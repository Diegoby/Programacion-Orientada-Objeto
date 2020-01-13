package t11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Prepara la estructura de datos necesaria para filtrar las palabras vacías y los verbos.
 * @author POO
 *
 */
public class Filtro {
	
	private TreeSet<String> verbos,vacias; 
	
	/**
	 * Crea la estructura de datos conteniendo los verbos y las palabras vacías
	 */
	public Filtro() {
	  verbos = new TreeSet<String>();
	  vacias = new TreeSet<String>();
	  verbos=toTreeSet("verbos.txt");
	  vacias=toTreeSet("palabrasVacias.txt");
	}
	
	  /**
	   * Inserta cada palabra del fichero de texto (accedido mediante Scanner)
	   * en un TreeSet de Strings; los ficheros de entrada contendran relaciones de palabras vacias.
	   * 
	   * @param ficheroPalabrasVacias El nombre del fichero de palabras vacías.
	   * @return TreeSet<String> Estructura de datos que alberga las palabras vacias.
	   */
	  private TreeSet<String> toTreeSet(String ficheroPalabrasVacias) {		  
	    Scanner in=null;
		try {
	      in = new Scanner(new FileReader(ficheroPalabrasVacias));
		} catch (FileNotFoundException e) {
		  System.out.println("Error abriendo el fichero "+ficheroPalabrasVacias);
		  e.printStackTrace();
		}	
		TreeSet<String> treeSet = new TreeSet<String>(); 
		while (in.hasNext()) 
		  treeSet.add(in.next().toUpperCase());
		in.close();
		return treeSet;
	  }
	  
      /**
       * Indica si una palabra proporcionada es verbo o vacía (artículos, preposiciones, etc).
       * @param s Palabra a consultar.
       * @return true si la palabra es vacía o es verbo.
       */
	  public boolean contains(String s) {
		return vacias.contains(s)||verbos.contains(s);
	  }	  

}
