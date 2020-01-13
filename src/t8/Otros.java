package t8;

/**
 *  Persona con sexo diferente a masculino o femenino.
 */
public class Otros extends Persona {

	  /**
	   * construye una persona con sexo diferente a masculino o femenino.
	   * @param DNI   identificador DNI de la persona.
	   * @param nombre  nombre o nombre y apellidos de la persona.
	   */
	  public Otros(String DNI, String nombre) {
		  super(DNI,nombre,sexo.OTROS);
	  }
	  
}
