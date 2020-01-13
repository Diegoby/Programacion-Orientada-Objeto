package t8;

/**
 *  Persona masculina.
 */
public class Hombre extends Persona {

  /**
   * construye una persona masculina.
   * @param DNI   identificador DNI de la persona.
   * @param nombre  nombre o nombre y apellidos de la persona.
   */
  public Hombre(String DNI, String nombre) {
	  super(DNI,nombre,sexo.HOMBRE);
  }
  
}
