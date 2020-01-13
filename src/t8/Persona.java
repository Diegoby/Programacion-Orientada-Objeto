package t8;

public class Persona implements IPersona {
  private String DNI;
  private String nombre;
  private sexo sexo;
  
  public Persona(String DNI, String nombre, sexo sexo) {
	  this.DNI = DNI;
	  this.nombre = nombre;
	  this.sexo = sexo;
  }
  
  public String getDNI() {return DNI;}
  public String getNombre() {return nombre;}
  public sexo getSexo() {return sexo;}
  public Persona get() {return this;}
  
  public void setDNI(String DNI) { this.DNI = DNI; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public void setSexo(sexo sexo) { this.sexo = sexo; }
  
  public String toString() {
	return "("+DNI+", "+nombre+")";
  }
  public boolean equals(IPersona p) {
    return DNI.equals(p.getDNI());
  }
  
  public int compareTo(IPersona p) {
	return DNI.compareTo(p.getDNI());
  }
  
}
