package t8;

/**
 *  Persona femenina.
 */
public class Mujer extends Persona {
	
	  /**
	   * construye una persona femenina.
	   * @param DNI   identificador DNI de la persona.
	   * @param nombre  nombre o nombre y apellidos de la persona.
	   */
	  public Mujer(String DNI, String nombre) {
		  super(DNI,nombre,sexo.MUJER);
	  }
	 
}
