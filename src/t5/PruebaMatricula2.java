package t5;

/**
 * 
 * Conceptos:
 * 1) Cómo recoger excepciones.
 * 2) Cómo usar enumerados.
 * @author POO.
 *
 */
public class PruebaMatricula2 {

	// Obtenemos la antigüedad de la matrícula, si su longitud es correcta y también su primera letra lo es.
	public static void main(String[] args) {
		Matricula2 m1 = new Matricula2("9312G8V");

		try {
			System.out.println("Comparar matrículas: "+m1.compareTo("9999G8V"));
         	m1.valida();
		} catch (ExMatricula2 e) {
			System.out.println("Error en la matrícula: "+e);
	        if (e.getFallo()!= Fallo.LONGITUD &&
	        	e.getFallo()!= Fallo.LETRA_UNO)
		      System.out.println(m1.año());	   
		}
	}
}
