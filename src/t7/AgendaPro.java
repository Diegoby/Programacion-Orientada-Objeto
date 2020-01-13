package t7;
/**
 * Implementación del Interdaz IAgendaPro; Agenda con funcionalidades de recorrido.
 * @author POO.
 *
 */
public class AgendaPro implements IAgendaPro {
	
	  private Persona[] agenda;
	  private int posicion;
	  private int numElementos;
	  private int maxSize;
	  
	  /**
	   * Crea una Agenda del tamaño máximo deseado.
	   * @param maxSize Tamaño máximo de la Agenda.
	   */
	  public AgendaPro(int maxSize) {
		this.maxSize = maxSize;
		agenda = new Persona[maxSize]; //se inicializa todo a null
	  }
	  
	  /**
	   * Crea una agenda de 100 elementos.
	   */
	  public AgendaPro() {
		this(100);
	  }
	  
	  public boolean full() {
		return numElementos == maxSize;
	  }
	  

	  public boolean empty() {
		 return numElementos == 0;
	  }
		
	  public int size() {
		return numElementos;
	  }


	  public int maxSize() {
		return maxSize;
	  }
		  

	  public void add(Persona e) throws ExAgendaProPersonaExistente, ExAgendaProLlena {
		if (full())
		  throw new ExAgendaProLlena();
		else {
		  int pos = pos(e);
		  if (pos!=-1) 
			throw new ExAgendaProPersonaExistente();
		  else {
			agenda[numElementos] = e;
			numElementos++;
		  }	
		}
	  }
	  
	   
      /*
       * Compactamos la agenda después de eliminar a un contacto.
       */
	  public void delete(Persona e) throws ExAgendaProPersonaNoExistente {
		int pos = pos(e);
		if (pos==-1)
		  throw new ExAgendaProPersonaNoExistente();
		else {
		  agenda[pos] = null;
		  numElementos--;
		  compactar(pos);
		}
	  }
		  

	  public Persona getByDNI(String dni) throws ExAgendaProPersonaNoExistente {
		int pos = pos(new Persona(dni,""));
		if (pos == -1)
		  throw new ExAgendaProPersonaNoExistente();
		else
		  return agenda[pos];
	  }
	   

	  public Persona first() throws ExAgendaProVacia {
		if (empty())
		  throw new ExAgendaProVacia();
		else {
		  posicion=0;
		  return agenda[posicion];
	    }
	  }	   
	  

	  public Persona next() {
		posicion++;
		return agenda[posicion];
	  }
	  
	   
	  public boolean hasNext() {
		 return agenda[posicion+1]!=null;	 
	  }
	   

	  public String toString() {
		String aux="";
		for (int i=0;i<agenda.length;i++)
		  if (agenda[i]!=null)
			aux = aux + agenda[i];
		return aux;
	  }
	  
	  
	  /*
	   * Devuelve la posición en la que se encuentra una Persona; -1 si no está en la agenda.
	   */
	  private int pos(Persona e) {
		int i = 0;
		boolean encontrado = false;		
		do {
		  if (agenda[i]!=null) 
			encontrado = e.equals(agenda[i]);
		  i++;  
		} while (i<maxSize&&!encontrado);
			
		  if (!encontrado)
			return -1;
		  else
			return i-1;
	  }
	  
	  
	  /*
	   * desplaza, una posición hacia la izquierda, todos los contactos de la agenda a partir de pos.
	   */
	  private void compactar(int pos) {
		int i = pos+1;
		while (agenda[i]!=null) {
		  agenda[i-1] = agenda[i];
		  agenda[i] = null;
		  i++;
		} 
		  
	  }

}
