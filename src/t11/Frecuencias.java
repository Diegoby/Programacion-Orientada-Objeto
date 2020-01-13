package t11;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Implementacion de IFrecuencia haciendo uso de la colección HashMap.
 * @author POO
 *
 */
public class Frecuencias implements IFrecuencia {

  private HashMap<String,Integer> palabrasFiltradas;
  private Filtro filtroPalabrasVacias;  
  
  /**
   * Crea una instancia de Frecuencias, proporcionando el documento de trabajo; prepara los filtros de palabras vacías.
   * @param documento Documento del que se desea obtener las frecuencias de sus palabras.
   */
  public Frecuencias(String documento) {
	filtroPalabrasVacias = new Filtro();
	palabrasFiltradas = toHashMap(documento);
  }
  
  /**
   * Inserta cada palabra del fichero de texto
   * en un HashMap de clave String y valor Integer.
   * Las palabras vacias no se insertan en el HashMap.
   * El fichero de entrada contiene una sucesion de palabras (p.e. El Quijote).
   * 
   * @param documento El nombre del fichero que contiene el documento, libro, etc.
   * @return HashMap<String,Integer> estructura de datos que alberga las palabras.
   */
  private HashMap<String,Integer> toHashMap(String documento) {
   Scanner in=null;
   try {
	 in = new Scanner(new FileReader(documento));
   } catch (FileNotFoundException e) {
	 System.out.println("Error abriendo el fichero "+documento);
   }
   
   HashMap<String,Integer> hashMap = new HashMap<String,Integer>(); 
   while (in.hasNext()) {
	 String palabra = in.next().toUpperCase();
     Integer valor = (Integer) hashMap.get(palabra);
     if (!filtroPalabrasVacias.contains(palabra))
       if (valor == null)
    	 hashMap.put(palabra,1);
        else
    	 hashMap.put(palabra,valor+1); 	  
	}
	in.close();
	return hashMap;
  }
  

  public int frecuencia(String palabra) {
	  Integer apariciones = palabrasFiltradas.get(palabra.toUpperCase()); 
	  if (apariciones==null)
		return 0;
	  else
		return apariciones.intValue();
  }
  
  public String toString() {
	  return palabrasFiltradas.toString();
  }
  
  public static void main(String[] a) {
	Frecuencias tresCerditos = new Frecuencias("TresCerditos.txt");
	System.out.println(tresCerditos.frecuencia("cerditos"));
  }
  
}
