package t5;

/**
 * 
 * Clase que encapsula el concepto de matrículas de vehículos con formato NNNNAAA.
 * Conceptos:
 * 1) Excepciones: métodos con excepciones.
 * 2) Métodos estáticos
 * 3) Una primera aproximación a uso de genéricos
 * 4) Utiilización del API: clases String y Character
 * 5) Enumerados en Java.
 * @author POO.
 */
public class Matricula2 {

	  private String matricula;
	  
	  public Matricula2(String matricula) {
		this.matricula = matricula;  
	  }

	  /**
	   * Comprueba la validez de la matrícula proporcionada.
	   * @param matricula  Matricula que se valida.
	   * @throws ExMatricula2 Situaciones que indica	n la falta de validez de la matrícula.
	   */
	  public static void valida(String matricula) throws ExMatricula2 {
			 if (matricula.length()!=7)
			   throw new ExMatricula2(Fallo.LONGITUD);
			 else {
			  if (!Character.isDigit(matricula.charAt(0)))
			    throw new ExMatricula2(Fallo.NUMERO_UNO);
			  if (!Character.isDigit(matricula.charAt(1)))
				throw new ExMatricula2(Fallo.NUMERO_DOS);
			  if (!Character.isDigit(matricula.charAt(2)))
				throw new ExMatricula2(Fallo.NUMERO_TRES);
			  if (!Character.isDigit(matricula.charAt(3)))
				throw new ExMatricula2(Fallo.NUMERO_CUATRO);
			  if (!Character.isLetter(matricula.charAt(4)))
				throw new ExMatricula2(Fallo.LETRA_UNO);
			  if (!Character.isLetter(matricula.charAt(5)))
				throw new ExMatricula2(Fallo.LETRA_DOS);
			  if (!Character.isLetter(matricula.charAt(6)))
				throw new ExMatricula2(Fallo.LETRA_TRES);
			 }
		  }
	  
	  
	  /**
	   * Comprueba la validez de la matrícula.
	   * @throws ExMatricula2 Situaciones que indican la falta de validez de la matrícula.
	   */
	  public void valida() throws ExMatricula2 {
		 valida(matricula);
	  }
	
	  
	  /**
	   * Compara matrículas por antigüedad (las letras tienen mayor peso en la antigüedad)
	   * Conceptos:
	   * 1) Método compareTo del interfaz Comparable
	   * @param matricula  Matricula que se comapra.
	   * @return valor negativo: menor; valor positivo: mayor; valor cero: igual.
	   */
	  public int compareTo(String matricula) {
		 return transformaMatricula(this.matricula).compareTo(transformaMatricula(matricula));
	  }

	/**
	 * Cambia la posición de las letras de la matrícula para que aparezcan en antes que los valores numéricos
	 * Conceptos:
	 * 1) Substring de una cadena
	 * @param matricula  Matricula que transforma.
	 * @return matrícula transformada
	 */
	  private String transformaMatricula(String matricula){
		  String auxiliar;
		  auxiliar = matricula.substring(4);
		  auxiliar += matricula.substring(0,4);
		  System.out.println(matricula+"->"+auxiliar);
		  return auxiliar;
	  }
	  
	  /**
	   * Proporciona la antigüedad de la matrícula 
	   * Supondemos que todas las matrículas con la primera letra 'A' se corresponden al año 2000
	   * Supondremos que cada comienzo de letra, en la primera letra de la matrícula, indica un año más.
	   * @return año de matriculación.
	   */
	  public int año() {
		char letra = matricula.charAt(4);
		return 2000+Character.getNumericValue(letra)-Character.getNumericValue('A');
	  }
	
}
