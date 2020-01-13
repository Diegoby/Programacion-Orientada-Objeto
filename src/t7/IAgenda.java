package t7;
/**
 * 
 * Agenda simple; sin recorrido de los contactos
 * Éste NO es un buen diseño; se proporciona para simplificar la implementación.
 * @author POO.
 * 
 */
public interface IAgenda {
	
	  /**
	   * Añade la persona; no se comprueba si existe; tampoco se comprueba si la 
	   * agenda está llena;
	   * @param e Persona a añadir.
	   */
	  public void add(Persona e);
	  
	  /**
	   * Coloca un apuntador señalando al contacto que se le pasa como parámetro.
	   * @param e Persona a encontrar 
	   * @throws ExAgendaPersonaNoExistente   No se ha encontrado a la persona.
	   */
	  public void pos(Persona e) throws ExAgendaPersonaNoExistente;

	  /**
	   * Obtiene el DNI de la persona apuntada en pos.
	   * @return DNI.
	   */
	  public String getDNI();
	  
	  /**
	   * Obtiene el nombre de la persona apuntada en pos.
	   * @return Nombre.
	   */
	  public String getNombre();
	  
	  /**
	   * Devuelve el número de personas que tiene la agenda es ese momento.
	   * @return Número de personas en la agenda.
	   */
	  public int size();
	  
	  /**
	   * Borra el elemento aountado por el método pos.
	   */
	  public void delete();
	  
	  public String toString();
	  
	}
