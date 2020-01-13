package t7;

public class Persona {
	  private String DNI;
	  private String nombre;
	  
	  /**
	   * Crea una instancia de Persona con el DNI y el nombre proporcionados.
	   * @param DNI Identificador de la Persona.
	   * @param nombre Nombre de la Persona.
	   */
	  public Persona(String DNI, String nombre) {
		  this.DNI = DNI;
		  this.nombre = nombre;
	  }
	  
	  public String getDNI() {return DNI;}
	  public String getNombre() {return nombre;}
	  public Persona get() {return this;}
	  
	  public void setDNI(String DNI) { this.DNI = DNI; }
	  public void setNombre(String nombre) { this.nombre = nombre; }
	  
	  public String toString() {
		return "("+DNI+", "+nombre+")";
	  }
	  public boolean equals(Persona p) {
	    return DNI.equals(p.getDNI());
	  }
	  
	  public int compareTo(IPersona p) {
		return DNI.compareTo(p.getDNI());
	  }
	  
	}
