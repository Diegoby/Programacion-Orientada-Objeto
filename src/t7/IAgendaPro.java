package t7;

/**
 * Agenda con funcionalidades más ámplias que las de la agenda mínima vista en un ejemplo anterior; Esta Agenda permite recorridos;
 * No extiende a IAgenda; IAgendaPro no es una IAgenda; IAgendaPro no extiende las funcionalidades de IAgenda.
 * @author POO.
 *
 */
public interface IAgendaPro {
  
  /**
   * Indica si la agenda está llena y no admite más contactos.
   * @return true si la agenda está completa.
   */
  public boolean full();	
  
  /**
   * Indica si la agenda está vacía.
   * @return true si la agenda está vacía.
   */
  public boolean empty();	
	
  /**
   * Número de contactos existentes en la agenda.
   * @return Número de personas en la Agenda.
   */
  public int size();

  /**
   * Número de contactos que admite la agenda.
   * @return Tamaño máximo de la Agenda.
   */
  public int maxSize();
	  
  /**
   * Añade una Persona en la agenda.
   * @param e Persona a añadir en la agenda.
   * @throws ExAgendaProPersonaExistente La Persona a introducir ya existe; no se añade.
   * @throws ExAgendaProLlena La agenda está llena; no se añade.
   */
   public void add(Persona e) throws ExAgendaProPersonaExistente, ExAgendaProLlena;
   
   /**
    * Elimina una Persona de la agenda.
    * @param e Persona a borrar en la agenda.
    * @throws ExAgendaProPersonaNoExistente La persona a borrar no existe; no se borra.
    */
   public void delete(Persona e) throws ExAgendaProPersonaNoExistente; 
	  
   /**
    * Busca una persona a partir de su DNI.
    * @param dni DNI de la persona buscada.
    * @return Persona que se corresponde con el DNI proporcionado.
    * @throws ExAgendaProPersonaNoExistente La persona buscada no existe en la agenda.
    */ 
   public Persona getByDNI(String dni) throws ExAgendaProPersonaNoExistente;

   /**
    * Obtiene la primera persona de la agenda.
    * @return Primer contacto de la agenda.
    * @throws ExAgendaProVacia No existen elementos en la agenda.
    */
   public Persona first() throws ExAgendaProVacia;
   
   /**
    * Proporciona la siguiente persona en la agenda, respecto a un posicionamiento anterior first() o next().
    * Debe usarse en combinación con el método hasNext().
    * @return siguiente Persona en la agenda.
    */
   public Persona next();
   
   /**
    * Indica si existe una siguiente persona en la agenda, respecto a un posicionamiento anterior first() o next().
    * @return Indica si existe una siguiente Persona en la agenda.
    */
   public boolean hasNext();
   

   public String toString();

}
