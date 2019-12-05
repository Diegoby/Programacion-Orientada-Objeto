package t5;

/**
 * Exception que almacena un estado.
 * Excepciones como clases, con estados.
 * @author POO.
 */
public class ExMatricula2 extends Exception {

	private Fallo e;
	
	public ExMatricula2(Fallo e) {
	  this.e = e;		
	}

	public Fallo getFallo() {
		return e;
	}

	public String getTipoFallo() {
		return e.getTipo();
	}

	@Override
	public String getMessage() {
		return e.getMensaje();
	}

	@Override
	public String toString() {
		return getMessage()+" ["+getTipoFallo()+"]";
	}
}
