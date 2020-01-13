package t11;

/**
 * Recopila un conjunto de palabras que deseamos filtrar;
 * En nuestro caso: verbos y palabras vacías (artículos, preposiciones, etc).
 * @author POO
 */
public interface IFiltro {
	
 /**
  * Indica si una palabra es vacia.
  * 
  * @param s Palabra que se deasea saber si es o no vacía.
  * @return true: la palabra aportada es vacia.
  */
  public boolean contains(String s);

}
