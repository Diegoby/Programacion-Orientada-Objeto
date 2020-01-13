package t8;

/**
 * Matrimonio para el registro eclesiástico, donde solo se permite el matrimonio entre un hombre y una mujer.
 * @param <H> Varón integrante del matrimonio.
 * @param <M> Mujer integrante del matrimonio.
 */
public class MatrimonioIglesia <H extends Hombre,M extends Mujer> extends Matrimonio<H,M> {
	
	  /**
	   * Crea una instancia de Matrimonio.
	   * @param hombre Varón integrante del matrimonio.
	   * @param mujer Mujer integrante del matrimonio.
	   */
	  public MatrimonioIglesia(H hombre, M mujer) {
		super(hombre,mujer);
	  }
	  
}
