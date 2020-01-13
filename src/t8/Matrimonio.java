package t8;

/**
 * Matrimonio entre cualquier pareja de personas.
 * @author POO
 *
 * @param <P1> Una Persona de cualquier tipo: Persona o clase derivada.
 * @param <P2> Una Persona de cualquier tipo: Persona o clase derivada.
 */
public class Matrimonio <P1 extends IPersona,P2 extends IPersona> implements IMatrimonio <P1,P2> {
	
	  private P1 pareja1;
	  private P2 pareja2;
	  
	  /**
	   * Crea una instancia de Matrimonio.
	   * @param pareja1 Una de las personas que componen el matrimonio.
	   * @param pareja2 La otra persona que compone el matrimonio.
	   */
	  public Matrimonio(P1 pareja1, P2 pareja2) {
		set(pareja1,pareja2);
	  }
		
	  public void set(P1 pareja1, P2 pareja2) {
		this.pareja1=pareja1;
		this.pareja2=pareja2;
	  }
	  
	  public IMatrimonio <P1,P2> get() {
		return this;
	  }
	  
	  public P1 getPareja1() {
		return pareja1;
	  }
	  
	  public P2 getPareja2() {
		return pareja2;
	  }
	  
	  public String toString() {
		return ""+pareja1+", "+pareja2;  
	  }
	    
	}

