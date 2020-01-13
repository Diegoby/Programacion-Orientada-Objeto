package t11;

/**
 * Permite obtener las frecuencias de las palabras de un texto;
 * Las clases que implementen este interfaz incluirán un constructor que permita proporcionar el nombre de un fichero de texto;
 * Las verbos y las palabras vacías (artículos, preposiciones, conjunciones, etc.) deben filtrarse (no incluirse como palabras válidas).
 * @author POO
 *
 */
public interface IFrecuencia {

  /**
   * Indica el número de apariciones, en el documento, de la palabra consultada.
   * @param palabra Palabra consultada.
   * @return Número de apariciones.
   */
   public int frecuencia(String palabra);
   
}
