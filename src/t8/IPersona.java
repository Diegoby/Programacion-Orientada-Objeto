package t8;

/**
 *  Abstracción del concepto de persona, entendida como los datos que definen a un individuo en un sistema.
 */
public interface IPersona {
  
  /**
   * Distintas modalidades de sexo.
   */
  static enum sexo {HOMBRE,MUJER,OTROS};  
  
  /**
   * Devuelve el DNI de la Persona.
   * @return identificador DNI de la persona.
   */
  String getDNI();
  
  /**
   * Devuelve el nombre de la Persona.
   * @return nombre o nombre y apellidos de la persona.
   */
  String getNombre();
  
  /**
   * Devuelve el sexo de la Persona.
   * @return sexo de la persona {HOMBRE,MUJER,OTROS}.
   */
  sexo getSexo();
  
  /**
   * Devuelve la instancia de la Persona
   * @return Objeto que define la abstracción de la persona.
   */
  Persona get();
  
  /**
   * Establece el identificador (DNI) de la Persona.
   * @param DNI identificador DNI de la persona.
   */
  void setDNI(String DNI);
  
  /**
   * Establece el nombre de la Persona.
   * @param nombre nombre o nombre y apellidos de la persona.
   */
  void setNombre(String nombre);
  
  /**
   * Establece el sexo de la Persona.
   * @param sexo sexo de la persona {HOMBRE,MUJER,OTROS}.
   */
  void setSexo(sexo sexo);
  
  public String toString(); 
  
  public boolean equals(IPersona p);
	   
}
