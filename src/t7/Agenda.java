package t7;
/**
 * Implementa el interfaz IAgenda; Agenda sencilla, sin funciones de recorrido.
 * @author POO.
 *
 */
public class Agenda implements IAgenda {
	
  private Persona[] agenda;
  private int posicion;
  
  /**
   * Crea una Agenda del tamaño máximo deseado.
   * @param maxSize Tamaño máximo de la Agenda.
   */
  public Agenda(int maxSize) {
	agenda = new Persona[maxSize];
  }
  
  /**
   * Crea una agenda de 100 elementos.
   */
  public Agenda() {
	this(100);
  }
	  
  public void pos(Persona e) throws ExAgendaPersonaNoExistente {
	posicion = 0;
	boolean encontrado = false;
	
	do {
	  if (agenda[posicion]!=null)
	    encontrado = e.equals(agenda[posicion]); 
	  posicion++;    
	} while (posicion<maxSize()&&!encontrado);
	
	if (!encontrado)
	  throw new ExAgendaPersonaNoExistente();
	else
	  posicion = posicion - 1;
  }
	  
  public String getDNI() {
	return agenda[posicion].getDNI();
  }
  
  public String getNombre() {
	return agenda[posicion].getNombre();
  }
	  
  public int size() {
	int i = 0;
	int size = 0;
	do {
	 if (agenda[i] != null)
	   size++;
	 i++;
	} while (i<maxSize());
	return size;
  }
	
  public void add(Persona e) {
	 int hueco = hueco();
	 if (hueco!=-1)
	   agenda[hueco] = e;
  }
  
  /** 
   * 
   * @return posición del primer hueco de la agenda, o -1, si la agenda está llena.
   */
  private int hueco() {
		int i = 0;
		boolean encontrado = false;
		do {
		 encontrado = agenda[i] == null;
		 i++;
		} while (i<maxSize()&&!encontrado);
		if (encontrado)	
		 return i-1;
		else
		 return -1;	  
  }
	  
  public void delete() {
	agenda[posicion] = null;
  }
  
  public String toString() {
	String aux="";
	for (int i=0;i<agenda.length;i++)
	  if (agenda[i]!=null)
		aux = aux + agenda[i];
	return aux;
  }
  
  
  /** Tamaño de la agenda. Número máximo de contactos que puede contener.
   * 
   * @return Número máximo de contactos que puede contener.
   */
  public int maxSize() {
	return agenda.length;
  }
  
  /**
   * 
   * @return Indicación de que la agenda está llena y no admite más contactos.
   */
  public boolean llena() {
	int i = 0;
	boolean encontrado = false;
	do {
	 encontrado = agenda[i] == null;
	 i++;
	} while (i<maxSize()&&!encontrado);
	return !encontrado;
  }
	
}
