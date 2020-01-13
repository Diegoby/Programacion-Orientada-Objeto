package t8;

/**
 * Alberga los objetos que forman un matrimonio, y que deben ser personas.
 * @param <P1> Una de las personas que conforma el matrimonio.
 * @param <P2> La otra persona que conforma el matrimonio.
 */
public interface IMatrimonio <P1 extends IPersona,P2 extends IPersona> {
	
	  /**
	   * @param pareja1 Una de las personas que conforma el matrimonio.
	   * @param pareja2 La otra persona que conforma el matrimonio.
	   */
	  public void set(P1 pareja1, P2 pareja2);
	  
	  /**
	   * @return un objeto matrimonio, conformado por dos personas.
	   */
	  public IMatrimonio<P1,P2> get();
	  
	  /**
	   * @return Uno de los dos objetos que definen el matrimonio.
	   */
	  public P1 getPareja1();
	  
	  /**
	   * @return Otro de los dos objetos que definen el matrimonio.
	   */
	  public P2 getPareja2();
	  
	  public String toString();
	}
